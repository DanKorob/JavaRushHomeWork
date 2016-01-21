package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    private static ArrayList<String> tagList = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
//        String fileName = "src\\com\\javarush\\test\\level19\\lesson10\\bonus03\\1.txt";

        String tag = args[0];

        String stringHTML = "";
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready())
            stringHTML += fileReader.readLine();

        tagList = getTagList(stringHTML, tag);

        for (String t : tagList)
            System.out.println(t);

        consoleReader.close();
        fileReader.close();
    }

    public static ArrayList<String> getTagList(String stringHTML, String tag)
    {
        ArrayList<String> tagList = new ArrayList<String>();

        String startOfTag = "<" + tag;
        String endOfTag = "</" + tag + ">";

        String[] sTags = stringHTML.split(startOfTag);
        String s = "";

        int inserted = 0;

        for (int i = 1; i < sTags.length; i++)
        {
            if (!sTags[i].contains(endOfTag))
            {
                s += startOfTag + sTags[i];
                inserted++;
            }
            else
            {
                // max
                s += startOfTag + sTags[i].substring(0, sTags[i].lastIndexOf(endOfTag) + endOfTag.length());
                tagList.add(s);

                while (inserted > 0)
                {
                    // cut 1
                    s = s.substring(startOfTag.length(), s.length() - endOfTag.length());
                    s = s.substring(s.indexOf(startOfTag), s.lastIndexOf(endOfTag) + endOfTag.length());
                    tagList.add(s);
                    inserted--;
                }
                s = "";
            }
        }

        return tagList;
    }
}
