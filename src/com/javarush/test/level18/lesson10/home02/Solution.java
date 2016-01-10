package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        FileInputStream fileIn = new FileInputStream(fileName);
        byte[] buffer = new byte[1000];

        int spaceCount = 0;
        int letterCount = fileIn.available();

        while (fileIn.available() > 0)
        {
            int count = fileIn.read(buffer);

            for (int x : buffer)
                if (x == 32)
                    spaceCount++;
        }

        System.out.println( (spaceCount*10000/letterCount)/100.0 );
        fileIn.close();
    }
}
