package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Sony on 02.01.2016.
 */
public class Thread3 extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                System.out.println("Ура");
                Thread.sleep(500);
            }
            catch (InterruptedException ignore){/*NOP*/}
        }
    }
}
