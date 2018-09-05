/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.startup;
import com.swingy.views.*;
import java.awt.EventQueue;
/**
 *
 * @author R.C Maake
 */
public class Main
{
    public static void main(String args[]) {
        /* Create and display the form */
        try
        {
            if (args[0].compareTo("gui") == 0)
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new SwingyG().setVisible(true);
                    }
                });
            }
            else if (args[0].compareTo("console") == 0)
            {
                SwingyC console = new SwingyC();
                console.startGame();
            }
            else
                throw new NullPointerException("demo");
        }
        catch(Exception e)
        {
            System.out.println("Invalid usage:\ntry: java -jar swingy-1.0-SNAPSHOT.jar gui\nAlternatively try: java -jar swingy-1.0-SNAPSHOT.jar console");
        }
    }
}
 
