package Game;

/**
 * Created by jojonari on 2017. 5. 2..
 */
public class Game {
    private int[] rolls= new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score =0;
        int firstRollinFrame = 0;
        for (int frame = 0; frame < 10 ; frame++) {
            if(isSpare(firstRollinFrame)) {
                score += 10 + nextBallForSpare(firstRollinFrame);
                firstRollinFrame += 2;
            }else if(rolls[firstRollinFrame] == 10 ) {
                score += 10 + nextBallForStrike(firstRollinFrame);
                firstRollinFrame += 1;
            }else{
                score += nextBallsForFrame(firstRollinFrame);
                firstRollinFrame += 2;
            }

        }
        return score;
    }

    private int nextBallForSpare(int firstRollinFrame) {
        return rolls[firstRollinFrame + 2];
    }

    private int nextBallsForFrame(int firstRollinFrame) {
        return rolls[firstRollinFrame ] + rolls[firstRollinFrame+1];
    }

    private int nextBallForStrike(int firstRollinFrame) {
        return rolls[firstRollinFrame + 1] + rolls[firstRollinFrame + 2];
    }

    private boolean isSpare(int firstRollinFrame) {
        return nextBallsForFrame(firstRollinFrame) == 10;
    }
}
