package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<Horse>();

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse Mashka = new Horse("Mashka", 3, 0);
        Horse Stepka = new Horse("Stepka", 3, 0);
        Horse Dimka = new Horse("Dimka", 3, 0);

        game.getHorses().add(Mashka);
        game.getHorses().add(Stepka);
        game.getHorses().add(Dimka);

        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move()
    {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : getHorses())
        {
            horse.print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner()
    {
        Horse winHorse = getHorses().get(0);

        for (Horse horse : getHorses())
            if (horse.getDistance() > winHorse.getDistance())
                winHorse = horse;

        return winHorse;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() +  "!");
    }
}
