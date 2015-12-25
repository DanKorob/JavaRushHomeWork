package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    String name;
    int weight;
    int age;
    String color;
    String address;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int weigth, int age) {
        this.name = name;
        this.age = age;
        this.weight = weigth;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 4;
    }

    public Cat(int weight, String color) {
        this.name = null;
        this.weight = weight;
        this.color = color;
        this.age = 0;
        this.address = null;
    }

    public Cat(int weight, String color, String address) {
        this.name = null;
        this.weight = weight;
        this.age = 0;
        this.address = address;
        this.color = color;
    }
}
