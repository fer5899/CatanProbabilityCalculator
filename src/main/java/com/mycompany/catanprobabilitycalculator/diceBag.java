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
    
}
