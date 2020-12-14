package datastructures;

import datastructures.Attributes;
import java.util.*;
import java.io.*;

/**
 * An object holding the stats
 *
 * @author Franklin Gao
 * @version 1.0 (current version number of program)
 * @since 1.8 (the version of the package this class was first added to)
 */
public abstract class Stats {

    /**
     * the level of the object
     */
    private int level;
    /**
     * the attributes of the object 0th index of attribute is the Main
     * attribute, all sub attributes are listed after 0
     */
    private ArrayList<Attributes> attribute;

    /**
     * This is the constructor function for creating new stats
     *
     * This sets the default value for the variables
     */
    public Stats() {
        level = 1;
        attribute = new ArrayList<Attributes>();
    }

    /**
     * This is the constructor function for creating new stats
     *
     * @param level - level of the object
     * @param attribute - the stats of the object
     */
    public Stats(int level, ArrayList<Attributes> attribute) {
        this.level = level;
        this.attribute = attribute;
    }

    /**
     * This sets the level of the object
     *
     * @param level - level of the object
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * This sets the values for the main stat for the object
     *
     * @param attribute the stat of the object
     * @param attributeNumber the numerical value of the stat
     * @param scaling whether the stat is scaling amount
     */
    public void setMainAttribute(String attribute, double attributeNumber, boolean scaling) {
        if (this.attribute.isEmpty()) {
            this.attribute.add(new Attributes(attribute, attributeNumber, scaling));
        } else {
            this.attribute.add(0, new Attributes(attribute, attributeNumber, scaling));
            this.attribute.remove(1);
        }
    }

    /**
     *
     * This adds the values for the sub stats for the object
     *
     * @param attribute the stat of the object
     * @param attributeNumber the numerical value of the stat
     * @param scaling whether the stat is scaling amount
     */
    public void addSubStats(String attribute, double attributeNumber, boolean scaling) {
        if (this.attribute.isEmpty()) {
            this.attribute.add(new Attributes());
        }
        this.attribute.add(new Attributes(attribute, attributeNumber, scaling));
    }

    /**
     *
     * This returns the level of the object
     *
     * @return the level of the object as an int
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * This returns the attributes of the object
     *
     * @return the attributes of the object as an ArrayList of Attributes
     */
    public ArrayList<Attributes> getAttributes() {
        return attribute;
    }

    /**
     * This deletes the main stat and resets it to its base values
     */
    public void deleteMainStat() {
        if (!attribute.isEmpty()) {
            attribute.set(0, new Attributes());
        }
    }

    /**
     *
     * Deletes the substat that is the same as the parameters
     *
     * @param attribute the stat of the object that will be deleted
     * @param attributeNumber the numerical value of the stat that will be
     * deleted
     * @param scaling whether the stat is scaling amount that will be deleted
     */
    public void deleteSubStat(String attribute, double attributeNumber, boolean scaling) {
        for (int index = 1; index < this.attribute.size(); index++) {
            if (this.attribute.get(index).getName() == attribute && this.attribute.get(index).getNumber() == attributeNumber && this.attribute.get(index).getScaling() == scaling) {
                this.attribute.remove(index);
                return;
            }
        }
        System.out.println("Delete Failed, Please reinput attributes");
    }

    /**
     * Prints the stats of the object
     */
    public void printStats() {
        try {
            Main.out.write("Main Stat:");
            if (attribute.size() == 0) {
                Main.out.write(" N/A\n");
            } else {
                Main.out.write("\n");
            }
            for (int index = 0; index < attribute.size(); index++) {
                if (index == 1) {
                    Main.out.write("Substat:\n");
                }
                if (attribute.get(index).getName().equals("")) {
                    Main.out.write("N/A: " + attribute.get(index).getNumber()+"\n");
                } else if (attribute.get(index).getScaling()) {
                    Main.out.write(attribute.get(index).getName() + ": " + attribute.get(index).getNumber() + "%\n");
                } else {
                    Main.out.write(attribute.get(index).getName() + ": " + attribute.get(index).getNumber()+"\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
