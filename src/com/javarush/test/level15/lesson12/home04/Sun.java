package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Чешир on 11.04.2016.
 */
public class Sun implements Planet
{
    private static Sun instance = null;

    private Sun(){};

    public static Sun getInstance()
    {
        if (instance == null) {
            instance = new Sun();
        }

        return instance;
    }
}
