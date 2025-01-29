package com.streamex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class javaDate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedNow = now.format(formatter);
        System.out.println("time and date now : " + formattedNow);

        LocalDateTime after5Hours = now.plusHours(5);
        String timeafter5hr = after5Hours.format(formatter);
        System.out.println("after 5 hours : " + timeafter5hr);

        LocalDateTime after1Week = now.plusWeeks(1);
        String timeafter1week = after1Week.format(formatter);
        System.out.println("after 1 week : " + timeafter1week);

        LocalDateTime after1Month = now.plusMonths(1);
        String timeafter1month = after1Month.format(formatter);
        System.out.println("after 1 month : " + timeafter1month);
    }
}

