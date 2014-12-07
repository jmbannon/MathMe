/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package games;

import static games.FlashMath_Difficulty.MEDIUM;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Contains player variables for the game FlashMath.
 */
public class FlashMath_Player {
    
    /** Easy question score amount. */
    private static final int EASY_QUESTION_SCORE = 5;
    
    /** Medium question score amount. */
    private static final int MEDIUM_QUESTION_SCORE = 10;
    
    /** Hard question score amount. */
    private static final int HARD_QUESTION_SCORE = 20;
    
    /** Expert question score amount. */
    private static final int EXPERT_QUESTION_SCORE = 50;
    
    
    /** Easy question timer amount. */
    private static final int EASY_TIMER_TIME = 15;
    
    /** Medium question timer amount. */
    private static final int MEDIUM_TIMER_TIME = 12;
    
    /** Hard question timer amount. */
    private static final int HARD_TIMER_TIME = 8;
    
    /** Expert question timer amount. */
    private static final int EXPERT_TIMER_TIME = 5;
    
    /** Total amount of player lives. */
    private static final int TOTAL_LIVES = 5;
    
    private FlashMath_Difficulty difficulty;
    
    private int questionScore;
    private int timerTime;
    
    private int lives;
    private int totalScore;
    
    /**
     * Sets the player difficulty and initializes player values 
     * based on difficulty.
     * @param theDifficulty Player difficulty.
     */
    public FlashMath_Player(FlashMath_Difficulty theDifficulty) {
        difficulty = theDifficulty;
        totalScore = 0;
        lives = TOTAL_LIVES;
        
        switch(difficulty) {
            case EASY:
                questionScore = EASY_QUESTION_SCORE;
                setTimer(EASY_TIMER_TIME);
                break;
            case MEDIUM:
                questionScore = MEDIUM_QUESTION_SCORE;
                setTimer(MEDIUM_TIMER_TIME);
                break;
            case HARD:
                questionScore = HARD_QUESTION_SCORE;
                setTimer(HARD_TIMER_TIME);
                break;
            case EXPERT:
                questionScore = EXPERT_QUESTION_SCORE;
                setTimer(EXPERT_TIMER_TIME);
                break;
            default:
                questionScore = 0;
                timerTime = 0;
                System.err.println("ERROR: INVALID DIFFICULTY");
        }    
    }
    
    /**
     * Updates a player's score or lives based on whether their answer was
     * correct or not.
     * @param answer True if answer is correct. False if answer is not correct.
     */
    public void updatePlayer(final boolean answer) {
        if (answer)
            totalScore += questionScore;
        else
            --lives;
    }
    
    /**
     * Returns whether the player is alive or not.
     * @return if lives are greater than 0.
     */
    public boolean isAlive() {
        return lives > 0;
    }
    
    /**
     * Sets the difficulty of the player and modifies player values based on
     * difficulty.
     * 
     * @param theDifficulty Player difficulty.
     */
    public void setDifficulty(FlashMath_Difficulty theDifficulty) {
        difficulty = theDifficulty;
        switch(theDifficulty) {
            case EASY:
                questionScore = EASY_QUESTION_SCORE;
                setTimer(EASY_TIMER_TIME);
                break;
            case MEDIUM:
                questionScore = MEDIUM_QUESTION_SCORE;
                setTimer(MEDIUM_TIMER_TIME);
                break;
            case HARD:
                questionScore = HARD_QUESTION_SCORE;
                setTimer(HARD_TIMER_TIME);
                break;
            case EXPERT:
                questionScore = EXPERT_QUESTION_SCORE;
                setTimer(EXPERT_TIMER_TIME);
                break;               
        }
    }
    
    /**
     * Sets the question timer time.
     * @param seconds Question timer time in seconds.
     */
    private void setTimer(final int seconds) {
        timerTime = seconds*1000;
    }
    
    /**
     * Returns the timer time in milliseconds.
     * @return Timer time in milliseconds.
     */
    public int getTimerTime() {
        return timerTime;
    }
    
    /**
     * Returns player's chosen difficulty.
     * @return Player's chosen difficulty.
     */
    public FlashMath_Difficulty getDifficulty() {
        return difficulty;
    }
    
    /**
     * Returns amount of player's lives.
     * @return Amount of player's lives.
     */
    public int getLives() {
        return lives;
    }
    
    /**
     * Returns amount of player's score.
     * @return Amount of player's score.
     */
    public int getScore() {
        return totalScore;
    }    
}
