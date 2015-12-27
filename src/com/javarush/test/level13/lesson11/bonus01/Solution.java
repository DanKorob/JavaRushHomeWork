package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

import static java.util.Collections.list;
import static java.util.Collections.sort;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String path = r.readLine();

        ArrayList<Integer> list = new ArrayList<Integer>();

        BufferedReader file = new BufferedReader(new FileReader(path));

        while (file.ready())
        {
            int a = Integer.parseInt(file.readLine());
            if (a % 2 == 0)
                list.add(a);
        }

        sort(list);

        for (Integer x :
                list)
        {
            System.out.println(x);

        }

    }

//    private static void sort(ArrayList<Integer> list)
//    {
//        for (int i = 0; i < list.size() - 1; i++)
//        {
//            for (int j = 0; j < list.size() - i - 1; j++)
//            {
//                if (list.get(j) > list.get(j+1))
//                {
//                    int t = list.get(j);
//                    list.set(j,list.get(j+1));
//                    list.set(j+1,t);
//                }
//            }
//        }
//    }
}
