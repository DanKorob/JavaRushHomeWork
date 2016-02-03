package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.

*/
public class Solution {
    static final long LONG_MAX = 922372036854775807L; // M = 19;

    public static void main(String[] args)
    {
        int[] numbers = getNumbers(100_000_000);

        for (long x : numbers)
            System.out.println(x);
    }

    public static int[] getNumbers(int N) {
        ArrayList<Long> numberList = new ArrayList<>();

        for (long number = 1; number <= N; number++)
        {
            char[] digits = String.valueOf(number).toCharArray();

            if (isSuitableNumber(digits))
            {
                long sum = sumOfNumber(digits);
                if (sumOfNumber(String.valueOf(sum).toCharArray()) == sum)
                    numberList.add(sum);
            }
        }

        int[] result = new int[numberList.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = numberList.get(i).intValue();

        return result;
    }

    public static long sumOfNumber(char[] digits)
    {
        long sum = 0;
        int M = digits.length;

        for (int i = 0; i < M; i++)
            sum += (long) Math.pow(Character.getNumericValue(digits[i]), M);

        return sum;
    }

    private static boolean isSuitableNumber (char[] digits)
    {
        for (int i = 1; i < digits.length; i++)
            if (digits[i] <= digits[i - 1])
                return false;

        return true;
    }
}
