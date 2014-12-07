/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package games;

import class_resources.CountdownTimer;
import class_resources.PlaySound;
import static games.FlashMath_Difficulty.MEDIUM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Contains everything needed to run the game FlashMath through a GUI.
 */
public class FlashMath_Main {
    private FlashMath_Player player;
    private FlashMath_Abstract_Question question;
    
    private FlashMath_Type type;
    private FlashMath_Difficulty difficulty;
    
    private CountdownTimer countdownTimer;
    private Timer timer;
    
    private JLabel timerLabel;
    private JLabel questionLabel;
    
    private String inputTextFieldString;
    private String questionLabelText;
    private String submitButtonText;
    private String scoreLabelText;
    private String livesLabelText;    
    
    private final List<JCheckBoxMenuItem> subjectList;
    
    private boolean userInGame;
    private boolean gameOver;
    private boolean answeringQuestion;
    private boolean inputTextFieldEditable;
    
    /**
     * Initializes all values within FlashMath.
     */
    public FlashMath_Main() {
        difficulty = MEDIUM;
        question = new FlashMath_Arithmetic();
        player = new FlashMath_Player(difficulty);
        subjectList = new ArrayList<>();
        
        timerLabel = new JLabel();
        questionLabel = new JLabel();
        
        userInGame = true;
        gameOver = false;
        answeringQuestion = false;
        inputTextFieldEditable = false;
        
        questionLabelText = "<html><center>Flash Math<br><font size=+0>"
                + "Press start to begin</font></center></html>";
        
        submitButtonText = "Start";
        scoreLabelText = "";
        livesLabelText = ""; 
        inputTextFieldString = "";
    }
    
    /**
     * Adds a JCheckBoxMenuItem to check for selected question types to produce.
     * @param subjectCheckBoxItem 
     */
    public void addSubjectCheckBoxItem(JCheckBoxMenuItem subjectCheckBoxItem) {
        subjectList.add(subjectCheckBoxItem);
    }
    
    /**
     * Starts a question.
     */
    private void startQuestion() { 
        if (userInGame) {
            
            if (difficulty != null) {
                player.setDifficulty(difficulty);               
            } else {
                difficulty = MEDIUM;
                player.setDifficulty(difficulty);
            }
                         
            updatePlayerStats();
            getRandomSubject();
        
            questionLabelText = question.getQuestionText();
            
            // Creates timer for question and countdown timer
            timer = new Timer(player.getTimerTime(), new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e) {
                    stopQuestion();
                }
            });
            
            timer.start();
            countdownTimer = new CountdownTimer(player.getTimerTime(), timerLabel);
            
            // Allows editing answer and changes button text to 'Submit'
            inputTextFieldString = "";
            inputTextFieldEditable = true;
            submitButtonText = "Submit";

