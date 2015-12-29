package com.javarush.test.level15.lesson12.home04;

/**
 * Created by user on 29.12.2015.
 */
public class Earth implements Planet
{
    private static Earth INSTANCE = null;

    private Earth(){}

    public static Earth getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Earth();
        return INSTANCE;
    }
}
