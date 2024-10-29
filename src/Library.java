import QA.Books;
import QA.Patrons;

import java.util.*;


public class Library {
    private static Map<String, Integer> books = new HashMap<>();
    private static Map<String, Patrons> patrons = new HashMap<>();
    private static int bookIdCounter = 1;
    private static int patronIdCounter = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command:\n" +
                    "addBook\n");

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

    private static void searchByISBN(Scanner scanner) {
        System.out.println("Enter ISBN to search:");
        try {
            int isbn = Integer.parseInt(scanner.nextLine().trim());
            Integer book = books.get(isbn); // Search the book by ISBN
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
        System.out.println("Enter name, ISBN: ");
        String[] bookInfo = scanner.nextLine().split(",");
        String bookName = bookInfo[0].trim();
        int isbn = Integer.parseInt(bookInfo[1].trim());
        int bookId = bookIdCounter++;
        Books book = new Books(bookName, isbn);
        books.put(bookName, isbn);
        System.out.println("Book added: " + bookName + " ISB: " + isbn);




    }


    }

