/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import datastructures.FastReader;
import datastructures.Stats;
import datastructures.Pair;
import java.util.*;
import java.io.*;

/**
 *
 * @author frank
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        Stats character = new Stats();
        character.setLevel(50);
        character.setSubStats("Crit Rate", 0.01);
        character.printStats();
        System.out.println("=============================");
        character.setMainAttribute("Attack Damage", 200);
        character.setSubStats("Crit Dmg", 0.1);
        character.setSubStats("Crit Rate", 0.15);
        character.printStats();
        System.out.println("=============================");
        character.deleteSubStat("Crit Dmg", 0.1);
        character.printStats();
        System.out.println("=============================");
        character.deleteSubStat("Crit Dmg", 0.1);
        character.deleteMainStat();
        character.printStats();
        
        
        
    }
    
}
