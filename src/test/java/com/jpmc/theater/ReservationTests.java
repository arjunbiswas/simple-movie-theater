package com.jpmc.theater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    private Customer customer;

    @BeforeEach
    public void beforeEachTest() {
        customer = Mockito.mock(Customer.class);
    }


    @Test
    void totalFee() {
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        assertTrue(new Reservation(customer, showing, 3).totalFee() == 37.5);
    }

    @Test
    void totalFeeAddingTwoPlacedDecimal() {
        LocalDateTime ldt = LocalDateTime.now();
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.50, 1),
                1,
                ldt.minus(1, ChronoUnit.DAYS)
        );
        assertTrue(new Reservation(customer, showing, 3).totalFee() == 37.50);
    }

    @Test
    void totalFeeAudienceCountZero() {
        var customer = new Customer("John Doe", "unused-id");
        LocalDateTime ldt = LocalDateTime.now();
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.50, 1),
                1,
                ldt.minus(1, ChronoUnit.DAYS)
        );
        assertTrue(new Reservation(customer, showing, 0).totalFee() == 0);
    }

    @Test
    void totalFeeAudienceCountNegative() {
        var customer = new Customer("John Doe", "unused-id");
        LocalDateTime ldt = LocalDateTime.now();
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.50, 1),
                1,
                ldt.minus(1, ChronoUnit.DAYS)
        );
        assertTrue(new Reservation(customer, showing, -1).totalFee() == 0);
    }

    @Test
    void totalFeeCheckReservationExcessAudience() {
        var customer = new Customer("John Doe", "unused-id");
        LocalDateTime ldt = LocalDateTime.now();
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.50, 1),
                1,
                ldt.minus(1, ChronoUnit.DAYS)
        );
        assertTrue(new Reservation(customer, showing, 100).totalFee() == 0);
    }
}
