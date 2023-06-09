package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Theater {

    private LocalDateProvider provider;

    private List<Showing> schedule;

    /**
     * Theater
     *
     * @param provider
     */
    public Theater(LocalDateProvider provider) {
        this.provider = provider;

        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        schedule = List.of(
                new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
                new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
                new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
                new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
                new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
                new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
                new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
                new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
                new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
        );
    }

    /**
     * Reserve a reservation for a customer
     *
     * @param customer
     * @param sequence
     * @param howManyTickets
     * @return
     */
    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        if (customer == null) {
            throw new IllegalStateException("not able to find customer is reservation " + sequence);
        }

        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence, ex);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    /**
     * Prints the Theatre schedule
     */
    public void printSchedule() {
        printScheduleText();
        printScheduleJson();
    }

    /**
     * Prints the Theatre schedule in json format
     */
    private void printScheduleJson() {
        System.out.println(schedule.toString());
    }

    /**
     * Prints the Theatre schedule in text format
     */
    private void printScheduleText() {
        System.out.println(provider.currentDate());
        System.out.println("===================================================");
        schedule.forEach(s -> System.out.println(s.toString()));
        System.out.println("===================================================");
    }

    public static void main(String[] args) {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}
