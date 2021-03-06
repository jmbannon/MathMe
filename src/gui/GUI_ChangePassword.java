/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package gui;

import class_resources.GetImage;
import database.StudentRegister;
import database.ChangeStudentPassword;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * JOptionPane for changing the user's password.
 */
public class GUI_ChangePassword extends javax.swing.JDialog {

    /** Status of GUI_ChangePassword if it is open or not. */
    private static boolean IS_OPEN = false;
    
    private final StudentRegister studentRegister;
    private final ChangeStudentPassword changeStudentPassword;
    
    /**
     * Creates a custom JOptionPane to change a user's password.
     * 
     * @param parent Frame for JOptionpane to display in.
     * @param modal 
     */
    public GUI_ChangePassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        studentRegister = new StudentRegister();
        changeStudentPassword = new ChangeStudentPassword();
    }
    
    /**
     * @return if an instance of GUI_ChangePassword is open or not.
     */
    public static boolean isOpen() {
        return IS_OPEN;
    }
    
    /**
     * Exits the GUI by setting status boolean to false and disposing of window.
     */
    private void exit() {
        IS_OPEN = false;
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChangePasswordTitle = new javax.swing.JLabel();
        CurrentPasswordLabel = new javax.swing.JLabel();
        CurrentPasswordTextField = new javax.swing.JPasswordField();
        NewPasswordLabel = new javax.swing.JLabel();
        NewPasswordTextField = new javax.swing.JPasswordField();
        VerifyNewPasswordLabel = new javax.swing.JLabel();
        VerifyNewPasswordTextField = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        ChangePasswordButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(GetImage.returnImage("MATHME_ICON.png"));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        ChangePasswordTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ChangePasswordTitle.setText("Change Password");

        CurrentPasswordLabel.setText("Current password:");

        NewPasswordLabel.setText("New password:");

        VerifyNewPasswordLabel.setText("Verify new password:");

        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        ChangePasswordButton.setText("Change");
        ChangePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ChangePasswordButton);

        CancelButton.setText("Cancel");
        CancelButton.setPreferredSize(new java.awt.Dimension(69, 23));
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ChangePasswordTitle)
                    .addComponent(CurrentPasswordLabel)
                    .addComponent(NewPasswordLabel)
                    .addComponent(VerifyNewPasswordLabel)
                    .addComponent(NewPasswordTextField)
                    .addComponent(CurrentPasswordTextField)
                    .addComponent(VerifyNewPasswordTextField)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChangePasswordTitle)
                .addGap(18, 18, 18)
                .addComponent(CurrentPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CurrentPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NewPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VerifyNewPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerifyNewPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change Password button action. Attempts to change the user's password by
     * verifying original password and verifying syntax of the new password.
     * 
     * @param evt 
     */
    private void ChangePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordButtonActionPerformed
        try {
            final int passwordVerification = 
                changeStudentPassword.verifyCurrentPassword
                (CurrentPasswordTextField.getText().trim());
            
            switch (passwordVerification) {
                case 1: // Current password is verified
                    break;                    
                    
                case 0: // Current password is incorrect
                    JOptionPane.showMessageDialog(this, "Current password is "
                            + "incorrect. Please re-enter your password.");
                    CurrentPasswordTextField.setText("");
                    return;
                    
                case -1: // Error connecting to the database
                    JOptionPane.showMessageDialog(this, "An error occured "
                            + "connecting to the database. Please consult your "
                            + "administrator.");
                    exit();
                    return;
                    
                default:
                    System.err.println("An error has occured: statusOne "
                            + "contains an invalid integer.");
                    exit();
                    return;
            }
            
            studentRegister.setPassword(NewPasswordTextField.getText().trim());
            studentRegister.setVerifyPassword(VerifyNewPasswordTextField.getText().trim());
            
            // If new password and verification password match and have correct syntax
            if (studentRegister.verifyPasswords(this)) { 
                
                // Password was successfully changed in the database
                if (changeStudentPassword.changePassword
                    (VerifyNewPasswordTextField.getText().trim()) == 1) {
                    
                    JOptionPane.showMessageDialog(this, "Your password has been changed successfully.");
                    exit();
                }
                
                // Could not connect to the database
                else {
                    JOptionPane.showMessageDialog(this, "An error occured connecting to the database. Please consult your administrator.");
                    exit();
                }                        
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(GUI_ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ChangePasswordButtonActionPerformed

    /**
     * Exit button action. Exits the window.
     * @param evt 
     */
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        exit();
    }//GEN-LAST:event_CancelButtonActionPerformed

    /**
     * Sets IS_OPEN to true when the window is opened.
     * @param evt 
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        IS_OPEN = true;
    }//GEN-LAST:event_formWindowOpened

    /**
     * Sets IS_OPEN to false when the window is closed.
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
            java.util.logging.Logger.getLogger(GUI_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI_ChangePassword dialog = new GUI_ChangePassword(new javax.swing.JFrame(), true);               
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ChangePasswordButton;
    private javax.swing.JLabel ChangePasswordTitle;
    private javax.swing.JLabel CurrentPasswordLabel;
    private javax.swing.JPasswordField CurrentPasswordTextField;
    private javax.swing.JLabel NewPasswordLabel;
    private javax.swing.JPasswordField NewPasswordTextField;
    private javax.swing.JLabel VerifyNewPasswordLabel;
    private javax.swing.JPasswordField VerifyNewPasswordTextField;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
