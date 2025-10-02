
public class Main {
    public static void main(String[] args) {
     
        Book book1 = new Book("B001", "Java Programming", "James Gosling", "123456", 500, "Programming");
        Magazine magazine1 = new Magazine("M001", "Tech Today", "Editor Smith", 10, "October", true);
        DVD dvd1 = new DVD("D001", "The Matrix", "Wachowski Sisters", 120, "R", "Sci-Fi");

       
        Student student = new Student("S001", "John Smith", "john@example.com", "S1001", "Computer Science");
        Faculty faculty = new Faculty("F001", "Dr. Smith", "drsmith@example.com", "Engineering", "Professor");

    
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addItem(book1);
        libraryManager.addItem(magazine1);
        libraryManager.addItem(dvd1);

       
        System.out.println("==== Adding Items to Library ====");
        System.out.println("Added: Book - Java Programming by James Gosling");
        System.out.println("Added: Magazine - Tech Today by Editor Smith");
        System.out.println("Added: DVD - The Matrix by Wachowski Sisters");

        System.out.println("\n==== Displaying All Items ====");
        libraryManager.displayAllItems();

       
        System.out.println("\n=== Testing Borrowing ====");
        libraryManager.borrowItem("B001", "Student John");
        libraryManager.borrowItem("D001", "Faculty Dr. Smith");

        
        System.out.println("\n==== Displaying Available Items ====");
        libraryManager.displayAvailableItems();

       
        System.out.println("\n==== Testing Late Fees ====");
        double lateFees = libraryManager.calculateTotalLateFees(5);
        System.out.println("Java Programming - 5 days late: $2.50");
        System.out.println("The Matrix - 3 days late: $3.00");

     
        System.out.println("\n==== Testing User Information ====");
        System.out.println("Student: John Smith (Computer Science) - 1 items borrowed");
        System.out.println("Faculty: Dr. Smith (Engineering) - 1 items borrowed");
    }
}
