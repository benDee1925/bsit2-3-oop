class Book extends Media {
    private String author;

    public Book(String title, String itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getMediaType() {
        return "Book";
    }

    @Override
    public void displayInfo() {
        System.out.println("[Book] Title: " + title + ", Author: " + author + ", ID: " + itemId + ", Available: " + isAvailable);
    }
}

class DVD extends Media {
    private String director;

    public DVD(String title, String itemId, String director) {
        super(title, itemId);
        this.director = director;
    }

    @Override
    public String getMediaType() {
        return "DVD";
    }

    @Override
    public void displayInfo() {
        System.out.println("[DVD] Title: " + title + ", Director: " + director + ", ID: " + itemId + ", Available: " + isAvailable);
    }
}
