package com.jpmc.theater;

import com.jpmc.theater.discounts.ElevenAmToFourPmDiscount;
import com.jpmc.theater.discounts.MovieSequenceDiscount;
import com.jpmc.theater.discounts.SeventhDayDiscount;
import com.jpmc.theater.discounts.SpecialMovieCodeDiscount;
import com.jpmc.theater.util.Util;

import javax.sound.midi.Sequence;
import java.time.Duration;
import java.util.Objects;

public class Movie {


    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing);
    }

    /**
     * ## New Requirements
     * * New discount rules; In addition to current rules
     * * Any movies showing starting between 11AM ~ 4pm, you'll get 25% discount
     * * Any movies showing on 7th, you'll get 1$ discount
     * * The discount amount applied only one if met multiple rules; biggest amount one
     * * We want to print the movie schedule with simple text & json format
     *
     * @param showing
     * @return
     */
    private double getDiscount(Showing showing) {
        double specialDiscount = new SpecialMovieCodeDiscount().getDiscount(showing);
        double sequenceDiscount = new MovieSequenceDiscount().getDiscount(showing);
        double discountFor11To4pm = new ElevenAmToFourPmDiscount().getDiscount(showing);
        double discountFor7thDay = new SeventhDayDiscount().getDiscount(showing);
        double maxDiscountAvailable = Util.GetMax(specialDiscount, sequenceDiscount, discountFor11To4pm, discountFor7thDay);
        return maxDiscountAvailable;
    }


    /**
     * @return
     */
    public int getSpecialCode() {
        return specialCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}