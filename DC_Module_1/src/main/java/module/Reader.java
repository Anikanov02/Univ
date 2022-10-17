package module;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Data
public class Reader implements Runnable {

    private String name;
    private String location;
    private Library library;
    private Room readingRoom;
    private ArrayList<Book> books;

    private HashMap<String, int[]> movementMap = new HashMap<>();

    public Reader(Library library, Room readingRoom, String name) {
        this.library = library;
        this.readingRoom = readingRoom;
        this.name = name;
        location = "home";
        books = new ArrayList<>();

        movementMap.put("home", new int[]{6, 8});
        movementMap.put("library", new int[]{1, 5, 5, 5, 7, 7});
        movementMap.put("building", new int[]{0, 0, 2, 2, 2, 2, 2});
        movementMap.put("reading room", new int[]{3, 6, 6, 6, 6, 6});
    }

    private int chooseAction() {
        for (String loc : movementMap.keySet()) {
            if (loc.equals(location)) {
                int[] moves = movementMap.get(loc);
                return moves[new Random().nextInt(moves.length)];
            }
        }
        return -1;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int action = chooseAction();
                switch (action) {
                    case 0:
                        library.enter(this);
                        Thread.sleep(2000);
                        break;
                    case 1:
                        library.leave(this);
                        Thread.sleep(2000);
                        break;
                    case 2:
                        readingRoom.enter(this);
                        Thread.sleep(3000);
                        break;
                    case 3:
                        readingRoom.leave(this);
                        Thread.sleep(3000);
                        break;
                    case 4:
                        setLocation("Home");
                        System.out.println("Reader " + name + " is at home");
                        Thread.sleep(5000);
                        break;
                    case 5:
                        if (library.getBooks().size() > 0) {
                            library.giveBook(this, library.getBooks().
                                    get(new Random().nextInt(library.getBooks().size())));
                            Thread.sleep(2000);
                            if (books.get(books.size() - 1).isReaderRoomOnly()) {
                                readAtReadingRoom(books.get(books.size() - 1));
                            }
                        }
                        break;
                    case 6:
                        if (books.size() > 0) {
                            System.out.println("Reader " + name + " is reading");
                            Thread.sleep(10000);
                        }
                        break;
                    case 7:
                        if (books.size() > 0) {
                            library.returnBook(this, getBooks().
                                    get(new Random().nextInt(getBooks().size())));
                        }
                        break;
                    case 8:
                        this.setLocation("building");
                        System.out.println("Reader " + name + " entered building");
                        break;
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void readAtReadingRoom(Book book) {
        try {
            setLocation("reading room");
            System.out.println("Reader " + name + " is reading the book " + book.getId() + " which is only allowed to read at reading room");
            Thread.sleep(10000);
            setLocation("library");
            library.returnBook(this, book);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}