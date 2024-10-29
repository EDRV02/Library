import QA.Books;
import QA.Patrons;

import java.util.*;


public class Library {
    private static List<Books> books = new ArrayList<>();
    private static List<Patrons> patrons = new ArrayList<>();
    private static Map<Books, Patrons> borrowedBooks = new HashMap<>();
    private static int bookIdCounter = 1;
    private static int patronIdCounter = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command:\n" +
                    "addBook\n addPatron\n searchBook\n borrowBook\n returnBook\n listBorrowedBooks\n");


            command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            }

            handleCommand(command, scanner);
        }
        scanner.close();
    }
    private static void handleCommand(String command, Scanner scanner) {
        switch (command) {
            case "addBook":
                addBook(scanner);
                break;
            case "addPatron":
                addPatron(scanner);
                break;
            case "borrowBook":
                borrowBook(scanner);
                break;
            case "returnBook":
                returnBook(scanner);
                break;
            case "listBorrowedBooks":
                listBorrowedBooks();
                break;
            case "searchBook":
                searchByISBN(scanner);
                break;

            default:
                System.out.println("Unknown command.");
        }
    }

    private static void searchByISBN(Scanner scanner) {
        System.out.println("Enter ISBN to search:");
        try {
            int isb = Integer.parseInt(scanner.nextLine().trim());
            Integer book = books.get(isb).getIsb(); // Search the book by ISBN
            if (book != null) {
                System.out.println("Found: " + book);
            } else {
                System.out.println("Book not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ISBN format. Please enter a valid number.");
        }
    }
    private static void addBook(Scanner scanner) {
        System.out.println("Enter book name, ISBN, and author (e.g., Name,9780743273565,Author):");
        String[] bookInfo = scanner.nextLine().split(",");
        String bookName = bookInfo[0].trim();
        int isb = Integer.parseInt(bookInfo[1].trim());
        String author = bookInfo[2].trim();
        int bookId = bookIdCounter++;
        Books book = new Books(bookName, isb, author);
        books.add(book);
        System.out.println("Book added: " + bookName + " ISB: " + isb);
    }
    private  static void addPatron(Scanner scanner) {
        System.out.println("Enter name of the patron: ");
        String patronName =scanner.nextLine();
        int patronId = patronIdCounter++;
        Patrons patron = new Patrons(patronName, patronId);
        patrons.add(patron);
        System.out.println("Patron added { Name: " + patronName + " ID: " + patronId);
    }
    public static void borrowBook(Scanner scanner) {
        System.out.print("Enter patron ID: ");
        int patronId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter book ID: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        Patrons patron = null;
        Books book = null;

        for (Patrons p : patrons) {
            if (p.getId() == patronId) {
                patron = p;
                break;
            }
        }
        for (Books b : books) {
            if (b.getIsb() == bookId) {
                book = b;
                break;
            }
        }

        if (patron != null && book != null) {
            if (!borrowedBooks.containsKey(book)) {
                borrowedBooks.put(book, patron);
                patron.borrowBook(book);
                System.out.println(patron.getName() + " borrowed " + book.getName());
            } else {
                System.out.println("Book is not available or already borrowed.");
            }
        } else {
            System.out.println("Invalid patron or book ID.");
        }
    }
    public static void returnBook(Scanner scanner) {
        System.out.print("Enter patron ID: ");
        int patronId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter book ID: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        Patrons patron = null;
        Books book = null;

        for (Patrons p : patrons) {
            if (p.getId() == patronId) {
                patron = p;
                break;
            }
        }
        for (Books b : books) {
            if (b.getIsb() == bookId) {
                book = b;
                break;
            }
        }

        if (patron != null && book != null) {
            if (borrowedBooks.containsKey(book) && borrowedBooks.get(book).equals(patron)) {
                borrowedBooks.remove(book);
                patron.returnBook(book);
                System.out.println(patron.getName() + " returned " + book.getName());
            } else {
                System.out.println("This book was not borrowed by this patron.");
            }
        } else {
            System.out.println("Invalid patron or book ID.");
        }
    }
    public static void listBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Map.Entry<Books, Patrons> entry : borrowedBooks.entrySet()) {
            System.out.println(entry.getKey() + " borrowed by " + entry.getValue().getName());
        }
    }

    }

