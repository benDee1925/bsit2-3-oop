import java.util.ArrayList;
abstract class User {
    protected String userId;
    protected String name;
    protected String email;
    protected ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public void displayBorrowedItems() {
        for (LibraryItem item : borrowedItems) {
            System.out.println(item.getItemInfo());
        }
    }

    public int getBorrowedItemsCount() {
        return borrowedItems.size();
    }

    public abstract int getMaxBorrowLimit();
}
