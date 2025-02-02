class Book {
    String title;
    String author;
    double price;
    boolean isAvailable;

    // Constructor
    Book(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to borrow a book
    void borrowBook() {
        if (isAvailable) {
            System.out.println("You have successfully borrowed: " + title);
            isAvailable = false; // Mark book as borrowed
        } else {
            System.out.println("Sorry, " + title + " is currently unavailable.");
        }
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        // Creating a book instance
        Book book = new Book("The Alchemist", "Paulo Coelho", 19.99, true);
        book.displayDetails();

        System.out.println(); // Line break

        // Borrowing the book
        book.borrowBook();

        System.out.println(); // Line break

        // Trying to borrow again
        book.borrowBook();
    }
}
