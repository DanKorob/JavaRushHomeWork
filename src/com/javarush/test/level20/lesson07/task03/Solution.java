package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person = new Person("Kolya", "Higuh", 23);
        person.setFather(new Person("Tolay", "Higuh", 44));
        person.setMother(new Person("Marta", "Figus", 42));

        List<Person> children = new ArrayList<Person>();
        children.add(new Person("Sun1", "Durik", 2));
        children.add(new Person("Sun2", "Burik", 4));
        person.setChildren(children);

        String path = "src\\com\\javarush\\test\\level20\\lesson07\\task03\\object.person";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
//        person.writeExternal(oos);
        oos.writeObject(person);
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
//        Person person1 = new Person(null, null, 0);
//        person1.readExternal(ois);
        Person person1 = (Person)ois.readObject();
        ois.close();
    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person () {};

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children =(List)in.readObject();
        }
    }
}
