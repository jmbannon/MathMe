/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package gui;

import class_resources.GetImage;
import database.StudentLogin;
import question_sets.Set_Factors;
import question_sets.Set_Abstract;
import question.Question_Abstract;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import question.Question_CheckBox;
import question.Question_MultipleChoice;
import question.Question_TextBox;
import question.Question_TrueFalse;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Graphical user interface for all tests.
 */
public class GUI_Test extends javax.swing.JFrame {

    private int MIN_QUESTION;
    private int MAX_QUESTION;
    
    private String FULL_NAME;    
    private String TEST_NAME;
    
    private int currentQuestion = 0;
    
    private Set_Abstract questionSet;
    private List<Question_Abstract> testQuestionList;
    
    private GUI_Calculator calculator;
    private GUI_DrawPad drawPad;
    
    
    private GUI_Test() { /* Do nothing. */ }
    
    public GUI_Test(String name, int numOfQuestions) {
        MIN_QUESTION = 0;
        MAX_QUESTION = numOfQuestions;
        FULL_NAME = StudentLogin.getFirstName() + " " 
                + StudentLogin.getLastName();    
        TEST_NAME = name;
        
        fillTest();
        initComponents();
        updateQuestion();
    }
    
    private void fillTest() throws IllegalArgumentException {
        switch(TEST_NAME) {
            case "Factors":
                questionSet = new Set_Factors();        
                testQuestionList = questionSet.getQuestionSet(MAX_QUESTION);
                break;     
            default:
                throw new IllegalArgumentException("Test name is invalid or does not exist");
        }
    }
    
    private void updateQuestion() {
        loadQuestion();
        loadAnswers();
        buttonDisplay();     
    }
    
    private void loadQuestion() {
        QuestionNumber.setText(TEST_NAME + " Test: Question " + (currentQuestion + 1));
        
        if (testQuestionList.get(currentQuestion).getQuestionImageURL() != null 
            && testQuestionList.get(currentQuestion).getQuestionText() == null) {
            jLabel1.setBounds(0, 0, 580, 230);
            jLabel1.setIcon(new javax.swing.ImageIcon(testQuestionList.get(currentQuestion).getQuestionImage()));           
            jLabel1.setText(null);
        }
        
        else if (testQuestionList.get(currentQuestion).getQuestionImageURL() == null 
            && testQuestionList.get(currentQuestion).getQuestionText() != null) {
            jLabel1.setIcon(null);
            jLabel1.setText(testQuestionList.get(currentQuestion).getQuestionText());
        }
        
        else if (testQuestionList.get(currentQuestion).getQuestionImageURL() != null 
            && testQuestionList.get(currentQuestion).getQuestionText() != null) {
            jLabel1.setIcon(null);
            jLabel1.setText("ERROR: QUESTION HAS BOTH TEXT AND IMAGE FOR INDEX " + currentQuestion);          
        }
            
        else {
            jLabel1.setIcon(null);
            jLabel1.setText("ERROR: NO QUESTION HAS BEEN INPUTTED FOR INDEX " + currentQuestion);
        }      
    }
    
    private void loadAnswers() {
        switch (testQuestionList.get(currentQuestion).getQuestionType()) {
            case MULTIPLE_CHOICE:
                loadMultipleChoiceAnswers();
                break;
            case TRUE_FALSE:
                loadTrueFalseAnswers();
                break;
            case TEXT_BOX:
                loadTextFieldAnswers();
                break;
            case CHECK_BOX:
                loadCheckBoxAnswers();
                break;
            default:
                System.err.println("Invalid question type");
                break;
        }
    }
    
    private void buttonDisplay() {
        if (currentQuestion <= MIN_QUESTION) PreviousButton.setVisible(false);
        else PreviousButton.setVisible(true);
        
        if (currentQuestion >= MAX_QUESTION-1) NextButton.setVisible(false);
        else NextButton.setVisible(true);
    }
    
