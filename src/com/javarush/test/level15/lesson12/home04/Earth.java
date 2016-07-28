package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Чешир on 11.04.2016.
 */
public class Earth implements Planet
{
    private static Earth instance = null;

    private Earth(){};

    public static Earth getInstance()
    {
        if (instance == null) {
            instance = new Earth();
        }

        return instance;
    }

}
