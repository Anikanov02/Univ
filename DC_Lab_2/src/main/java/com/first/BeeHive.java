package com.first;

import java.util.ArrayList;
import java.util.List;

public class BeeHive implements Runnable {
    private final boolean[][] forest;
    private int bees;
    private boolean found = false;
    private final RowManager rowManager;
    private final List<Bee> groups;

    public BeeHive(boolean[][] forest, int bees) {
        this.forest = forest;
        this.bees = bees;
        this.rowManager = new RowManager();
        groups = new ArrayList<>();
        for (int i = 0; i < Math.min(forest.length, bees); i++) {
            groups.add(new Bee(forest[rowManager.getFreeRow()], rowManager.currentRow));
        }
        for (int i = 0, j = bees; j > 0; j--, i++) {
            groups.get(i).addBee();
            if (i + 1 >= groups.size()) {
                i = 0;
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).getNumberOfBees(); j++) {
                new Thread(groups.get(i), "Bee from group  " + i + " with id " + j).start();
            }
        }

        int row = 0;
        while (row < forest.length && !found) {
            synchronized (rowManager) {//in our case we dont need this
                while (groups.stream().allMatch(Bee::busy)) {
                    try {
                        rowManager.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                row = rowManager.getFreeRow();
                Bee group = groups.stream().filter(g -> !g.busy()).findFirst().orElseThrow();
                System.out.println("Inspecting row : " + rowManager.getCurrentRow());
                group.setRow(forest[rowManager.getCurrentRow()], rowManager.getCurrentRow());
            }
        }
    }

    private class Bee implements Runnable {
        private int numberOfBees;
        boolean busy;
        private boolean[] row;
        private int rowNum;
        private final CellManager cellManager;

        public Bee(boolean[] initialRow, int initialRowNum) {
            this.row = initialRow;
            this.rowNum = initialRowNum;
            this.busy = false;
            this.cellManager = new CellManager();
        }

        @Override
        public void run() {
            int cell;
            int finished = 0;
            while (!found) {
                synchronized (cellManager) {
                    while (cellManager.getCurrentCell() + 1 >= row.length) {
                        try {
                            finished++;
                            if (finished == numberOfBees) {
                                busy = false;
                            }
                            cellManager.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    busy = true;
                    cell = cellManager.getFreeCell();
                }
                try {
                    Thread.sleep(100);
                    if (row[cell]) {
                        System.out.println(Thread.currentThread().getName() + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!found in sell [" + rowNum + ", " + cell + "]");
                        found = true;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " inspected sell [" + rowNum + ", " + cell + "]");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void setRow(boolean[] row, int rowNum) {
            synchronized (cellManager) {
                cellManager.currentCell = 0;
                this.row = row;
                this.rowNum = rowNum;
                cellManager.notifyAll();
            }
        }

        public void addBee() {
            numberOfBees++;
        }

        public int getNumberOfBees() {
            return numberOfBees;
        }

        public boolean busy() {
            return busy;
        }

        public void busy(boolean busy) {
            synchronized (rowManager) {
                busy = false;
                rowManager.notifyAll();
            }
        }

        class CellManager {
            private Integer currentCell = -1;

            public Integer getCurrentCell() {
                return currentCell;
            }

            public Integer getFreeCell() {
                return ++currentCell;
            }
        }
    }

    private class RowManager {
        private Integer currentRow = -1;

        public Integer getCurrentRow() {
            return currentRow;
        }

        public Integer getFreeRow() {
            return ++currentRow;
        }
    }
}
