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
        }else{
            System.out.println("Max Limit of Artifacts Reached");
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
     *
     * This adds the values for charcter stats
     * Characters do not have main or sub stats so this function will delete a stat
     *
     * @param attribute the stat of the object
     * @param attributeNumber the numerical value of the stat
     * @param scaling whether the stat is scaling amount
     */
    @Override
    public void addSubStats(String attribute, double attributeNumber, boolean scaling) {
        super.getAttributes().add(new Attributes(attribute, attributeNumber, scaling));
    }
    
    /**
     *
     * Deletes the stat that is the same as the parameters
     * Characters do not have main or sub stats so this function will delete a stat
     *
     * @param attribute the stat of the object that will be deleted
     * @param attributeNumber the numerical value of the stat that will be
     * deleted
     * @param scaling whether the stat is scaling amount that will be deleted
     */
    @Override
    public void deleteSubStat(String attribute, double attributeNumber, boolean scaling) {
        for (int index = 0; index < this.getAttributes().size(); index++) {
            if (this.getAttributes().get(index).getName().equals(attribute) && this.getAttributes().get(index).getNumber() == attributeNumber && this.getAttributes().get(index).getScaling() == scaling) {
                this.getAttributes().remove(index);
                return;
            }
        }
        System.out.println("Delete Failed, Please reinput attributes");
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
            Main.out.write("=========================\n");
            if (artifacts.size() != 0) {
                for (int index = 0; index < artifacts.size(); index++) {
                    artifacts.get(index).printArtifact();
                    if(index!=artifacts.size()-1)
                        Main.out.write("\n");
                }
            } else {
                Main.out.write("Artifacts: N/A\n");
            }
            Main.out.write("=========================\n");
            Main.out.write(name+" Stats:\n");
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
