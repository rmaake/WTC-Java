/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.views;

import java.io.*;
import com.swingy.repository.*;
import com.swingy.controllers.*;
import com.swingy.models.*;
import java.util.*;
/**
 *
 * @author R.C Maake
 */
public class SwingyC {
    private GamePlay game;
    private SwingyMap map;
    private List<HeroController> charact;
    private List<EnemyController> enemies;
    private int selectedHero;
    private HeroController newHero;
    private Scanner readLine;
    private WriteToFileController writer;
    /**
     * Creates new form SwingyG
     */
    public SwingyC() {
        atStart();
    }
    public void startGame()
    {
        System.out.println("\t\t\t\t      Welcome to Swingy\n\t\t\t\tA simplified WTC RPG Game\n\nNote: Use ctrl + C to exit\n");
        System.out.print("Options:\n\n1) Choose a hero\n2) Create a hero\n\nChoice: ");
        String option = readLine.nextLine();
        try
        {
            optionChose(Integer.parseInt(option));    
        }
        catch(Exception e)
        {
            errorMessages(0);
        }
    }
    private void optionChose(int option)
    {
        if (option == 1)
            chooseHero();
        else if (option == 2)
            createHero();
        else
            errorMessages(1);

    }
    private boolean moveHero(int di)
    {
        boolean move = game.moveCharacter(charact.get(selectedHero), di, 1);
        String [][] tmpMap =  map.getMap(charact.get(selectedHero).getCharact().level);
        clearScreen();
        map.drawMap(charact.get(selectedHero), enemies, tmpMap);
        System.out.println("\n" + map.getDisplay(tmpMap)+ "\n");
        System.out.println(viewHeroStats(selectedHero));
        return move;
    }
    private void gameStart()
    {
        arenaStats(charact.get(selectedHero));
        boolean move = true;
        int di = 0;
        String option = "";
        while(true)
        {
            switch(option)
            {
                case "N":
                    di = 1;
                    move  = moveHero(di);
                    break;
                case "S":
                    di = 2;
                    move = moveHero(di);
                    break;
                case "W":
                    di = 3;
                    move = moveHero(di);
                    break;
                case "E":
                    di = 4;
                    move = moveHero(di);
                    break;
                default:
                    di = -1;
                    break;
            }
            if (move == false)
            {
                boolean state = false;
                while (state == false)
                {
                    System.out.print("There is an enemy in front of you...\nF) Fight\nR) Run\nYour choice: ");
                    option = readLine.nextLine();
                    if (option.compareTo("F") == 0)
                    {
                        fof(1);
                        state = true;
                    }   
                    else if (option.compareTo("R") == 0)
                    {
                        state = true;
                        fof(0);
                    }
                }
                
            }
            game.checkGameState(charact.get(selectedHero), di, 1);
            System.out.print("To move:\nN) North\nS) South\nW) West\nE) East\n\nMove: ");
            option = readLine.nextLine();
        }
    }
    private void chooseHero()
    {
        String option;
        while (selectedHero < 0)
        {
            System.out.println("\nHere forth is a list of available heros, choose wisely:\n");
            for (int i = 0; i < charact.size(); i++)
                System.out.println((i + 1)+") " + charact.get(i).getCharact().name);
            System.out.print("\nYour choice: ");
            option = readLine.nextLine();
            try
            {
                selectedHero = Integer.parseInt(option) - 1;
                option = viewHeroStats(selectedHero);
                System.out.println("\nSelected hero stats:\n" + option);
                System.out.print("Note: any other response will stop the game.\nUse this hero? (y: yes / n: no): ");
                option = readLine.nextLine();
                if (option.compareTo("n") == 0)
                    selectedHero = -1;
                else if (option.compareTo("y") == 0)
                {
                    game.setHero(charact.get(selectedHero));
                    gameStart();
                }
                else
                    errorMessages(2);
            }
            catch (Exception e)
            {
                System.out.println(option);
                errorMessages(0);
            }
        }
    }
    private String viewHeroStats(int option)
    {
        String stats = "";
        if (option < 0 || option >= charact.size())
            errorMessages(1);
        HeroController hero = charact.get(option);
        stats += "Name: " + hero.getCharact().name + "\n";
        stats += "Class Name: " + hero.getCharact().type + "\n";
        stats += "Level: " + hero.getCharact().level + "\n";
        stats += "Experience: " + hero.getCharact().exp + " XP\n";
        stats += "Weapon: " + hero.getCharact().weapon.name + "\n";
        stats += "Attack: " + hero.getCharact().weapon.attack + "\n";
        stats += "Amor: " + hero.getCharact().amor.name + "\n";
        stats += "Defense: " + hero.getCharact().amor.defence + "\n";
        stats += "Hit points: " + hero.getCharact().hp + "\n";
        return stats;
    }
    private void fof(int option)
    {
        boolean state = false;
        clearScreen();
        if (option == 0)//flight
        {
            state = game.getHero().run();
            if (state == false)
            {
                System.out.println("Ooops... there will be no running this time... forced into a fight...");
                state = game.getHero().fight(game.getEnemy());
                option = 1;
            }
            else
                System.out.println("Lucky... change direction to run away....");
        }
        else if (option == 1) // fight
            state = game.getHero().fight(game.getEnemy());
        charact.get(selectedHero).getCharact().exp = game.getHero().getCharact().exp;
        charact.get(selectedHero).getCharact().level = game.getHero().getCharact().level;
        writer.update(charact);
        String [][] tmpMap =  map.getMap(charact.get(selectedHero).getCharact().level);
        if (state == true && option == 1)
        {
            System.out.println("Congratulations... you have won the battle... keep moving...");
            enemies.remove(game.getEnemy());
        }
        else if (state == false && option == 1)
        {
            System.out.println("Boohaahahah... you have lost the battle...\n***GAME OVER***\n");
            System.exit(1);
        }
        map.drawMap(charact.get(selectedHero), enemies, tmpMap);
        System.out.println("\n" + map.getDisplay(tmpMap)+ "\n");
        System.out.println(viewHeroStats(selectedHero));
    }
    private void createHero()
    {
        String option;
        String wep[] = {"Axe", "M-16 Rifle", "ChainSaw", "C4 Explosives"};
        String cls[] = {"Wizard", "Zombie", "Hobbit", "Elf"};
        Random rand  = new Random();
        System.out.print("Let's create a new Hero: \n\nEnter the name of the new hero: ");
        option = readLine.nextLine();
        newHero.getCharact().name = option;
        System.out.println("Choose hero class: ");
        for(int i = 0; i < cls.length; i++)
            System.out.println((i + 1) + ") " + cls[i]);
        System.out.print("Note: an incorrect input will terminate the game.\n\nYour choice: ");
        option = readLine.nextLine();
        try
        {
            int a  = Integer.parseInt(option) - 1;
            if (a < 0 || a >= cls.length)
                errorMessages(1);
            newHero.getCharact().type = cls[a];
        }
        catch(Exception e)
        {
            errorMessages(0);
        }
        newHero.getCharact().amor.defence = 20;
        newHero.getCharact().hp = 100;
        newHero.getCharact().helm.hitPoints = 5;
        newHero.getCharact().helm.name = "Razor";
        newHero.getCharact().level = 0;
        newHero.getCharact().exp = 0;
        newHero.getCharact().amor.name = "Force Field";
        newHero.getCharact().weapon.name = wep[rand.nextInt(4)];
        newHero.getCharact().weapon.attack = 20;
        charact.add(newHero);
        writer.update(charact);
        selectedHero = charact.size() - 1;
        game.setHero(charact.get(selectedHero));
        gameStart();
    }
    private void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\t\t\t\t      Welcome to Swingy\n\t\t\t\tA simplified WTC RPG Game\n\nNote: Use ctrl + C to exit\n");
    }
    private void arenaStats(HeroController option)
    {
        String [][] tmpMap = map.getMap(option.getCharact().level);
        option.getCharact().cordinates.x =  tmpMap.length / 2;
        option.getCharact().cordinates.y =  tmpMap.length / 2;
        placeEnemies(tmpMap.length);
        clearScreen();
        map.drawMap(option, enemies, tmpMap);
        System.out.println("\n" + map.getDisplay(tmpMap)+ "\n");
        System.out.println(viewHeroStats(selectedHero));
        game.setHero(option);
    }
    private void placeEnemies(int mapSize)
    {
        Random rand = new Random();
        int x;
        int y;
        for(int i = 0; i < enemies.size(); i++)
        {
            x = rand.nextInt(mapSize) + 1;
            y = rand.nextInt(mapSize) + 1;
            x -= 1;
            y -= 1;
            if (x != newHero.getCharact().cordinates.x && y != newHero.getCharact().cordinates.y)
            {
                enemies.get(i).getCharact().cordinates.x = x;
                enemies.get(i).getCharact().cordinates.y = y;
            }
            else
            {
                enemies.get(i).getCharact().cordinates.x = x - 1;
                enemies.get(i).getCharact().cordinates.y = y - 1;
            }
        }
        
       
    }





    private void atStart()
    {
        game = new GamePlay(1);
        charact = game.getHeros();
        enemies = game.getEnemies();
        map = new SwingyMap();
        newHero = new HeroController();
        readLine = new Scanner(System.in);
        writer = new WriteToFileController();
        selectedHero = -1;
    }
    private void errorMessages(int code)
    {
        if (code == 0)
            System.out.println("\nInvalid input: Use only numbers");
        if (code == 1)
            System.out.println("\nInvalid input: Value out of range");
        if (code == 2)
            System.out.println("\nInvalid input: Enter 'y' for yes or 'n' for no");
        System.exit(1);
    }
}
