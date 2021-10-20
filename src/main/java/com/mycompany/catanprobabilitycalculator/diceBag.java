/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.catanprobabilitycalculator;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fer5899 Github profile: https://github.com/fer5899
 */
public class diceBag {
    
    Random generator;
    
    public diceBag() {
        Random generator = new Random();        
    }
    
    public int throwDice(int nDice, int diceType, int modifier) {
        
        int result = 0;
        
        for (int i = 0; i < nDice; i++) {
            result = result + generator.nextInt(diceType)+1;
        }
        
        return result + modifier;
    }
    
    public int throwDice(String dice) {
        
        int result = -1;
        
        // regex to check if the dice format is correct     Ej: 3d8+6
        String regex = "[1-9]*d[1-9]+\\[+-]*[1-9]*";
        
        // create the pattern with the chosen regex
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); 
        
        // create the matcher with the pattern created to match on the input string
        Matcher matcher = pattern.matcher(dice);
        
        // check the format of the input string
        boolean matchFound = matcher.find();
        
        if (matchFound) {
            // set the pattern to extract number of dice
            pattern = Pattern.compile("[1-9]*");
            int nDice = 0 + Integer.parseInt(pattern.matcher(dice).group());
            int diceType = 0;
            int modifier = 0;
        }
            
        
        
        return result;
    }
    
}
