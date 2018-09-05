/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.repository;
import com.swingy.controllers.*;
import com.swingy.models.*;
import java.util.*;
/**
 *
 * @author xpsi-360
 */
public class SwingyMap {
    String mapDisplay;
    public String[][] getMap(int level)
    {
        int size =  (level-1)*5+10-(level%2);
        String map[][] = new String[size][];
        for (int i = 0; i < size; i++)
        {
            map[i] = new String[size];
        }
        return map;
    }
    public void drawMap(HeroController hero, List<EnemyController> enemies, String[][] map)
    {
        int size = map.length;
        Coordinates hc = hero.getCharact().cordinates;
        Coordinates ec;
        clearMap(map);
        for(int a = 0; a < enemies.size(); a++)
        {
            ec = enemies.get(a).getCharact().cordinates;
            for(int i = 0; i < size; i++)
            {
                for(int j = 0; j < size - 1; j++)
                {
                    if (ec.x == i && ec.y == j)
                        map[i][j] = "X ---- ";
                    else if (map[i][j].equals("X ---- ") == false)
                        map[i][j] = "  ---- ";
                }
            }
        }
        map[hc.x][hc.y] = "O ---- ";
        
    }
    public String getDisplay(String[][] map)
    {
        int size = map.length;
        mapDisplay = "";
        
        for(int i = 0; i < size; i++)
        {
            mapDisplay += "\n";
            for(int j = 0; j < size - 1; j++)
            {
                mapDisplay += map[i][j];
            }
            
            if (i + 1 != size)
            {
                mapDisplay += "\n|";
                for(int j = 1; j < size - 1; j++)
                {
                    mapDisplay += "      |";
                }
               mapDisplay += "      |";
            }
        }
        return mapDisplay;
    }
    private void clearMap(String[][] map)
    {
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map.length; j++)
            {
                map[i][j] = " ";
            }
        }
    }
}
