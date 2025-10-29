package org.example;

public class Member {
    public int id;
    public String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * 1.0; // default fee
    }

    public void showInfo() {
        System.out.println("Member ID: " + id + ", Name: " + name);
    }
}

