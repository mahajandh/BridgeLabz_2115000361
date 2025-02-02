class Book {
    public String ISBN;  // Public variable
    protected String title;  // Protected variable
    private String author;  // Private variable

    // Constructor to initialize book details
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to get the author's name
    public String getAuthor() {
        return author;
    }

    // Public method to set the author's name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass EBook demonstrating the use of access modifiers
class EBook extends Book {

    // Constructor to initialize eBook details
    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    // Method to display eBook details (accessing protected and public members)
    void displayEBookDetails() {
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ISBN);  // Accessing public variable
        System.out.println("Title: " + title);  // Accessing protected variable
        System.out.println("Author: " + getAuthor());  // Accessing private member via public getter
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        // Creating a Book instance
        Book book = new Book("978-3-16-148410-0", "Java Programming", "James Gosling");
        book.displayDetails();

        // Modifying the author name using setter method
        book.setAuthor("Herbert Schildt");
        System.out.println("\nAfter Author Update:");
        book.displayDetails();

        // Creating an EBook instance
        EBook eBook = new EBook("978-1-26-512366-6", "Advanced Java", "Bruce Eckel");
        eBook.displayEBookDetails();
    }
}
