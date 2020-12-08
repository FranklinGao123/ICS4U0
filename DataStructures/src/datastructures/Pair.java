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
public class Pair {
    private String name;
    private double number;
    
    public Pair(){
        name = "";
        number = 0;
    }
    
    public Pair(String name, double number){
        this.name = name;
        this.number = number;
    }
    
    public String getName(){
        return name;
    }
    
    public double getNumber(){
        return number;
    }
}
