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

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
        String fileName = "d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\bonus02\\1.txt";
        String command = args[0];
        if (command.equals("-c"))
        {
            // get next id
            String nextId = getNextIdFromCrudFile(fileName);

//            String line = createLine(args, nextId);
//
//            FileOutputStream fileOut = new FileOutputStream(fileName, true);
//            fileOut.write(line.getBytes());
//            fileOut.close();
        }
        
        reader.close();
    }

    private static String createLine(String[] args, String nextId)
    {
        String id = nextId;                             // 8 symbols
        String productName = args[1];                   // 60 bytes (30 chars, 30 symbols)
        String price = args[2];                         // 8 symbols
        String quantity = args[3];                      // 4 symbols

        // prepare id
        for (int i = 0; i < (8 - id.length()); i++)
            id += " ";

        // prepare productName
        if (productName.length() < 30)
            for (int i = 0; i < (30 - productName.length()); i++)
                productName += " ";
        else
            productName = productName.substring(0, 29);

        // prepare Price
        for (int i = 0; i < (8 - price.length()); i++)
            price += " ";

        // prepare quantity
        for (int i = 0; i < (4 - quantity.length()); i++)
            quantity += " ";

        return (id + productName + price + quantity + "\n");
    }

    private static String getNextIdFromCrudFile(String fileName) throws IOException
    {
        FileInputStream fileIn = new FileInputStream(fileName);
        // fseek()
        FileChannel fc = fileIn.getChannel();
        fc.position(fileIn.available() - 80); // begining of last record

        // get the last id
        byte[] buffer = new byte[80];
        int count = fileIn.read(buffer);
        fileIn.close();

        String s = new String(buffer);//.split("\n")[1];

//        int x; = Integer.parseInt(s.split(" ")[0]) + 1;
//        String s1 = String.valueOf(x);
        // return next id
        return "";
    }
}
