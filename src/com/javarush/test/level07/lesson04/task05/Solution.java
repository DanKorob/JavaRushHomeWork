package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[20];
        int[] b = new int[10];
        int[] c = new int[10];

        for (int i = 0; i < 20; i++) {
            a[i] = Integer.parseInt(reader.readLine());
            if (i < 10)
                b[i] = a[i];
            else
                c[i-10] = a[i];
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println(c[i]);
        }
    }
}
