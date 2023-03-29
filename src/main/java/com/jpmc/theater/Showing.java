package com.jpmc.theater;

import com.jpmc.theater.util.Util;

import java.time.LocalDateTime;

/**
 * Showing class
 */
public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    /**
     * getStartTime
     *
     * @return
     */
    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    /**
     * isSequence
     *
     * @param sequence
     * @return boolean
     */
    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    /**
     * getMovieFee
     *
     * @return double
     */
    public double getMovieFee() {
        return movie.getTicketPrice();
    }

    /**
     * getSequenceOfTheDay
     *
     * @return int
     */
    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    /**
     * calculateFee
     *
     * @param audienceCount
     * @return double
     */
    private double calculateFee(int audienceCount) {
        return movie.calculateTicketPrice(this) * audienceCount;
    }

    /**
     * Returns the object string representation in json format
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        builder.append("\"sequence\" : \"" + getSequenceOfTheDay() + "\", ");
        builder.append("\"start_time\" : \"" + getStartTime() + "\", ");
        builder.append("\"title\" : \"" + getMovie().getTitle() + "\", ");
        builder.append("\"running_time\" : \"" + Util.GetInHumanReadableFormat(getMovie().getRunningTime()) + "\", ");
        builder.append("\"ticket\" : \"$" + getMovieFee() + "\"");
        builder.append(" }");
        return builder.toString();
    }
}
