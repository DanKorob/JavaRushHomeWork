package examples.max;

import java.util.ArrayList;

public class Solution
{
    private static  ArrayList<String> errorArr = new ArrayList<String>();
    private static  ArrayList<String> garbageArr = new ArrayList<String>();


    private static final int COUNT_GOOD = 3;

    public static void main(String[] args)
    {
        ArrayList<String> goodArr = new ArrayList<String>(); //"КОБЫЛА", "ЛОШАДЬ", "ЛОСЬ"
        ArrayList<String> almostGoodArray = new ArrayList<String>();

        goodArr.add("КОБЫЛА");
        goodArr.add("ЛОШАДЬ");
        goodArr.add("ЛОСЬ");

        almostGoodArray.add("кАбыла");
        almostGoodArray.add("ло1адь");
        almostGoodArray.add("кирпич");
        almostGoodArray.add("бурда");
        almostGoodArray.add("вейдер");

        getWordsWithErrors(goodArr, almostGoodArray);

        System.out.println("Error Array:");
        for (String s : errorArr)
            System.out.println(s);

        System.out.println("Garbage Array:");
        for (String s : garbageArr)
            System.out.println(s);
    }

    private static void getWordsWithErrors(ArrayList<String> goodArr, ArrayList<String> almostGoodArray)
    {
        for (String almostGoodWord : almostGoodArray)
        {
            boolean isGarbage = true;
            for (String goodWord : goodArr)
            {
                if (goodWord.length() == almostGoodWord.length())
                {
                    int countError = getErrorCountInWords(almostGoodWord, goodWord);

                    if (countError == 0)
                    {
                        isGarbage = false;
                        break;
                    }
                    else if (countError < COUNT_GOOD)
                    {
                        isGarbage = false;
                        errorArr.add(almostGoodWord);
                        break;
                    }
                }
            }

            if (isGarbage)
                garbageArr.add(almostGoodWord);
        }
    }

    private static int getErrorCountInWords(String almostGoodWord, String goodWord)
    {
        int countError = 0;
        String[] arr1 = almostGoodWord.toLowerCase().split("");
        String[] arr2 = goodWord.toLowerCase().split("");

        for (int i = 0; i < arr1.length; i++)
        {
            if (!arr1[i].equals(arr2[i]))
                countError++;
        }

        return countError;
    }
}
