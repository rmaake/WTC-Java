/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.models;
import javax.validation.constraints.*;
/**
 *
 * @author R.C Maake
 */
public class Characters {
    public Helm helm = new Helm();
    public Coordinates cordinates = new Coordinates();
    public Weapon weapon = new Weapon();
    public Amor amor = new Amor();
    public String name;
    public String type;
    @Min(0)
    public int level;
    @Min(0)
    public int exp;
    @Min(0)
    public int hp;
}