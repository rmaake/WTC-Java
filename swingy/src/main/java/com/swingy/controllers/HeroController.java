/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.controllers;
import java.util.*;
/**
 *
 * @author R.C Maake
 */
public class HeroController extends CharacterController {
    public boolean run()
    {
        Random rand = new Random();
        int chance = rand.nextInt(2) + 1;
        if(chance != 2)
            return false;
        return true;
    }
}
