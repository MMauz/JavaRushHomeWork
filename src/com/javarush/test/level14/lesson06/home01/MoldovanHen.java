package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Чешир on 05.04.2016.
 */
public class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 60;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - Moldova. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
