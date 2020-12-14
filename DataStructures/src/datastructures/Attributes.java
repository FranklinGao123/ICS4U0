/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author 665937
 */
public class Attributes {
    private String name;
    private double number;
    private boolean scaling;
    
    public Attributes(){
        name = "";
        number = 0;
        scaling = false;
    }
    
    public Attributes(String name, double number, boolean scaling){
        this.name = name;
        this.number = number;
        this.scaling = scaling;
    }
    
    public String getName(){
        return name;
    }
    
    public double getNumber(){
        return number;
    }
    
    public boolean getScaling(){
        return scaling;
    }
}
