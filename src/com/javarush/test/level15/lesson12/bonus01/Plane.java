package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Чешир on 12.04.2016.
 */
public class Plane implements Flyable
{
    public int passangers;

    public Plane(int x)
    {
        this.passangers = x;
    }

    @Override
    public void fly()
    {

    }
}
