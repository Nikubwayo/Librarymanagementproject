package org.example;

public class Book {
    public int id;
    public String title;
    public String author;
    public boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public void showInfo() {
        System.out.println("Book ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Borrowed: " + isBorrowed);
    }
}