    private void loadMultipleChoiceAnswers() {
        MultipleChoiceQuestionPanel.setVisible(true);
        TextBoxQuestionPanel.setVisible(false);
        CheckBoxQuestionPanel.setVisible(false);
        TrueFalseQuestionPanel.setVisible(false);
        
        MultipleChoiceAnswer1.setVisible(true);
        MultipleChoiceAnswer2.setVisible(true);
        MultipleChoiceAnswer3.setVisible(true);
        MultipleChoiceAnswer4.setVisible(true); 
        
        MultipleChoiceAnswer1.setText(testQuestionList.get(currentQuestion).getAnswer1());
        MultipleChoiceAnswer2.setText(testQuestionList.get(currentQuestion).getAnswer2());
        MultipleChoiceAnswer3.setText(testQuestionList.get(currentQuestion).getAnswer3());
        MultipleChoiceAnswer4.setText(testQuestionList.get(currentQuestion).getAnswer4());
        
        switch (((Question_MultipleChoice)testQuestionList.get(currentQuestion)).getInput()) {
            case 0: MultipleChoiceButtonGroup.clearSelection();
                    break;
            case 1: MultipleChoiceAnswer1.setSelected(true);
                    MultipleChoiceAnswer2.setSelected(false);
                    MultipleChoiceAnswer3.setSelected(false);
                    MultipleChoiceAnswer4.setSelected(false);
                    break;
            case 2: MultipleChoiceAnswer1.setSelected(false);
                    MultipleChoiceAnswer2.setSelected(true);
                    MultipleChoiceAnswer3.setSelected(false);
                    MultipleChoiceAnswer4.setSelected(false);
                    break;
            case 3: MultipleChoiceAnswer1.setSelected(false);
                    MultipleChoiceAnswer2.setSelected(false);
                    MultipleChoiceAnswer3.setSelected(true);
                    MultipleChoiceAnswer4.setSelected(false);
                    break;
            case 4: MultipleChoiceAnswer1.setSelected(false);
                    MultipleChoiceAnswer2.setSelected(false);
                    MultipleChoiceAnswer3.setSelected(false);
                    MultipleChoiceAnswer4.setSelected(true);
                    break;
            default: throw new IllegalArgumentException("Answer Input is invalid");
        }
    }
    
    private void loadTrueFalseAnswers() {
        MultipleChoiceQuestionPanel.setVisible(false);
        TextBoxQuestionPanel.setVisible(false);
        CheckBoxQuestionPanel.setVisible(false);
        TrueFalseQuestionPanel.setVisible(true);
        
        TrueAnswer.setVisible(true);
        FalseAnswer.setVisible(true);
        
        
        switch (((Question_TrueFalse)testQuestionList.get(currentQuestion)).getInput()) {
            case 0: TrueFalseButtonGroup.clearSelection();
                    break;
            case 2: TrueAnswer.setSelected(true);
                    FalseAnswer.setSelected(false);
                    break;
            case 1: TrueAnswer.setSelected(false);
                    FalseAnswer.setSelected(true);
                    break;
            default: throw new IllegalArgumentException("Answer Input is invalid");
        }
    }
    
    private void loadTextFieldAnswers() {
        MultipleChoiceQuestionPanel.setVisible(false);
        TextBoxQuestionPanel.setVisible(true);
        CheckBoxQuestionPanel.setVisible(false);
        TrueFalseQuestionPanel.setVisible(false);
        
        AnswerField.setText(((Question_TextBox)testQuestionList.get(currentQuestion)).getInput());
    }
    
    private void loadCheckBoxAnswers() {
        MultipleChoiceQuestionPanel.setVisible(false);
        TextBoxQuestionPanel.setVisible(false);
        CheckBoxQuestionPanel.setVisible(true);
        TrueFalseQuestionPanel.setVisible(false);
        
        CheckBoxAnswer1.setText(testQuestionList.get(currentQuestion).getAnswer1());
        CheckBoxAnswer2.setText(testQuestionList.get(currentQuestion).getAnswer2());
        CheckBoxAnswer3.setText(testQuestionList.get(currentQuestion).getAnswer3());
        CheckBoxAnswer4.setText(testQuestionList.get(currentQuestion).getAnswer4());
        
        //Checkbox1
        if (((Question_CheckBox)testQuestionList.get(currentQuestion)).getCheckBoxInputOne()) CheckBoxAnswer1.setSelected(true);
        else CheckBoxAnswer1.setSelected(false);
        
        //Checkbox2
        if (((Question_CheckBox)testQuestionList.get(currentQuestion)).getCheckBoxInputTwo()) CheckBoxAnswer2.setSelected(true);
        else CheckBoxAnswer2.setSelected(false);
        
        //Checkbox3
        if (((Question_CheckBox)testQuestionList.get(currentQuestion)).getCheckBoxInputThree()) CheckBoxAnswer3.setSelected(true);
        else CheckBoxAnswer3.setSelected(false);
        
        //Checkbox4
        if (((Question_CheckBox)testQuestionList.get(currentQuestion)).getCheckBoxInputFour()) CheckBoxAnswer4.setSelected(true);
        else CheckBoxAnswer4.setSelected(false);
    }
       
