package com.jpmc.theater;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateProviderTests {

    @Test
    void makeSureCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDate currentlocalDateFromProvider = LocalDateProvider.singleton().currentDate();
        Assertions.assertEquals(currentlocalDateFromProvider , LocalDate.now());
    }
}
