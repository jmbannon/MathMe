/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package tools;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Backend code of a simple calculator to run through a GUI.
 */
public class Calculator_Main {
    private final StringBuilder operatorBuilder = new StringBuilder();
    private final StringBuilder inputBuilder = new StringBuilder();
    private String operator;
    private String input;
    
    private double totalDouble = 0;
    private double tempDouble = 0;
    
    /* Operators */
    private boolean add;
    private boolean sub;
    private boolean mult;
    private boolean div;
    private boolean uniqueOperator; //Sqrt and Reciprocal
    
    private boolean editable;
    private boolean hasError;   
    private boolean overrideNextButton;
    private boolean tempIsNegative;
    private boolean tempHasDecimal;
    
    
    public String getInput() {
        return input;
    }
    
    public String getOperator() {
        return operator;
    }
    
    private void updateInputScreen() {      
        input = inputBuilder.toString();       
        
        if (hasError || overrideNextButton) {
            hasError = false;
            overrideNextButton = false;
            inputBuilder.setLength(0);
            editable = true;
        }
    }
    
    private void addToOperatorScreen(char operation) {
        if (uniqueOperator) {            
            operatorBuilder.append(" ");
            operatorBuilder.append(operation);
            operatorBuilder.append(" ");
            uniqueOperator = false;
        } else {
            operatorBuilder.append(input);
            operatorBuilder.append(" ");
            operatorBuilder.append(operation);
            operatorBuilder.append(" ");
        }        
        operator = operatorBuilder.toString();
        //OperatorScreen.setText(operator);       
    }
    
    /**
     * Parses the input in the InputTextScreen to a double
     * and sets input string to input.
     */
    private void parseInput() {
        input = inputBuilder.toString();
        tempDouble = Double.parseDouble(input);
        tempHasDecimal = false;
        tempIsNegative = false;
    }
    
    private void Operation() {
        if (add) {
            totalDouble += tempDouble;
            add = false;
        }
        else if (sub) {
            totalDouble -= tempDouble;
            sub = false;
        }
        else if (mult) {
            totalDouble *= tempDouble;
            mult = false;
        }
        else if (div) {
            if (tempDouble == 0) {
                hasError = true;
                editable = false;
                inputBuilder.setLength(0); 
                inputBuilder.append("Divide by 0 Error");
                //updateInputScreen();
            } else {
                totalDouble = totalDouble/tempDouble;
            }
            div = false;
        }
        else totalDouble = tempDouble;
    }
    
    private void inputUneditable() {
        if (!editable) {
            clearOperatorScreen();
            clearInputScreen();
            editable = true;
        }
    }
    
    private boolean hasNoInput() {
        if (inputBuilder.length() == 0) return true;
        else if (inputBuilder.length() == 1 && (inputBuilder.charAt(0) == '.' 
            || inputBuilder.charAt(0) == '-')) return true;      
        else return hasError;
    }
    
    /**
     * Clears the OperatorScreen.
     */
    private void clearOperatorScreen() {
        operatorBuilder.setLength(0);
        operator = "";
    }
    
    private void clearInputScreen() {
        inputBuilder.setLength(0);
        input = ""; 
    }
    
    public void addButton() {
        if (!hasNoInput()) {          
            parseInput();
            addToOperatorScreen('+');                                   
            Operation();
            
            add = true;           
            overrideNextButton = true;
            
            updateInputScreen();
        }
    }
    
    public void subtractButton() {
        if (!hasNoInput()) {
            parseInput();
            addToOperatorScreen('-');                                              
            Operation();
            
            sub = true;           
            overrideNextButton = true;
            
            updateInputScreen();
        }
    }
    
    public void multiplyButton() {
        if (!hasNoInput()) {          
            parseInput();
            addToOperatorScreen('*');                                   
            Operation();           
            
            mult = true;           
            overrideNextButton = true;
            
            updateInputScreen();
        }
    }
    
    public void divideButton() {
        if (!hasNoInput()) {          
            parseInput();
            addToOperatorScreen('/');                                   
            Operation();
            
            div = true;           
            overrideNextButton = true;
            
            updateInputScreen();
        }
    }
    
    public void equalsButton() {
        if (!hasNoInput()) {
            
            clearOperatorScreen();           
            parseInput();            
            Operation();
            
            if (!hasError) {           
                inputBuilder.setLength(0);
                inputBuilder.append(totalDouble);
            
                editable = false;                           
            }
            
            updateInputScreen();
            
        }
    }
    
    public void clearButton() {
        clearOperatorScreen();
        clearInputScreen();
        
        totalDouble = 0;
        tempDouble = 0;
        tempIsNegative = false;
        tempHasDecimal = false;
        
        add = false;
        sub = false;
        mult = false;
        div = false;
        uniqueOperator = false;
        
        hasError = false;
        overrideNextButton = false;
        editable = true;
                
        updateInputScreen();
    }
    
    public void clearInputButton() {
        clearInputScreen();
        updateInputScreen();
    }
    
    public void backSpaceButton() {
        if (inputBuilder.length() > 0 && editable) {
            if (inputBuilder.charAt(inputBuilder.length() -1) == '.') tempHasDecimal = false;
            else if (inputBuilder.charAt(inputBuilder.length() - 1) == '-') tempIsNegative = false;
            inputBuilder.deleteCharAt(inputBuilder.length()-1);
            updateInputScreen();
        }  
    }
    
    public void numButton(char num) {
        inputUneditable();
        inputBuilder.append(num);
        updateInputScreen();
    }
    
    public void negativeButton() {
        if (inputBuilder.charAt(0) == '-') {
            tempIsNegative = false;
            inputBuilder.deleteCharAt(0);
            updateInputScreen();     
        }
        else { 
            tempIsNegative = true;
            inputBuilder.insert(0, '-');
            updateInputScreen(); 
        }
    }
    
    public void decimalButton() {
        inputUneditable();
        if (!tempHasDecimal) {
            tempHasDecimal = true;
            if (inputBuilder.length() == 0 
                || (inputBuilder.length() == 1 
                && inputBuilder.charAt(0) == '-')) 
                inputBuilder.append("0.");
            else inputBuilder.append('.'); 
            
            updateInputScreen();
        }    
    }
    
    public void reciprocalButton() {
        if (!hasNoInput()) {
            parseInput();                                   
        
            if (tempDouble == 0) {
                hasError = true;
                inputBuilder.setLength(0); 
                inputBuilder.append("Divide by 0 Error");
            } else {
                //Lets operatorscreen know to use custom append
                uniqueOperator = true;
                
                operatorBuilder.append("Reciproc(");
                operatorBuilder.append(input);
                operatorBuilder.append(")");
                
                tempDouble = 1/tempDouble;
                inputBuilder.setLength(0); 
                inputBuilder.append(tempDouble);
            }
            
            editable = false;            
            updateInputScreen();           
        }
    }
    
    public void squareRootButton() {
        if (!hasNoInput()) {
            parseInput();                       
        
            if (tempDouble < 0) {
                hasError = true;
                inputBuilder.setLength(0); 
                inputBuilder.append("SQRT of Negative Error");
            } else {
                //Lets operatorscreen know to use custom append
                uniqueOperator = true;                
                
                operatorBuilder.append("Sqrt(");
                operatorBuilder.append(input);
                operatorBuilder.append(")");
                
                tempDouble = Math.sqrt(tempDouble);
                inputBuilder.setLength(0); 
                inputBuilder.append(tempDouble);
            }
            
            editable = false;
            updateInputScreen();           
        }
    }
    
    
    
}
