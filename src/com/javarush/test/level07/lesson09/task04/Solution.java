package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("руру"); //0
        list.add("маляр"); //1
        list.add("коля"); //2
        list.add("суцй"); //3
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list)
    {
        //напишите тут ваш код
        ArrayList<String> list1 = new ArrayList<String>();
        for (String s : list)
        {
            if (s.contains("р") && s.contains("л"))
                list1.add(s);
            else if (s.contains("р"))
                continue;
            else if (s.contains("л"))
            {
                list1.add(s);
                list1.add(s);
            }
            else
                list1.add(s);
        }

        return list1;
    }
}