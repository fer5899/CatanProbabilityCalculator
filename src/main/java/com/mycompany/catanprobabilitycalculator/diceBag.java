/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.catanprobabilitycalculator;

import java.util.Random;


/**
 *
 * @author fer5899 Github profile: https://github.com/fer5899
 */
public class DiceBag {
    
    Random generator;
    
    public DiceBag() {
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
        
        StringManipulator manipulator = new StringManipulator(false); // caseSensitive set to false
        
        // regex to check if the dice format is correct     Ej: 3d8+6
        String regexFormat = "[1-9]*d[1-9]+\\[+-]*[1-9]*";
        
        
        if (manipulator.containsPattern(regexFormat, dice)) {
            
            // set the pattern and extract number of dice
            String regexNDice = "[1-9]*d";
            String nDiceS = manipulator.extractFirstMatch(regexNDice, dice);
            // remove the "d" from the string obtained and parse the integer
            int nDice = 0 + Integer.parseInt(nDiceS.replaceFirst("d", "")); 
            // remove the string obtained from dice
            dice = dice.replaceFirst(nDiceS, "");
            
            // repeat the process for the dice type
            String regexDiceType = "[1-9]+\\+";
            String diceTypeS = manipulator.extractFirstMatch(regexDiceType, dice);
            int diceType = 0 + Integer.parseInt(diceTypeS.replaceFirst("\\+", ""));
            dice = dice.replaceFirst(diceTypeS, "");
            
            // if everything goes well, the rest of dice is only the modifier number
            int modifier = 0 + Integer.parseInt(dice);
            
            // execute throwDice with basic inputs
            result = throwDice(nDice, diceType, modifier);
        }
            

        return result;
    }
    
}
