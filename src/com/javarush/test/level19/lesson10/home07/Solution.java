package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        boolean isFirstLine = true;

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        while (bufferedReader.ready())
        {
            String s = bufferedReader.readLine();
            s = wordsFilter(s);

            if (!s.isEmpty())
            {
                if (isFirstLine)
                    isFirstLine = false;
                else
                    s = "," + s;

                bufferedWriter.write(s);
            }

        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String wordsFilter(String line)
    {
        String result = "";
        String[] words = line.split(" ");

        for (String s : words)
            if (s.length() > 6)
                result += s + ",";

        return result.isEmpty() ? "" : result.substring(0, result.length() - 1);
    }
}
