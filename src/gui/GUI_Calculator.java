/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package gui;
import class_resources.GetImage;
import tools.Calculator_Main;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Calculator graphical user interface.
 */
public class GUI_Calculator extends javax.swing.JFrame {

    /** Status of GUI_Calculator if it is open or not. */
    private static boolean IS_OPEN = false;
    
    private final Calculator_Main calculator; 
    
    /**
     * Initializes calculator GUI components. 
     */
    public GUI_Calculator() {
        calculator = new Calculator_Main();
        initComponents();    
    }
    
    /**
     * @return If an instance of GUI_Calculator is already open or not. 
     */
    public static boolean isOpen() {
        return IS_OPEN;
    }
    
    /**
     * Updates the calculator input and operator screens based on user input.
     */
    private void updateScreens() {
       InputScreen.setText(calculator.getInput());
       OperatorScreen.setText(calculator.getOperator());
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        C = new javax.swing.JButton();
        Neg = new javax.swing.JButton();
        _7 = new javax.swing.JButton();
        _8 = new javax.swing.JButton();
        _9 = new javax.swing.JButton();
        Divide = new javax.swing.JButton();
        _4 = new javax.swing.JButton();
        _5 = new javax.swing.JButton();
        Multiply = new javax.swing.JButton();
        _1 = new javax.swing.JButton();
        _2 = new javax.swing.JButton();
        _3 = new javax.swing.JButton();
        Subtract = new javax.swing.JButton();
        Equals = new javax.swing.JButton();
        _0 = new javax.swing.JButton();
        Decimal = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        _6 = new javax.swing.JButton();
        Reciprocal = new javax.swing.JButton();
        CE = new javax.swing.JButton();
        Backspace = new javax.swing.JButton();
        SquareRoot = new javax.swing.JButton();
        InputScreen = new javax.swing.JTextField();
        OperatorScreen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calculator");
        setIconImage(GetImage.returnImage("MATHME_ICON.png"));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(C, gridBagConstraints);

        Neg.setText("+-");
        Neg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Neg, gridBagConstraints);

