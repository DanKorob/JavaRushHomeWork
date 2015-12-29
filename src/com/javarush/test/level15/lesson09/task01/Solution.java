package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(23d, "23");
        labels.put(13d, "13");
        labels.put(33d, "33");
        labels.put(43d, "43");
        labels.put(53d, "53");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
