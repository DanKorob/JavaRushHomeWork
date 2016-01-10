package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id,
    и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String id = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
//        String fileName = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home07\\1.txt";

        FileInputStream fileIn = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fileIn);

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            String[] s = line.split(" ");

            if (s[0].equals(id))
            {
                System.out.println(line);//.substring(s[0].length() + 1));
                break;
            }
        }

        reader.close();
        fileIn.close();
        scanner.close();
    }
}
