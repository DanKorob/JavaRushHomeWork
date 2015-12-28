package com.javarush.test.level14.lesson06.home01;

/**
 * Created by user on 28.12.2015.
 */
public class UkrainianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 32;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE+ ". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
