package module;

public class ReadingRoom implements Room {
    private int readersInRoom = 0;
    private int maxReadersInRoom = 4;
    private int minReadersInRoom = 0;

    @Override
    public synchronized void enter(Reader reader) {
        while (readersInRoom >= maxReadersInRoom) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readersInRoom++;
        reader.setLocation("reading room");
        System.out.println("Reader " + reader.getName() + " entered reading room");
        System.out.println("Readers in reading room: " + readersInRoom);
        notifyAll();
    }

    @Override
    public synchronized void leave(Reader reader) {
        while (readersInRoom <= minReadersInRoom) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readersInRoom--;
        reader.setLocation("building");
        System.out.println("Reader " + reader.getName() + " left reading room");
        System.out.println("Readers in reading room: " + readersInRoom);
        notifyAll();
    }
}