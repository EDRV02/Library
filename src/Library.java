import QA.Books;
import QA.Patrons;

import java.awt.print.Book;
import java.util.*;


public class Library {
    private static Map<String, Books> books = new HashMap<>();
    private static Map<String, Patrons> patrons = new HashMap<>();
    private static int bookIdCounter = 1;
    private static int patronIdCounter = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command:\n");

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
            //add book
            //add patron
            //search book
            //borrow book
            //return book
            case "searchBook":
                searchByISBN(scanner);
                break;

            default:
                System.out.println("Unknown command.");
        }
    }

    public static void searchByISBN(Scanner scanner) {
        System.out.println("Enter ISBN to search:");
        int isbn = Integer.parseInt(scanner.nextLine().trim());
        Books book = books.get(isbn); // Search the book by ISBN
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

}