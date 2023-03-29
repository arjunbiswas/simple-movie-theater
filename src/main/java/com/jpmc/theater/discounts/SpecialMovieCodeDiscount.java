package com.jpmc.theater.discounts;

import com.jpmc.theater.Showing;

public class SpecialMovieCodeDiscount implements Discount {

    private static int MOVIE_CODE_SPECIAL = 1;

    @Override
    public double getDiscount(Showing showing) {
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == showing.getMovie().getSpecialCode()) {
            specialDiscount = showing.getMovie().getTicketPrice() * 0.2;  // 20% discount for special movie
        }
        return specialDiscount;
    }
}
