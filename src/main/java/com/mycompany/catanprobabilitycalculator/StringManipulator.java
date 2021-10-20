package com.mycompany.catanprobabilitycalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author fer5899 Github profile: https://github.com/fer5899
 */
public class StringManipulator {
    
    private
            
    Pattern pattern;
    Matcher matcher;
    String toManipulate;
    String regex;
    boolean caseSensitive;
    
    
    public StringManipulator(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }
    
    public void compileCreateMatcher() {
        
        if (caseSensitive) {
            pattern = Pattern.compile(regex);
        } else {
            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); 
        }
        
        // create the matcher with the pattern created to match on the input string
        matcher = pattern.matcher(toManipulate);
    }
    
    public void setCaseSensitive (boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }
    
    public boolean containsPattern (String toManipulate, String regex) {
        this.toManipulate = toManipulate;
        this.regex = regex;
       
        compileCreateMatcher();
        
        return matcher.find();
    }
    
    
    
    
}
