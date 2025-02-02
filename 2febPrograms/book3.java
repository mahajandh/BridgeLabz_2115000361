class B\ook {
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Using default constructor
        Book defaultBook = new Book();
        defaultBook.displayDetails();

        System.out.println(); // Line break

        // Using parameterized constructor
        Book paramBook = new Book("The Alchemist", "Paulo Coelho", 19.99);
        paramBook.displayDetails();
    }
}

