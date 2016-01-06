package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

//        String file1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson05\\task04\\in.txt";
//        String file2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson05\\task04\\out.txt";

        FileInputStream fileIn      = new FileInputStream(file1);
        FileOutputStream fileOut    = new FileOutputStream(file2);

        byte[] buffer = new byte[fileIn.available()];
        int count = fileIn.read(buffer);

        for (int i = count - 1; i >= 0; i--)
            fileOut.write(buffer[i]);

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
