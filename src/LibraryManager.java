import java.util.ArrayList;
import java.util.Scanner;

class LibraryManager {
    ArrayList<String> books;
    Scanner scanner;

    public LibraryManager() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
        books.add("Java Programming");
        books.add("Web Development");
        books.add("Database Design");
    }

    public void showBooks() {
        try {
            if (books == null) throw new IllegalStateException("Book list is null");

            if (books.isEmpty()) {
                System.out.println("No books available.");
            } else {
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i + 1) + ". " + books.get(i));
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Display operation completed.\n");
        }
    }

    public void addBook() {
        try {
            System.out.print("Enter book title to add: ");
            String title = scanner.nextLine();

            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Book title cannot be empty!");
            }
            if (title.trim().length() < 3) {
                throw new IllegalArgumentException("Book title must be at least 3 characters long!");
            }

            books.add(title.trim());
            System.out.println("Book '" + title.trim() + "' added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Add book operation completed.\n");
            showBooks();
        }
    }

    public void removeBook() {
        try {
            if (books.isEmpty()) {
                System.out.println("Cannot remove - library is empty.");
                return;
            }

            System.out.print("Enter book number to remove (1-" + books.size() + "): ");
            String input = scanner.nextLine();
            int index = Integer.parseInt(input);

            if (index < 0) throw new IllegalArgumentException("Invalid book number!");
            if (index < 1 || index > books.size()) throw new ArrayIndexOutOfBoundsException("Invalid book number! Please enter between 1 and " + books.size() + ".");

            String removed = books.remove(index - 1);
            System.out.println("Book '" + removed + "' removed successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Remove book operation completed.\n");
        }
    }
}
