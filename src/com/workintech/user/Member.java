package com.workintech.user;

import com.workintech.database.Database;
import com.workintech.operations.*;
import java.util.Scanner;

public class Member extends User {
    String fineStatus;

    public Member() {
//        this.operations = new Operations[]{
//                new BarrowBook(),
//                new CalculateFine(),
//                new ViewBarrowBooks(),
//                new ReturnBook(),
//                new Exit(),
//        };
    }

    public Member(String name) {
        super(name);
    }

    public Member(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        this.fineStatus = "cezanız yok";
    }

    public Operations getOper(int num) {
        switch (num) {
            case 0:
                return new BarrowBook();
            case 1:
                return new CalculateFine();
            case 2:
                return  new ViewBarrowBooks();
            case 3:
                return new ReturnBook();
            case 4:
                return new Exit();
            default:
                System.out.println("geçersiz değer girildi.");
                return new Exit();
        }
    }

    public String getFineStatus() {
        return fineStatus;
    }

    public void setFineStatus(String fineStatus) {
        this.fineStatus = fineStatus;
    }

    @Override
    public void menu(Database database, User user) {
        System.out.println("0-Kitap Ödünç Al");
        System.out.println("1-Cezayı Hesapla");
        System.out.println("2-Ödünç Alınan Kitapları Görüntüle");
        System.out.println("3-Kitabı İade Et");
        System.out.println("4-ÇIKIŞ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getOper(n).oper(database, user);
        //this.operations[n].oper(database, user);
    }
}

