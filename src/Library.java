import QA.Books;
import QA.Patrons;

import java.util.*;


public class Library {
    private static Map<String, Integer> books = new HashMap<String, Integer>();
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

            default:
                System.out.println("Unknown command.");
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.println("Enter name, ISB: ");
        String[] bookInfo = scanner.nextLine().split(",");
        String bookName = bookInfo[0].trim();
        int isb = Integer.parseInt(bookInfo[1].trim());
        int bookId = bookIdCounter++;
        Books book = new Books(bookName, isb);
        books.put(bookName, isb);
        System.out.println("Book added: " + bookName + " ISB: " + isb);




    }

    }
