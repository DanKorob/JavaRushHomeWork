package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Sony on 02.01.2016.
 */
public class Thread2 extends Thread
{
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }

    }
}
