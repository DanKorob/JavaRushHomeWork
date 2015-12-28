package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());

        ArrayList<Integer> listA = new ArrayList<Integer>();
        for (int i = 1; i <= a; i++)
        {
            if (a % i == 0)
                listA.add(i);
        }

        ArrayList<Integer> listB = new ArrayList<Integer>();
        for (int i = 1; i <= b; i++)
        {
            if (b % i == 0)
                listB.add(i);
        }

        Integer max = listA.get(0);
        for (Integer x : listA)
            if (listB.contains(x))
                if (x > max)
                    max = x;

        System.out.println(max);
    }
}
