package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();

        removeAllSummerPeople(map);

        System.out.print("aa");
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Staldasne", new Date("OCTOBER 12 1970"));
        map.put("vwsvsd", new Date("SEPTEMBER 12 2011"));
        map.put("Staldagdbgdbdsne", new Date("DECEMBER 2 2000"));
        map.put("evdfvd", new Date("JANUARY 24 2015"));
        map.put("ettgdfv", new Date("NOVEMBER 21 2001"));
        map.put("gbfgbcx", new Date("MARCH 13 2005"));
        map.put("dgdv", new Date("MAY 12 2012"));
        map.put("zxcd", new Date("AUGUST 12 2012"));
        map.put("Staldasgrne", new Date("JULY 12 1999"));


        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            Date currentDate = pair.getValue();
            int month = currentDate.getMonth();

            if (month == 7 || month == 6 || month == 5)
                list.add(pair.getKey());
        }

        for (String s : list)
            map.remove(s);
    }
}
