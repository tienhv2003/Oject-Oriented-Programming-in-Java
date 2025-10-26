import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class LibraryManagementSystem {

    // Book class
    static class Book {
        private String title;
        private String author;
        private String genre;
        private int publicationYear;

        public Book(String title, String author, String genre, int publicationYear) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publicationYear = publicationYear;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getGenre() { return genre; }
        public int getPublicationYear() { return publicationYear; }

        public String toString() {
            return title + " - " + author + " - " + genre + " - " + publicationYear;
        }
    }

    private static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }

    private static boolean isValidYear(int year) {
        return year >= 1000 && year <= 2025;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Book> library = new HashMap<>();

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search for a book");
            System.out.println("4. Remove a book");
            System.out.println("5. View sorted books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1 -> addBook(scanner, library);
                case 2 -> viewBook(library);
                case 3 -> searchBook(scanner, library);
                case 4 -> removeBook(scanner, library);
                case 5 -> sortBook(library);
                case 6 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner, HashMap<String, Book> library) {
        System.out.println("----- Adding a new book -----");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        if (library.containsKey(isbn)) {
            System.out.println("A book with this ISBN already exists!");
            System.out.print("Do you want to replace it? (y/n): ");
            String replace = scanner.nextLine();
            if (!replace.equalsIgnoreCase("y")) {
                return;
            }
        }

        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        if (!isValidText(title)) {
            System.out.println("Invalid title! Title cannot be empty.");
            return;
        }

        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        if (!isValidText(author)) {
            System.out.println("Invalid author! Author cannot be empty.");
            return;
        }

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        if (!isValidText(genre)) {
            System.out.println("Invalid genre! Genre cannot be empty.");
            return;
        }

        System.out.print("Enter publication year: ");
        int publicationYear;
        try {
            publicationYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        if (!isValidYear(publicationYear)) {
            System.out.println("Invalid publication year!");
            return;
        }

        Book addBook = new Book(title, author, genre, publicationYear);
        library.put(isbn, addBook);
        System.out.println("Book added successfully!");
    }

    private static void viewBook(HashMap<String, Book> library) {
        System.out.println("----- View all books -----");
        if (library.isEmpty()) {
            System.out.println("The library is empty!");
        } else {
            for (Map.Entry<String, Book> entry : library.entrySet()) {
                System.out.println(entry.getKey() + " --- " + entry.getValue());
            }
        }
    }

    private static void searchBook(Scanner scanner, HashMap<String, Book> library) {
        if (library.isEmpty()) {
            System.out.println("The library is empty!");
            return;
        }

        System.out.println("----- Search book by -----");
        System.out.println("1. ISBN");
        System.out.println("2. Title");
        System.out.println("3. Author");
        System.out.print("Enter choice: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        switch (choice) {
            case 1 -> {
                System.out.print("Enter ISBN to search: ");
                String searchIsbn = scanner.nextLine();
                if (library.containsKey(searchIsbn)) {
                    System.out.println("Result: " + library.get(searchIsbn));
                } else {
                    System.out.println("Not found!");
                }
            }
            case 2 -> {
                System.out.print("Enter title to search: ");
                String searchTitle = scanner.nextLine();
                boolean found1 = false;
                for (Book b : library.values()) {
                    if (b.getTitle().equalsIgnoreCase(searchTitle)) {
                        System.out.println(b);
                        found1 = true;
                    }
                }
                if (!found1) System.out.println("Not found!");
            }
            case 3 -> {
                System.out.print("Enter author to search: ");
                String searchAuthor = scanner.nextLine();
                boolean found2 = false;
                for (Book b : library.values()) {
                    if (b.getAuthor().equalsIgnoreCase(searchAuthor)) {
                        System.out.println(b);
                        found2 = true;
                    }
                }
                if (!found2) System.out.println("Not found!");
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void removeBook(Scanner scanner, HashMap<String, Book> library) {
        System.out.println("----- Removing a book -----");
        if (library.isEmpty()) {
            System.out.println("The library is empty!");
            return;
        }

        System.out.print("Enter ISBN to remove: ");
        String removeIsbn = scanner.nextLine();

        if (library.containsKey(removeIsbn)) {
            library.remove(removeIsbn);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void sortBook(HashMap<String, Book> library) {
        System.out.println("----- Sorted list of books (by ISBN) -----");
        if (library.isEmpty()) {
            System.out.println("The library is empty!");
            return;
        }

        TreeMap<String, Book> sortedLibrary = new TreeMap<>(library);
        for (Map.Entry<String, Book> entry : sortedLibrary.entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }
    }
}
