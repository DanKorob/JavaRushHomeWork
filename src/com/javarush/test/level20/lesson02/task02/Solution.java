package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH);
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        String fileName = "src\\com\\javarush\\test\\level20\\lesson02\\task02\\1.txt";
        try {
//            File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File(fileName);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User stepa = new User();
            stepa.setFirstName("Stephan");
            stepa.setLastName("Menshikov");
            stepa.setBirthDate((sdf.parse("21/12/2012")));
            stepa.setMale(true);
            stepa.setCountry(User.Country.UKRAINE);

            User petya = new User();
            petya.setFirstName("Petya");
            petya.setLastName("Magadanov");
            petya.setBirthDate((sdf.parse("11/06/2010")));
            petya.setMale(false);
            petya.setCountry(User.Country.OTHER);

            javaRush.users.add(stepa);
            javaRush.users.add(petya);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            int countUsers = users.size();
            writer.println(countUsers);

            for (User user : users)
            {
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(sdf.format(user.getBirthDate()));
                writer.println(String.valueOf(user.isMale()));
                writer.println(user.getCountry());
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int countUsers = Integer.parseInt(reader.readLine());

            for (int i = 0; i < countUsers; i++)
            {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(sdf.parse(reader.readLine()));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));

                users.add(user);
            }

            reader.close();
        }
    }
}