    private void incCurrentQuestion() {
        ++currentQuestion;
    }
    
    private void decCurrentQuestion() {
        --currentQuestion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MultipleChoiceButtonGroup = new javax.swing.ButtonGroup();
        TrueFalseButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        TestNavigationPane = new javax.swing.JPanel();
        NavigatePanel = new javax.swing.JPanel();
        PreviousButtonPanel = new javax.swing.JPanel();
        PreviousButton = new javax.swing.JButton();
        NextButtonPanel = new javax.swing.JPanel();
        NextButton = new javax.swing.JButton();
        SubmitTest = new javax.swing.JButton();
        AnswerPane = new javax.swing.JLayeredPane();
        MultipleChoiceQuestionPanel = new javax.swing.JPanel();
        MultipleChoiceAnswer1 = new javax.swing.JRadioButton();
        MultipleChoiceAnswer2 = new javax.swing.JRadioButton();
        MultipleChoiceAnswer3 = new javax.swing.JRadioButton();
        MultipleChoiceAnswer4 = new javax.swing.JRadioButton();
        TextBoxQuestionPanel = new javax.swing.JPanel();
        AnswerField = new javax.swing.JTextField();
        CheckBoxQuestionPanel = new javax.swing.JPanel();
        CheckBoxAnswer1 = new javax.swing.JCheckBox();
        CheckBoxAnswer2 = new javax.swing.JCheckBox();
        CheckBoxAnswer3 = new javax.swing.JCheckBox();
        CheckBoxAnswer4 = new javax.swing.JCheckBox();
        TrueFalseQuestionPanel = new javax.swing.JPanel();
        TrueAnswer = new javax.swing.JRadioButton();
        FalseAnswer = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        QuestionNumber = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MathMe Test");
        setIconImage(GetImage.returnImage("MATHME_ICON.png"));
        setResizable(false);

        NavigatePanel.setPreferredSize(new java.awt.Dimension(160, 39));
        NavigatePanel.setLayout(new java.awt.GridLayout(1, 2));

        PreviousButtonPanel.setMinimumSize(new java.awt.Dimension(73, 50));
        PreviousButtonPanel.setPreferredSize(new java.awt.Dimension(75, 30));

        PreviousButton.setText("Previous");
        PreviousButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PreviousButtonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PreviousButtonFocusLost(evt);
            }
        });
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PreviousButtonPanelLayout = new javax.swing.GroupLayout(PreviousButtonPanel);
        PreviousButtonPanel.setLayout(PreviousButtonPanelLayout);
        PreviousButtonPanelLayout.setHorizontalGroup(
            PreviousButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PreviousButtonPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(PreviousButton)
                .addContainerGap(2, Short.MAX_VALUE))
        );
        PreviousButtonPanelLayout.setVerticalGroup(
            PreviousButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PreviousButtonPanelLayout.createSequentialGroup()
                .addComponent(PreviousButton)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        NavigatePanel.add(PreviousButtonPanel);

        NextButtonPanel.setPreferredSize(new java.awt.Dimension(80, 30));

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NextButtonPanelLayout = new javax.swing.GroupLayout(NextButtonPanel);
        NextButtonPanel.setLayout(NextButtonPanelLayout);
        NextButtonPanelLayout.setHorizontalGroup(
            NextButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NextButtonPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NextButtonPanelLayout.setVerticalGroup(
            NextButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NextButtonPanelLayout.createSequentialGroup()
                .addComponent(NextButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        NavigatePanel.add(NextButtonPanel);

        SubmitTest.setText("Submit");
        SubmitTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TestNavigationPaneLayout = new javax.swing.GroupLayout(TestNavigationPane);
        TestNavigationPane.setLayout(TestNavigationPaneLayout);
        TestNavigationPaneLayout.setHorizontalGroup(
            TestNavigationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TestNavigationPaneLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(NavigatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(SubmitTest, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        TestNavigationPaneLayout.setVerticalGroup(
            TestNavigationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TestNavigationPaneLayout.createSequentialGroup()
                .addComponent(SubmitTest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TestNavigationPaneLayout.createSequentialGroup()
                .addComponent(NavigatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        AnswerPane.setLayout(new java.awt.CardLayout());

        MultipleChoiceQuestionPanel.setLayout(new java.awt.GridLayout(2, 2));

        MultipleChoiceButtonGroup.add(MultipleChoiceAnswer1);
        MultipleChoiceAnswer1.setText(testQuestionList.get(currentQuestion).getAnswer1());
        MultipleChoiceAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultipleChoiceAnswer1ActionPerformed(evt);
            }
        });
        MultipleChoiceQuestionPanel.add(MultipleChoiceAnswer1);

        MultipleChoiceButtonGroup.add(MultipleChoiceAnswer2);
        MultipleChoiceAnswer2.setText(testQuestionList.get(currentQuestion).getAnswer2());
        MultipleChoiceAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultipleChoiceAnswer2ActionPerformed(evt);
            }
        });
        MultipleChoiceQuestionPanel.add(MultipleChoiceAnswer2);

        MultipleChoiceButtonGroup.add(MultipleChoiceAnswer3);
        MultipleChoiceAnswer3.setText(testQuestionList.get(currentQuestion).getAnswer3());
        MultipleChoiceAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultipleChoiceAnswer3ActionPerformed(evt);
            }
        });
        MultipleChoiceQuestionPanel.add(MultipleChoiceAnswer3);

        MultipleChoiceButtonGroup.add(MultipleChoiceAnswer4);
        MultipleChoiceAnswer4.setText(testQuestionList.get(currentQuestion).getAnswer4());
        MultipleChoiceAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultipleChoiceAnswer4ActionPerformed(evt);
            }
        });
        MultipleChoiceQuestionPanel.add(MultipleChoiceAnswer4);

        AnswerPane.add(MultipleChoiceQuestionPanel, "card1");

        AnswerField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AnswerFieldFocusLost(evt);
            }
        });
        AnswerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnswerFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TextBoxQuestionPanelLayout = new javax.swing.GroupLayout(TextBoxQuestionPanel);
        TextBoxQuestionPanel.setLayout(TextBoxQuestionPanelLayout);
        TextBoxQuestionPanelLayout.setHorizontalGroup(
            TextBoxQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextBoxQuestionPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(AnswerField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        TextBoxQuestionPanelLayout.setVerticalGroup(
            TextBoxQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextBoxQuestionPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(AnswerField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AnswerPane.add(TextBoxQuestionPanel, "card2");

        CheckBoxQuestionPanel.setLayout(new java.awt.GridLayout(2, 2));

        CheckBoxAnswer1.setText(testQuestionList.get(currentQuestion).getAnswer1());
        CheckBoxAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxAnswer1ActionPerformed(evt);
            }
        });
        CheckBoxQuestionPanel.add(CheckBoxAnswer1);

        CheckBoxAnswer2.setText(testQuestionList.get(currentQuestion).getAnswer2());
        CheckBoxAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxAnswer2ActionPerformed(evt);
            }
        });
        CheckBoxQuestionPanel.add(CheckBoxAnswer2);

        CheckBoxAnswer3.setText(testQuestionList.get(currentQuestion).getAnswer3());
        CheckBoxAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxAnswer3ActionPerformed(evt);
            }
        });
        CheckBoxQuestionPanel.add(CheckBoxAnswer3);

        CheckBoxAnswer4.setText(testQuestionList.get(currentQuestion).getAnswer4());
        CheckBoxAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxAnswer4ActionPerformed(evt);
            }
        });
        CheckBoxQuestionPanel.add(CheckBoxAnswer4);

        AnswerPane.add(CheckBoxQuestionPanel, "card4");

        TrueFalseQuestionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        TrueFalseButtonGroup.add(TrueAnswer);
        TrueAnswer.setText("True");
        TrueAnswer.setPreferredSize(new java.awt.Dimension(559, 23));
        TrueAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrueAnswerActionPerformed(evt);
            }
        });
        TrueFalseQuestionPanel.add(TrueAnswer);

        TrueFalseButtonGroup.add(FalseAnswer);
        FalseAnswer.setText("False");
        FalseAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FalseAnswerActionPerformed(evt);
            }
        });
        TrueFalseQuestionPanel.add(FalseAnswer);

        AnswerPane.add(TrueFalseQuestionPanel, "card5");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(null);
        jLabel1.setText(null);
        jLabel1.setMaximumSize(new java.awt.Dimension(580, 230));
        jLabel1.setPreferredSize(new java.awt.Dimension(580, 230));
        jLabel1.setOpaque(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        jLabel1.setBorder(border);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        QuestionNumber.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        QuestionNumber.setText(TEST_NAME + " Test: Question " + (currentQuestion + 1));
        QuestionNumber.setPreferredSize(new java.awt.Dimension(300, 22));
        jPanel2.add(QuestionNumber);

        NameLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameLabel.setText(FULL_NAME);
        NameLabel.setPreferredSize(new java.awt.Dimension(80, 22));
        jPanel2.add(NameLabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnswerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TestNavigationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(AnswerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TestNavigationPane, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        File.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Save Session");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        File.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Exit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        File.add(jMenuItem5);

        jMenuBar1.add(File);

        jMenu1.setText("Edit");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Reset Answers");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tools");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Calculator");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Draw Pad");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitTestActionPerformed
        updateQuestion();
        int choice;
        
        if (questionSet.hasUnsubmittedQuestions()) {
            choice = JOptionPane.showConfirmDialog(this, "Test has unanswered questions.\nSubmit anyways?");
        }
        else {
            choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit?");
        }
        
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "You got " 
                + questionSet.getQuestionsCorrect() + " questions correct."
                    + "\nPercentage: " + questionSet.getGradePercentage());
            this.dispose();
        }
        
    }//GEN-LAST:event_SubmitTestActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        if (currentQuestion > MIN_QUESTION) {
            decCurrentQuestion();
            updateQuestion();
        }
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void PreviousButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PreviousButtonFocusGained
        //if (currentQuestion > 0) PreviousButton.setVisible(true);
    }//GEN-LAST:event_PreviousButtonFocusGained

    private void PreviousButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PreviousButtonFocusLost
        //if (currentQuestion <= 0) PreviousButton.setVisible(false);
    }//GEN-LAST:event_PreviousButtonFocusLost

    private void MultipleChoiceAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultipleChoiceAnswer3ActionPerformed
        ((Question_MultipleChoice)testQuestionList.get(currentQuestion)).setInput(3);
    }//GEN-LAST:event_MultipleChoiceAnswer3ActionPerformed

    private void MultipleChoiceAnswer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultipleChoiceAnswer4ActionPerformed
        ((Question_MultipleChoice)testQuestionList.get(currentQuestion)).setInput(4);
    }//GEN-LAST:event_MultipleChoiceAnswer4ActionPerformed

    private void MultipleChoiceAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultipleChoiceAnswer2ActionPerformed
        ((Question_MultipleChoice)testQuestionList.get(currentQuestion)).setInput(2);
    }//GEN-LAST:event_MultipleChoiceAnswer2ActionPerformed

    private void MultipleChoiceAnswer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultipleChoiceAnswer1ActionPerformed
        ((Question_MultipleChoice)testQuestionList.get(currentQuestion)).setInput(1);
    }//GEN-LAST:event_MultipleChoiceAnswer1ActionPerformed

    private void AnswerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnswerFieldActionPerformed
        ((Question_TextBox)testQuestionList.get(currentQuestion)).setInput(AnswerField.getText());
    }//GEN-LAST:event_AnswerFieldActionPerformed

    private void CheckBoxAnswer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxAnswer1ActionPerformed
        if (CheckBoxAnswer1.isSelected()) ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputOne(true);
        else ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputOne(false);
    }//GEN-LAST:event_CheckBoxAnswer1ActionPerformed

    private void CheckBoxAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxAnswer2ActionPerformed
        if (CheckBoxAnswer2.isSelected()) ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputTwo(true);
        else ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputTwo(false);
    }//GEN-LAST:event_CheckBoxAnswer2ActionPerformed

    private void CheckBoxAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxAnswer3ActionPerformed
        if (CheckBoxAnswer3.isSelected()) ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputThree(true);
        else ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputThree(false);
    }//GEN-LAST:event_CheckBoxAnswer3ActionPerformed

    private void CheckBoxAnswer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxAnswer4ActionPerformed
        if (CheckBoxAnswer4.isSelected()) ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputFour(true);
        else ((Question_CheckBox)testQuestionList.get(currentQuestion)).setCheckBoxInputFour(false);
    }//GEN-LAST:event_CheckBoxAnswer4ActionPerformed

    private void AnswerFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AnswerFieldFocusLost
        ((Question_TextBox)testQuestionList.get(currentQuestion)).setInput(AnswerField.getText());             
    }//GEN-LAST:event_AnswerFieldFocusLost

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (GUI_Calculator.isOpen()) {
            JOptionPane.showMessageDialog(this, "A Calculator instance is already open");
        } else {
        calculator = new GUI_Calculator();
        calculator.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (GUI_DrawPad.isOpen()) {
            JOptionPane.showMessageDialog(this, "A Draw Pad instance is already open");
        } else {
        drawPad = new GUI_DrawPad();
        drawPad.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        if (currentQuestion < MAX_QUESTION) {
            incCurrentQuestion();
            updateQuestion();
        }
    }//GEN-LAST:event_NextButtonActionPerformed

    private void TrueAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrueAnswerActionPerformed
        ((Question_TrueFalse)testQuestionList.get(currentQuestion)).setInput(true);
    }//GEN-LAST:event_TrueAnswerActionPerformed

    private void FalseAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FalseAnswerActionPerformed
        ((Question_TrueFalse)testQuestionList.get(currentQuestion)).setInput(false);
    }//GEN-LAST:event_FalseAnswerActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        for (Question_Abstract question : testQuestionList)
            question.clearInput();
        loadAnswers();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                
                new GUI_Test().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnswerField;
    private javax.swing.JLayeredPane AnswerPane;
    private javax.swing.JCheckBox CheckBoxAnswer1;
    private javax.swing.JCheckBox CheckBoxAnswer2;
    private javax.swing.JCheckBox CheckBoxAnswer3;
    private javax.swing.JCheckBox CheckBoxAnswer4;
    private javax.swing.JPanel CheckBoxQuestionPanel;
    private javax.swing.JRadioButton FalseAnswer;
    private javax.swing.JMenu File;
    private javax.swing.JRadioButton MultipleChoiceAnswer1;
    private javax.swing.JRadioButton MultipleChoiceAnswer2;
    private javax.swing.JRadioButton MultipleChoiceAnswer3;
    private javax.swing.JRadioButton MultipleChoiceAnswer4;
    private javax.swing.ButtonGroup MultipleChoiceButtonGroup;
    private javax.swing.JPanel MultipleChoiceQuestionPanel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JPanel NavigatePanel;
    private javax.swing.JButton NextButton;
    private javax.swing.JPanel NextButtonPanel;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JPanel PreviousButtonPanel;
    private javax.swing.JLabel QuestionNumber;
    private javax.swing.JButton SubmitTest;
    private javax.swing.JPanel TestNavigationPane;
    private javax.swing.JPanel TextBoxQuestionPanel;
    private javax.swing.JRadioButton TrueAnswer;
    private javax.swing.ButtonGroup TrueFalseButtonGroup;
    private javax.swing.JPanel TrueFalseQuestionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
