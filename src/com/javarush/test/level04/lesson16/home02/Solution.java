package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[3];
        a[0] = scanner.nextInt();
        a[1] = scanner.nextInt();
        a[2] = scanner.nextInt();

        double mean = (a[0] + a[1] + a[2]) / 3;

        int ind = 0;
        double cur = Math.abs(a[0] - mean);

        for (int i = 1; i < 3; i++) {
            if (Math.abs(a[i]-mean) < cur ) {
                cur = Math.abs(a[0] - mean);
                ind = i;
            }
        }

        System.out.println(a[ind]);

    }
}
