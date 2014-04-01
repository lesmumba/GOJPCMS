import java.util.*;
import java.lang.*;
/**
 * Write a description of class Captial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Captial extends Project
{
    // instance variables - replace the example below with your own
    String typeOfCapital;


    /**
     * Constructor for objects of class Captial
     */
    public Captial(String typeOfCapital,String name, String description)
    {
        // initialise instance variables
        super(name,description);
        this.typeOfCapital= typeOfCapital;
    }

    
}
