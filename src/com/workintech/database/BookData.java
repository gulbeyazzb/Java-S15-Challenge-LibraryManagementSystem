package com.workintech.database;

import com.workintech.book.Book;
import com.workintech.user.Member;
import com.workintech.user.User;

import java.util.HashMap;
import java.util.Map;

public class BookData {
    private Map<Long, Book> books = new HashMap<>();
    public final Map<Long, Book> books(){
        Book book1 = new Book(1,"Var Mısın?","Doğan Cüceoğlu","Rafta","Kronik",115.00);
        Book book2 = new Book(2,"Bilinçaltının Gücü","Joseph Murphy","Rafta","Diyojen",138.50 );
        Book book3 = new Book(3,"Masallar","La Fontaine","Rafta","Kültür Yayınları",84.00 );
        Book book4 = new Book(4,"Gizemli Yabancı?","Mark Twain","Rafta","Alakarga",16.0 );
        Book book5 = new Book(5,"Yeraltından Notlar","Dostoyevski","Rafta","Kültür Yayınları",12.0);
        Book book6 = new Book(6,"Satranç","Stefan Zweig","Rafta","Alakarga",10.0);

        books.put(book1.getBookID(),book1);
        books.put(book2.getBookID(),book2);
        books.put(book3.getBookID(),book3);
        books.put(book4.getBookID(),book4);
        books.put(book5.getBookID(),book5);
        books.put(book6.getBookID(),book6);

        return books;
    }


}
