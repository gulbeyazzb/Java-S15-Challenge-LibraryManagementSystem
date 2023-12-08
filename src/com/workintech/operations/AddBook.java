package com.workintech.operations;

import com.workintech.book.Book;
import com.workintech.database.Database;
import com.workintech.user.Admin;
import com.workintech.user.Member;
import com.workintech.user.User;

import java.util.Scanner;

public class AddBook implements Operations {
    @Override
    public void oper(Database database, User user) {
        Member member = new Member();
        User admin = new Admin();
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kitap ID giriniz:");
        book.setBookID(Long.parseLong(scanner.nextLine()));

        System.out.println("Kitap ismini giriniz:");
        book.setName(scanner.nextLine());

        System.out.println("Kitabın yazarını giriniz:");
        book.setAuthor(scanner.nextLine());

        System.out.println("Kitabın fiyatını giriniz:");
        book.setPrice(scanner.nextDouble());

        System.out.println("Kitabın yayıncısını giriniz:");
        book.setPublisher(scanner.next());

        System.out.println("Kitabın durumunu giriniz:");
        book.setStatus(scanner.next());


        database.addBook(book);
        System.out.println("1-Kütüphane İşlemleri \n2-Üye İşlemleri");
        int num = scanner.nextInt();
        if (num == 1) {
            admin.menu(database, admin);
        } else if (num == 2) {
            database.getUsers();
            System.out.println("İşlem yapılacak üyenin id'sini giriniz:");
            int id = scanner.nextInt();
            database.getMember(id);
            member.menu(database, user);
        }
    }


}
