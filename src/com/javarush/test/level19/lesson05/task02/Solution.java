package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
//        String fileName = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson05\\task02\\1.txt";
        Scanner scanner = new Scanner(new File(fileName));

        int count = 0;
        while (scanner.hasNext())
        {
            String s = scanner.nextLine();
            s = s.replaceAll("\\p{P}"," ");
            s = s.replaceAll("\\s"," ");

            String[] sSpl =  s.split(" ");
            for (String x : sSpl)
                if (x.equals("world"))
                    count++;
        }

        System.out.println(count);

        reader.close();
        scanner.close();
    }
}
