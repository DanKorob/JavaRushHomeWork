package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            if (this instanceof C)
                return super.clone();
            else
                throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        A a = new A(10, 12);
        A a1 = (A) a.clone();
        System.out.println(a);
        System.out.println(a1);

        C c = new C(13, 14, "Yo-c");
        C c1 = (C) c.clone();
        System.out.println(c);
        System.out.println(c1);

        B b = new B(12, 1, "Yo-b");
        B b1 = (B) b.clone();
        System.out.println(b);
        System.out.println(b1);
    }
}
