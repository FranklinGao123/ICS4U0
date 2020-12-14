package datastructures;

/**
 * A Object for inputing different types of input data types
 *
 * @author Franklin Gao
 * @version 1.0 (current version number of program)
 * @since 1.8 (the version of the package this class was first added to)
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
