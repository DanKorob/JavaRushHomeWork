package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле
    максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        while (true)
        {
            String fileName = reader.readLine();
            if (fileName.equals("exit"))
                break;
            list.add(fileName);
        }

        for (String s : list) {
            new ReadThread(s).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            try
            {
                FileInputStream fileIn = new FileInputStream(fileName);
                HashMap<Integer, Integer> symbols = new HashMap<Integer, Integer>();
                int maxCount = 0;

                while (fileIn.available() > 0)
                {
                    int x = fileIn.read();
                    Integer xValue = 1;

                    if (symbols.containsKey(x))
                        xValue += symbols.get(x);

                    symbols.put(x, xValue);

                    if (maxCount < xValue)
                        maxCount = xValue;
                }

                for (Map.Entry<Integer, Integer> pair : symbols.entrySet())
                {
                    if (pair.getValue().equals(maxCount))
                    {
                        synchronized (resultMap)
                        {
                            resultMap.put(this.fileName, pair.getKey());
                        }
                        //System.out.println(fileName + " " + pair.getKey());
                        break;
                    }
                }

                fileIn.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("Wrong file name");
            }
            catch (IOException ignore) {/*NOP*/}
        }
    }
}
