package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter
{
    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter f = new FileConsoleWriter("src\\com\\javarush\\test\\level19\\lesson10\\bonus02\\1.txt");
        String s = "test2";
        char[] b = "blokada".toCharArray();
        int q = 584;
        f.write(q);
        f.close();
    }

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(int c) throws IOException
    {
        System.out.println(Character.toChars(c));
        super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        System.out.println(String.copyValueOf(cbuf).substring(off, off + len));
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        System.out.println(str.substring(off, off + len));
        super.write(str, off, len);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        super.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException
    {
        super.write(str);
    }
}
