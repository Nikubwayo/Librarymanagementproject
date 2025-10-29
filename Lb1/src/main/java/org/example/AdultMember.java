package org.example;

public class AdultMember extends Member {
    public AdultMember(int id, String name) {
        super(id, name);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.5; // adult pays more
    }
}

