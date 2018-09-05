/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.controllers;
import com.swingy.models.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author xpsi-360
 */
public class WriteToFileController {
    File file = new File("../hero.csv");
    FileWriter writer;
    public WriteToFileController()
    {
    }
    public boolean update(List<HeroController> charact)
    {
        CharacterController focus;
        try
        {
            if (writer == null)
                writer = new FileWriter(file);
           for(int i = 0; i < charact.size(); i++)
           {
               focus = charact.get(i);
               writer.write(focus.getCharact().name + ",");
               writer.append(focus.getCharact().type + ",");
               writer.append(focus.getCharact().level + ",");
               writer.append(focus.getCharact().exp + ",");
               writer.append(focus.getCharact().weapon.name + ",");
               writer.append(focus.getCharact().amor.name + "\n");
           }
           writer.close();
           writer = null;
        }
        catch(Exception e)
        {
            System.out.println("Error writting to file:\n Reason: " + e.getMessage());
            System.exit(1);
        }
        return true;
    }
    
}
