package com.workintech.operations;


import com.workintech.database.Database;
import com.workintech.user.Admin;
import com.workintech.user.Member;
import com.workintech.user.User;

import java.util.Scanner;

public class ViewBook implements Operations {


    @Override
    public void oper(Database database, User user) {
        Member member = new Member();
        User admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        database.getBooks();
        System.out.println("1-Kütüphane İşlemleri \n2-Üye İşlemleri");
        int num = scanner.nextInt();
        if (num == 1) {
            admin.menu(database, admin);
        } else if (num == 2) {
            database.getUsers();

            System.out.println("İşlem yapılacak üyenin id'sini giriniz:");
            int id = scanner.nextInt();
            User foundUser=database.getMember(id);
            member.menu(database, foundUser);
        }

    }
}