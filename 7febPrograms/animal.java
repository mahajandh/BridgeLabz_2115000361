class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass: Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Dog) barks: Woof Woof!");
    }
}

// Subclass: Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Cat) meows: Meow Meow!");
    }
}

// Subclass: Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Bird) chirps: Tweet Tweet!");
    }
}

// Main Class
public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy", 3);
        Animal myCat = new Cat("Whiskers", 2);
        Animal myBird = new Bird("Tweety", 1);

        // Demonstrating polymorphism
        myDog.makeSound(); // Buddy (Dog) barks: Woof Woof!
        myCat.makeSound(); // Whiskers (Cat) meows: Meow Meow!
        myBird.makeSound(); // Tweety (Bird) chirps: Tweet Tweet!
    }
}
