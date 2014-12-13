/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package gui;

import class_resources.GetImage;
import class_resources.GetOS;
import database.StudentLogin;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import class_resources.TestSelection;
import database.StudentRegister;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import class_resources.PlaySound;
import class_resources.RunExe;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Jesse Bannon
 * @version 1.6
 * 
 * Graphical User Interface for MathMe.
 */
public class GUI_Main extends javax.swing.JFrame {
    
    /* Font of title screen. */
    private Font mathFont;
    
    /* Integers to keep track of jComboBox selected items. */
    private int seriesComboBoxIndex = 0;
    private int subjectComboBoxIndex = 0;
    private int questionsComboBoxSelection = 0;
    
    /* Variables to keep track of cards and to navigate forward and backwards. */
    private CardLayout cardLayout;
    private final Stack<String> cardStackBack = new Stack<>();  
    private final Stack<String> cardStackForward = new Stack<>();  
    private String currentCard = "card3";
    
    /* Screen to display test. */
    private GUI_Test screenList;
    
    /* Tools declared. */
    private GUI_FlashMath flashMath;
    private GUI_Calculator calculator;
    private GUI_DrawPad drawPad;
    
    /* Edit tools declared */
    private GUI_ChangePassword changePassword;
    
    private StudentRegister r1;
    private StudentLogin s1;
       
    
    /**
     * Creates new form MainScreen and initializes components and variables.
     */
    public GUI_Main() {
        initPreComponents();
        initComponents();
        initPostComponents();
        System.out.println(GetOS.getOSName());
    }
    
    /**
     * Initializes variables before Components are initialized.
     * 
     * @pre There must be a font of the same name in gui.resources.
     */
    private void initPreComponents() {
        s1 = new StudentLogin();
        
        try { 
            try (InputStream fontStream = getClass().getResourceAsStream("/file_resources/GUI_MathFont.TTF")) {
                mathFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                mathFont = mathFont.deriveFont(Font.PLAIN, 40);
            } 
        } 
        catch(FontFormatException | IOException ex) { 
            System.err.println(ex.getMessage()); 
        }        
    }
    
    /**
     * Initializes variables after Components are initialized.
     * 
     * @pre There must be a panel named MainPanel with card layout.
     */
    private void initPostComponents() {
        cardLayout = (CardLayout)(MainPanel.getLayout());
    }
    
    /**
     * Displays the card provided in parameter in MainPanel and sets currentCard
     * string to that name.
     * 
     * @pre cardNum must match a card that exists in MainPanel.
     * @param cardNum Card string of a particular card in MainPanel.
     */
    private void displayCard(String cardNum) {           
        currentCard = cardNum;
        cardLayout.show(MainPanel, currentCard);
    }
    
    /**
     * Clears the forward card stack and adds current card to back card stack.
     * 
     * @pre Must call before displayCard so currentCard is the card about to be changed
     * to add it to back card stack.
     */    
    private void newCard() {
        if (cardStackBack.isEmpty()) {
            cardStackForward.clear();
            cardStackBack.push(currentCard);
        } else if (!cardStackBack.lastElement().equals(currentCard)) {
            cardStackForward.clear();
            cardStackBack.push(currentCard);       
        }
    }
    
    /**
     * Used to navigate one card back if it exists.
     * 
     * Adds currentCard to forward card stack and pops card stack back and sets it
     * to the currentCard, then displays it.
     */
    private void backCard() {
        if (!cardStackBack.isEmpty()) {
            cardStackForward.push(currentCard);
            currentCard = (String) cardStackBack.pop();
            displayCard(currentCard);
        }
    }
    
    /**
     * Used to navigate one card forward if it exists.
     * 
     * Adds currentCard to back card stack and pops card stack forward and sets it
     * to the currentCard, then displays it.
     */
    private void forwardCard() {
        if (!cardStackForward.isEmpty()) {
            cardStackBack.push((String)currentCard);
            currentCard = (String) cardStackForward.pop();    
            displayCard(currentCard);
        }
    }
    
    /**
     * Returns the subject of a particular series based on selected indexes of
     * their combo boxes.
     * 
     * @post must match a test name (java file) found in \tests
     * 
     * @return the string of the subject.
     */
    private String getSubject() {
        return TestSelection.getSubject(seriesComboBoxIndex, subjectComboBoxIndex);
    }
    
