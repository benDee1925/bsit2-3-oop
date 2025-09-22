public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===\n");

        Library library = new Library();

        System.out.println("Adding books to Library...");
        library.addBook(new Book("Java Programming", "John Smith", "1234567890", 2020));
        library.addBook(new Book("Data Structures", "Jane Doe", "9876543210", 2019));
        library.addBook(new Book("Web Development", "Mike Johnson", "5555666677", 2021));

        library.showBooks();

        library.borrowBook("Java Programming");
        library.borrowBook("Java Programming");
       // library.borrowBook("Java Programming");

        library.showAvailableBooks();

        //library.validateBook(1400, "12345");
        library.returnBook("Java Programming");

        library.validateBook(1400, "12345");
    }
}