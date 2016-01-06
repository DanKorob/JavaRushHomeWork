package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        //start here - начни тут
        String command = args[0];
        Person person;

        if ("-c".equals(command))
        {
            person = createPerson(args, 0);
            allPeople.add(person);

            System.out.println(allPeople.indexOf(person));
        }
        else if ("-u".equals(command))
        {
            person = createPerson(args, 1);
            allPeople.set(Integer.parseInt(args[1]), person);
        }
        else if ("-d".equals(command))
        {
            person = Person.createMale(null, null);
            allPeople.set(Integer.parseInt(args[1]), person);
        }
        else if ("-i".equals(command))
        {
            person = allPeople.get(Integer.parseInt(args[1]));
            printInfo(person);
        }
        else
        {
            System.out.println("Wrong parameter");
        }
    }

    private static void printInfo(Person person)
    {
        String name = person.getName();
        String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
        String birthDate = dateFormat.format(person.getBirthDay());

        System.out.println(name + " " + sex + " " + birthDate);
    }

    private static Person createPerson(String[] args, int d)
    {
        Person person;

        String[] dateStr = args[3 + d].split("/");
        int[] dateInt = new int[3];
        for (int i = 0; i < dateStr.length; i++)
            dateInt[i] = Integer.parseInt(dateStr[i]);

        if (args[2 + d].equals("м"))
            person = Person.createMale(args[1 + d], new Date(dateInt[2] - 1900, dateInt[1] - 1, dateInt[0]));
        else
            person = Person.createFemale(args[1 + d], new Date(dateInt[2] - 1900, dateInt[1] - 1, dateInt[0]));
        return person;
    }
}
