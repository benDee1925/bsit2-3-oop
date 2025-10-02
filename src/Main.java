public class Main {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM TEST ===\n");

        LibraryManager manager = new LibraryManager();

        System.out.println("=== Adding Items to Library ===");
        Book book1 = new Book("B001", "Java Programming", "James Gosling", "ISBN123", 450, "Programming");
        Book book2 = new Book("B002", "Python Cookbook", "David Beazley", "ISBN456", 350, "Programming");
        Magazine mag1 = new Magazine("M001", "Tech Today", "Editor Smith", 34, "October", true);
        Magazine mag2 = new Magazine("M002", "Health Weekly", "Editor Jones", 12, "September", false);
        DVD dvd1 = new DVD("D001", "The Matrix", "Wachowski Sisters", 136, "PG-13", "Sci-Fi");
        DVD dvd2 = new DVD("D002", "Inception", "Christopher Nolan", 148, "PG-13", "Sci-Fi");

        manager.addItem(book1);
        manager.addItem(mag1);
        manager.addItem(dvd1);

        System.out.println();

        System.out.println("=== Displaying All Items ===");
        manager.displayAllItems();
        System.out.println();

      
        Student student = new Student("U001", "John Smith", "john.smith@email.com", "S123", "Computer Science");
        Faculty faculty = new Faculty("U002", "Dr. Smith", "dr.smith@email.com", "Engineering", "Professor");

        System.out.println("=== Testing Borrowing ===");
        if (student.getBorrowedItemsCount() < student.getMaxBorrowLimit() && book1.isAvailable()) {
            book1.borrowItem(student.getName());
            student.addBorrowedItem(book1);
            System.out.println("Student " + student.getName() + " borrowed: " + book1.title);
        }
        if (faculty.getBorrowedItemsCount() < faculty.getMaxBorrowLimit() && dvd1.isAvailable()) {
            dvd1.borrowItem(faculty.getName());
            faculty.addBorrowedItem(dvd1);
            System.out.println("Faculty " + faculty.getName() + " borrowed: " + dvd1.title);
        }
        System.out.println();

        System.out.println("=== Displaying Available Items ===");
        manager.displayAvailableItems();
        System.out.println();

        System.out.println("=== Testing Late Fees ===");
        System.out.printf("%s - 5 days late: $%.2f\n", book1.title, book1.calculateLateFee(5));
        System.out.printf("%s - 3 days late: $%.2f\n", dvd1.title, dvd1.calculateLateFee(3));
        System.out.println();

        System.out.println("=== Testing User Information ===");
        System.out.println("Student: " + student.getName() + " (" + student.getMajor() + ") - " + student.getBorrowedItemsCount() + " items borrowed");
        System.out.println("Faculty: " + faculty.getName() + " (" + faculty.getDepartment() + ") - " + faculty.getBorrowedItemsCount() + " items borrowed");
    }
}
