package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String url = r.readLine();
        //String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";

        String[] spl = url.split("\\?");
        String[] buf = spl[1].split("&");
        String objVal = "";
        String parameters = "";

        for (int i = 0; i < buf.length; i++)
        {
            String[] q = buf[i].split("=");
            if (q[0].equals("obj"))
                objVal = q[1];

            parameters += q[0] + " ";
        }

        System.out.println(parameters);

        if (!objVal.isEmpty())
        {
            try
            {
                alert(Double.parseDouble(objVal));
            }
            catch (Exception e)
            {
                alert(objVal);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
