package com.jpmc.theater.discounts;

import com.jpmc.theater.Showing;

import java.time.LocalDateTime;

public class ElevenAmToFourPmDiscount implements Discount {
    @Override
    public double getDiscount(Showing showing) {
        double discountFor11amTo4pmMovies = 0;
        final LocalDateTime now = LocalDateTime.now();
        int hour = showing.getStartTime().getHour();
        final LocalDateTime minRange = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 11, 00);
        LocalDateTime maxRange = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 16, 00);
        if ((hour >= 11) && (hour <= 16)) {
            if (hour == 16) {
                if (showing.getStartTime().getMinute() > 0) {
                    return discountFor11amTo4pmMovies;
                }
            }
            discountFor11amTo4pmMovies = showing.getMovie().getTicketPrice() * 0.25;
        }
        return discountFor11amTo4pmMovies;
    }
}
