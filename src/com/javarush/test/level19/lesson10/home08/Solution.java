package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
//        String fileName = "src\\com\\javarush\\test\\level19\\lesson10\\home08\\1.txt";

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready())
        {
            String s = fileReader.readLine();
            System.out.println(symbolRearrange(s));
        }

        consoleReader.close();
        fileReader.close();
    }

    private static String symbolRearrange(String line)
    {
        String result = "";

        char[] lineArray = line.toCharArray();

        for (int i = lineArray.length - 1; i >= 0; i--)
            result += lineArray[i];

        return result;
    }
}
