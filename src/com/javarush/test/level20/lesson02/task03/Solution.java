package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties property = new Properties();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String  fileName = consoleReader.readLine();
        consoleReader.close();

        InputStream inputStream = new FileInputStream(fileName);

        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream);

        property.putAll(properties);
        property.store(outputStream, "");

        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.load(inputStream);

        Set<String> set = property.stringPropertyNames();

        for (String s : set)
            properties.put(s, property.getProperty(s));
    }
}
