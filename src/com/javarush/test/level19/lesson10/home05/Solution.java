package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        while (bufferedReader.ready())
        {
            String s = bufferedReader.readLine();
            String s2 = getWordsContainsNumber(s);
            bufferedWriter.write(s2);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String getWordsContainsNumber(String line)
    {
        String[] words = line.split(" ");
        String goodWords = "";

        for (String s : words)
            if (isHaveNumber(s))
                goodWords += s + " ";

        return goodWords;
    }

    private static boolean isHaveNumber(String word)
    {
        char[] wordArray = word.toCharArray();

        for (char c : wordArray)
            if (Character.isDigit(c))
                return true;

        return false;
    }
}
