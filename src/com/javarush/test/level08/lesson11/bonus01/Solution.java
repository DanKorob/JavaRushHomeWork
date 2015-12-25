package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        HashMap<String, Integer> mapDate = new HashMap<String, Integer>();

        mapDate.put("January", 1);
        mapDate.put("February", 2);
        mapDate.put("March", 3);
        mapDate.put("April", 4);
        mapDate.put("May", 5);
        mapDate.put("June", 6);
        mapDate.put("July", 7);
        mapDate.put("August", 8);
        mapDate.put("September", 9);
        mapDate.put("October", 10);
        mapDate.put("November", 11);
        mapDate.put("December", 12);

        int numMonth = mapDate.get(month);

        System.out.println(month + " is " + numMonth + " month");
    }

}
