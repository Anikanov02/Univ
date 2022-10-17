package module;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.setBooks(books());
        ReadingRoom readingRoom = new ReadingRoom();

        new Thread(new Reader(library, readingRoom, "reader1"), "reader1").start();
        new Thread(new Reader(library, readingRoom, "reader2"), "reader2").start();
        new Thread(new Reader(library, readingRoom, "reader3"), "reader3").start();
        new Thread(new Reader(library, readingRoom, "reader4"), "reader4").start();
        new Thread(new Reader(library, readingRoom, "reader5"), "reader5").start();
        new Thread(new Reader(library, readingRoom, "reader6"), "reader6").start();
    }

    private static ArrayList<Book> books() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            Book book = new Book(i, new Random().nextBoolean());
            books.add(book);
        }
        return books;
    }
}