package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String path = reader.readLine();
        FileInputStream fileIn = new FileInputStream(path);

        int max = fileIn.read();
        int b = 0;
        while (fileIn.available() > 0)
        {
            b = fileIn.read();
            if (b > max)
                max = b;
        }

        System.out.println(max);

        reader.close();
        fileIn.close();
    }
}
