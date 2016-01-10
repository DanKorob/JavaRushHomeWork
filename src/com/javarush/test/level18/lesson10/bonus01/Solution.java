package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String command = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        byte[] buffer = new byte[1000];
        byte[] key = "javarush".getBytes();

        FileInputStream fileIn = new FileInputStream(fileName);
        FileOutputStream fileOut = new FileOutputStream(fileOutputName);

        if (command.equals("-e"))
        {
            while (fileIn.available() > 0)
            {
                int count = fileIn.read(buffer);
                encodeFileName(buffer, count, key);
                fileOut.write(buffer, 0, count);
            }
        }
        else if (command.equals("-d"))
        {
            while (fileIn.available() > 0)
            {
                int count = fileIn.read(buffer);
                decodeFileName(buffer, count, key);
                fileOut.write(buffer, 0, count);
            }
        }

        fileIn.close();
        fileOut.close();
    }

    private static void decodeFileName(byte[] buffer, int count, byte[] key)
    {
        for (int i = 0; i < count; i++)
            buffer[i] = (byte) (buffer[i] ^ key[i % key.length]);
    }


    private static void encodeFileName(byte[] buffer, int count, byte[] key)
    {
        for (int i = 0; i < count; i++)
            buffer[i] = (byte) (buffer[i] ^ key[i % key.length]);
    }

}
