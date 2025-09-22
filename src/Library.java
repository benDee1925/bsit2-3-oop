class Library {
    private java.util.List<Book> books;

    public Library() {
        books = new java.util.ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void showBooks() {
        System.out.println("\nAll books in library:");
        for (Book book : books) {
            System.out.println(book.getDetails());
        }
    }

    public void borrowBook(String title) {
        System.out.println("\nBorrowing " + title + "...");
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.borrowBook();
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book is not available for borrowing.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        System.out.println("\nReturning " + title + "...");
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("Book returned successfully!");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showAvailableBooks() {
        System.out.println("\nAvailable books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getDetails());
            }
        }
    }

    public void validateBook(int year, String isbn) {
        System.out.println("\nTesting validation...");
        if (year < 1450 || year > 2025) {
            System.out.println("Invalid year provided. Year must be between 1450 and 2025");
        }
        if (!(isbn.length() == 10 || isbn.length() == 13)) {
            System.out.println("Invalid ISBN. ISBN must be 10 or 13 characters long");
        }
    }
}
