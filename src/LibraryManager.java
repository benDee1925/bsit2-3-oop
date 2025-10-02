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
