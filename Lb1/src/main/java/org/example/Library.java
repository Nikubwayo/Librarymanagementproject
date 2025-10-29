package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> books = new ArrayList<>();
    public List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void borrowBook(Member member, Book book) {
        if (!book.isBorrowed) {
            book.isBorrowed = true;
            System.out.println(member.name + " borrowed " + book.title);
        } else {
            System.out.println(book.title + " is already borrowed.");
        }
    }

    public void showBorrowedBooks() {
        System.out.println("\nBorrowed Books:");
        for (Book book : books) {
            if (book.isBorrowed) {
                System.out.println("- " + book.title);
            }
        }
    }
}

