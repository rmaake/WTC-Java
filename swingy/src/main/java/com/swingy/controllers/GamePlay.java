/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.controllers;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import lombok.*;
/**
 *
 * @author R.C Maake
 */
public class GamePlay {
    @Getter
    private List<HeroController> heros = new ArrayList<HeroController>();
    private List<EnemyController> enemies = new ArrayList<EnemyController>();
    @Setter
    @Getter
    private HeroController hero;
    @Getter
    private EnemyController enemy;
    public GamePlay(int mode)
    {
        initGame(mode);
    }
    public List<HeroController> getHeros()
    {
        return heros;
    }
    public List<EnemyController> getEnemies()
    {
        return enemies;
    }
    public boolean fight(EnemyController enemy)
    {
        
        while(enemy.takeDamage(hero.charact.weapon))
        {
            hero.charact.exp += 50;
            if (!hero.takeDamage(enemy.charact.weapon))
                return (false);
        }
        
        
        return (true);
    }
    public boolean run()
    {
        return hero.run();
    }
    public boolean checkCollision(int x, int y, int option)
    {
        EnemyController focus;
        switch(option)
        {
            case 1:
                x -= 1;
                break;
            case 2:
                x += 1;
                break;
            case 3:
                y -= 1;
                break;
            case 4:
                y += 1;
                break;
        }
        for(int i = 0; i < enemies.size(); i++)
        {
           focus = enemies.get(i);
           if (focus.getCharact().cordinates.x == x && focus.getCharact().cordinates.y == y)
           {
               enemy = enemies.get(i);
               return true;
           }
        }
        return false;
    }
    public boolean moveCharacter(CharacterController character, int option, int mode)
    {
        int x = character.getCharact().cordinates.x;
        int y = character.getCharact().cordinates.y;
        if (checkCollision(x, y, option) == true)
            return false;
        switch(option)
        {
            case 1: // North
                character.getCharact().cordinates.x -= 1;
                break;
            case 2: //South
                character.getCharact().cordinates.x += 1;
                break;
            case 3:
                character.getCharact().cordinates.y -= 1;
                break;
            case 4:
                character.getCharact().cordinates.y += 1;
                break;
            default:
                break;
        }
        return true;
    }
    public void checkGameState(CharacterController character, int option, int mode)
    {
        int size =  (hero.getCharact().level-1)*5+10-(hero.getCharact().level%2);
        size -= 1;
        if (character.getCharact().cordinates.y  <= 0 || character.getCharact().cordinates.x <= 0)
        {
            if (mode == 0)
                JOptionPane.showMessageDialog(null, "Congratulations... You have won");
            else
                System.out.println("Congratulations... You have won");
            System.exit(1);
        }
        if (character.getCharact().cordinates.y  >= size || character.getCharact().cordinates.x >= size)
        {
            if (mode == 0)
                JOptionPane.showMessageDialog(null, "Congratulations... You have won");
            else
                System.out.println("Congratulations... You have won");
            System.exit(1);
        }
    }
    private void initGame(int mode)
    {
        String content = "";
        try
        {
            FileReader file = new FileReader("../hero.csv");
            BufferedReader buffer = new BufferedReader(file);
            String line;
            
            while((line = buffer.readLine()) != null)
            {
                content += line + "\n";
                
            }
            buffer.close();
            file.close();
        }
        catch(Exception e)
        {
            System.out.println("Error reading file:\nReason: " + e.getMessage());
            System.exit(1);
        }
        toList(content.split("\n"), mode);
    }
    private boolean toList(String[] data, int option)
    {
        HeroController nC;
        EnemyController eC;
        String err;
        String line[];
        Random rand = new Random();
        for(int i = 0; i < data.length; i++)
        {
            try
            {
                line = data[i].split(",");
                nC = new HeroController();
                nC.charact.name = line[0];
                nC.charact.type = line[1];
                nC.charact.level = Integer.parseInt(line[2]);
                nC.charact.exp = Integer.parseInt(line[3]);
                eC = new EnemyController();
                eC.charact.name = line[0];
                eC.charact.type = line[1];
                eC.charact.level = Integer.parseInt(line[2]);
                eC.charact.exp = Integer.parseInt(line[3]);
                if (nC.charact.exp < 0 || nC.charact.level < 0)
                {
                    err = "Error: Experience or level cannot be less than 0.\nRefer to line " + i;
                    if (option == 0)
                        JOptionPane.showMessageDialog(null, err);
                    else
                        System.out.println(err);
                    System.exit(1);
                }
                nC.charact.weapon.name = line[4];
                nC.charact.weapon.attack = 10;
                nC.charact.amor.name = line[5];
                nC.charact.amor.defence = 20;
                nC.charact.hp = 100;
                eC.charact.weapon.name = line[4];
                eC.charact.weapon.attack = 30;
                eC.charact.amor.name = line[5];
                eC.charact.amor.defence = 10;
                eC.charact.hp = rand.nextInt(50) + 1;
                eC.charact.cordinates.x = 1;
                eC.charact.cordinates.y = 1;
                heros.add(nC);
                enemies.add(eC);
            }
            catch(Exception e)
            {
                err = "Error values in file: Line " + i + 1 + "\nReason: " + e.getMessage();
                 if (option == 0)
                    JOptionPane.showMessageDialog(null, err);
                else
                    System.out.println(err);
                System.exit(1);
            }
        }
        return true;
    }
}
