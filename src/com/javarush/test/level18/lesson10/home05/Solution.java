package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

//        String file1 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home05\\1.txt";
//        String file2 = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home05\\2.txt";

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        byte[] buffer = new byte[fis.available()];

        // Read all bytes
        while (fis.available() > 0)
            fis.read(buffer);

        // Convert to String
        String bStr = "";
        for (byte x : buffer)
            bStr += String.valueOf((char)x);

        // Split by space
        String[] bStrSpl = bStr.split(" ");


        for (String s : bStrSpl)
        {
            // Round a value
            Long x = Math.round(Double.parseDouble(s));

            // Write
            fos.write(x.toString().getBytes());
            fos.write(32);
        }

        reader.close();
        fis.close();
        fos.close();
    }
}
