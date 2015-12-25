package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    String name;
    int weight;
    int age;
    String color;
    String address;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int weigth, int age) {
        this.name = name;
        this.age = age;
        this.weight = weigth;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 4;
    }

    public void initialize(int weight, String color) {
        this.name = null;
        this.weight = weight;
        this.age = 0;
        this.address = null;
    }

    public void initialize(int weight, String color, String address) {
        this.name = null;
        this.weight = weight;
        this.age = 0;
        this.address = address;

    }
}
