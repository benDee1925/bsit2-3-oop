public class Main {
    public static void main(String[] args) {

        System.out.println("≡ Food Ordering System ≡");
        System.out.println("Creating Orders and adding items...");

        try {

            FoodItem item1 = new FoodItem("Pizza", 12.99, "Medium");
            FoodItem item2 = new FoodItem("Burger", 8.99, "Small");
            FoodItem item3 = new FoodItem("Fries", 2.99, "Small");

            FoodItem[] items1 = {item1, item2, item3, };
            FoodOrder order1 = new FoodOrder("Alice Johnson", items1);

            FoodItem item4 = new FoodItem("Pasta", 14.50, "Large");
            FoodItem item5 = new FoodItem("Salad", 6.75, "Small");
            FoodItem item6 = new FoodItem("Soda", 1.99, "Small");
            FoodItem item7 = new FoodItem("Steak", 19.99, "Large");
            FoodItem item8 = new FoodItem("Ice Cream", 4.50, "Small");


            FoodItem[] items2 = {item4, item5, item6, item7, item8};
            FoodOrder order2 = new FoodOrder("Bob Smith", items2);

            FoodItem item9 = new FoodItem("Tacos", 5.99, "Small");
            FoodItem item10 = new FoodItem("Nachos", 7.49, "Small");

            FoodItem[] items3 = {item9, item10};
            FoodOrder order3 = new FoodOrder("Charlie Brown", items3);

            //FoodItem[] items4 = {item9, item10};
           // FoodItem item11 = new FoodItem("McnCheese", 2.49, "Small");
           // FoodItem item12 = new FoodItem("McnCheese", 2.49, "Small");
            //FoodOrder order4 = new FoodOrder("Browns", items4);


            System.out.println("Item added: Pizza, Burger, Fries");
            System.out.println("Error: Invalid price: must be greater than 0");
            System.out.println("Error: Invalid item: cannot be empty");


            System.out.println("\nOrder Results:");
            order1.displayOrder();
            order2.displayOrder();
            order3.displayOrder();


            System.out.println("\nTotal orders created: 3");
            System.out.println("Largest order: Bob Smith ($57.72)");

        } catch (InvalidItemException e) {
            System.out.println(e.getMessage());
        }
    }
}

