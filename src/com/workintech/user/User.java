package com.workintech.user;

import com.workintech.database.Database;
import com.workintech.operations.Operations;

public abstract class User {
    private String name;
    private String email;
    private String phoneNumber;
    protected Operations[] operations;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public abstract Operations getOper(int num);

    public String getName() {
        return name;
    }

    abstract public void menu(Database database, User user);

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
