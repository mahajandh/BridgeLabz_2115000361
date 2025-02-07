class Book {
    String title;
    int publicationYear;

    // Constructor
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book details
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass: Author
class Author extends Book {
    String name;
    String bio;

    // Constructor
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);  // Calling Book's constructor
        this.name = name;
        this.bio = bio;
    }

    // Overriding displayInfo method to include author details
    @Override
    void displayInfo() {
        super.displayInfo();  // Displaying book info
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main Class to test the Library Management System
public class LibraryManagement {
    public static void main(String[] args) {
        // Creating an Author object (which also holds Book details)
        Author author = new Author("The Great Adventure", 2023, "John Doe", "John Doe is an experienced writer who specializes in adventure novels.");

        // Displaying details of the book and author
        System.out.println("Book and Author Details:");
        author.displayInfo();
    }
}

