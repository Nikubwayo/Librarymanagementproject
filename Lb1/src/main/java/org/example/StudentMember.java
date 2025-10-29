package org.example;

public class StudentMember extends Member {
    public StudentMember(int id, String name) {
        super(id, name);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.5;
    }

    public String getName() {
        return null;
    }
}
