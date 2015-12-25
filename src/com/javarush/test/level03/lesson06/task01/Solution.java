package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        String mama = "Мама";
        String mula = "Мыла";
        String ramu = "Раму";

        System.out.println(mama + mula + ramu);
        System.out.println(mama + ramu + mula);
        System.out.println(ramu + mula + mama);
        System.out.println(ramu + mama + mula);
        System.out.println(mula + ramu + mama);
        System.out.println(mula + mama + ramu);

    }
}