package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
              // number, count
        HashMap<Integer, Integer> repeatList = new HashMap<Integer, Integer>();

        while (fileIn.available() > 0)
        {
            int n = fileIn.read();
            if (repeatList.containsKey(n))
                repeatList.put(n,repeatList.get(n) + 1);
            else
                repeatList.put(n, 1);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> x : repeatList.entrySet())
        {
            int b = x.getValue();
            if (b > max)
                max = b;
        }

        for (Map.Entry<Integer, Integer> x: repeatList.entrySet())
        {
            if (x.getValue().equals(max))
                System.out.print(x.getKey() + " ");
        }

        reader.close();
        fileIn.close();
    }
}
