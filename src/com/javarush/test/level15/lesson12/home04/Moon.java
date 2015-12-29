package com.javarush.test.level15.lesson12.home04;

/**
 * Created by user on 29.12.2015.
 */
public class Moon implements Planet
{
    private static Moon INSTANCE = null;

    private Moon(){}

    public static Moon getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Moon();
        return INSTANCE;
    }
}
