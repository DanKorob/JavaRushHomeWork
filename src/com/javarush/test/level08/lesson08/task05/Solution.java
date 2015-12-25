package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();

        removeTheFirstNameDuplicates(map);

        System.out.println("aa");
    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Korob", "Dan");
        map.put("Ksdfsdforob", "Dafghbn");
        map.put("Kofdrob", "Dghan");
        map.put("Kodsfdsrob", "Dgfhan");
        map.put("Korgfbgfbob", "Dan");
        map.put("Kogfgfbrob", "Dgfan");
        map.put("Korhnhob", "Danghn");
        map.put("Kgfbgforob", "Dmhjan");
        map.put("Korogbb", "jkDan");
        map.put("Kornhob", "Dank");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        //ArrayList<Integer> list = new ArrayList<Integer>();

        for(Map.Entry<String, String> pair : copy.entrySet())
        {
            int count = 0;
            String val = pair.getValue();
            for(Map.Entry<String, String> pair1 : copy.entrySet())
            {
                if (val.equals(pair1.getValue()))
                    count++;
            }
            if (count > 1)
                removeItemFromMapByValue(map, val);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
