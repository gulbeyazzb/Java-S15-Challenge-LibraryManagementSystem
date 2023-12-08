package com.workintech.book;

import java.util.Objects;

public class Book {
    private long bookID;
    private String name;
    private String author;
    private String status;
    private String publisher;
    private Double price;

    public Book() {
    }

    public Book(long bookID, String name, String author, String status, String publisher, Double price) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.status = status;
        this.publisher = publisher;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void updateStatus(String status) {
        this.status = status;
    }
    public long getBookID() {
        return bookID;
    }
    public String getStatus() {
        return status;
    }
    public void setBookID(long bookID) {
        this.bookID = bookID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
}
