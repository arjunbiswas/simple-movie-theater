package com.jpmc.theater;

public class Reservation {

    private int MAX_AUDIENCE_COUNT = 10;

    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    /**
     * totalFee
     *
     * @return double
     */
    public double totalFee() {
        if (audienceCount == 0) {
            return 0;
        }
        if (audienceCount < 0) {
            return 0;
        }
        if (audienceCount > MAX_AUDIENCE_COUNT) {
            return 0;
        }
        return showing.getMovieFee() * audienceCount;
    }
}