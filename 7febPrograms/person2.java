class Person {
    String name;
    String personId;

    public Person(String name, String personId) {
        this.name = name;
        this.personId = personId;
    }
}

// Interface Worker
interface Worker {
    void performDuties();
}

// Subclass Chef that inherits from Person and implements Worker
class Chef extends Person implements Worker {
    String specialty;

    public Chef(String name, String personId, String specialty) {
        super(name, personId);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + ", the chef, is cooking " + specialty + ".");
    }
}

// Subclass Waiter that inherits from Person and implements Worker
class Waiter extends Person implements Worker {
    String section;

    public Waiter(String name, String personId, String section) {
        super(name, personId);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println(name + ", the waiter, is serving customers in section " + section + ".");
    }
}

// Main class to demonstrate the system
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("John", "C123", "Pasta");
        Waiter waiter = new Waiter("Emma", "W456", "A");

        chef.performDuties();
        waiter.performDuties();
    }
}

