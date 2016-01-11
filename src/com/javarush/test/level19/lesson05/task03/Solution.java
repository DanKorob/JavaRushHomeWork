package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
//        String fileName1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson05\\task03\\1.txt";
//        String fileName2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson05\\task03\\2.txt";

        Scanner scanner = new Scanner(new File(fileName1));
        FileOutputStream fileWriter = new FileOutputStream(fileName2);

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            String[] lineSpl = line.split(" ");

            for (String s : lineSpl)
            {
                try {
                    Integer num = Integer.parseInt(s); // isNumeric
                    fileWriter.write((s + " ").getBytes());
                }
                catch (Exception e)
                {
                    /* NOT NUMERIC */
                }
            }
        }

        fileWriter.close();
        reader.close();
        scanner.close();
    }
}
