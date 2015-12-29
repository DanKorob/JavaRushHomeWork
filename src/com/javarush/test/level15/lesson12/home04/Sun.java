package com.javarush.test.level15.lesson12.home04;

/**
 * Created by user on 29.12.2015.
 */
public class Sun implements Planet
{
    private static Sun INSTANCE = null;

    private Sun(){}

    public static Sun getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Sun();
        return INSTANCE;
    }
}
