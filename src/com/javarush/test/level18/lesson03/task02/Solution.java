package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileIn = new FileInputStream(reader.readLine());

        int min = fileIn.read();
        int b = 0;
        while (fileIn.available() > 0)
        {
            b = fileIn.read();
            if (b < min)
                min = b;
        }

        System.out.println(min);

        reader.close();
        fileIn.close();

    }
}
