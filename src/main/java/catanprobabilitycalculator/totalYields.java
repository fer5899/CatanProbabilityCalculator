package catanprobabilitycalculator;

/**
 *
 * @author Fernando Gómez de la Varga -- Github profile:
 * https://github.com/fer5899
 */
public class totalYields {

    // calculates the raw yield probability of a set of tiles in a turn and the number of hits
    // OUTPUT: double array {ratio, hits}
    static double[] getYieldsRatioPerTurn(int[] tiles, int nThrows) {
        DiceBag myDiceBag = new DiceBag();
        int hits = 0;
        int dice;
        double ratio;
        double[] result = {0,0};

        // do nThrows number of turns
        for (int a = 0; a < nThrows; a++) {
            dice = myDiceBag.throwDice(2, 6, 0);

            // check the number of tiles that produce with the dice rolled
            for (int b = 0; b < tiles.length; b++) {
                if (tiles[b] == dice) {
                    hits++;
                }
            }
        }

        ratio = hits / Double.valueOf(nThrows);
        
        result[0] = ratio;
        result[1] = hits;
        
        return result; // OUTPUT: double array {ratio, hits}
    }

    // calculates the percentage of turns where you get yields from your tiles of game length nTurns, being nGames
    // equivalent to nThrows in the method getYieldsRatioPerTurn
    static double getYieldsRatioPerGame(int[] tiles, int nTurns, int nGames) {
        double ratio = 0;
        
        for (int a = 0; a < nGames; a++) {
            ratio = ratio + getYieldsRatioPerTurn(tiles, nTurns)[0];
        }
        
        ratio = ratio/nGames;
        
        return ratio;
    }

    public static void main(String args[]) {

        int[] tiles = {3, 4, 5, 9, 10, 11};
        int nTurns = 10;
        int nGames = 1000000;

        System.out.println(getYieldsRatioPerGame(tiles, nTurns, nGames));

    }
}
