package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[3];
        int max;
        max = scanner.nextInt();
        a[0] = scanner.nextInt();
        a[1] = scanner.nextInt();
        a[2] = scanner.nextInt();

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] > max)
            {
                max = a[i];
            }
        }

        System.out.print(max);
    }
}
