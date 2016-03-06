package com.javarush.test.level24.lesson02.home01;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{
    public SelfInterfaceMarkerImpl()
    {

    }

    public void printName(String name)
    {
        System.out.println("Hello Mr(s). " + name + "!");
    }

    public void printAge(int age)
    {
        System.out.println("You are " + age + "years old!");
    }
}
