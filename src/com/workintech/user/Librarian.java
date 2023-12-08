package com.workintech.user;

import com.workintech.database.BookData;
import com.workintech.database.Database;
import com.workintech.database.MemberData;

import java.util.*;

public class Librarian {

    static Scanner scanner = new Scanner(System.in);
    static Database dataBase = new Database(new HashMap<>(),new HashMap<>());

    public static void main(String[] args) {
        MemberData memberData=new MemberData();
        dataBase.setUsers(memberData.Members());

        BookData bookData=new BookData();
        dataBase.setBooks(bookData.books());


        System.out.println("KÜTÜPHANE SİSTEMİNE HOŞGELDİNİZ!");
        int num;
        do {
            System.out.println("0-Çıkış \n1-Giriş ");
            num = scanner.nextInt();

            if (num == 1) {
                login();
                break;
            }
        } while (num != 0); ///DONGU İÇİN DO WHILE KULLANDIM. NUM İÇİN İNİTİALİZE
        // DEĞER İSTEDİĞİ İÇİN DO WHILE ŞEKLİNDE TANIMLADIM
    }

    public static void login() { //Login metodunu instance kullanmadan direkt çağırabilmek için static yapıyoruz.
        boolean found = false;
        while (!found) {
            System.out.println("Lütfen email giriniz: ");
            String email = scanner.next();
            System.out.println("Lütfen şifre giriniz: ");
            int password = scanner.nextInt();
            if (dataBase.login(email, password)) {
                found = true;
                User admin=new Admin();
                admin.menu(dataBase, admin);
            } else {
                found = false;
            }
            if (!found) {
                System.out.println("1-Tekrar giriş yap \n0-Çıkış");
                int num = scanner.nextInt();
                if (num == 1) {
                    login();
                    break;
                }
                if (num == 0) {
                    break;
                }
            }
        }
    }


}
