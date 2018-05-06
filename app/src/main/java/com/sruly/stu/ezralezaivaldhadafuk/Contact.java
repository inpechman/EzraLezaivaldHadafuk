package com.sruly.stu.ezralezaivaldhadafuk;

/**
 * Created by stu on 5/6/2018.
 *
 */

public class Contact {
    String name;
    int birthYear;

    public Contact(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
