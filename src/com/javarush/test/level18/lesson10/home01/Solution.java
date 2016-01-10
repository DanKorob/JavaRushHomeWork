package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        FileInputStream fileIn = new FileInputStream(fileName);
        byte[] buffer = new byte[1000];
        int letterCount = 0;

        while (fileIn.available() > 0)
        {
            int count = fileIn.read(buffer);

            for (int x : buffer)
                if (x >= 97 && x <= 122 || x >= 65 && x <= 90)
                    letterCount++;
        }

        System.out.println(letterCount);
        fileIn.close();
    }
}
