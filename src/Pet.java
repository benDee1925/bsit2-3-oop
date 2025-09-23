abstract class Pet {
    String name;
    int age;

    Pet(String n, int a) {
        name = n;
        age = a;
    }

    abstract void makeSound();

    void displayInfo() {
        System.out.println("Pet Name: " + name + ", Age: " + age);
    }
}

interface Trainable {
    void performTrick();
}


class Dog extends Pet implements Trainable {
    Dog(String n, int a) {
        super(n, a);
    }

    void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    public void performTrick() {
        System.out.println("Training " + name + ": Sits and shakes hands");
    }
}


class Cat extends Pet {
    Cat(String n, int a) {
        super(n, a);
    }
    void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
}


class Bird extends Pet implements Trainable {
    Bird(String n, int a) {
        super(n, a);
    }
    void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }
    public void performTrick() {
        System.out.println("Training " + name + ": Flies in circles and lands on perch");
    }
}
