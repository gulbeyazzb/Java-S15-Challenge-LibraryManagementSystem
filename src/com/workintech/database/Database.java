package com.workintech.database;

import com.workintech.book.Book;
import com.workintech.user.Member;
import com.workintech.user.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Database {
    //*************************************************INSTANCE VARIABLES*****************************************************************
    private Map<Integer, User> users;
    private Map<Long, Book> books;
    private Map<Book, User> barrowBooks;
    private Map<Map, String> barrowedDate;


    public Database() {
    }

    public Database(Map<Book, User> barrowBooks, Map<Map, String> barrowedDate) {
        this.barrowBooks = barrowBooks;
        this.barrowedDate = barrowedDate;
    }

    //*************************************************LOGIN*****************************************************************
    public boolean login(String email, int password) {
        if (email.equals("g@gmail.com") && password == 123) {
            System.out.println("Hoşgeldin Gülbeyaz Özer!");
            return true;
        } else {
            return false;
        }
    }


    //*************************************************USER/MEMBER*****************************************************************
    public void addUser(int id, String name, String email, String phoneNumber) {
        users.putIfAbsent(id, new Member(name, email, phoneNumber));
        System.out.println("Üye başarılı bir şekilde eklendi!");
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public void getUsers() {
        for (Map.Entry user : users.entrySet()) {
            System.out.println(user);
        }
    }

    public User getMember(int id) {
        User foundUser = new Member();
        boolean hasId = users.containsKey(id);
        if (hasId) {
            for (Map.Entry user : users.entrySet()) {
                if (user.getKey().equals(id)) {
                    foundUser = (User) user.getValue();
                }
            }
        }
        return foundUser;
    }

    //*******************************BOOK*********************************************************************************
    public void addBook(Book book) {
        books.put(book.getBookID(), book);
        System.out.println("Kitap başarılı bir şekilde eklendi!");
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }

    public void deleteBook(long id) {
        boolean wasItDeleted = false;
        for (Map.Entry entry : books.entrySet()) {
            long bookID = (Long) entry.getKey();
            if (bookID == id) {
                books.remove(entry.getKey(), entry.getValue());
                wasItDeleted = true;
                break;
            }
        }
        if (wasItDeleted) {
            System.out.println("Kitap başarıyla silindi.Kütüphanedeki kitaplar: ");
            getBooks();
        } else {
            System.out.println("Kitap bulunamadı...");
        }
    }

    public void getBooks() {
        for (Map.Entry book : books.entrySet()) {
            System.out.println(book);
        }
    }

    public void barrowBook(User user, long id) {  //foundUser yani id'si seçilen user burada
        List<Book> barrowBooksOfUser = new ArrayList<>();
        Book barrowedBook = new Book();
        boolean found = false;

        Date date = new Date();
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String today = f.format(date);
        for (Map.Entry entry : barrowBooks.entrySet()) {
            if (entry.getValue().equals(user)) {
                barrowBooksOfUser.add((Book) entry.getKey());
            }
        }
        if (barrowBooksOfUser.size() == 5) {
            System.out.println("Daha fazla kitap ödünç alamazsınız.");
        } else {

            for (Map.Entry book : books.entrySet()) {
                Long key = (Long) book.getKey();
                if (key.equals(id)) {
                    barrowedBook = (Book) book.getValue();
                    System.out.println("Ödünç alınmak istenen kitap: " + barrowedBook);
                    found = true;
                    break;
                }
            }
            if (found) {
                if (barrowedBook.getStatus().toLowerCase().contains("alındı")) {
                    System.out.println(barrowedBook.getStatus());
                    for (Map.Entry entry : barrowBooks.entrySet()) {
                        if (entry.getKey().equals(barrowedBook)) {
                            System.out.println(barrowedBook.getName() + " " + entry.getValue() + " isimli üyede.");
                            break;
                        }
                    }
                }
                if (barrowedBook.getStatus().toLowerCase().contains("rafta")) {
                    barrowBooks.put(barrowedBook, user);
                    setBarrowedDate(barrowBooks, today);
                    barrowedBook.updateStatus(user.getName() + " tarafından kitap " + today + " tarihinde ödünç alındı");
                    System.out.println("ödünç alma işlemi başarılı");
                }
            }


            if (!found) {
                System.out.println("Girilen id'de kitap bulunamadı...");
            }
        }
    }

    public void setBarrowedDate(Map<Book, User> barrowbooks, String date) {
        barrowedDate.put(barrowbooks, date);
    }


    public void getBarrowBooks(User user) {  //----------id si girilen user gelir---------------
        boolean hasUser = barrowBooks.containsValue(user);
        if (hasUser) {
            System.out.println(user.getName() + "'e ait kitaplar:\n");
            for (Map.Entry entry : barrowBooks.entrySet()) {
                if (entry.getValue().equals(user)) {
                    System.out.println(entry.getKey());

                }
            }
        } else {
            System.out.println("üyeye ait kitap bulunamadı");
        }
    }

    public Map<Map, String> getBarrowedDate() {
        return barrowedDate;
    }

    public void returnBook(User user) {
        Book returnedBook;
        Book foundBook = new Book();
        String barrowedTime = "1";

        Date date = new Date();
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String today = f.format(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        getBarrowBooks(user);
        System.out.println("İade edilecek kitabın id'sini giriniz:");
        Scanner scanner = new Scanner(System.in);
        long scannerID = scanner.nextLong();
        for (Map.Entry dateMap : barrowedDate.entrySet()) {
            Map<Book, User> bookUserMap = (Map) dateMap.getKey();
            barrowedTime = (String) dateMap.getValue();
            for (Map.Entry entry2 : bookUserMap.entrySet()) {
                returnedBook = (Book) entry2.getKey();
                if (returnedBook.getBookID() == scannerID) {
                    foundBook = returnedBook;
                    break;
                }
            }
        }

        LocalDate date1 = LocalDate.parse(barrowedTime, formatter);
        LocalDate date2 = LocalDate.parse(today, formatter);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        if (daysBetween > -1) {
            daysBetween = daysBetween;
        } else {
            daysBetween = daysBetween * (-1);
        }
        if (daysBetween > 365) {
            System.out.println("ceza aldın.");
        } else {
            System.out.println("cezan yok");
        }
        if (barrowBooks.containsKey(foundBook)) {
            barrowBooks.remove(foundBook, user);
            foundBook.updateStatus("rafta");
        }

    }


}
