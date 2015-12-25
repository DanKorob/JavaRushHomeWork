package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int m1,m2,m3;



        if (b > c) {
            if (b > d) {
                m1 = b;
                if (c > d) {
                    m2 = c;
                    m3 = d;
                }
                else {
                    m2 = d;
                    m3 = c;
                }
            }
            else {
                m1 = d;
                if (c > b) {
                    m2 = c;
                    m3 = b;
                }
                else {
                    m2 = b;
                    m3 = c;
                }
            }
        }
        else {
            if (c > d) {
                m1 = c;
                if (b > d) {
                    m2 = b;
                    m3 = d;
                }
                else {
                    m2 = d;
                    m3 = b;
                }
            }
            else {
                m1 = d;
                if (b > c) {
                    m2 = b;
                    m3 = c;
                }
                else {
                    m2 = c;
                    m3 = b;
                }
            }
        }


        System.out.print(m1 + "\n" + m2 + "\n" + m3);
    }
}
