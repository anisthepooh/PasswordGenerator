
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This is an abstract class that holds the methods and attributes 
 * for the books objects to be made later. 
 * @author casperanisimow
 */
public abstract class Book {
    
    //Attributes:
    
    /** Title of the book */
    String title;
    
    /** Name of the author of the book */
    String author;
    
    /** Publish year */
    int year; 
    
    /** ArrayList containing the names of selected characters in the book */
    public ArrayList<String> characters = new ArrayList<String>(); 
    
    
    //Methods:
    
    /** Returns the year of publish
    * @return year of publish
    */
    public int getYear(){
        return year; 
    }

    
    /** Adds a character to the ArrayList
     * @param person which is the character given as a String
     */
    public void addNames(String person){
        characters.add(person); 
    }
    
    
   
}