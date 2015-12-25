package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg1 = new Zerg(); zerg1.name = "Kolya";
        Zerg zerg2 = new Zerg(); zerg2.name = "Tolya";
        Zerg zerg3 = new Zerg(); zerg3.name = "Senya";
        Zerg zerg4 = new Zerg(); zerg4.name = "Vasya";
        Zerg zerg5 = new Zerg(); zerg5.name = "Sergey";
        Zerg zerg6 = new Zerg(); zerg6.name = "Nikita";
        Zerg zerg7 = new Zerg(); zerg7.name = "Martik";
        Zerg zerg8 = new Zerg(); zerg8.name = "Vanessa";
        Zerg zerg9 = new Zerg(); zerg9.name = "Triton";
        Zerg zerg10 = new Zerg(); zerg10.name = "Upacka";

        Protos prot1 = new Protos(); prot1.name = "Shprot";
        Protos prot2 = new Protos(); prot2.name = "Kal";
        Protos prot3 = new Protos(); prot3.name = "tyr";
        Protos prot4 = new Protos(); prot4.name = "Shprrtyrtyot";
        Protos prot5 = new Protos(); prot5.name = "Shtryrtyprot";

        Terran ter1 = new Terran(); ter1.name = "werwer";
        Terran ter2 = new Terran(); ter2.name = "asdfdgdfaf";
        Terran ter3 = new Terran(); ter3.name = "ewrwer";
        Terran ter4 = new Terran(); ter4.name = "hjdyjd";
        Terran ter5 = new Terran(); ter5.name = "erterter";
        Terran ter6 = new Terran(); ter6.name = "asdssdfsdaf";
        Terran ter7 = new Terran(); ter7.name = "sdfsv";
        Terran ter8 = new Terran(); ter8.name = "gdfgdfg";
        Terran ter9 = new Terran(); ter9.name = "ewrwer";
        Terran ter10 = new Terran(); ter10.name = "fgsdfgfdg";
        Terran ter11 = new Terran(); ter11.name = "vgrhss";
        Terran ter12 = new Terran(); ter12.name = "czxczc";






//        String dict = "abcdefghijklmnopqrstuvwxyz"; //строка содержит все доступные символы
//        char dictChar[] = dict.toCharArray();
//
//        int i;
//        int j;
//
//        for (i = 0; i < zergs.length; i++) {
//            zergs[i] = new Zerg();
//            char[] unitName = new char[6];
//            for (j = 0; j < 6; j++)
//                unitName[j] = dictChar[(int)(Math.random()*dictChar.length)];
//            zergs[i].name = String.valueOf(unitName);
//            System.out.print(zergs[i].name + "\n");
//        }
//
//        for (i = 0; i < protoss.length; i++) {
//            protoss[i] = new Protos();
//            char[] unitName = new char[7];
//            for (j = 0; j < 7; j++)
//                unitName[j] = dictChar[(int)(Math.random()*dictChar.length)];
//            protoss[i].name = String.valueOf(unitName);
//            System.out.print(protoss[i].name + "\n");
//        }
//
//        for (i = 0; i < terrans.length; i++) {
//            terrans[i] = new Terran();
//            char[] unitName = new char[5];
//            for (j = 0; j < 5; j++)
//                unitName[j] = dictChar[(int)(Math.random()*dictChar.length)];
//            terrans[i].name = String.valueOf(unitName);
//            System.out.print(terrans[i].name + "\n");
//        }

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}