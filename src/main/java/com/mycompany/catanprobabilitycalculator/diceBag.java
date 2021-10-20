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
            
            int nDice = 0;
            
            // set the pattern and extract the type of dice
            int diceType = 0;
            int modifier = 0;
        }
            
        
        
        return result;
    }
    
}
