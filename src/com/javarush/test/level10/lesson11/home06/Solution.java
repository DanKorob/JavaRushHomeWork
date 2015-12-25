package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        String lastName;
        int age;
        boolean sex;
        int height;
        boolean isDubil;

        public Human(String name, String lastName, int age, boolean sex, int height, boolean isDubil)
        {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.isDubil = isDubil;
        }

        public Human(String name, String lastName, int age, boolean sex, int height)
        {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }

        public Human(String name, String lastName, int age, boolean sex)
        {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String lastName, int age)
        {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String name, String lastName)
        {
            this.name = name;
            this.lastName = lastName;
        }

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String lastName, boolean sex, boolean isDubil)
        {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.isDubil = isDubil;
        }

        public Human(boolean isDubil)
        {
            this.isDubil = isDubil;
        }

        public Human(boolean isDubil, boolean sex, int height)
        {
            this.isDubil = isDubil;
            this.sex = sex;
            this.height = height;
        }
    }
}
