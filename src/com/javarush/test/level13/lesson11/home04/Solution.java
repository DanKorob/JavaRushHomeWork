package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;


// CODE BY VLADIK (!??!?!??)
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(filePath);
        String previusString = reader.readLine();
        while(true){
            String currentString = reader.readLine();
            if(currentString.equals("exit")){
                previusString = previusString + "\n" + currentString;
                outputStream.write(previusString.getBytes());
                break;
            }
            else{
                previusString = previusString + "\n";
                outputStream.write(previusString.getBytes());
                previusString = currentString;
            }
        }
    }
}
