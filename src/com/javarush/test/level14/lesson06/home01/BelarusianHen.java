package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Чешир on 05.04.2016.
 */
public class BelarusianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 90;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - Belarus. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
