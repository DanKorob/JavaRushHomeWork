package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children0 = new ArrayList<Human>();
        //напишите тут ваш код
        Human child1 = new Human("child1", true, 3,  children0);
        Human child2 = new Human("child2", true, 13,  children0);
        Human child3 = new Human("child3", false, 8,  children0);

        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(child1);
        children1.add(child2);
        children1.add(child3);

        Human batya = new Human("batya", true, 38,  children1);
        Human matya = new Human("matya", false, 33,  children1);

        ArrayList<Human> childrenB = new ArrayList<Human>();
        childrenB.add(batya);
        ArrayList<Human> childrenM = new ArrayList<Human>();
        childrenM.add(matya);

        Human ded1 = new Human("ded1", true, 100, childrenB);
        Human ded2 = new Human("ded2", true, 90, childrenM);

        Human baba1 = new Human("baba1", false, 93, childrenB);
        Human baba2 = new Human("baba2", false, 87, childrenM);

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(baba1.toString());
        System.out.println(baba2.toString());
        System.out.println(batya.toString());
        System.out.println(matya.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
