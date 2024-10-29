package QA;
import java.util.*;

public class Patrons {
    private String name;
    private int id;
    private List<Books> borrowedBooks;

    public Patrons(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = borrowedBooks;
    }
    public void borrowBook(Books book) {
        borrowedBooks.add(book);
    }
    public void returnBook(Books book) {
        borrowedBooks.remove(book);
    }
    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Patrons{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
