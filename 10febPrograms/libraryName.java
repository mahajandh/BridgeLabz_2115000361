import java.util.*;

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

// Interface Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved: " + getTitle());
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved: " + getTitle());
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        
        LibraryItem item1 = new Book("B101", "Java Programming", "John Doe");
        LibraryItem item2 = new Magazine("M202", "Tech Weekly", "Jane Smith");
        LibraryItem item3 = new DVD("D303", "Inception", "Christopher Nolan");
        
        items.add(item1);
        items.add(item2);
        items.add(item3);
        
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails() + " | Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
                System.out.println("Availability: " + ((Reservable) item).checkAvailability());
            }
        }
    }
}
