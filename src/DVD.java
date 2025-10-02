class DVD extends LibraryItem {
    private int duration;
    private String rating;
    private String genre;

    public DVD(String itemId, String title, String author, int duration, String rating, String genre) {
        super(itemId, title, author);
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
    }

    public String getItemType() {
        return "DVD";
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00;
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
        return 5; 
    }

    public String getBorrowingStatus() {
        return "DVD: " + super.getBorrowingStatus();
    }
}