        _7.setText("7");
        _7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_7, gridBagConstraints);

        _8.setText("8");
        _8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_8, gridBagConstraints);

        _9.setText("9");
        _9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_9, gridBagConstraints);

        Divide.setText("/");
        Divide.setPreferredSize(new java.awt.Dimension(39, 23));
        Divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivideActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Divide, gridBagConstraints);

        _4.setText("4");
        _4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_4, gridBagConstraints);

        _5.setText("5");
        _5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_5, gridBagConstraints);

        Multiply.setText("*");
        Multiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiplyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Multiply, gridBagConstraints);

        _1.setText("1");
        _1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_1, gridBagConstraints);

        _2.setText("2");
        _2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_2, gridBagConstraints);

        _3.setText("3");
        _3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_3, gridBagConstraints);

        Subtract.setText("-");
        Subtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubtractActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Subtract, gridBagConstraints);

        Equals.setText("=");
        Equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EqualsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 67;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Equals, gridBagConstraints);

        _0.setText("0");
        _0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(_0, gridBagConstraints);

        Decimal.setText(".");
        Decimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecimalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Decimal, gridBagConstraints);

        Add.setText("+");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Add, gridBagConstraints);

        _6.setText("6");
        _6.setPreferredSize(new java.awt.Dimension(39, 29));
        _6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(_6, gridBagConstraints);

        Reciprocal.setText("1/x");
        Reciprocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReciprocalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(Reciprocal, gridBagConstraints);

        CE.setText("CE");
        CE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(CE, gridBagConstraints);

        Backspace.setText("<---");
        Backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackspaceActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(Backspace, gridBagConstraints);

        SquareRoot.setText("\u221A");
        SquareRoot.setPreferredSize(new java.awt.Dimension(39, 23));
        SquareRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SquareRootActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(SquareRoot, gridBagConstraints);

        InputScreen.setEditable(false);
        InputScreen.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        InputScreen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        InputScreen.setText(calculator.getInput());

        OperatorScreen.setEditable(false);
        OperatorScreen.setText(calculator.getOperator());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OperatorScreen)
                    .addComponent(InputScreen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(OperatorScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(InputScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Divide button [ / ] action.
     * @param evt
     */
    private void DivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DivideActionPerformed
        calculator.divideButton();
        updateScreens();
    }//GEN-LAST:event_DivideActionPerformed

    /**
     * Clear input screen button [ CA ] action.
     * @param evt 
     */
    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        calculator.clearButton();
        updateScreens();
    }//GEN-LAST:event_CActionPerformed

    /**
     * 0 Button [ 0 ] action.
     * @param evt 
     */
    private void _0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__0ActionPerformed
        calculator.numButton('0');
        updateScreens();
    }//GEN-LAST:event__0ActionPerformed

    /**
     * 1 Button [ 1 ] action.
     * @param evt 
     */
    private void _1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__1ActionPerformed
        calculator.numButton('1');
        updateScreens();
    }//GEN-LAST:event__1ActionPerformed

    /**
     * Decimal Button [ . ] action.
     * @param evt 
     */
    private void DecimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecimalActionPerformed
        calculator.decimalButton();
        updateScreens();
    }//GEN-LAST:event_DecimalActionPerformed

    /**
     * 2 Button [ 2 ] action.
     * @param evt 
     */
    private void _2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__2ActionPerformed
        calculator.numButton('2');
        updateScreens();
    }//GEN-LAST:event__2ActionPerformed

    /**
     * 3 Button [ 3 ] action.
     * @param evt 
     */
    private void _3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__3ActionPerformed
        calculator.numButton('3');
        updateScreens();
    }//GEN-LAST:event__3ActionPerformed

    /**
     * 4 Button [ 4 ] action.
     * @param evt 
     */
    private void _4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__4ActionPerformed
        calculator.numButton('4');
        updateScreens();
    }//GEN-LAST:event__4ActionPerformed

    /**
     * 5 Button [ 5 ] action.
     * @param evt 
     */
    private void _5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__5ActionPerformed
        calculator.numButton('5');
        updateScreens();
    }//GEN-LAST:event__5ActionPerformed

    /**
     * 6 Button [ 6 ] action.
     * @param evt 
     */
    private void _6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__6ActionPerformed
        calculator.numButton('6');
        updateScreens();
    }//GEN-LAST:event__6ActionPerformed

    /**
     * 7 Button [ 7 ] action.
     * @param evt 
     */
    private void _7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__7ActionPerformed
        calculator.numButton('7');
        updateScreens();
    }//GEN-LAST:event__7ActionPerformed

    /**
     * 8 Button [ 8 ] action.
     * @param evt 
     */
    private void _8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__8ActionPerformed
        calculator.numButton('8');
        updateScreens();
    }//GEN-LAST:event__8ActionPerformed

    /**
     * 9 Button [ 9 ] action.
     * @param evt 
     */
    private void _9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__9ActionPerformed
        calculator.numButton('9');
        updateScreens();
    }//GEN-LAST:event__9ActionPerformed

    /**
     * Negative Button [ - ] action.
     * @param evt 
     */
    private void NegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegActionPerformed
        calculator.negativeButton();
        updateScreens();
    }//GEN-LAST:event_NegActionPerformed

    /**
     * Backspace Button [ <-- ] action.
     * @param evt 
     */
    private void BackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackspaceActionPerformed
        calculator.backSpaceButton();
        updateScreens();
    }//GEN-LAST:event_BackspaceActionPerformed

    /**
     * Reciprocal button [ 1/x ] action.
     * @param evt 
     */
    private void ReciprocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReciprocalActionPerformed
        calculator.reciprocalButton();
        updateScreens();
    }//GEN-LAST:event_ReciprocalActionPerformed

    /**
     * Add button [ + ] action.
     * @param evt 
     */
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        calculator.addButton();
        updateScreens();
    }//GEN-LAST:event_AddActionPerformed

    /**
     * Subtract button [ - ] action.
     * @param evt 
     */
    private void SubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubtractActionPerformed
        calculator.subtractButton();
        updateScreens();
    }//GEN-LAST:event_SubtractActionPerformed

    /**
     * Equals button [ = ] action.
     * @param evt 
     */
    private void EqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EqualsActionPerformed
        calculator.equalsButton();
        updateScreens();
    }//GEN-LAST:event_EqualsActionPerformed

    /**
     * Clear everything button [ C ] action.
     * @param evt 
     */
    private void CEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEActionPerformed
        calculator.clearInputButton();
        updateScreens();
    }//GEN-LAST:event_CEActionPerformed

    /**
     * Square root button [ SQRT ] action.
     * @param evt 
     */
    private void SquareRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SquareRootActionPerformed
        calculator.squareRootButton();
        updateScreens();
    }//GEN-LAST:event_SquareRootActionPerformed

    /**
     * Multiply button [ * ] action.
     * @param evt 
     */
    private void MultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiplyActionPerformed
        calculator.multiplyButton();
        updateScreens();
    }//GEN-LAST:event_MultiplyActionPerformed

    /**
     * Sets IS_OPEN to true when window is opened.
     * @param evt 
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        IS_OPEN = true;
    }//GEN-LAST:event_formWindowOpened

    /**
     * Sets IS_OPEN to false when window is closed.
     * @param evt 
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        IS_OPEN = false;
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Calculator().setVisible(true);               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton Add;
    javax.swing.JButton Backspace;
    javax.swing.JButton C;
    javax.swing.JButton CE;
    javax.swing.JButton Decimal;
    javax.swing.JButton Divide;
    javax.swing.JButton Equals;
    javax.swing.JTextField InputScreen;
    javax.swing.JButton Multiply;
    javax.swing.JButton Neg;
    javax.swing.JTextField OperatorScreen;
    javax.swing.JButton Reciprocal;
    javax.swing.JButton SquareRoot;
    javax.swing.JButton Subtract;
    javax.swing.JButton _0;
    javax.swing.JButton _1;
    javax.swing.JButton _2;
    javax.swing.JButton _3;
    javax.swing.JButton _4;
    javax.swing.JButton _5;
    javax.swing.JButton _6;
    javax.swing.JButton _7;
    javax.swing.JButton _8;
    javax.swing.JButton _9;
    javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
