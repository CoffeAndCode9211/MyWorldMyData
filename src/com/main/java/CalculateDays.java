package com.main.java;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class CalculateDays {


    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1988, Month.AUGUST, 27);
        Period p = Period.between(birthday, today);
        System.out.println(p.getYears() + "Y " + p.getMonths() + "M " + p.getDays() + "D");
    }


}
