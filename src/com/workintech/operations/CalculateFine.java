package com.workintech.operations;


import com.workintech.database.Database;
import com.workintech.user.Admin;
import com.workintech.user.Member;
import com.workintech.user.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class CalculateFine implements Operations {
    @Override
    public void oper(Database database, User user) {
        Member member = new Member();
        User admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        Date date = new Date();
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String today = f.format(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Map.Entry entry : database.getBarrowedDate().entrySet()) {
            String barrowedDate = (String) entry.getValue();


            LocalDate date1 = LocalDate.parse(barrowedDate, formatter);
            LocalDate date2 = LocalDate.parse(today, formatter);

            long daysBetween = ChronoUnit.DAYS.between(date1, date2);

            if (daysBetween > -1) {
                break;
            } else {
                daysBetween = daysBetween * (-1);
            }
            if (daysBetween > 365) {
                member.setFineStatus("ceza aldınız");
            } else {
                member.setFineStatus("cezanız yok");
            }
        }
        if (member.getFineStatus() == null) {
            System.out.println("Ceza yok");
        } else {
            System.out.println(member.getFineStatus());
        }
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

