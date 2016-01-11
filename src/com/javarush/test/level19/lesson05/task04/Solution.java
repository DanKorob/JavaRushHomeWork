package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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
//        String fileName1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson05\\task04\\1.txt";
//        String fileName2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson05\\task04\\2.txt";

        Scanner scanner = new Scanner(new File(fileName1));
        FileOutputStream fileWriter = new FileOutputStream(fileName2);

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            line = line.replace(".", "!") + "\n";
            fileWriter.write(line.getBytes());
        }

        reader.close();
        scanner.close();
        fileWriter.close();
    }
}
