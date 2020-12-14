/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import datastructures.Artifacts;
import datastructures.Attributes;
import datastructures.Stats;
import datastructures.Weapon;
import java.util.*;
import java.io.*;

/**
 *
 * @author frank
 */
public class Character extends Stats {

    /**
     * Name of the character
     */
    private String name;
    /**
     * Dmg Type of the character
     */
    private String dmgType;
    /**
     * Character's weapon
     */
    private Weapon weapon;
    /**
     * Character's artifact
     */
    private ArrayList<Artifacts> artifacts;

    /**
     * Default constuctor of the character with no information
     */
    public Character() {
        super();
        name = "";
        dmgType = "";
        weapon = new Weapon();
        artifacts = new ArrayList<Artifacts>();
    }

    /**
     * Overloaded constructor of the character with basic information
     *
     * @param name - name of the character
     * @param dmgType - dmg type of the character
     * @param weapon - character's weapon
     * @param artifacts - character's artifacts
     */
    public Character(String name, String dmgType, Weapon weapon, ArrayList<Artifacts> artifacts) {
        super();
        this.name = name;
        this.dmgType = dmgType;
        this.weapon = weapon;
        this.artifacts = artifacts;
    }

    /**
     * Overloaded constructor of the character with all its information
     *
     * @param name - name of the character
     * @param dmgType - dmg type of the character
     * @param weapon - weapon of the character
     * @param artifacts - character's artifacts
     * @param level - character's level
     * @param attributes - character's attributes
     */
    public Character(String name, String dmgType, Weapon weapon, ArrayList<Artifacts> artifacts, int level, ArrayList<Attributes> attributes) {
        super(level, attributes);
        this.name = name;
        this.dmgType = dmgType;
        this.weapon = weapon;
        this.artifacts = artifacts;
    }

    /**
     * Returns the name of the character
     *
     * @return the name of the character as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the character
     *
     * @param name - name of the character
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the dmg type of the character
     *
     * @return the dmg type of the character as a String
     */
    public String getDmgType() {
        return dmgType;
    }

    /**
     * Set dmg type of the character
     *
     * @param dmgtype - dmg type of the character
     */
    public void setDmgType(String dmgType) {
        this.dmgType = dmgType;
    }

    /**
     * Returns the weapon of the character
     *
     * @return the weapon of the character as a Weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Set weapon of the character
     *
     * @param weapon - weapon of the character
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Returns the artifacts of the character
     *
     * @return the artifacts of the character as a String
     */
    public ArrayList<Artifacts> getArtifacts() {
        return artifacts;
    }

    /**
     * Set artifacts of the character
     *
     * @param artifacts - artifacts of the character
     */
    public void setArtifacts(ArrayList<Artifacts> artifacts) {
        this.artifacts = artifacts;
    }

    /**
     * Adds an artifact to the character
     *
     * @param artifact - artifact to be added to character
     */
    public void addArtifacts(Artifacts artifact) {
        if (this.artifacts.size() < 5) {
            this.artifacts.add(artifact);
        }
    }

    /**
     * Replaces artifact at an index
     *
     * @param index - the index you want to replace
     * @param artifact - new artifact you want to replace with
     */
    public void replaceArtifacts(int index, Artifacts artifact) {
        this.artifacts.set(index, artifact);
    }
    
    /**
     * Prints the character's stats
     */
    @Override
    public void printStats() {
        try {
            Main.out.write("Name: " + name+ "\n");
            Main.out.write("Damage Type: " + dmgType+"\n");
            weapon.printWeapon();
            if (artifacts.size() != 0) {
                for (int index = 0; index < artifacts.size(); index++) {
                    artifacts.get(index).printArtifact();
                }
            } else {
                Main.out.write("Artifacts: N/A\n");
            }
            for (int index = 0; index < super.getAttributes().size(); index++) {
                if (super.getAttributes().get(index).getScaling()) {
                    Main.out.write(super.getAttributes().get(index).getName() + ": " + super.getAttributes().get(index).getNumber() + "%\n");
                } else {
                    Main.out.write(super.getAttributes().get(index).getName() + ": " + super.getAttributes().get(index).getNumber()+"\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