    private void resetAllFields() {
        NewFirstNameField.setText("First Name");
        NewLastNameField.setText("Last Name");
        NewUsernameField.setText("Username");
        NewPasswordField.setEchoChar((char)0);
        NewPasswordField.setText("Password");
        VerifyPasswordField.setEchoChar((char)0);
        VerifyPasswordField.setText("Verify Password");
        MonthComboBox.setSelectedIndex(0);
        DayComboBox.setSelectedIndex(0);
        YearComboBox.setSelectedIndex(0);        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginScreen = new javax.swing.JPanel();
        RegistrationPanel = new javax.swing.JPanel();
        NewUserLabel = new javax.swing.JLabel();
        NewFirstNameField = new javax.swing.JTextField();
        NewLastNameField = new javax.swing.JTextField();
        NewUsernameField = new javax.swing.JTextField();
        NewPasswordField = new javax.swing.JPasswordField();
        VerifyPasswordField = new javax.swing.JPasswordField();
        DateOfBirthLabel = new javax.swing.JLabel();
        MonthComboBox = new javax.swing.JComboBox();
        DayComboBox = new javax.swing.JComboBox();
        YearComboBox = new javax.swing.JComboBox();
        Register = new javax.swing.JButton();
        LoginPanel = new javax.swing.JPanel();
        UsernameLoginField = new javax.swing.JTextField();
        EmailLoginLabel = new javax.swing.JLabel();
        PasswordLoginField = new javax.swing.JPasswordField();
        PasswordLoginLabel = new javax.swing.JLabel();
        MainMenuLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        GifPanel = new javax.swing.JPanel();
        SinCosGif = new javax.swing.JLabel();
        MainMenu = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        TestNewCard = new javax.swing.JPanel();
        BeginTestButton = new javax.swing.JButton();
        TextPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SelectionPanel = new javax.swing.JPanel();
        SeriesLabel = new javax.swing.JLabel();
        SubjectLabel = new javax.swing.JLabel();
        NumOfQLabel = new javax.swing.JLabel();
        SeriesComboBox = new javax.swing.JComboBox();
        SubjectComboBox = new javax.swing.JComboBox<String>();
        NumOfQComboBox = new javax.swing.JComboBox();
        GradesCard = new javax.swing.JPanel();
        GradesScrollPanel = new javax.swing.JScrollPane();
        GradesTable = new javax.swing.JTable();
        TableScrollBar = new javax.swing.JScrollBar();
        AboutAuthorPanel = new javax.swing.JPanel();
        PictureLabel = new javax.swing.JLabel();
        BioLabel = new javax.swing.JLabel();
        FactsLabel = new javax.swing.JLabel();
        ResumeCard = new javax.swing.JPanel();
        ResumeScrollPane = new javax.swing.JScrollPane();
        ResumeIcon = new javax.swing.JLabel();
        PortfolioCard = new javax.swing.JPanel();
        MathMeIconLabel = new javax.swing.JLabel();
        AsteroidsIconLabel = new javax.swing.JLabel();
        ProjectZombieIconLabel = new javax.swing.JLabel();
        MathMeDescLabel = new javax.swing.JLabel();
        AsteroidsDescLabel = new javax.swing.JLabel();
        ProjectZombieDescLabel = new javax.swing.JLabel();
        BottomPanel = new javax.swing.JPanel();
        NavigateButtonPanel = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        ForwardButton = new javax.swing.JButton();
        BottomUsernameTextField = new javax.swing.JTextField();
        BottomFullNameTextField = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewItem = new javax.swing.JMenuItem();
        LogOutItem = new javax.swing.JMenuItem();
        ExitItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        ChangePasswordItem = new javax.swing.JMenuItem();
        ViewMenu = new javax.swing.JMenu();
        ViewGrades = new javax.swing.JMenuItem();
        ToolsMenu = new javax.swing.JMenu();
        CalculatorItem = new javax.swing.JMenuItem();
        DrawPadItem = new javax.swing.JMenuItem();
        GamesMenu = new javax.swing.JMenu();
        PlayFlashMathItem = new javax.swing.JMenuItem();
        PlayAsteroidsItem = new javax.swing.JMenuItem();
        AboutMenu = new javax.swing.JMenu();
        AboutAuthorItem = new javax.swing.JMenuItem();
        ResumeItem = new javax.swing.JMenuItem();
        PortfolioItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MathMe");
        setIconImage(GetImage.returnImage("MATHME_ICON.png"));
        getContentPane().setLayout(new java.awt.CardLayout());

        RegistrationPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        NewUserLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NewUserLabel.setText("New student? Sign up it's free!");
        NewUserLabel.setPreferredSize(new java.awt.Dimension(270, 20));
        RegistrationPanel.add(NewUserLabel);

        NewFirstNameField.setText("First Name");
        NewFirstNameField.setPreferredSize(new java.awt.Dimension(135, 30));
        NewFirstNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NewFirstNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewFirstNameFieldFocusLost(evt);
            }
        });
        NewFirstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NewFirstNameFieldKeyPressed(evt);
            }
        });
        RegistrationPanel.add(NewFirstNameField);

        NewLastNameField.setText("Last Name");
        NewLastNameField.setPreferredSize(new java.awt.Dimension(135, 30));
        NewLastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NewLastNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewLastNameFieldFocusLost(evt);
            }
        });
        NewLastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NewLastNameFieldKeyPressed(evt);
            }
        });
        RegistrationPanel.add(NewLastNameField);

        NewUsernameField.setText("Username");
        NewUsernameField.setPreferredSize(new java.awt.Dimension(275, 30));
        NewUsernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NewUsernameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewUsernameFieldFocusLost(evt);
            }
        });
        NewUsernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NewUsernameFieldKeyPressed(evt);
            }
        });
        RegistrationPanel.add(NewUsernameField);

        NewPasswordField.setText("Password");
        NewPasswordField.setEchoChar((char)0);
        NewPasswordField.setPreferredSize(new java.awt.Dimension(275, 30));
        NewPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NewPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewPasswordFieldFocusLost(evt);
            }
        });
        NewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NewPasswordFieldKeyPressed(evt);
            }
        });
        RegistrationPanel.add(NewPasswordField);

        VerifyPasswordField.setText("Verify Password");
        VerifyPasswordField.setEchoChar((char)0);
        VerifyPasswordField.setPreferredSize(new java.awt.Dimension(275, 30));
        VerifyPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                VerifyPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                VerifyPasswordFieldFocusLost(evt);
            }
        });
        VerifyPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerifyPasswordFieldKeyPressed(evt);
            }
        });
        RegistrationPanel.add(VerifyPasswordField);

        DateOfBirthLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DateOfBirthLabel.setText("Date of Birth");
        DateOfBirthLabel.setPreferredSize(new java.awt.Dimension(270, 14));
        RegistrationPanel.add(DateOfBirthLabel);

        MonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        MonthComboBox.setPreferredSize(new java.awt.Dimension(88, 30));
        MonthComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MonthComboBoxKeyPressed(evt);
            }
        });
        RegistrationPanel.add(MonthComboBox);

        DayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        DayComboBox.setPreferredSize(new java.awt.Dimension(88, 30));
        DayComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DayComboBoxKeyPressed(evt);
            }
        });
        RegistrationPanel.add(DayComboBox);

        YearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914" }));
        YearComboBox.setMinimumSize(new java.awt.Dimension(88, 30));
        YearComboBox.setPreferredSize(new java.awt.Dimension(88, 30));
        YearComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                YearComboBoxKeyPressed(evt);
            }
        });
        RegistrationPanel.add(YearComboBox);

        Register.setText("Register");
        Register.setPreferredSize(new java.awt.Dimension(150, 34));
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        Register.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RegisterKeyPressed(evt);
            }
        });
        RegistrationPanel.add(Register);

        UsernameLoginField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UsernameLoginFieldKeyPressed(evt);
            }
        });

        EmailLoginLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EmailLoginLabel.setText("Username");

        PasswordLoginField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordLoginFieldKeyPressed(evt);
            }
        });

        PasswordLoginLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PasswordLoginLabel.setText("Password");

        MainMenuLabel.setFont(mathFont);
        MainMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainMenuLabel.setText("MathMe");

        LoginButton.setText("Log In");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addComponent(EmailLoginLabel)
                        .addGap(199, 199, 199)
                        .addComponent(PasswordLoginLabel))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addComponent(UsernameLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PasswordLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addComponent(MainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmailLoginLabel)
                    .addComponent(PasswordLoginLabel))
                .addGap(3, 3, 3)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SinCosGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file_resources/GUI_SinCos.gif")));

        javax.swing.GroupLayout GifPanelLayout = new javax.swing.GroupLayout(GifPanel);
        GifPanel.setLayout(GifPanelLayout);
        GifPanelLayout.setHorizontalGroup(
            GifPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GifPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(SinCosGif, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        GifPanelLayout.setVerticalGroup(
            GifPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GifPanelLayout.createSequentialGroup()
                .addComponent(SinCosGif, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LoginScreenLayout = new javax.swing.GroupLayout(LoginScreen);
        LoginScreen.setLayout(LoginScreenLayout);
        LoginScreenLayout.setHorizontalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(RegistrationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(GifPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LoginScreenLayout.setVerticalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(RegistrationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(GifPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(LoginScreen, "card2");

        MainMenu.setLayout(new java.awt.BorderLayout());

        MainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MainPanel.setLayout(new java.awt.CardLayout());

        BeginTestButton.setText("Begin Test");
        BeginTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeginTestButtonActionPerformed(evt);
            }
        });

        TextPanel.setLayout(new java.awt.GridLayout(4, 1, 5, 10));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Note:");
        TextPanel.add(jLabel1);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Tests are timed based on the series, subject, and number of questions. There");
        TextPanel.add(jLabel5);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("are tools provided on the test screen such as a calculator to assist you. Please");
        TextPanel.add(jLabel4);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("speak to your instructor for further questions regarding the test.");
        TextPanel.add(jLabel6);

        SelectionPanel.setLayout(new java.awt.GridLayout(2, 3, 40, 0));

        SeriesLabel.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        SeriesLabel.setText("Series");
        SelectionPanel.add(SeriesLabel);

        SubjectLabel.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        SubjectLabel.setText("Subject");
        SelectionPanel.add(SubjectLabel);

        NumOfQLabel.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        NumOfQLabel.setText("Number of Questions");
        SelectionPanel.add(NumOfQLabel);

        SeriesComboBox.setModel(new javax.swing.DefaultComboBoxModel(TestSelection.getSeries()));
        SeriesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeriesComboBoxActionPerformed(evt);
            }
        });
        SelectionPanel.add(SeriesComboBox);

        SubjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(TestSelection.getSubjects(seriesComboBoxIndex)));
        SubjectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectComboBoxActionPerformed(evt);
            }
        });
        SelectionPanel.add(SubjectComboBox);

        NumOfQComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select # of Questions...", "5", "10" }));
        NumOfQComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumOfQComboBoxActionPerformed(evt);
            }
        });
        SelectionPanel.add(NumOfQComboBox);

        javax.swing.GroupLayout TestNewCardLayout = new javax.swing.GroupLayout(TestNewCard);
        TestNewCard.setLayout(TestNewCardLayout);
        TestNewCardLayout.setHorizontalGroup(
            TestNewCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TestNewCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TestNewCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TestNewCardLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(TextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TestNewCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BeginTestButton)
                .addGap(253, 253, 253))
        );
        TestNewCardLayout.setVerticalGroup(
            TestNewCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TestNewCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(TextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(SelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(BeginTestButton)
                .addGap(25, 25, 25))
        );

        MainPanel.add(TestNewCard, "card3");

        GradesScrollPanel.setVerticalScrollBar(TableScrollBar);

        GradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"WORK IN PROGRESS", null, null, null},
                {"WORK IN PROGRESS", null, null, null},
                {"WORK IN PROGRESS", null, null, null},
                {"Elementary", null, null, null},
                {"Elementary", null, null, null},
                {"Elementary", null, null, null},
                {"Elementary", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Series", "Subject", "Correct", "Percentage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GradesScrollPanel.setViewportView(GradesTable);

        javax.swing.GroupLayout GradesCardLayout = new javax.swing.GroupLayout(GradesCard);
        GradesCard.setLayout(GradesCardLayout);
        GradesCardLayout.setHorizontalGroup(
            GradesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GradesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GradesScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        GradesCardLayout.setVerticalGroup(
            GradesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GradesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GradesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GradesScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(TableScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        MainPanel.add(GradesCard, "card4");

        PictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file_resources/GUI_Author.jpg"))); // NOI18N

        BioLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BioLabel.setText("<html><p>Thank you for using my program!  My name is Jesse Bannon, I was born and raised in Washington just a ferry ride away from Seattle.  I have been coding for about a year and plan on continuing for the rest of my life.  I am attending University of Washington Tacoma majoring in Computer Science and Systems and minoring in Mathematics. </p> <br> <p>I made this program not only because it was my project for TCSS 305 (Fall quarter), but because of my long profound love for mathematics.  Before transferring to UW Tacoma, I attended University of Alaska Fairbanks majoring in Mathematics.  I had originally wanted to teach math at the college level.  It was not until the summer of 2013 when I took my first programming course.  Since then I have realized my place in life is a programmer; there's so much math and logic embedded in programming!  </p> <br> <p>I aspire to program for a firm that makes an significant impact in the realm of science.  I want to use my mathematical skills to help contribute to a vast project that awes its users everytime they click on its shortcut.</p><br><p>Thanks for reading!<p/><html>");
        BioLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FactsLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        FactsLabel.setText("<html><body><table cellpadding=\"1\"><tr><td><b>Name:</b></td><td>Jesse Bannon</td></tr>  <tr><td><b>Birthday:</b></td><td>March 17th, 1994</td></tr>  <tr><td><b>Hobbies:</b></td><td>Playing guitar,</td></tr>   <tr><td></td><td>long boarding,</td></tr>    <tr><td></td><td>archery,</td></tr>     <tr><td></td><td>cooking</td></tr>   <tr><td><b>Music:</b></td><td>Pink Floyd,</td></tr>  <tr><td></td><td>Pearl Jam</td></tr>  <tr><td><b>Games:</b></td><td>Counter Strike,</td></tr>   <tr><td></td><td>Age of Empires II</td></tr>  <tr><td></td><td>Super Smash Bros</td></tr> </table></body></html>");
        FactsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout AboutAuthorPanelLayout = new javax.swing.GroupLayout(AboutAuthorPanel);
        AboutAuthorPanel.setLayout(AboutAuthorPanelLayout);
        AboutAuthorPanelLayout.setHorizontalGroup(
            AboutAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutAuthorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AboutAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FactsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
        AboutAuthorPanelLayout.setVerticalGroup(
            AboutAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutAuthorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AboutAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(AboutAuthorPanelLayout.createSequentialGroup()
                        .addComponent(PictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FactsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                .addContainerGap())
        );

        MainPanel.add(AboutAuthorPanel, "card7");

        ResumeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file_resources/GUI_Resume.jpg"))); // NOI18N
        ResumeScrollPane.setViewportView(ResumeIcon);

        javax.swing.GroupLayout ResumeCardLayout = new javax.swing.GroupLayout(ResumeCard);
        ResumeCard.setLayout(ResumeCardLayout);
        ResumeCardLayout.setHorizontalGroup(
            ResumeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ResumeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );
        ResumeCardLayout.setVerticalGroup(
            ResumeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ResumeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        MainPanel.add(ResumeCard, "card8");

        MathMeIconLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        MathMeIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MathMeIconLabel.setIcon(new ImageIcon(GetImage.returnImage("MATHME_ICON.png").getScaledInstance(110, 110, Image.SCALE_SMOOTH))
        );

        AsteroidsIconLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AsteroidsIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AsteroidsIconLabel.setText("<html><center>ASTEROIDS<br>REDUX<br><font size=-1>(icon coming soon)</font></center><html>");

        ProjectZombieIconLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ProjectZombieIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProjectZombieIconLabel.setText("<html><center>PROJECT<br>ZOMBIE<br><font size=-1>(icon coming soon)</font></center><html>");

        MathMeDescLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MathMeDescLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MathMeDescLabel.setText("<html><p>MathMe is my most complete program thus far. It uses many features commonly used in industry such as MySQL, JUnit, FileIO, and other important assets.</p><br><p>I hope to continually improve this program to learn more skills and eventually release to the public</p></html>");

        AsteroidsDescLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AsteroidsDescLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AsteroidsDescLabel.setText("<html><p>This redux version of Asteroids was programmed in C++ during my Spring Semester at University of Alaska Fairbanks. At the time we were taught GIT to be able to share code amongst our groups.</p><br><p>After many long nights of pair programming, we created a finished remake of Asteroids with elastic collision. You can play it within the Games menu.</p></html>");
        AsteroidsDescLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        ProjectZombieDescLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ProjectZombieDescLabel.setText("<html>\n<p>Despite not producing any actual code for this, I created a network of Minecraft servers that have served over 30,000 unique players.  Many YAML config files game logic were used to create a fun environment for players.</p>\n<br>\n<p>I started all of this when I was 16 years old.  It essentially ignited my interest for computer science.  You can find more info at www.projectzombie.net</p>\n</html>");

        javax.swing.GroupLayout PortfolioCardLayout = new javax.swing.GroupLayout(PortfolioCard);
        PortfolioCard.setLayout(PortfolioCardLayout);
        PortfolioCardLayout.setHorizontalGroup(
            PortfolioCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortfolioCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PortfolioCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AsteroidsIconLabel)
                    .addComponent(ProjectZombieIconLabel)
                    .addComponent(MathMeIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PortfolioCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MathMeDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(AsteroidsDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ProjectZombieDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        PortfolioCardLayout.setVerticalGroup(
            PortfolioCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortfolioCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PortfolioCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MathMeDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(MathMeIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PortfolioCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AsteroidsDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(AsteroidsIconLabel))
                .addGap(18, 18, 18)
                .addGroup(PortfolioCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProjectZombieIconLabel)
                    .addComponent(ProjectZombieDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        MathMeIconLabel.getAccessibleContext().setAccessibleName("<html><center>MATH<br>ME</center></html>");

        MainPanel.add(PortfolioCard, "card9");

        MainMenu.add(MainPanel, java.awt.BorderLayout.CENTER);

        BottomPanel.setPreferredSize(new java.awt.Dimension(600, 24));
        BottomPanel.setLayout(new java.awt.GridLayout(1, 0));

        NavigateButtonPanel.setLayout(new java.awt.GridLayout(1, 0));

        BackButton.setText("Back");
        BackButton.setPreferredSize(new java.awt.Dimension(100, 24));
        BackButton.setMnemonic(KeyEvent.VK_LEFT);
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        NavigateButtonPanel.add(BackButton);

        ForwardButton.setText("Forward");
        ForwardButton.setPreferredSize(new java.awt.Dimension(100, 24));
        ForwardButton.setMnemonic(KeyEvent.VK_RIGHT);
        ForwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForwardButtonActionPerformed(evt);
            }
        });
        NavigateButtonPanel.add(ForwardButton);

        BottomPanel.add(NavigateButtonPanel);

        BottomUsernameTextField.setEditable(false);
        BottomUsernameTextField.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        BottomUsernameTextField.setFocusable(false);
        BottomUsernameTextField.setPreferredSize(new java.awt.Dimension(200, 24));
        BottomPanel.add(BottomUsernameTextField);

        BottomFullNameTextField.setEditable(false);
        BottomFullNameTextField.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        BottomFullNameTextField.setFocusable(false);
        BottomFullNameTextField.setPreferredSize(new java.awt.Dimension(200, 24));
        BottomPanel.add(BottomFullNameTextField);

        MainMenu.add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(MainMenu, "card3");

        MenuBar.setVisible(false);

        FileMenu.setText("File");
        FileMenu.setMnemonic(KeyEvent.VK_F);

        NewItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        NewItem.setText("New");
        NewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewItemActionPerformed(evt);
            }
        });
        FileMenu.add(NewItem);

        LogOutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        LogOutItem.setText("Log Out");
        LogOutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutItemActionPerformed(evt);
            }
        });
        FileMenu.add(LogOutItem);

        ExitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        ExitItem.setText("Exit");
        ExitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitItem);

        MenuBar.add(FileMenu);

        EditMenu.setText("Edit");
        EditMenu.setMnemonic(KeyEvent.VK_E);

        ChangePasswordItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        ChangePasswordItem.setText("Change Password");
        ChangePasswordItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordItemActionPerformed(evt);
            }
        });
        EditMenu.add(ChangePasswordItem);

        MenuBar.add(EditMenu);

        ViewMenu.setText("View");
        ViewMenu.setMnemonic(KeyEvent.VK_V);

        ViewGrades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        ViewGrades.setText("Grades");
        ViewGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewGradesActionPerformed(evt);
            }
        });
        ViewMenu.add(ViewGrades);

        MenuBar.add(ViewMenu);

        ToolsMenu.setText("Tools");
        ToolsMenu.setMnemonic(KeyEvent.VK_O);

        CalculatorItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        CalculatorItem.setText("Calculator");
        CalculatorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculatorItemActionPerformed(evt);
            }
        });
        ToolsMenu.add(CalculatorItem);

        DrawPadItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        DrawPadItem.setText("Draw Pad");
        DrawPadItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawPadItemActionPerformed(evt);
            }
        });
        ToolsMenu.add(DrawPadItem);

        MenuBar.add(ToolsMenu);

        GamesMenu.setText("Games");
        GamesMenu.setMnemonic(KeyEvent.VK_G);

        PlayFlashMathItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        PlayFlashMathItem.setText("Flash Math");
        PlayFlashMathItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayFlashMathItemActionPerformed(evt);
            }
        });
        GamesMenu.add(PlayFlashMathItem);

        PlayAsteroidsItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        PlayAsteroidsItem.setText("Asteroids");
        PlayAsteroidsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayAsteroidsItemActionPerformed(evt);
            }
        });
        GamesMenu.add(PlayAsteroidsItem);

        MenuBar.add(GamesMenu);

        AboutMenu.setText("About");
        AboutMenu.setMnemonic(KeyEvent.VK_A);

        AboutAuthorItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        AboutAuthorItem.setText("About the Author");
        AboutAuthorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutAuthorItemActionPerformed(evt);
            }
        });
        AboutMenu.add(AboutAuthorItem);

        ResumeItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        ResumeItem.setText("Resume");
        ResumeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumeItemActionPerformed(evt);
            }
        });
        AboutMenu.add(ResumeItem);

        PortfolioItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK));
        PortfolioItem.setText("Portfolio");
        PortfolioItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortfolioItemActionPerformed(evt);
            }
        });
        AboutMenu.add(PortfolioItem);

        MenuBar.add(AboutMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        try {
            if (s1.login(UsernameLoginField.getText().trim(), PasswordLoginField.getText().trim())) {
                PlaySound.play("GUI_LogOn.wav");
                UsernameLoginField.setText("");
                PasswordLoginField.setText("");
                resetAllFields();
                LoginScreen.setVisible(false);
                MainMenu.setVisible(true);
                MenuBar.setVisible(true);
                BottomUsernameTextField.setText(StudentLogin.getUsername());
                BottomFullNameTextField.setText(StudentLogin.getFirstName() 
                        + " " + StudentLogin.getLastName());
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid login");
            }
            
        } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException ex) {
            Logger.getLogger(GUI_Main.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void BeginTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeginTestButtonActionPerformed
        if (seriesComboBoxIndex != 0 && questionsComboBoxSelection != 0) {
            
            //TEMPORARY; ONLY LETS USER DO ELEMENTARY TESTS
            if (seriesComboBoxIndex == 1) {
                System.out.println(getSubject() + questionsComboBoxSelection);
                /*
                    screen = new TestGUI("Factors", questionsComboBoxSelection);
                    screen.setVisible(true);
                */
                    screenList = new GUI_Test("Factors", questionsComboBoxSelection);
                    screenList.setVisible(true);
            } 
            else JOptionPane.showMessageDialog(this, "Only Elementary tests are available at this time.");
        }
        
        else if (seriesComboBoxIndex == 0)
            JOptionPane.showMessageDialog(this, "You must select a series before you begin.");
        
        else if (questionsComboBoxSelection == 0) 
            JOptionPane.showMessageDialog(this, "You must select an amount of questions before you begin.");
        
        else JOptionPane.showMessageDialog(this, "Error: Cannot start test");
        
    }//GEN-LAST:event_BeginTestButtonActionPerformed

    private void SeriesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeriesComboBoxActionPerformed
      
        seriesComboBoxIndex = SeriesComboBox.getSelectedIndex();
        try {
        SubjectComboBox.setModel
            (new javax.swing.DefaultComboBoxModel<>
                (TestSelection.getSubjects(seriesComboBoxIndex)));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
            System.err.println("Must have array of subjects for every series");
        }
 
        
    }//GEN-LAST:event_SeriesComboBoxActionPerformed

    private void SubjectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectComboBoxActionPerformed
        subjectComboBoxIndex = SubjectComboBox.getSelectedIndex();
    }//GEN-LAST:event_SubjectComboBoxActionPerformed

    private void NumOfQComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumOfQComboBoxActionPerformed
        if (NumOfQComboBox.getSelectedIndex() != 0)
        questionsComboBoxSelection = Integer.parseInt
                (NumOfQComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_NumOfQComboBoxActionPerformed

    private void NewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewItemActionPerformed
        newCard();
        displayCard("card3"); 
    }//GEN-LAST:event_NewItemActionPerformed

    private void ViewGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewGradesActionPerformed
        newCard();
        displayCard("card4");
        
    }//GEN-LAST:event_ViewGradesActionPerformed

    private void AboutAuthorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutAuthorItemActionPerformed
        newCard();
        displayCard("card7");        
    }//GEN-LAST:event_AboutAuthorItemActionPerformed

    private void ResumeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumeItemActionPerformed
        newCard();
        displayCard("card8");
        
    }//GEN-LAST:event_ResumeItemActionPerformed

    private void PortfolioItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortfolioItemActionPerformed
        newCard();
        displayCard("card9");    
    }//GEN-LAST:event_PortfolioItemActionPerformed

    private void PlayFlashMathItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayFlashMathItemActionPerformed
        if (!GUI_FlashMath.isOpen()) {
            flashMath = new GUI_FlashMath();
            flashMath.setVisible(true);     
        } else 
            JOptionPane.showMessageDialog(this, "A Flash Math instance is already open.");
    }//GEN-LAST:event_PlayFlashMathItemActionPerformed

    private void CalculatorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculatorItemActionPerformed
        if (!GUI_Calculator.isOpen()) {
            calculator = new GUI_Calculator();
            calculator.setVisible(true);           
        } else 
            JOptionPane.showMessageDialog(this, "A Calculator instance is already open.");
        
    }//GEN-LAST:event_CalculatorItemActionPerformed

    private void NewPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewPasswordFieldFocusLost
        if (NewPasswordField.getPassword().length == 0) {
            NewPasswordField.setEchoChar((char)0);
            NewPasswordField.setText("Password");
        }
    }//GEN-LAST:event_NewPasswordFieldFocusLost

    private void NewPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewPasswordFieldFocusGained
        if (NewPasswordField.getEchoChar() == (char)0) {
            NewPasswordField.setText("");
            NewPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_NewPasswordFieldFocusGained

    private void VerifyPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VerifyPasswordFieldFocusGained
        if (VerifyPasswordField.getEchoChar() == (char)0) {
            VerifyPasswordField.setText("");
            VerifyPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_VerifyPasswordFieldFocusGained

    private void VerifyPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VerifyPasswordFieldFocusLost
        if (VerifyPasswordField.getPassword().length == 0) {
            VerifyPasswordField.setEchoChar((char)0);
            VerifyPasswordField.setText("Verify Password");
        }
    }//GEN-LAST:event_VerifyPasswordFieldFocusLost

    private void DrawPadItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawPadItemActionPerformed
        if (!GUI_DrawPad.isOpen()) {
            drawPad = new GUI_DrawPad();
            drawPad.setVisible(true);            
        } else {
            JOptionPane.showMessageDialog(this, "A Draw Pad instance is already open.");
        }
    }//GEN-LAST:event_DrawPadItemActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        backCard();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ForwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForwardButtonActionPerformed
        forwardCard();
    }//GEN-LAST:event_ForwardButtonActionPerformed

    private void NewUsernameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewUsernameFieldFocusGained
        if (NewUsernameField.getText().equals("Username")) {
            NewUsernameField.setText("");
        }
    }//GEN-LAST:event_NewUsernameFieldFocusGained

    private void NewUsernameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewUsernameFieldFocusLost
        if (NewUsernameField.getText().equals("")) {
            NewUsernameField.setText("Username");
        }
    }//GEN-LAST:event_NewUsernameFieldFocusLost

    private void NewFirstNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewFirstNameFieldFocusGained
        if (NewFirstNameField.getText().equals("First Name")) {
            NewFirstNameField.setText("");
        }
    }//GEN-LAST:event_NewFirstNameFieldFocusGained

    private void NewFirstNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewFirstNameFieldFocusLost
        if (NewFirstNameField.getText().equals("")) {
            NewFirstNameField.setText("First Name");
        }
    }//GEN-LAST:event_NewFirstNameFieldFocusLost

    private void NewLastNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewLastNameFieldFocusGained
        if (NewLastNameField.getText().equals("Last Name")) {
            NewLastNameField.setText("");
        }
    }//GEN-LAST:event_NewLastNameFieldFocusGained

    private void NewLastNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewLastNameFieldFocusLost
        if (NewLastNameField.getText().equals("")) {
            NewLastNameField.setText("Last Name");
        }
    }//GEN-LAST:event_NewLastNameFieldFocusLost

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        r1 = new StudentRegister();
        r1.setFirstName(NewFirstNameField.getText());
        r1.setLastName(NewLastNameField.getText());
        r1.setUsername(NewUsernameField.getText());
        r1.setPassword(NewPasswordField.getText());
        r1.setVerifyPassword(VerifyPasswordField.getText());
        r1.setDOB(MonthComboBox.getSelectedItem().toString(), 
            DayComboBox.getSelectedItem().toString(),
            YearComboBox.getSelectedItem().toString());
        if (r1.verifyAllFields(this)) {
            try {
                r1.registrationPrompt(this, r1.register());
            } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException ex) {
                Logger.getLogger(GUI_Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {           
                resetAllFields();
            }
        }
    }//GEN-LAST:event_RegisterActionPerformed

    private void LogOutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutItemActionPerformed
        PlaySound.play("GUI_LogOff.wav");
        s1.logout();
        MainMenu.setVisible(false);
        MenuBar.setVisible(false);
        LoginScreen.setVisible(true);                
    }//GEN-LAST:event_LogOutItemActionPerformed

    private void ChangePasswordItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordItemActionPerformed
        if (!GUI_ChangePassword.isOpen()) {
            changePassword = new GUI_ChangePassword(this, true);
            changePassword.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "A Change Password instance is already open.");
        }
    }//GEN-LAST:event_ChangePasswordItemActionPerformed

    private void PasswordLoginFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordLoginFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {            
            if (PasswordLoginField.getPassword().length == 0)
                return;
            else
                LoginButton.doClick();
        }
    }//GEN-LAST:event_PasswordLoginFieldKeyPressed

    private void UsernameLoginFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameLoginFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {            
            if (PasswordLoginField.getText().isEmpty())
                PasswordLoginField.requestFocus();
            else LoginButton.doClick();
        }
    }//GEN-LAST:event_UsernameLoginFieldKeyPressed

    private void LoginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginButtonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            LoginButton.doClick();
    }//GEN-LAST:event_LoginButtonKeyPressed

    private void RegisterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RegisterKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            Register.doClick();
    }//GEN-LAST:event_RegisterKeyPressed

    private void NewFirstNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NewFirstNameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (NewFirstNameField.getText().isEmpty())
                NewFirstNameField.requestFocus();
            else if (NewLastNameField.getText().equalsIgnoreCase("Last Name"))
                NewLastNameField.requestFocus();
            else if (NewUsernameField.getText().equalsIgnoreCase("Username"))
                NewUsernameField.requestFocus();
            else if (NewPasswordField.getEchoChar() == (char)0)
                NewPasswordField.requestFocus();
            else if (VerifyPasswordField.getEchoChar() == (char)0)
                VerifyPasswordField.requestFocus();
            else if (MonthComboBox.getSelectedIndex() == 0)
                MonthComboBox.requestFocus();
            else if (DayComboBox.getSelectedIndex() == 0)
                DayComboBox.requestFocus();
            else if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_NewFirstNameFieldKeyPressed

    private void NewLastNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NewLastNameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (NewLastNameField.getText().equalsIgnoreCase("Last Name"))
                NewLastNameField.requestFocus();
            else if (NewUsernameField.getText().equalsIgnoreCase("Username"))
                NewUsernameField.requestFocus();
            else if (NewPasswordField.getEchoChar() == (char)0)
                NewPasswordField.requestFocus();
            else if (VerifyPasswordField.getEchoChar() == (char)0)
                VerifyPasswordField.requestFocus();
            else if (MonthComboBox.getSelectedIndex() == 0)
                MonthComboBox.requestFocus();
            else if (DayComboBox.getSelectedIndex() == 0)
                DayComboBox.requestFocus();
            else if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_NewLastNameFieldKeyPressed

    private void NewUsernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NewUsernameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (NewUsernameField.getText().equalsIgnoreCase("Username"))
                NewUsernameField.requestFocus();
            else if (NewPasswordField.getEchoChar() == (char)0)
                NewPasswordField.requestFocus();
            else if (VerifyPasswordField.getEchoChar() == (char)0)
                VerifyPasswordField.requestFocus();
            else if (MonthComboBox.getSelectedIndex() == 0)
                MonthComboBox.requestFocus();
            else if (DayComboBox.getSelectedIndex() == 0)
                DayComboBox.requestFocus();
            else if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_NewUsernameFieldKeyPressed

    private void NewPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NewPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (NewPasswordField.getPassword().length == 0)
                NewPasswordField.requestFocus();
            else if (VerifyPasswordField.getEchoChar() == (char)0)
                VerifyPasswordField.requestFocus();
            else if (MonthComboBox.getSelectedIndex() == 0)
                MonthComboBox.requestFocus();
            else if (DayComboBox.getSelectedIndex() == 0)
                DayComboBox.requestFocus();
            else if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_NewPasswordFieldKeyPressed

    private void VerifyPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerifyPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (VerifyPasswordField.getPassword().length == 0)
                VerifyPasswordField.requestFocus();
            else if (MonthComboBox.getSelectedIndex() == 0)
                MonthComboBox.requestFocus();
            else if (DayComboBox.getSelectedIndex() == 0)
                DayComboBox.requestFocus();
            else if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_VerifyPasswordFieldKeyPressed

    private void MonthComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MonthComboBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (MonthComboBox.getSelectedIndex() == 0)
                MonthComboBox.requestFocus();
            else if (DayComboBox.getSelectedIndex() == 0)
                DayComboBox.requestFocus();
            else if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_MonthComboBoxKeyPressed

    private void DayComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DayComboBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (DayComboBox.getSelectedIndex() == 0)
                DayComboBox.requestFocus();
            else if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_DayComboBoxKeyPressed

    private void YearComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YearComboBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (YearComboBox.getSelectedIndex() == 0)
                YearComboBox.requestFocus();
            else
                Register.doClick();
        }
    }//GEN-LAST:event_YearComboBoxKeyPressed

    private void ExitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitItemActionPerformed

    private void PlayAsteroidsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayAsteroidsItemActionPerformed
        try {
            RunExe.run(this);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PlayAsteroidsItemActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutAuthorItem;
    private javax.swing.JPanel AboutAuthorPanel;
    private javax.swing.JMenu AboutMenu;
    private javax.swing.JLabel AsteroidsDescLabel;
    private javax.swing.JLabel AsteroidsIconLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton BeginTestButton;
    private javax.swing.JLabel BioLabel;
    private javax.swing.JTextField BottomFullNameTextField;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JTextField BottomUsernameTextField;
    private javax.swing.JMenuItem CalculatorItem;
    private javax.swing.JMenuItem ChangePasswordItem;
    private javax.swing.JLabel DateOfBirthLabel;
    private javax.swing.JComboBox DayComboBox;
    private javax.swing.JMenuItem DrawPadItem;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JLabel EmailLoginLabel;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JLabel FactsLabel;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JButton ForwardButton;
    private javax.swing.JMenu GamesMenu;
    private javax.swing.JPanel GifPanel;
    private javax.swing.JPanel GradesCard;
    private javax.swing.JScrollPane GradesScrollPanel;
    private javax.swing.JTable GradesTable;
    private javax.swing.JMenuItem LogOutItem;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel LoginScreen;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JLabel MainMenuLabel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel MathMeDescLabel;
    private javax.swing.JLabel MathMeIconLabel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JComboBox MonthComboBox;
    private javax.swing.JPanel NavigateButtonPanel;
    private javax.swing.JTextField NewFirstNameField;
    private javax.swing.JMenuItem NewItem;
    private javax.swing.JTextField NewLastNameField;
    private javax.swing.JPasswordField NewPasswordField;
    private javax.swing.JLabel NewUserLabel;
    private javax.swing.JTextField NewUsernameField;
    private javax.swing.JComboBox NumOfQComboBox;
    private javax.swing.JLabel NumOfQLabel;
    private javax.swing.JPasswordField PasswordLoginField;
    private javax.swing.JLabel PasswordLoginLabel;
    private javax.swing.JLabel PictureLabel;
    private javax.swing.JMenuItem PlayAsteroidsItem;
    private javax.swing.JMenuItem PlayFlashMathItem;
    private javax.swing.JPanel PortfolioCard;
    private javax.swing.JMenuItem PortfolioItem;
    private javax.swing.JLabel ProjectZombieDescLabel;
    private javax.swing.JLabel ProjectZombieIconLabel;
    private javax.swing.JButton Register;
    private javax.swing.JPanel RegistrationPanel;
    private javax.swing.JPanel ResumeCard;
    private javax.swing.JLabel ResumeIcon;
    private javax.swing.JMenuItem ResumeItem;
    private javax.swing.JScrollPane ResumeScrollPane;
    private javax.swing.JPanel SelectionPanel;
    private javax.swing.JComboBox SeriesComboBox;
    private javax.swing.JLabel SeriesLabel;
    private javax.swing.JLabel SinCosGif;
    private javax.swing.JComboBox<String> SubjectComboBox;
    private javax.swing.JLabel SubjectLabel;
    private javax.swing.JScrollBar TableScrollBar;
    private javax.swing.JPanel TestNewCard;
    private javax.swing.JPanel TextPanel;
    private javax.swing.JMenu ToolsMenu;
    private javax.swing.JTextField UsernameLoginField;
    private javax.swing.JPasswordField VerifyPasswordField;
    private javax.swing.JMenuItem ViewGrades;
    private javax.swing.JMenu ViewMenu;
    private javax.swing.JComboBox YearComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
