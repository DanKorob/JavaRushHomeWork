package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = args[0];
        TreeMap<String, Double> listPerson = new TreeMap<>();

        Scanner scanner = new Scanner(new File(fileName));
        double max = 0;

        while (scanner.hasNext())
        {
            String[] s = scanner.nextLine().split(" ");
            if (listPerson.containsKey(s[0]))
                listPerson.put(s[0], listPerson.get(s[0]) + Double.parseDouble(s[1]));
            else
                listPerson.put(s[0], Double.parseDouble(s[1]));

            if (listPerson.get(s[0]) > max)
                max = listPerson.get(s[0]);
        }

        for (Map.Entry<String, Double> pair: listPerson.entrySet())
        {
            if (pair.getValue() == max)
            {
                System.out.println(pair.getKey());
                break;
            }
        }

        scanner.close();
    }
}
