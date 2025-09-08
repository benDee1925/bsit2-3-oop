class FoodItem {
    private String itemName;
    private double price;
    private String size;

    public FoodItem(String itemName, double price, String size) throws InvalidItemException {
        if (itemName == null || itemName.isEmpty()) {
            throw new InvalidItemException("Error: Invalid item: cannot be empty");
        }
        if (price <= 0) {
            throw new InvalidItemException("Error: Invalid price: must be greater than 0");
        }
        this.itemName = itemName;
        this.price = price;
        this.size = size;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }
}

class InvalidItemException extends Exception {
    public InvalidItemException(String message) {
        super(message);
    }
}

class FoodOrder {
    private String customerName;
    private FoodItem[] items;
    private double totalPrice;

    public FoodOrder(String customerName, FoodItem[] items) {
        this.customerName = customerName;
        this.items = items;
        calculateTotal();
    }

    private void calculateTotal() {
        totalPrice = 0.0;
        for (FoodItem item : items) {
            totalPrice += item.getPrice();
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount() {
        return items.length;
    }

    public String getSize() {
        return items[0].getSize();
    }

    public void displayOrder() {
        System.out.println("Order for " + customerName);
        System.out.println("Total: $" + totalPrice);
        System.out.println("Items: " + getItemCount());
        System.out.println("Size: " + getSize());
    }

}


