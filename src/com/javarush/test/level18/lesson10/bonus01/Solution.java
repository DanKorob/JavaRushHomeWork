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
        private static int key = 24;

    public static void main(String[] args) throws IOException
    {
        String command = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        FileInputStream fileIn = new FileInputStream(fileName);
        FileOutputStream fileOut = new FileOutputStream(fileOutputName);

        while (fileIn.available() > 0)
            fileOut.write(getCrypt(fileIn.read()));

        fileIn.close();
        fileOut.close();
    }

    private static int getCrypt(int b)
    {
        return b ^ key;
    }
}
