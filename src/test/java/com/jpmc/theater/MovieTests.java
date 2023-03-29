package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {

    @Test
    void specialMovieWith50PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MARCH, 29, 19, 30, 40);
        Showing showing = new Showing(spiderMan, 5, dateTime);
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWithSequenceDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MARCH, 29, 19, 30, 40);
        Showing showing = new Showing(spiderMan, 2, dateTime);
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWith11AMto4PMDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        LocalDateTime three = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(), 15, 00);
        LocalDateTime seventhDay = LocalDateTime.of(2023, Month.MARCH, 8, 11, 30, 40);
        Showing showing = new Showing(spiderMan, 5, three);
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWith7thDayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        LocalDateTime seventhDay = LocalDateTime.of(2023, Month.MARCH, 7, 10, 30, 40);
        Showing showing = new Showing(spiderMan, 5, seventhDay);
        assertEquals(10.0, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWithNoDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        LocalDateTime eighthDay = LocalDateTime.of(2023, Month.MARCH, 8, 10, 30, 40);
        Showing showing = new Showing(spiderMan, 5, eighthDay);
        assertEquals(12.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWithSequenceDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MARCH, 29, 19, 30, 40);
        Showing showing = new Showing(spiderMan, 2, dateTime);
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWith11AMto4PMDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MARCH, 29, 11, 30, 40);
        Showing showing = new Showing(spiderMan, 5, dateTime);
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWithAllDiscounts() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MARCH, 7, 11, 30, 40);
        Showing showing = new Showing(spiderMan, 2, dateTime);
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWithin11AMto4PMAnd7dayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        LocalDate seventhDay = LocalDateProvider.singleton().currentDate().withDayOfMonth(7);
        LocalTime twelveTwenty = LocalTime.of(12, 20, 45, 342123342);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(seventhDay, twelveTwenty));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieAt11AMAnd7dayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        LocalDate seventhDay = LocalDateProvider.singleton().currentDate().withDayOfMonth(7);
        LocalTime twelveTwenty = LocalTime.of(11, 00, 00, 000000);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(seventhDay, twelveTwenty));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieAt4AMAnd7dayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        LocalDate seventhDay = LocalDateProvider.singleton().currentDate().withDayOfMonth(7);
        LocalTime twelveTwenty = LocalTime.of(16, 00, 00, 000000);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(seventhDay, twelveTwenty));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWithStartAfter4PMAnd7dayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        LocalDate seventhDay = LocalDateProvider.singleton().currentDate().withDayOfMonth(7);
        LocalTime twelveTwenty = LocalTime.of(16, 20, 45, 342123342);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(seventhDay, twelveTwenty));
        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWith7thDayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        LocalDateTime seventhDay = LocalDateTime.of(2023, Month.MARCH, 7, 10, 30, 40);
        Showing showing = new Showing(spiderMan, 5, seventhDay);
        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));
    }

}
