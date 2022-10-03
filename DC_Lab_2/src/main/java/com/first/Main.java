package com.first;

public class Main {
    public static void main(String[] args) {
        boolean[][] forest = new boolean[10][10];
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                forest[i][j] = false;
            }
        }
        forest[3][7] = true;

        new Thread(new BeeHive(forest, 20)).start();
    }
}
