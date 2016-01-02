package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Sony on 02.01.2016.
 */
public class Thread5 extends Thread
{
    @Override
    public void run() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        try
        {
            while (true)
            {
                String s = r.readLine();
                if (s.equals("N")) break;
                sum += Integer.parseInt(s);
            }
            r.close();
        }
        catch (IOException e) {/*NOP*/}

        System.out.println(sum);
    }
}
