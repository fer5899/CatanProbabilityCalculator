package com.mycompany.catanprobabilitycalculator;

/**
 *
 * @author fer5899   Github profile: https://github.com/fer5899
 */

import java.util.Random;
        
public class totalYields {

    static void getYields (int [] tiles, int testSize) {
        
    }
        
    public static void main(String args[]) {
        
        StringManipulator manipulator = new StringManipulator(false);
        DiceBag myDiceBag = new DiceBag();
        
        String dice = "2d6+1";
        String regexFormat = "[0-9]+d[0-9]+\\+*[0-9]*";
        
        //System.out.println(manipulator.extractFirstMatch(toManipulate, regex));
        for (int i = 0; i < 10; i++) {
            System.out.println(myDiceBag.throwDice(dice));
        }
        
        
        
    }
}
