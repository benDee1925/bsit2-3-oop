public class Main {
    public static void main(String[] args) {
        PetService Ps = new PetService();

        System.out.println("Basic checkup: $" + Ps.calculateFee());
        System.out.println("Checkup with vaccination: $" + Ps.calculateFee(true));
        System.out.println("Full service: $" + Ps.calculateFee(true, true));
        System.out.println("Emergency: $" + Ps.calculateFee("Critical"));
        System.out.println();

        System.out.println("Welcome to the Pet Clinic!");
        System.out.println("======================");
        Pet Dog = new Dog("Buddy", 3);
        Pet Cat = new Cat("Whiskers", 2);
        Pet Bird = new Bird("Tweety", 1);

        Dog.displayInfo(); Dog.makeSound();
        System.out.println();

        Cat.displayInfo(); Cat.makeSound();
        System.out.println();

        Bird.displayInfo(); Bird.makeSound();
        System.out.println();

        System.out.println("Training Session Started!");
        System.out.println("======================");
        Trainable trainDog = new Dog("Buddy", 3);
        Trainable trainBird = new Bird("Tweety", 1);
        trainDog.performTrick();
        trainBird.performTrick();
    }
}
