public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Night Circus", "Erin Morgenstern", 387);
        Book book2 = new Book("The Road", "Cormac McCarthy", 287);
        Book book3 = new Book("The Midnight Library", "Matt Haig", 304);

        performBookActions(book1);
        performBookActions(book2);
        performBookActions(book3);
    }

    public static void performBookActions(Book book) {
        System.out.println("\n===== " + book.getTitle() + " =====");
        book.displayInfo();
        book.borrowBook();
        book.displayInfo();
        book.returnBook();
        book.displayInfo();
    }
}
