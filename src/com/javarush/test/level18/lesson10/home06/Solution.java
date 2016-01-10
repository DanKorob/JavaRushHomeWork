package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).
    Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];

        TreeMap<Integer, Integer> symbolNums = new TreeMap<Integer, Integer>();

        FileInputStream fileIn = new FileInputStream(fileName);

        // Read in Threemap (automatically sort by key)
        while (fileIn.available() > 0)
        {
            int x = fileIn.read();
            if (symbolNums.containsKey(x))
                symbolNums.put(x, symbolNums.get(x) + 1);
            else
                symbolNums.put(x, 1);
        }

        // sout
        for (Map.Entry<Integer, Integer> pair : symbolNums.entrySet())
        {
            int key = pair.getKey();
            char keyCh = (char)key;
            System.out.println(keyCh + " " + pair.getValue());
        }

        fileIn.close();
    }
}
