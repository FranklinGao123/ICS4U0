/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import datastructures.Stats;
import datastructures.Attributes;
import java.util.*;
import java.io.*;

/**
 *
 * @author frank
 */
public class Weapon extends Stats {

    /**
     * Name of the weapon
     */
    String name;
    /**
     * Type of weapon ex sword, bow, etc
     */
    String type;

    /**
     * Default constructor for a weapon
     */
    public Weapon() {
        super();
        name = "";
        type = "";
    }

    /**
     * Overloaded constructor for a weapon with its information
     *
     * @param name - name of the weapon
     * @param type - type of weapon
     */
    public Weapon(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    /**
     * Overloaded constructor for the weapon with its information + its
     * attributes
     *
     * @param name - name of weapon
     * @param type - type of weapon
     * @param level - level of weapon
     * @param attribute - stats of weapon
     */
    public Weapon(String name, String type, int level, ArrayList<Attributes> attribute) {
        super(level, attribute);
        this.name = name;
        this.type = type;

    }

    /**
     * Returns the name of the weapon
     *
     * @return the name of the weapon as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of weapon
     *
     * @return the type of weapon as a String
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the name of the artifact
     *
     * @param name - the new name of the weapon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the type of weapon
     *
     * @param type - the new type of weapon
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Prints the weapon information
     */
    public void printWeapon() {
        try {
            Main.out.write("Weapon: ");
            if (!name.equals("")) {
                Main.out.write(name);
            } else {
                Main.out.write("N/A");
            }
            Main.out.write(" - ");
            if (!type.equals("")) {
                Main.out.write(type);
            } else {
                Main.out.write("N/A");
            }
            Main.out.write("\n");
            super.printStats();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
