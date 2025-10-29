package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new Book(1, "Java Basics", "John Doe");
        Book book2 = new Book(2, "OOP Concepts", "Jane Smith");

        library.addBook(book1);
        library.addBook(book2);

        // Create members
        StudentMember s1 = new StudentMember(101, "Alice");
        AdultMember a1 = new AdultMember(102, "Bob");

        library.addMember(s1);
        library.addMember(a1);

        // Borrow books
        library.borrowBook(s1, book1);
        library.borrowBook(a1, book2);

        // Show borrowed books
        library.showBorrowedBooks();

        // Show late fee calculation
        System.out.println(s1.getName() + " late fee for 4 days: " + s1.calculateLateFee(4));

    }
}
