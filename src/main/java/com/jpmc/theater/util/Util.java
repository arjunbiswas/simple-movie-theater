package com.jpmc.theater.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Util {

    /**
     * GetMax
     *
     * @param num
     * @return
     */
    public static double GetMax(double... num) {
        double max = Double.MIN_VALUE;
        for (double currentNumber : num) {
            if (currentNumber > max) {
                max = currentNumber;
            }
        }
        return max;
    }

    /**
     * GetInHumanReadableFormat
     *
     * @param duration
     * @return String
     */
    public static String GetInHumanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());
        return String.format("(%s hour%s %s minute%s)", hour, HandlePlural(hour), remainingMin, HandlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private static String HandlePlural(long value) {
        String fixed = ((value == 1) ? "" : "s");
        return fixed;
    }
}
