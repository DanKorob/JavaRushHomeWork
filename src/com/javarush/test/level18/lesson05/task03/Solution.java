package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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

//        String file1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson05\\task03\\in.txt";
//        String file2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson05\\task03\\out1.txt";
//        String file3 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson05\\task03\\out2.txt";

        FileInputStream fileIn = new FileInputStream(file1);
        FileOutputStream fileOut1 = new FileOutputStream(file2);
        FileOutputStream fileOut2 = new FileOutputStream(file3);

        int count1, count2;

        count1 = fileIn.available() / 2;
        count2 = count1;
        if (!(fileIn.available() % 2 == 0))
            count1++;

        byte[] buffer = new byte[count1];

        fileIn.read(buffer);
        fileOut1.write(buffer, 0, count1);
        fileIn.read(buffer);
        fileOut2.write(buffer, 0, count2);

        reader.close();
        fileIn.close();
        fileOut1.close();
        fileOut2.close();
    }
}
