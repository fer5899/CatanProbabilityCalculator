package catanprobabilitycalculator;

/**
 *
 * @author fer5899   Github profile: https://github.com/fer5899
 */

import java.util.Random;
        
public class totalYields {
    
    // calculates the raw yield probability of a set of tiles in a turn
    static double getYieldsRatio (int [] tiles, int testSize) {
        DiceBag myDiceBag = new DiceBag();
        int hits = 0;
        int dice;
        double ratio;
        
        // do testSize number of turns
        for (int a = 0; a < testSize; a++) {
            dice = myDiceBag.throwDice(2,6,0);
            
            // check the number of tiles that produce with the dice rolled
            for (int b = 0; b < tiles.length; b++) {
                if (tiles[b] == dice) {
                    hits++;
                }
            }
        }
        
        ratio = hits / Double.valueOf(testSize);
        
        return ratio;
    }
        
    public static void main(String args[]) {
        
        int[] tiles = {5,5,6,6,8,8};
        int testSize = 1000000;
        
        System.out.println(getYieldsRatio(tiles, testSize)); 

    }
}
