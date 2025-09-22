class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;
    private boolean available;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        this.available = false;
    }

    public void returnBook() {
        this.available = true;
    }

    public String getDetails() {
        String status = available ? "Available" : "Not Available";
        return "Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Year: " + year + " \nStatus: " + status;
    }

    public String getAuthor() {
        return author;
    }
}