package com.javarush.test.level19.lesson10.home03;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static SimpleDateFormat sdf = new SimpleDateFormat("d M yyyy");

    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        String fileName = args[0];
        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext())
        {
            String[] s = scanner.nextLine().split(" ");
            String name = "";
            String date = "";

            for (int i = 0; i < s.length - 3; i++)
                name += s[i] + " ";
            name = name.substring(0, name.length() - 1);
            date += s[s.length - 3] + " " + s[s.length - 2] + " " + s[s.length - 1];

            PEOPLE.add(new Person(name, sdf.parse(date)));
        }

        scanner.close();
    }
}
