package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Чешир on 07.04.2016.
 */
public class Singleton
{
    private static Singleton INSTANCE = new Singleton();

    public static Singleton getInstance(){
        return INSTANCE;
    }

    private Singleton()
    {
    }

}
