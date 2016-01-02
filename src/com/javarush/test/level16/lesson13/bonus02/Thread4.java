package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Sony on 02.01.2016.
 */
public class Thread4 extends Thread implements Message
{
    @Override
    public void showWarning()
    {
        this.interrupt();
        try
        {
            this.join();
        }
        catch (InterruptedException e)
        {

        }
    }

    @Override
    public void run()
    {
        while(!isInterrupted())
        {

        }
    }
}
