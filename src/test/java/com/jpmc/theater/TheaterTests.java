package com.jpmc.theater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class TheaterTests {

    private Customer customer;

    @BeforeEach
    public void beforeEachTest() {
        customer = Mockito.mock(Customer.class);
    }

    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(customer, 2, 4);
        assertEquals(reservation.totalFee(), 50);
    }

    @Test
    void totalFeeForCustomer_EmptyId() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(reservation.totalFee(), 50);
    }


    @Test
    void totalFeeForCustomer_NullCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        IllegalStateException thrown = assertThrows(IllegalStateException.class,
                () ->
                        theater.reserve(null, 2, 4),
                "not able to find customer is reservation 2"
        );
        assertTrue(thrown.getMessage().contentEquals("not able to find customer is reservation 2"));
    }

    @Test
    void totalFeeForCustomer_InvalidSequence() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        IllegalStateException thrown = assertThrows(IllegalStateException.class,
                () ->
                        theater.reserve(customer, 100, 4),
                "not able to find any showing for given sequence 100"
        );
        assertTrue(thrown.getMessage().contentEquals("not able to find any showing for given sequence 100"));
    }

    @Test
    void totalFeeForCustomer_NegativeSequence() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        IllegalStateException thrown = assertThrows(IllegalStateException.class,
                () ->
                        theater.reserve(customer, -1, 4),
                "not able to find any showing for given sequence -1"
        );
        assertTrue(thrown.getMessage().contentEquals("not able to find any showing for given sequence -1"));
    }

    @Test
    void totalFeeForCustomer_ZeroSequence() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "");
        IllegalStateException thrown = assertThrows(IllegalStateException.class,
                () ->
                        theater.reserve(john, 0, 4),
                "not able to find any showing for given sequence 0"
        );
        assertTrue(thrown.getMessage().contentEquals("not able to find any showing for given sequence 0"));
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}
