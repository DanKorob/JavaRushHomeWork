package com.javarush.test.level14.lesson08.bonus01;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.beans.ExceptionListener;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            Integer a = null;
            a++;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        Object ch = new Character('*');
        try
        {
            System.out.println((Byte)ch);
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new RuntimeException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalStateException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        int i = 6;
        int[] nArray = new int[5];

        try
        {
            nArray[i] = i;
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        String szShortString = "123";
        try
        {
            char chr = szShortString.charAt(10);
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        Object szStr[] = new String[10];

        try
        {
            szStr[0] = new Character('*');
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] nNegArray = new int[-5];
        }
        catch(Exception e)
        {
             exceptions.add(e);
        }

        try
        {
            throw new ClassNotFoundException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
