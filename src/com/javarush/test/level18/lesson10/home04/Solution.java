package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось
    объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

//        String file1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home04\\1.txt";
//        String file2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home04\\2.txt";

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        ArrayList<Integer> listBuffer = new ArrayList<Integer>();
        byte[] buffer = new byte[1000];

        while (fis1.available() > 0)
        {
            int num = fis1.read();
            listBuffer.add(num);
        }
        fis1.close();

        FileOutputStream fos = new FileOutputStream(file1);
        while (fis2.available() > 0)
        {
            int count = fis2.read(buffer);
            fos.write(buffer, 0, count);
        }

        for (Integer x : listBuffer)
            fos.write(x);


        reader.close();
        fis2.close();
        fos.close();
    }
}
