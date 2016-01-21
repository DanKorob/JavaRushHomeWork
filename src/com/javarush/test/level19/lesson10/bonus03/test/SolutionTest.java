package com.javarush.test.level19.lesson10.bonus03.test;

import com.javarush.test.level19.lesson10.bonus03.Solution;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SolutionTest
{
    @Test
    public void test_span_1()
    {

        assertEqualsTags(
                "span",

                "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela" +
                        "</span></b></span><span>Super</span><span>girl</span>",

                "<span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela</span></b></span>\n" +
                        "<span>Turanga Leela</span>\n" +
                        "<span>Super</span>\n" +
                        "<span>girl</span>"
        );
    }

    @Test
    public void test_span_2() {

        assertEqualsTags(
                "span",

                "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span><b><span xml::>Turanga Leela" +
                        "</span>ololo</b></span></b></span><span>Super</span><span>girl</span>",

                "<span xml:lang=\"en\" lang=\"en\"><b><span><b><span xml::>Turanga Leela</span>ololo</b></span></b></span>\n" +
                        "<span><b><span xml::>Turanga Leela</span>ololo</b></span>\n" +
                        "<span xml::>Turanga Leela</span>\n" +
                        "<span>Super</span>\n" +
                        "<span>girl</span>"
        );
    }

    @Test
    public void test_tag_1() {

        assertEqualsTags(
                "tag",

                "Info about Leela tag <span xml:lang=\"en\" lang=\"en\"><b><span><tag><span xml::>Turanga Leela" +
                        "</span>ololo</tag></span></b></span><span>Super</span><span>girl</span>",

                "<tag><span xml::>Turanga Leela</span>ololo</tag>"
        );
    }

    @Test
    public void test_tag_2() {

        assertEqualsTags(
                "tag",

                "Info about Leela tag <tag xml:lang=\"en\" lang=\"en\"><b><span><tag><span xml::>Turanga Leela" +
                        "</span>ololo</tag></span></b></tag><span>Super</span><span>girl</span>",

                "<tag xml:lang=\"en\" lang=\"en\"><b><span><tag><span xml::>Turanga Leela" +
                "</span>ololo</tag></span></b></tag>\n" +
                "<tag><span xml::>Turanga Leela</span>ololo</tag>"
        );
    }

    private void assertEqualsTags(String tag, String htmlCode, String expected) {
        ArrayList<String> resultList = Solution.getTagList(htmlCode, tag);

        String result = arrayToString(resultList);

        assertEquals(result, expected);
    }

    private String arrayToString(ArrayList<String> resultList) {
        String s = "";

        for (String str : resultList)
            s += str + "\n";

        return s.substring(0, s.length() - 1);
    }
}
