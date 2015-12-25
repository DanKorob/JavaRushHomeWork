package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String name;
    private String gender;
    private int age;
    //напишите тут ваш код
    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void initialize(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
