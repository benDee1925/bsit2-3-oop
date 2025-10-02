interface Borrowable {
    void borrowItem(String borrowerName);
    void returnItem();
    boolean isAvailable();
    int getBorrowingPeriod(); // in days
    default String getBorrowingStatus() {
        return isAvailable() ? "Available for borrowing" : "Currently borrowed";
    }
}

// 2.) LibraryItem Abstract Class
abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;
    protected boolean isCheckedOut;
    protected String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.borrowerName = null;
    }

    public String getItemInfo() {
        return getItemType() + ": " + title + " by " + author;
    }

    public void checkOut(String borrowerName) {
        this.isCheckedOut = true;
        this.borrowerName = borrowerName;
    }

    public void checkIn() {
        this.isCheckedOut = false;
        this.borrowerName = null;
    }

    public abstract String getItemType();
    public abstract double calculateLateFee(int daysLate);
}

// 3.) Book Class
class Book extends LibraryItem implements Borrowable {
    private String isbn;
    private int numberOfPages;
    private String genre;

    public Book(String itemId, String title, String author, String isbn, int numberOfPages, String genre) {
        super(itemId, title, author);
        this.isbn = isbn;
        setNumberOfPages(numberOfPages);
        setGenre(genre);
    }

    // Getters
    public String getIsbn() { return isbn; }
    public int getNumberOfPages() { return numberOfPages; }
    public String getGenre() { return genre; }

    // Setters with validation
    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty())
            throw new IllegalArgumentException("Genre cannot be null or empty.");
        this.genre = genre;
    }

    public void setNumberOfPages(int pages) {
        if (pages <= 0)
            throw new IllegalArgumentException("Number of pages must be positive.");
        this.numberOfPages = pages;
    }

    @Override
    public String getItemType() { return "Book"; }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.50;
    }

    // Implement Borrowable
    @Override
    public void borrowItem(String borrowerName) {
        checkOut(borrowerName);
    }

    @Override
    public void returnItem() {
        checkIn();
    }

    @Override
    public boolean isAvailable() {
        return !isCheckedOut;
    }

    @Override
    public int getBorrowingPeriod() {
        return 14;
    }
}

// 4.) Magazine Class
class Magazine extends LibraryItem implements Borrowable {
    private int issueNumber;
    private String publicationMonth;
    private boolean isLatestIssue;

    public Magazine(String itemId, String title, String author, int issueNumber, String publicationMonth, boolean isLatestIssue) {
        super(itemId, title, author);
        setIssueNumber(issueNumber);
        this.publicationMonth = publicationMonth;
        this.isLatestIssue = isLatestIssue;
    }

    // Getters
    public int getIssueNumber() { return issueNumber; }
    public String getPublicationMonth() { return publicationMonth; }
    public boolean getIsLatestIssue() { return isLatestIssue; }

    // Setters
    public void setLatestIssue(boolean latest) {
        this.isLatestIssue = latest;
    }

    public void setIssueNumber(int issue) {
        if (issue <= 0)
            throw new IllegalArgumentException("Issue number must be positive.");
        this.issueNumber = issue;
    }

    @Override
    public String getItemType() {
        return "Magazine";
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.25;
    }

    // Implement Borrowable
    @Override
    public void borrowItem(String borrowerName) {
        checkOut(borrowerName);
    }

    @Override
    public void returnItem() {
        checkIn();
    }

    @Override
    public boolean isAvailable() {
        return !isCheckedOut;
    }

    @Override
    public int getBorrowingPeriod() {
        return 7;
    }
}

// 5.) DVD Class
class DVD extends LibraryItem implements Borrowable {
    private int duration; // in minutes
    private String rating;
    private String genre;

    public DVD(String itemId, String title, String author, int duration, String rating, String genre) {
        super(itemId, title, author);
        setDuration(duration);
        setRating(rating);
        this.genre = genre;
    }

    // Getters
    public int getDuration() { return duration; }
    public String getRating() { return rating; }
    public String getGenre() { return genre; }

