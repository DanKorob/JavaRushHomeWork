package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable
{
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        // WTF?

        Solution s1 = new Solution();
        s1.node = 1;
        Solution s2 = new Solution();
        s2.node = 2;
        s1.edges.add(s2);
        s2.edges.add(s1);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(s1);
        oos.close();

        byte[] buffer = baos.toByteArray();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
        Solution sol = (Solution) ois.readObject();
        ois.close();
    }
}
