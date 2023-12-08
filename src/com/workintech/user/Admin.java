package com.workintech.user;

import com.workintech.database.Database;
import com.workintech.operations.*;

import java.util.Scanner;

public class Admin extends User {


    public Admin() {

    }

    public Admin(String name) {
        super(name);
//        this.operations = new Operations[]{
//                new ViewBook(),
//                new AddBook(),
//                new DeleteBook(),
//                new ViewMembers(),
//                new AddMember(),
//                new Exit(),
//
//        };
    }

    public Operations getOper(int num) {
        switch (num) {
            case 0:
                return new ViewBook();
            case 1:
                return new AddBook();
            case 2:
                return  new DeleteBook();
            case 3:
                return new ViewMembers();
            case 4:
                return new AddMember();
            case 5:
                return new Exit();
            default:
                System.out.println("geçersiz değer girildi.");
                return new Exit();
        }
    }

    @Override
    public void menu(Database database, User user) {
        System.out.println("0-Kitapları Görüntüle");
        System.out.println("1-Kitap Ekle");
        System.out.println("2-Kitap Sil");
        System.out.println("3-Üyeleri Görüntüle");
        System.out.println("4-Üye Ekle");
        System.out.println("5-ÇIKIŞ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getOper(n).oper(database, user);
    }
}