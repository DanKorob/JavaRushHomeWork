package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main (String[] args)
    {
        HashMap<String, String> map = createMap();

        int a = getCountTheSameFirstName(map, "Dan");
        int b = getCountTheSameLastName(map, "Kobfdbrob");

    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Korob", "Dan");
        map.put("Korodsfb", "Dweff");
        map.put("sdfsd", "Dan");
        map.put("dsfsdf", "Dadfsdfn");
        map.put("Kofbdfrob", "Dan");
        map.put("Kobfdbrob", "dfs");
        map.put("df", "dfffd");
        map.put("Kfbfborob", "dsfdsff");
        map.put("bfbb", "dfs");
        map.put("Kobffddbrob", "Ddsfdsfan");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getValue().equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getKey().equals(lastName))
                count++;
        }
        return count;
    }
}
