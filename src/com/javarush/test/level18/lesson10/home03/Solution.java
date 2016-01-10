package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое
    третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

//        String file1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home03\\1.txt";
//        String file2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home03\\2.txt";
//        String file3 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home03\\3.txt";

        FileOutputStream fos = new FileOutputStream(file1);
        FileInputStream fis1 = new FileInputStream(file2);
        FileInputStream fis2 = new FileInputStream(file3);

        byte[] buffer = new byte[1000];

        while (fis1.available() > 0)
        {
            int count = fis1.read(buffer);
            fos.write(buffer, 0, count);
        }

        while (fis2.available() > 0)
        {
            int count = fis2.read(buffer);
            fos.write(buffer, 0, count);
        }

        reader.close();
        fos.close();
        fis1.close();
        fis2.close();
    }
}
