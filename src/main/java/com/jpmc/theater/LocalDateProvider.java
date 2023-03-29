package com.jpmc.theater;

import java.time.LocalDate;

public class LocalDateProvider {

    private static final LocalDateProvider instance = new LocalDateProvider();

    /**
     * private constructor to avoid client applications using the constructor
     */
    private LocalDateProvider() {
    }

    /**
     * @return make sure to return singleton instance
     */
    public static LocalDateProvider singleton() {
        return instance;
    }

    public LocalDate currentDate() {
        return LocalDate.now();
    }
}
