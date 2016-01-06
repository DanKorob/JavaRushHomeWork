package com.javarush.test.level18.lesson03.task04;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        // number, count
        HashMap<Integer, Integer> repeatList = new HashMap<Integer, Integer>();

        int n = 0;
        while (fileIn.available() > 0)
        {
            n = fileIn.read();
            if (repeatList.containsKey(n))
                repeatList.put(n,repeatList.get(n) + 1);
            else
                repeatList.put(n, 1);
        }

        int min = repeatList.get(n);
        for (Map.Entry<Integer, Integer> x : repeatList.entrySet())
        {
            int b = x.getValue();
            if (b < min)
                min = b;
        }

        for (Map.Entry<Integer, Integer> x: repeatList.entrySet())
        {
            if (x.getValue().equals(min))
                System.out.print(x.getKey() + " ");
        }

        reader.close();
        fileIn.close();
    }
}
