package com.javarush.test.level08.lesson11.home09;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        String date = "JANUARY 2 2002";
        System.out.println(date+" = "+isDateOdd(date));

    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date currentTime = format.parse(date);

        Date yearStartTime = new Date(currentTime.getTime());
        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);


        long msDays = currentTime.getTime() - yearStartTime.getTime();
        int days = (int) (1+msDays/(1000*60*60*24));

        return (days%2 == 0) ? false : true;
    }
}
