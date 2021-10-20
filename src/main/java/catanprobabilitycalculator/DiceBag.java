/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catanprobabilitycalculator;

import java.util.Random;

/**
 *
 * @author fer5899 Github profile: https://github.com/fer5899
 */
public class DiceBag {
    
    Random generator;
    
    public DiceBag() {
        generator = new Random();
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
        String regexFormat = "[0-9]+d[0-9]+\\+*[0-9]*";
        
        
        if (manipulator.containsPattern(dice, regexFormat)) {
            
            // set the pattern and extract number of dice
            String regexNDice = "[0-9]+d";
            String nDiceS = manipulator.extractFirstMatch(dice, regexNDice);
            // remove the "d" from the string obtained and parse the integer
            int nDice = 0 + Integer.parseInt(nDiceS.replaceFirst("d", "")); 
            // remove the string obtained from dice
            dice = dice.replaceFirst(nDiceS, "");

            
            // repeat the process for the dice type
            String regexDiceType = "[0-9]+\\+";
            String diceTypeS = manipulator.extractFirstMatch(dice, regexDiceType);
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
