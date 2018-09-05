/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.controllers;
import com.swingy.models.*;
import lombok.*;

/**
 *
 * @author R.C Maake
 */
@Getter
@Setter
public class CharacterController {
    
    protected Characters charact = new Characters();
    
    public boolean takeDamage(Weapon weapon)
    {
        int res = charact.amor.defence - weapon.attack;
        if (res < 0)
            charact.hp += res;
        else
            charact.amor.defence -= weapon.attack;
        if (charact.hp <= 0)
        {
            charact.hp = 0;
            return true;
        }
        return (false);
    }
    public boolean fight(CharacterController enemy)
    {
        boolean res = true;
        int diff = charact.level;
        if (diff < 0)
            diff = 0;
        int levelUp = (charact.level + 1) * 1000 + (diff) * (diff) * 450;
        while(res == true)
        {
            charact.exp += 50;
            res = takeDamage(enemy.charact.weapon);
            if (res == true)
            {
                if (levelUp <= charact.exp)
                    charact.level += 1;
                return false;
            }
            res = enemy.takeDamage(charact.weapon);
            if (res == true)
            {
                if (levelUp <= charact.exp)
                    charact.level += 1;
                return true;
            }
            if (res == false)
                res = true;
        }
        if (levelUp <= charact.exp)
           charact.level += 1;
        return true;
    }
    
}
