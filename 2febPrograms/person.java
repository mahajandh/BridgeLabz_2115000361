class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating an original Person object
        Person person1 = new Person("Alice", 25);
        person1.displayDetails();

        System.out.println(); // Line break

        // Creating a copy using the copy constructor
        Person person2 = new Person(person1);
        person2.displayDetails();
    }
}
