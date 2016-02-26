package com.javarush.test.level19.lesson10.bonus01.test;

import com.javarush.test.level19.lesson10.bonus01.Solution;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest
{
    @Test
    public void test_0()
    {
        assertList(
                "строка1\n",

                "строка1\n",

                "строка1 SAME"
        );

        Solution.lines.clear();
    }


    @Test
    public void test_begin1()
    {
        assertList(
                "строка1\n" +
                "строка2\n" +
                "строка3",

                "строка1\n" +
                "строка3",

                "строка1 SAME\n" +
                "строка2 REMOVED\n" +
                "строка3 SAME"
        );

        Solution.lines.clear();
    }


    @Test
    public void test_begin2()
    {
        assertList(
                "строка1\n" +
                "строка2",

                "строка2",

                "строка1 REMOVED\n" +
                "строка2 SAME"
        );

        Solution.lines.clear();
    }

    @Test
    public void test_begin3()
    {
        assertList(
                "строка2",

                "строка1\n" +
                "строка2",

                "строка1 ADDED\n" +
                "строка2 SAME"
        );

        Solution.lines.clear();
    }

    @Test
    public void test_situation_1()
    {
        assertList(
                "строка5\n" +
                "строка6\n" +
                "строка12",

                "строка5\n" +
                "строка12\n" +
                "строка6",

                "строка5 SAME\n" +
                "строка12 ADDED\n" +
                "строка6 SAME\n" +
                "строка12 REMOVED"
        );

        Solution.lines.clear();
    }

    @Ignore
    @Test
    public void test_situation_2()
    {
        assertList(
                "строка5\n" +
                "строка12\n" +
                "строка6",

                "строка5\n" +
                "строка6\n" +
                "строка12",

                "строка5 SAME\n" +
                "строка12 REMOVED\n" +
                "строка6 SAME\n" +
                "строка12 ADDED"
        );

        Solution.lines.clear();
    }


    @Test
    public void test_4() {
        assertList(
                "строка1\n" +
                "строка2\n" +
                "строка3",

                "строка1\n" +
                "строка8\n" +
                "строка2\n" +
                "строка9\n" +
                "строка3\n",

                "строка1 SAME\n" +
                "строка8 ADDED\n" +
                "строка2 SAME\n" +
                "строка9 ADDED\n" +
                "строка3 SAME"
        );

        Solution.lines.clear();
    }

    @Test
    public void test_5() {

        assertList(
                "строка1\n" +
                "строка2\n" +
                "строка3\n" +
                "строка4\n" +
                "строка5\n" +
                "строка1\n" +
                "строка2\n" +
                "строка3\n" +
                "строка4\n" +
                "строка5",

                "строка1\n" +
                "строка3\n" +
                "строка5\n" +
                "строка0\n" +
                "строка1\n" +
                "строка3\n" +
                "строка5\n" +
                "строка4",

                "строка1 SAME\n" +
                "строка2 REMOVED\n" +
                "строка3 SAME\n" +
                "строка4 REMOVED\n" +
                "строка5 SAME\n" +
                "строка0 ADDED\n" +
                "строка1 SAME\n" +
                "строка2 REMOVED\n" +
                "строка3 SAME\n" +
                "строка5 ADDED\n" +
                "строка4 SAME\n" +
                "строка5 REMOVED"
        );

        Solution.lines.clear();
    }

    private void assertList(String file1, String file2, String expected)
    {
        Solution.getResult(createlist(file1), createlist(file2));
        String actual = arrayLineItemToString(Solution.lines);

        assertEquals(expected, actual);
    }


    public ArrayList<String> createlist(String line) {
        ArrayList<String> list = new ArrayList<String>();
        for (String s : line.split("\n"))
            list.add(s);
        return list;
    }

    public String arrayLineItemToString(List<Solution.LineItem> lineItems) {

        String result = "";

        for (Solution.LineItem lineItem : lineItems)
            result += lineItem.line + " " + lineItem.type + "\n";

        return result.substring(0, result.length() - 1);
    }
}
