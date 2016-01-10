package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN.
    Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN].
    Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ...,
    в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        // Read and save to list all files
        while (true)
        {
            String fileName = reader.readLine();
            if (fileName.equals("end"))
                break;

            list.add(fileName);
        }

        // Sort list (part1, part2, part3 ... )
        Collections.sort(list);

        // Create output file
        String fileOutName = list.get(0).substring(0, list.get(0).length() - 6);
        FileOutputStream fileOut = new FileOutputStream(fileOutName);
        byte[] buffer = new byte[1000];

        // Copying all files to output
        for (String s : list)
        {
            FileInputStream fileIn = new FileInputStream(s);
            while (fileIn.available() > 0)
            {
                int count = fileIn.read(buffer);
                fileOut.write(buffer, 0, count);
            }
            fileIn.close();
        }

        fileOut.close();
        reader.close();
    }
}
