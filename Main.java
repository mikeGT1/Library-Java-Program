import java.util.ArrayList;
import java.util.Scanner;

// Superclass for Library Items
class Item {
    private String title;
    private String author;
    private int year;

    public Item(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Method to display information
    public String displayInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}

// Subclass for Books
class Book extends Item {
    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn = isbn;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Overriding the displayInfo method
    @Override
    public String displayInfo() {
        return super.displayInfo() + ", ISBN: " + isbn;
    }
}

// Subclass for Magazines
class Magazine extends Item {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    // Getters and Setters
    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    // Overriding the displayInfo method
    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Issue Number: " + issueNumber;
    }
}

// Class for Library Members
class Member {
    private String name;
    private String memberId;
    private String email;

    public Member(String name, String memberId, String email) {
        this.name = name;
        this.memberId = memberId;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to display information
    public String displayInfo() {
        return "Name: " + name + ", Member ID: " + memberId + ", Email: " + email;
    }
}

// Library class to manage items and members
class Library {
    private ArrayList<Item> items;
    private ArrayList<Member> members;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println(item.displayInfo());
        }
    }

    public void displayMembers() {
        for (Member member : members) {
            System.out.println(member.displayInfo());
        }
    }

    public Item findItem(String title) {
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
}

// Main class to interact with the user
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add Member");
            System.out.println("4. Display All Items");
            System.out.println("5. Display All Members");
            System.out.println("6. Find Item by Title");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int bookYear = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(bookTitle, bookAuthor, bookYear, isbn);
                    library.addItem(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter magazine title: ");
                    String magazineTitle = scanner.nextLine();
                    System.out.print("Enter magazine author: ");
                    String magazineAuthor = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int magazineYear = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter issue number: ");
                    int issueNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Magazine magazine = new Magazine(magazineTitle, magazineAuthor, magazineYear, issueNumber);
                    library.addItem(magazine);
                    System.out.println("Magazine added successfully!");
                    break;

                case 3:
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    Member member = new Member(memberName, memberId, email);
                    library.addMember(member);
                    System.out.println("Member added successfully!");
                    break;

                case 4:
                    library.displayItems();
                    break;

                case 5:
                    library.displayMembers();
                    break;

                case 6:
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    Item item = library.findItem(title);
                    if (item != null) {
                        System.out.println("Item found:");
                        System.out.println(item.displayInfo());
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
