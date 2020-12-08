/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import datastructures.Pair;
import java.util.*;

/**
 * @author      Franklin Gao
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Stats {

    private int level;
    //0th index of attribtue is the Main attribute, all sub attributes are listed after 0
    private ArrayList<Pair> attribute;

    public Stats() {
        level = 1;
        attribute = new ArrayList<Pair>();
    }

    public Stats(int level, ArrayList<Pair> attribute) {
        this.level = level;
        this.attribute = attribute;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMainAttribute(String attribute, double attributeNumber) {
        if (this.attribute.isEmpty()) {
            this.attribute.add(new Pair(attribute, attributeNumber));
        } else {
            this.attribute.add(0, new Pair(attribute, attributeNumber));
            this.attribute.remove(1);
        }
    }

    public void setSubStats(String attribute, double attributeNumber) {
        if (this.attribute.isEmpty()) {
            this.attribute.add(new Pair());
        }
        this.attribute.add(new Pair(attribute, attributeNumber));
    }
    
    public int getLevel(){
        return level;
    }
    
    public ArrayList<Pair> getAttributes(){
        return attribute;
    }
    
    public void deleteMainStat(){
        if(!attribute.isEmpty()){
            attribute.set(0, new Pair());
        }
    }
    
    public void deleteSubStat(String attribute, double attributeNumber) {
        for (int index = 1; index < this.attribute.size(); index++) {
            if (this.attribute.get(index).getName() == attribute && this.attribute.get(index).getNumber() == attributeNumber) {
                this.attribute.remove(index);
                return;
            }
        }
        System.out.println("Delete Failed, Please reinput attributes");
    }

    public void printStats() {
        System.out.println("Main Stat:");
        for (int index = 0; index < attribute.size(); index++) {
            if(index==1) {
                System.out.println("Substat:");
            }
            if(attribute.get(index).getName().equals(""))
                System.out.println("N/A: " + attribute.get(index).getNumber());
            else
                System.out.println(attribute.get(index).getName() + ": " + attribute.get(index).getNumber());
        }
    }

}
