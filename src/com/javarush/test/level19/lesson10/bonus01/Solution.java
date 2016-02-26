package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = consolereader.readLine();
        String filename2 = consolereader.readLine();
        consolereader.close();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(filename1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(filename2));

        List<String> list1 = new LinkedList<String>();
        List<String> list2 = new LinkedList<String>();

        while (fileReader1.ready())
            list1.add(fileReader1.readLine());
        while (fileReader2.ready())
            list2.add(fileReader2.readLine());

        fileReader1.close();
        fileReader2.close();

        getResult(list1, list2);
    }

    public static void getResult(List<String> list1, List<String> list2) {

        int ind1 = 0;
        int ind2 = 0;

        while (true)
        {
            String s1 = list1.get(ind1);
            String s2 = list2.get(ind2);

            if (s1.equals(s2))
            {
                lines.add(new LineItem(Type.SAME, s1));
                ++ind1;
                ++ind2;
            }
            else if ((ind2 + 1 < list2.size()) && (s1.equals(list2.get(ind2 + 1))))
            {
                lines.add(new LineItem(Type.ADDED, s2));
                ind2++;
            }
            else if ((ind1 + 1 < list1.size()) && (s2.equals(list1.get(ind1 + 1))))
            {
                lines.add(new LineItem(Type.REMOVED, s1));
                ind1++;
            }

            if (ind1 == list1.size() && ind2 == list2.size())
                break;
            else if (ind2 == list2.size())
            {
                lines.add(new LineItem(Type.REMOVED, list1.get(ind1)));
                break;
            }
            else if (ind1 == list1.size())
            {
                lines.add(new LineItem(Type.ADDED, list2.get(ind2)));
                break;
            }
        }

    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
