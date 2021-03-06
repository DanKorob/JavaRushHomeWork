package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    public static LinkedList<String> lineList = new LinkedList<String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            line = replaceNumbers(line);
            lineList.add(line);
        }
        bufferedReader.close();

        for (String s : lineList)
            System.out.println(s);
    }

    private static String replaceNumbers(String line)
    {
        String result = "";
        String[] words = line.split(" ");

        for (String s : words)
        {
            if (s.matches("((1[012])|[0-9])"))
                result += map.get(Integer.parseInt(s)) + " ";
            else
                result += s + " ";
        }

        return result.trim();
    }
}
