abstract class LibraryItem implements Borrowable {
    protected String itemId;
    protected String title;
    protected String author;
    protected boolean isCheckedOut = false;
    protected String borrowerName = "";

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemInfo() {
        return title + " (" + getItemType() + " - " + getBorrowingStatus() + ")";
    }

    public void checkOut(String borrowerName) {
        isCheckedOut = true;
        this.borrowerName = borrowerName;
    }

    public void checkIn() {
        isCheckedOut = false;
        this.borrowerName = "";
    }

    public abstract String getItemType();
    public abstract double calculateLateFee(int daysLate);
}
