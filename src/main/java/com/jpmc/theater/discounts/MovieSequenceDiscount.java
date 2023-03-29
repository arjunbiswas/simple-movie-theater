package com.jpmc.theater.discounts;

import com.jpmc.theater.Showing;

public class MovieSequenceDiscount implements Discount {
    @Override
    public double getDiscount(Showing showing) {
        double sequenceDiscount = 0;
        if (showing.getSequenceOfTheDay() == 1) {
            sequenceDiscount = 3;
        } else if (showing.getSequenceOfTheDay() == 2) {
            sequenceDiscount = 2;
        }
        return sequenceDiscount;
    }
}
