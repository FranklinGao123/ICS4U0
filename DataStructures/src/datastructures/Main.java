/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import datastructures.FastReader;
import datastructures.Stats;
import datastructures.Attributes;
import datastructures.Artifacts;
import java.util.*;
import java.io.*;

/**
 *
 * @author frank
 */
public class Main {
    public static FileWriter out;
    
    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        out = new FileWriter("output.txt");
        String characterName = scanner.nextLine();
        String dmgType = scanner.nextLine();
        String weaponName = scanner.nextLine();
        String weaponType = scanner.nextLine();
        Character character1 = new Character(characterName, dmgType, new Weapon(weaponName, weaponType), new ArrayList<Artifacts>());
        for(int index = 0; index < 4; index++){
            
        }
        out.close();
        
        
        
    }
    
}
