package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца
    слова, которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        String string = "JavaRush - лучший сервис обучения Java.";
        System.out.println(getPartOfString(string));
    }

    public static String getPartOfString(String string)
    {
        String result = "";

        if (string == null)
            throw new TooShortStringException();

        try
        {
            int indFirstSpace = string.indexOf(" ");
            int countSpace = 1;
            int indLastSpace = string.length();

            for (int i = indFirstSpace + 1; i < string.length(); i++)
            {
                if (string.charAt(i) == ' ')
                    countSpace++;

                if (countSpace == 5)
                {
                    indLastSpace = i;
                    break;
                }
            }

            if (countSpace < 4)
                throw new TooShortStringException();

            result = string.substring(indFirstSpace + 1, indLastSpace);
        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends RuntimeException
    {

    }
}