            answeringQuestion = true;
            System.out.println("Starting timer...");
        }
        else {
            updatePlayerStats();
            gameOver = true;
            inputTextFieldEditable = false;
            scoreLabelText = "";
            livesLabelText = "";
            inputTextFieldString = "";
            questionLabelText = 
                    "<HTML><CENTER>Game Over<br><font size=+2>Score: " 
                    + player.getScore() + "</font><br><font size=+1>Play Again?"
                    + "</font></CENTER></HTML>";
            
            submitButtonText = "Yes!";
        }
    }
     
    /**
     * Gets a random subject based on selected JCheckBoxMenuItems.
     */
    private void getRandomSubject() {
        if (!subjectList.isEmpty()) {
            Collections.shuffle(subjectList);
            boolean isSelected = false;
            
            for (JCheckBoxMenuItem subject : subjectList) {
                if (subject.isSelected()) {
                    switch (subject.getText()) {
                        case "Arithmetic":
                            question = new FlashMath_Arithmetic();
                            isSelected = true;
                          break;
                        case "Multiplication":
                            question = new FlashMath_Multiplication();
                            isSelected = true;
                            break;
                        case "Exponents":
                            question = new FlashMath_Exponent();
                            isSelected = true;
                            break;
                        case "Binary":
                            question = new FlashMath_Binary();
                            isSelected = true;
                            break;
                        case "To Binary":
                            question = new FlashMath_ToBinary();
                            isSelected = true;
                            break;
                        default:
                            System.err.println("Invalid subject.getText()");
                            isSelected = false;
                            break;
                    }
                }
                if (isSelected)
                    break;
            }
            
            if (!isSelected)
                question = new FlashMath_Arithmetic();
        } else
            question = new FlashMath_Arithmetic();
        
        type = question.getType();    
    }
    
    /**
     * Stops the question.
     */
    private void stopQuestion() {
        if (timer != null)
            timer.stop();
        
        countdownTimer.stop();
        
        answeringQuestion = false;
        inputTextFieldEditable = false;
        
        question.setInput(inputTextFieldString.trim());
        
        if (question.isCorrect()) {
            PlaySound.stop();
            PlaySound.play("FlashMath_Correct.wav");
            player.updatePlayer(true);
            questionLabelText = question.getDisplayCorrectAnswer();
        } else {
            PlaySound.stop();
            PlaySound.play("FlashMath_Wrong.wav");
            player.updatePlayer(false);
            if (question.getInput().isEmpty())
                questionLabelText = question.getDisplayNoAnswer();
            else
                questionLabelText = question.getDisplayWrongAnswer();
        }

        questionLabel.setText(questionLabelText);
        
        updatePlayerStats();
        
        userInGame = player.isAlive();
        
        submitButtonText = "Next";
        System.out.println("Stopping timer. Answer = " + question.getAnswer());       
    }
    
    /**
     * Updates the players score and amount of lives remaining.
     */
    private void updatePlayerStats() {
        scoreLabelText = "Score: " + player.getScore();
        livesLabelText = "Lives: " + player.getLives();
    }
    
    /**
     * Action of when a user submits an answer.
     */
    public void submitButtonAction() {
        // Inputted text and timer still running
        if (answeringQuestion && timer != null && timer.isRunning() && userInGame) {
            if (!inputTextFieldString.isEmpty())
                stopQuestion();
        } else if (!gameOver)
            startQuestion(); 
        else {
            player = new FlashMath_Player(difficulty);
            gameOver = false;
            userInGame = true;
            startQuestion();
        }
    }
    
    /**
     * Stops the timers when the user is closing FlashMath.
     */
    public void closeGame() {
        //countdownTimer.stop();
    }
    
    /**
     * Sets the JLabel to display the timer.
     * @param timer JLabel to display the timer. 
     */
    public void setTimerLabel(final JLabel timer) {
        timerLabel = timer;
    }
    
    /**
     * Sets the JLabel to display the question.
     * @param question JLabel to display the question.
     */
    public void setQuestionLabel(final JLabel question) {
        questionLabel = question;
    }
    
    /**
     * Sets the difficulty for the user.
     * @param theDifficulty Difficulty for the user.
     */
    public void setDifficulty(final FlashMath_Difficulty theDifficulty) {
        difficulty = theDifficulty;
    }
    
    /**
     * Sets the text within the user's input TextField.
     * @param inputTextField Text within the user's input TextField.
     */
    public void setInputTextFieldString(final String inputTextField) {
        inputTextFieldString = inputTextField;
    } 
    
    /**
     * Sets whether the game is over or not.
     * @param isGameOver Status of game over.
     */
    public void setGameOver(final boolean isGameOver) {
        gameOver = isGameOver;
    }
    
    /**
     * Sets whether the user is in game.
     * @param inGame Status of the user in game.
     */
    public void setUserInGame(final boolean inGame) {
        userInGame = inGame;
    }
    
    /**
     * Returns whether if the user is in game.
     * @return If the user is in game.
     */
    public boolean getUserInGame() {
        return userInGame;
    }
    
    /**
     * Returns whether the game is over.
     * @return Status of game is over.
     */
    public boolean getGameOver() {
        return gameOver;
    }
    
    /**
     * Returns whether the user's input TextField is editable.
     * @return Status of user's input TextField being editable.
     */
    public boolean getInputTextFieldEditable() {
        return inputTextFieldEditable;
    }
     
    /**
     * Returns the user's input text within the TextField.
     * @return User's input within the TextField.
     */
    public String getInputTextFieldString() {
        return inputTextFieldString;
    }
    
    /**
     * Returns the question label text.
     * @return Question label text.
     */
    public String getQuestionLabelText() {
        return questionLabelText;
    }
    
    /**
     * Returns the submit button text.
     * @return Submit button text.
     */
    public String getSubmitButtonText() {
        return submitButtonText;
    }
    
    /**
     * Returns the user's difficulty.
     * @return User's difficulty.
     */
    public FlashMath_Difficulty getDifficulty() {
        return difficulty;
    }
    
    /**
     * Returns the score label text.
     * @return Score label text.
     */
    public String getScoreLabelText() {
        return scoreLabelText;
    }
    
    /**
     * Returns the lives label text.
     * @return Lives label text.
     */
    public String getLivesLabelText() {
        return livesLabelText;
    }
}
