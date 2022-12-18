import models.Author;
import models.Book;
import models.Library;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {
    private final static String path = "src/main/java/library.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        Library library = DOMParser.parse(path);
        library.outputAllContents();

        System.out.println("\nAdd a new author Someone\n");
        Author author = new Author("Someone", library);
        library.addAuthor(author);
        library.outputAllContents();

        System.out.println("\nAdd some new books for this author\n");
        Book book1 = new Book("Key", 2022, library);
        library.addBook(book1, author.getAuthorId());
        Book book2 = new Book("OldKey", 2018, library);
        library.addBook(book2, author.getAuthorId());
        library.outputAllContents();


        System.out.println("\nChange book's name\n");
        library.renameBook(library.getBook("Key"), "NewBook");
        library.outputAllContents();

        System.out.println("\nChange author's name\n");
        library.renameAuthor(library.getAuthor("Someone"), "Alex");
        library.outputAllContents();

        System.out.println("\nGet Alex's books\n");
        List<Book> books = library.getAuthorsBooks("Alex");
        for (Book b : books)
            b.outputBook();

        System.out.println("\nGet all author\n");
        Map<String, Author> authors = library.getAuthors();
        for (String id : authors.keySet()){
            authors.get(id).outputAuthor();
        }

        System.out.println("\nDelete a Alex's book\n");
        library.removeBook(book1);
        books = library.getAuthorsBooks("Alex");
        for (Book b : books)
            b.outputBook();

        System.out.println("\nDelete Alex\n");
        library.removeAuthor(author);
        library.outputAllContents();
        DOMParser.write(library, path);
    }
}