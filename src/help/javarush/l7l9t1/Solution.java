package help.javarush.l7l9t1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> mass = new ArrayList<Integer>();
        ArrayList<Integer> mass1 = new ArrayList<Integer>();
        ArrayList<Integer> mass2 = new ArrayList<Integer>();
        ArrayList<Integer> mass3 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
        {
            mass.add(i, Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < mass.size(); i++)
        {
            if (mass.get(i) % 3 == 0)
            {
                mass1.add(mass.get(i));
            }
            if (mass.get(i) % 2 == 0)
            {
                mass2.add(mass.get(i));
            }
            if (mass.get(i) % 2 == 0 && mass.get(i) % 3 == 0)
            {
                mass1.add(mass.get(i)); mass2.add(mass.get(i));
            }
            else if (mass.get(i) % 2 != 0 && mass.get(i) % 3 != 0)
            {
                mass3.add(mass.get(i));
            }
        }
        printList(mass1);
        printList(mass2);
        printList(mass3);
    }
    public static void printList(List<Integer> list)
    {
        for (int j = 0; j < list.size(); j++)
            System.out.println(list.get(j));
    }
}
