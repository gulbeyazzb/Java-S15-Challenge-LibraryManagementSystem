package com.workintech.operations;

import com.workintech.database.Database;
import com.workintech.user.Admin;
import com.workintech.user.Member;
import com.workintech.user.User;
import java.util.Scanner;

public class BarrowBook implements Operations {
    @Override
    public void oper(Database database, User user) {  //artık user=founduser.
        Member member = new Member();
        User admin = new Admin();
        database.getBooks();
        System.out.println("ödünç alınacak kitabın id'sini giriniz:");
        Scanner scanner = new Scanner(System.in);
        long bookid = scanner.nextLong();
        database.barrowBook(user, bookid);


        System.out.println("1-Kütüphane İşlemleri \n2-Üye İşlemleri");
        int num = scanner.nextInt();
        if (num == 1) {
            admin.menu(database, admin);
        } else if (num == 2) {
            database.getUsers();

            System.out.println("İşlem yapılacak üyenin id'sini giriniz:");
            int Memberid = scanner.nextInt();
            User foundUser = database.getMember(Memberid);
            member.menu(database, foundUser);
        }
    }
}
