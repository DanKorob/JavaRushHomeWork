package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //напишите тут ваш код
    int top;
    int left;
    int width;
    int height;

    public void initialize(int top, int left, int width, int height) {
        this.height = height;
        this.left = left;
        this.top = top;
        this.width = width;
    }

    public void initialize(int top, int left) {
        this.height = 0;
        this.left = left;
        this.top = top;
        this.width = 0;
    }

    public void initialize(int top, int left, int width) {
        this.height = width;
        this.left = left;
        this.top = top;
        this.width = width;
    }

    public void initialize(Rectangle rect) {
        this.initialize(rect.top, rect.left, rect.width, rect.height);
    }
}
