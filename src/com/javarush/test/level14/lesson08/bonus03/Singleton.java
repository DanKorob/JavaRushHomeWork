package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by user on 28.12.2015.
 */
public class Singleton
{
    private static Singleton instance = new Singleton();

    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        if (instance == null)
            return new Singleton();
        return instance;
    }
}
