public class Book {
    private String title;
    private String author;
    private int pages;
    private boolean isAvailable;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
        System.out.println("New book '" + title + "' by " + author + " has been added to the library!");
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("\n---- Book Details ----");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("\n-----------------------");
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book has been borrowed.");
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book has been returned.");
        } else {
            System.out.println("This book is already in the library.");
        }
    }
}
