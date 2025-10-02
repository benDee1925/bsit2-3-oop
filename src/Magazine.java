class Magazine extends LibraryItem {
    private int issueNumber;
    private String publicationMonth;
    private boolean isLatestIssue;

    public Magazine(String itemId, String title, String author, int issueNumber, String publicationMonth, boolean isLatestIssue) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.publicationMonth = publicationMonth;
        this.isLatestIssue = isLatestIssue;
    }

    public String getItemType() {
        return "Magazine";
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * 0.25;
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
        return 7; 
    }
}
