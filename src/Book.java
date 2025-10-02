
class Book extends LibraryItem {
    private String isbn;
    private int numberOfPages;
    private String genre;

    public Book(String itemId, String title, String author, String isbn, int numberOfPages, String genre) {
        super(itemId, title, author);
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public String getItemType() {
        return "Book";
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * 0.50;
    }

    public void borrowItem(String borrowerName) {
        checkOut(borrowerName);
    }

    public void returnItem() {
        checkIn();
    }

    public boolean isAvailable() {
        return !isCheckedOut;
    }

    public int getBorrowingPeriod() {
        return 14; 
    }
}
