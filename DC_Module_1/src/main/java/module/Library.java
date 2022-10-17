package module;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Library implements Room {
    private int readersInRoom = 0;

    @Getter
    @Setter
    private ArrayList<Book> books;

    @Override
    public synchronized void enter(Reader reader) {
        int maxReadersInRoom = 2;
        while (readersInRoom >= maxReadersInRoom) {
            try {
                wait();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        readersInRoom++;
        reader.setLocation("library");
        System.out.println("Reader " + reader.getName() + " entered library");
        System.out.println("Readers in library: " + readersInRoom);
        notifyAll();
    }

    @Override
    public synchronized void leave(Reader reader) {
        int minReadersInRoom = 0;
        while (readersInRoom <= minReadersInRoom) {
            try {
                wait();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        readersInRoom--;
        reader.setLocation("building");
        System.out.println("Reader " + reader.getName() + " left library");
        System.out.println("Readers in library: " + readersInRoom);
        notifyAll();
    }


    public synchronized void giveBook(Reader reader, Book book) {
        ArrayList<Book> readerBooks = reader.getBooks();
        readerBooks.add(book);
        reader.setBooks(readerBooks);
        books.remove(book);
        System.out.println("Reader " + reader.getName() + " got "
                + book.getId());
    }

    public synchronized void returnBook(Reader reader, Book book) {
        ArrayList<Book> readerBooks = reader.getBooks();
        readerBooks.remove(book);
        reader.setBooks(readerBooks);
        books.add(book);
        System.out.println("Reader " + reader.getName() + " returned "
                + book.getId());
    }
}