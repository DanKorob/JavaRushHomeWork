package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of cities
        Map<String, String> cities = new HashMap<String, String>();
        while (true)
        {
            String familyCity = reader.readLine();
            if (familyCity.isEmpty()) break;
            String family = reader.readLine();


            cities.put(familyCity, family);
        }

        //read home number
        String city = reader.readLine();

        if (cities.containsKey(city))
        {
            System.out.println(cities.get(city));
        }
    }
}
