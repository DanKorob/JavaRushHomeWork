package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
    инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\bonus02\\1.txt";

        String command = args[0];
        if (command.equals("-c"))
        {
            // get next id
            String nextId = getNextIdFromCrudFile(fileName);

            String line = createLine(args, nextId);

            FileOutputStream fileOut = new FileOutputStream(fileName, true);
            fileOut.write(line.getBytes());
            fileOut.close();
        }
        
        reader.close();
    }

    private static String createLine(String[] args, String nextId)
    {
        String id = nextId;                             // 8 symbols
        String productName = "";                        // 60 bytes (30 chars, 30 symbols)
        for (int i = 1; i < args.length - 2; i++)
            productName += args[i] + " ";
        String price = args[args.length - 2];           // 8 symbols
        String quantity = args[args.length - 1];        // 4 symbols

        // prepare id
        while (id.length() < 8)
            id += " ";

        // prepare productName
        if (productName.length() < 30)
            while (productName.length() < 30)
                productName += " ";
        else
            productName = productName.substring(0, 30);

        // prepare Price
       while(price.length() < 8)
            price += " ";

        // prepare quantity
        while(quantity.length() < 4)
            quantity += " ";

        return (id + productName + price + quantity + "\n");
    }

    private static String getNextIdFromCrudFile(String fileName) throws IOException
    {
        Scanner scanner = new Scanner(new File(fileName));
        String s = "";
        while (scanner.hasNext())
            s = scanner.nextLine();

        int id = Integer.parseInt(s.substring(0, 8).replaceAll("[^\\d]","")) + 1;

        return String.valueOf(id);
    }
}
