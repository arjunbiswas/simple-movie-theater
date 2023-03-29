package com.jpmc.theater.discounts;

import com.jpmc.theater.Showing;

public class SeventhDayDiscount implements Discount {
    @Override
    public double getDiscount(Showing showing) {
        double discountForDayOfMonth = 0;
        int dayOfMonth = showing.getStartTime().getDayOfMonth();
        if (dayOfMonth == 7) {
            discountForDayOfMonth = 1;
        }
        return discountForDayOfMonth;
    }
}
