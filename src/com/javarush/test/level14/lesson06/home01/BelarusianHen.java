package com.javarush.test.level14.lesson06.home01;

/**
 * Created by user on 28.12.2015.
 */
public class BelarusianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 12;
    }
    public String getDescription() {

        return super.getDescription() + " Моя страна - "+ Country.BELARUS+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";

    }
}
