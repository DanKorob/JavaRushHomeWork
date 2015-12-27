package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String filePath = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            while (fileInputStream.available() > 0){
                int b = fileInputStream.read();
                System.out.print((char)b);
            }
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
