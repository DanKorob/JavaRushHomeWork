package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.util.Collections.sort;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (fileIn.available() > 0)
        {
            int n = fileIn.read();
            if (!list.contains(n))
                list.add(n);
        }

        sort(list);

        for (Integer x :
                list)
        {
            System.out.print(x + " ");
        }

        reader.close();
        fileIn.close();
    }
}
