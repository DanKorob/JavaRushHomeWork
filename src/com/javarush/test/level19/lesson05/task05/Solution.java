package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
//        String fileName1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson05\\task05\\1.txt";
//        String fileName2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson05\\task05\\2.txt";

        Scanner scanner = new Scanner(new File(fileName1));
        FileOutputStream fileWriter = new FileOutputStream(fileName2);

        while (scanner.hasNext())
        {
            String s = scanner.nextLine();
            s = s.replaceAll("\\p{P}","");
            s = s.replaceAll("\\s","");
            fileWriter.write(s.getBytes());
        }

        reader.close();
        scanner.close();
        fileWriter.close();
    }
}