    // Setters with validation
    public void setRating(String rating) {
        String[] validRatings = {"G", "PG", "PG-13", "R", "NC-17"};
        boolean valid = false;
        for (String r : validRatings) {
            if (r.equals(rating)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Invalid rating. Must be one of G, PG, PG-13, R, or NC-17.");
        }
        this.rating = rating;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.duration = duration;
    }

    @Override
    public String getItemType() {
        return "DVD";
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00;
    }

    // Implement Borrowable
    @Override
    public void borrowItem(String borrowerName) {
        checkOut(borrowerName);
    }

    @Override
    public void returnItem() {
        checkIn();
    }

    @Override
    public boolean isAvailable() {
        return !isCheckedOut;
    }

    @Override
    public int getBorrowingPeriod() {
        return 5;
    }

    // Override default method
    @Override
    public String getBorrowingStatus() {
        return "DVD: " + Borrowable.super.getBorrowingStatus();
    }
}

// 6.) User Abstract Class
abstract class User {
    private String userId;
    private String name;
    private String email;
    private ArrayList<LibraryItem> borrowedItems;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getBorrowedItemsCount() { return borrowedItems.size(); }

    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public void displayBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("No borrowed items.");
            return;
        }
        for (LibraryItem item : borrowedItems) {
            System.out.println(item.getItemInfo());
        }
    }

    public abstract int getMaxBorrowLimit();
}

// 7.) Student Class
class Student extends User {
    private String studentId;
    private String major;

    public Student(String userId, String name, String email, String studentId, String major) {
        super(userId, name, email);
        this.studentId = studentId;
        this.major = major;
    }

    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }
}

// 8.) Faculty Class
class Faculty extends User {
    private String department;
    private String position;

    public Faculty(String userId, String name, String email, String department, String position) {
        super(userId, name, email);
        this.department = department;
        this.position = position;
    }

    public String getDepartment() { return department; }
    public String getPosition() { return position; }

    @Override
    public int getMaxBorrowLimit() {
        return 10;
    }
}

// 9.) LibraryManager Class
class LibraryManager {
    private ArrayList<Borrowable> items;

    public LibraryManager() {
        items = new ArrayList<>();
    }

    public void addItem(Borrowable item) {
        items.add(item);
        if (item instanceof LibraryItem) {
            LibraryItem libItem = (LibraryItem) item;
            System.out.println("Added: " + libItem.getItemType() + " - " + libItem.title + " by " + libItem.author);
        }
    }

    public void displayAllItems() {
        System.out.println("=== Displaying All Items ===");
        for (Borrowable item : items) {
            if (item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                System.out.println(libItem.getItemType() + ": " + libItem.title + " (" + item.getBorrowingStatus() + ")");
            }
        }
    }

    public void borrowItem(String itemId, String borrowerName) {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                if (libItem.itemId.equals(itemId)) {
                    if (item.isAvailable()) {
                        item.borrowItem(borrowerName);
                        System.out.println(borrowerName + " borrowed: " + libItem.title);
                    } else {
                        System.out.println(libItem.title + " is currently not available.");
                    }
                    return;
                }
            }
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void returnItem(String itemId) {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                if (libItem.itemId.equals(itemId)) {
                    if (!item.isAvailable()) {
                        item.returnItem();
                        System.out.println(libItem.title + " has been returned.");
                    } else {
                        System.out.println(libItem.title + " was not checked out.");
                    }
                    return;
                }
            }
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void displayAvailableItems() {
        System.out.println("=== Displaying Available Items ===");
        for (Borrowable item : items) {
            if (item.isAvailable() && item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                System.out.println(libItem.getItemType() + ": " + libItem.title + " (" + item.getBorrowingStatus() + ")");
            }
        }
    }

    public double calculateTotalLateFees(int daysLate) {
        double total = 0;
        for (Borrowable item : items) {
            total += ((LibraryItem) item).calculateLateFee(daysLate);
        }
        return total;
    }

    public LibraryItem findItemById(String itemId) {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                if (libItem.itemId.equals(itemId)) {
                    return libItem;
                }
            }
        }
        return null;
    }
}

// 10.) Main Class
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

        // Create users
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
