package com.javarush.test.level17.lesson10.bonus02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит
    id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();

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
            createPerson(args);
        }
        else if ("-u".equals(command))
        {
            //printPersonById(allPeople.get(Integer.parseInt(args[1])));
            updatePerson(args);
        }
        else if ("-d".equals(command))
        {
            deletePerson(args);
        }
        else if ("-i".equals(command))
        {
            printPersonById(args);
        }
        else
        {
            System.out.println("Wrong parameter");
        }
    }

    private static void createPerson(String[] args)
    {
        Person person;
        String[] dateStr;
        int[] dateInt;

        int personCount = (args.length - 1) / 3;

        for (int i = 0; i < personCount; i++)
        {
            dateStr = args[i*3+3].split("/");
            dateInt = new int[3];

            for (int j = 0; j < dateStr.length; j++)
                dateInt[j] = Integer.parseInt(dateStr[j]);

            if (args[i*3+2].equals("м"))
                person = Person.createMale(args[i*3+1], new Date(dateInt[2] - 1900, dateInt[1] - 1, dateInt[0]));
            else
                person = Person.createFemale(args[i*3+1], new Date(dateInt[2] - 1900, dateInt[1] - 1, dateInt[0]));

            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }

    private synchronized static void updatePerson(String[] args)
    {
        Person person;
        String[] dateStr;
        int[] dateInt;

        int personCount = (args.length - 1) / 4;

        for (int i = 0; i < personCount; i++)
        {
            dateStr = args[i*4+4].split("/");
            dateInt = new int[3];

            for (int j = 0; j < dateStr.length; j++)
                dateInt[j] = Integer.parseInt(dateStr[j]);

            if (args[i*4+3].equals("м"))
                person = Person.createMale(args[i*4+2], new Date(dateInt[2] - 1900, dateInt[1] - 1, dateInt[0]));
            else
                person = Person.createFemale(args[i*4+2], new Date(dateInt[2] - 1900, dateInt[1] - 1, dateInt[0]));

            allPeople.set(Integer.parseInt(args[i*4+1]), person);
        }
    }

    private synchronized static void deletePerson(String[] args)
    {
        Person person;
        int personCount = (args.length - 1);

        for (int i = 0; i < personCount; i++)
        {
            person = Person.createMale(null, null);
            allPeople.set(Integer.parseInt(args[i+1]), person);
        }
    }

    private static void printPersonById(String[] args)
    {
        int personCount = args.length - 1;

        for (int i = 0; i < personCount; i++)
        {
            Person person = allPeople.get(Integer.parseInt(args[i+1]));

            String name = person.getName();
            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
            String birthDate = dateFormat.format(person.getBirthDay());

            System.out.println(name + " " + sex + " " + birthDate);
        }
    }
}
