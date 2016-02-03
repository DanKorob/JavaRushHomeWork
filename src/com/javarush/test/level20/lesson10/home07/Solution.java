package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    private static final long serialVersionUID = 32L;

    public static void main(String[] args) throws Exception
    {
        String fileName = "/home/dan/Dropbox/java/JavaRush/JavaRushHomeWork/src/com/javarush/test/level20/lesson10/home07/1.txt";
        String fileName2 = "/home/dan/Dropbox/java/JavaRush/JavaRushHomeWork/src/com/javarush/test/level20/lesson10/home07/2.txt";

        Solution solution = new Solution(fileName);
        solution.writeObject("data before");
        solution.close();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName2));
        oos.writeObject(solution);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName2));
        Solution newSolution = (Solution)ois.readObject();
        ois.close();

        newSolution.writeObject("data after");
    }


    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName, true);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(this.fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.fileName = (String)in.readObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
