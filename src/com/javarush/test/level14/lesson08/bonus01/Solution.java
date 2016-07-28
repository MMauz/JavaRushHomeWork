package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] array = new int[2];
            int a = array[3];

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] array = new int[-2];

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int a = Integer.parseInt(null);
            int[] array = new int[a];

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NullPointerException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ArrayStoreException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ClassCastException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalThreadStateException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new UnsupportedOperationException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
