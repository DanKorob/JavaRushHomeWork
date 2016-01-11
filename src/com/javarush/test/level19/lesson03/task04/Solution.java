package com.javarush.test.level19.lesson03.task04;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся
    в одной строке. Метод read() должен читать данные одного человека.
*/

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        PersonScanner personScanner = new PersonScannerAdapter(new Scanner(new File("d:\\Dropbox\\java\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson03\\task04\\1.txt")));
        System.out.println(personScanner.read());
        personScanner.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            if (scanner.hasNext())
            {
                String[] pInfo = scanner.nextLine().split(" ");
                int year = Integer.parseInt(pInfo[5]) - 1900;
                int month = Integer.parseInt(pInfo[4]) - 1;
                int day = Integer.parseInt(pInfo[3]);

                return new Person(pInfo[1], pInfo[2], pInfo[0], new Date(year, month, day));
            }

            return null;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
