package datastructures;

import java.util.*;
import java.io.*;
import datastructures.Attributes;

/**
 * An object containing information for the artifacts
 * 
 * @author      Franklin Gao
 * @version     1.0                 (current version number of program)
 * @since       1.8          (the version of the package this class was first added to)
 */
public class Artifacts extends Stats implements Comparable<Artifacts>{
    /**
     * name of the artifact
     */
    private String name;
    /**
     * the name of the set of the artifact
     */
    private String setName;
    /**
     * the name of the piece of the artifact
     */
    private String piece;
    /**
     * the artifact 2 set bonus stat
     */
    private String artifact2SetBonus;
    /**
     * the artifact 4 set bonus stat
     */
    private String artifact4SetBonus;
    
    /**
     * This is the constructor function for a new artifact
     */

    public Artifacts() {
        super();
        name = "";
        setName = "";
        piece = "";
        artifact2SetBonus = "";
        artifact4SetBonus = "";
    }
    
    /**
     * This is an overloaded constructor for an artifact without its stats
     * 
     * @param name - name of the artifact
     * @param setName - name of the set of the artifact
     * @param piece - name of the piece of the artifact
     * @param artifact2SetBonus - the 2 set bonus stat of the artifact set
     * @param artifact4SetBonus - the 4 set bonus stat of the artifact set
     */

    public Artifacts(String name, String setName, String piece, String artifact2SetBonus, String artifact4SetBonus) {
        super();
        this.name = name;
        this.setName = setName;
        this.piece = piece;
        this.artifact2SetBonus = artifact2SetBonus;
        this.artifact4SetBonus = artifact4SetBonus;
    }
    
    /**
     * This is an overloaded constructor with all its information
     * 
     * @param name - name of the artifact
     * @param setName - name of the set of the artifact
     * @param piece - name of the piece of the artifact
     * @param artifact2SetBonus - the 2 set bonus stat of the artifact set
     * @param artifact4SetBonus - the 4 set bonus stat of the artifact set
     * @param level - level of the artifact
     * @param attribute - attributes of the artifact
     */

    public Artifacts(String name, String setName, String piece, String artifact2SetBonus, String artifact4SetBonus, int level, ArrayList<Attributes> attribute) {
        super(level, attribute);
        this.name = name;
        this.setName = setName;
        this.piece = piece;
        this.artifact2SetBonus = artifact2SetBonus;
        this.artifact4SetBonus = artifact4SetBonus;
    }
    
    /**
     * Returns the name of the artifact
     * 
     * @return the name of the artifact as a String
     */

    public String getName() {
        return name;
    }
    
    /**
     * Returns the Set name of the artifact
     * 
     * @return the set name of the artifact as a String 
     */

    public String getSetName() {
        return setName;
    }
    
    /**
     * Returns the piece of the artifact
     * 
     * @return the piece of the artifact as a String
     */
    
    public String getPiece() {
        return piece;
    }
    
    /**
     * Returns the 2 set bonus of the artifact
     * 
     * @return the 2 set bonus of the artifact as a String
     */
    
    public String getArtifact2SetBonus(){
        return artifact2SetBonus;
    }
    
    /**
     * Returns the 4 set bonus of the artifact
     * 
     * @return the 4 set bonus of the artifact as a String
     */
    
    public String getArtifact4SetBonus(){
        return artifact4SetBonus;
    }
    
    /**
     * Sets the name of the artifact
     * 
     * @param name - name of the artifact
     */
    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets the set name of the artifact
     * 
     * @param setName - the name of the set of the artifact
     */

    public void setSetName(String setName) {
        this.setName = setName;
    }
    
    /**
     * Sets the name of the piece of the artifact
     * 
     * @param getPiece - the name of the piece of the artifact
     */

    public void setPiece(String getPiece) {
        this.piece = piece;
    }
    
    /**
     * Sets the 2 set artifact bonus
     * 
     * @param artifact2SetBonus - the bonus of having a 2 set artifact set bonus
     */
    
    public void setArtifact2SetBonus(String artifact2SetBonus){
        this.artifact2SetBonus = artifact2SetBonus;
    }
    
    /**
     * Sets the 4 set artifact bonus
     * 
     * @param artifact4SetBonus - the bonus of having a 4 set artifact set bonus
     */
    
    public void setArtifact4SetBonus(String artifact4SetBonus){
        this.artifact4SetBonus = artifact4SetBonus;
    }
    
    /**
     * Prints the artifact information as well as its stats
     */
    
    public void printArtifact(){
        try{
        Main.out.write("Artifact:\n");
        if(!name.equals(""))
            Main.out.write("Name: "+ name +"\n");
        else
            Main.out.write("Name: N/A\n");
        if(!setName.equals(""))
            Main.out.write("Set Name: "+ setName +"\n");
        else
            Main.out.write("Set Name: N/A\n");
        if(!piece.equals(""))
            Main.out.write("Piece: "+ piece+"\n");
        else
            Main.out.write("Piece: N/A\n");
        if(!artifact2SetBonus.equals(""))
            Main.out.write("2 Set Bonus: "+ artifact2SetBonus+"\n");
        else
            Main.out.write("2 Set Bonus: N/A\n");
        if(!artifact4SetBonus.equals(""))
            Main.out.write("4 Set Bonus: "+ artifact4SetBonus+"\n");
        else
            Main.out.write("4 Set Bonus: N/A\n");
        super.printStats();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    @Override
    public int compareTo(Artifacts other){
        return this.getLevel()-other.getLevel();
    }

}
