package Wordle;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    final private int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    final private int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    final private String ORANGE = "#C9B458", GREEN = "#6AAA64", GRAY = "#787C7E", WHITE = "#FFFFFF", BLUE = "#32527B";
    private int row = 0, col = 0;
    private Boolean firstTime = true;
    private JPanel grid[];
    private String[][] colorGrid = new String[6][5];
    private String[][] stringGrid = new String[6][5];
    private String ANSWER = "";
    private String[] WORDLE_WORDS, ENGLISH_WORDS;
    private int[] guessFreq = new int[7];
    private int games = 0, wins = 0;
    private String[] alphaColor = new String[26];
    private String[] rows = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
    private Boolean updateTextColor = false;
    private final String buttonText[] = {"Start", "Rules", "Stats", "Exit"};

    // Call starting screen method
    public GUI(String[] wordle, String[] english ) {
        WORDLE_WORDS = wordle;
        ENGLISH_WORDS = english;
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.focus", new Color(0, 0, 0, 0));
        initializeStartingScreen();
    }

    // Generate random word for wordle
    String getRandomWord() {
        return WORDLE_WORDS[(int) (Math.random() * WORDLE_WORDS.length)];
    }

    // Prompt user with winning screen if they choose word correctly
    void doWin() {
        JOptionPane.showMessageDialog(null, "You won!");
        return;
    }

    // Prompt user with losing screen if they don't get the correct answer after 6 guesses
    void doLose() {
        JOptionPane.showMessageDialog(null, "You lost! The correct answer was: " + ANSWER);
        return;
    }

    // Inform user that the entered word is invalid
    void invalidWord() {
        JOptionPane.showMessageDialog(null, "Invalid word!");
        return;
    }

    // Function to deterine whether or not word is a valid english word
    Boolean invalidWord(String word) {
        Boolean valid = false; for (int i = 0; i < ENGLISH_WORDS.length; i++) if (ENGLISH_WORDS[i].equals(word)) valid = true;
        for (int i = 0; i < WORDLE_WORDS.length; i++) if (WORDLE_WORDS[i].equals(word)) valid = true; // Some wordle words are not in the english word list, so check for stragglers here
        return !valid;
    }

    // Function to reset panel
    void resetPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        return;
    }

    // Function to reset frame
    void resetFrame() {
        frame.getContentPane().invalidate();
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        return;
    }

    // Function to delete a character on the Wordle grid
    void doDelete(int ch) {
        if (ch == 8 || ch == 127) {
            while (col > 0 && stringGrid[row][col].equals("")) col--;
            stringGrid[row][col] = ""; // Delete the current character
            setGrid(); // Update grid
        }
        return;
    }

    // Function to add character to the Wordle grid
    void doAdd(int ch) {
        if ((int)'a' <= ch && ch <= (int)'z') { // Ensure that the character is a a valid letter
            stringGrid[row][col] = Character.toString(ch).toUpperCase(); // Update grid variables
            setGrid(); // Update GUI grid
            if (col < 4) col++; // Change current column
        }
        return;
    }

    // Function to check user's guess
    void doEnter(int ch) {
        if (ch == 10 || ch == 13) {
            String entered = ""; for (int i = 0; i < 5; i++) entered += stringGrid[row][i]; // Convert guess to string
            if (invalidWord(entered)) { // Check for invalid words
                invalidWord();
                return;
            }
            for (int i = 0; i < 5; i++) colorGrid[row][i] = GRAY; // Initialized new color grid as gray (default color)
            for (int i = 0; i < 5; i++) if (stringGrid[row][i].equals(Character.toString(ANSWER.charAt(i)))) colorGrid[row][i] = GREEN; // If the letter is correct, change color to green
            int freq[] = new int[26];
            for (int i = 0; i < 5; i++) freq[ANSWER.charAt(i) - 'A']++; // Get frequency of each letter in the answer
            for (int i = 0; i < 5; i++) if (colorGrid[row][i].equals(GREEN)) freq[stringGrid[row][i].charAt(0) - 'A']--; // Decrement frequency if we've already counted the character
            for (int i = 0; i < 5; i++) if (!colorGrid[row][i].equals(GREEN) && freq[stringGrid[row][i].charAt(0) - 'A'] > 0) { // Check if the letter is in the answer, but not in the correct position
                colorGrid[row][i] = ORANGE;
                freq[stringGrid[row][i].charAt(0) - 'A']--;
            }
            // Change colors of visible keyboard
            for (int i = 0; i < 5; i++) {
                if (colorGrid[row][i].equals(GRAY)) alphaColor[stringGrid[row][i].charAt(0) - 'A'] = GRAY;
                else if (colorGrid[row][i].equals(ORANGE) && !alphaColor[stringGrid[row][i].charAt(0) - 'A'].equals(GREEN)) alphaColor[stringGrid[row][i].charAt(0) - 'A'] = ORANGE;
                else alphaColor[stringGrid[row][i].charAt(0) - 'A'] = GREEN;
            }
            updateTextColor = true; // Indicate that the color is being updated
            setGrid(); // Update GUI grid
            row++;
            col = 0;
            if (entered.equals(ANSWER)) { // Check if user guessed correctly
                wins++;
                doWin();
                guessFreq[row]++;
                resetPanel();
                frame.dispose();
                initializeStartingScreen();
                return;
            }
            else if (row == 6) { // Check if user has run out of guesses
                doLose();
                resetPanel();
                frame.dispose();
                initializeStartingScreen();
                return;
            }
        }
        return;
    }

    // Function to generate title of the game
    void generateTitle() {
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel title = new JLabel("Wordle");
        title.setFont(new Font("Montserrat", Font.BOLD, 100));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        return;
    }

    // Function to add panel to frame
    void addPanel() {
        frame.add(panel);
        frame.pack();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Set size to screen size of user
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allow the user to close the window
        frame.setResizable(false);
        frame.setVisible(true);
        return;
    }

    // Function to update grid
    void setGrid() {
        resetPanel();
        panel.add(Box.createRigidArea(new Dimension(0, HEIGHT / 7)));

        // Update grid
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JPanel();
            // Set size
            grid[i].setMaximumSize(new Dimension(750, 80));
            grid[i].setMinimumSize(new Dimension(750, 80));
            grid[i].setPreferredSize(new Dimension(750, 80));
            for (int j = 0; j < 5; j++) {
                // Create label and style accordingly
                JLabel label = new JLabel(stringGrid[i][j], SwingConstants.CENTER);
                label.setFont(new Font("Arial", Font.BOLD, 50));
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                label.setAlignmentY(Component.CENTER_ALIGNMENT);
                label.setBackground(Color.decode(colorGrid[i][j]));
                if (i < row || i == row && updateTextColor) label.setForeground(Color.white);
                label.setOpaque(true);
                label.setMinimumSize(new Dimension(75, 75));
                label.setMaximumSize(new Dimension(75, 75));
                label.setPreferredSize(new Dimension(75, 75));
                if (!stringGrid[i][j].equals("") && i == row) label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                else label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(GRAY)));
                // Add label
                grid[i].add(label);
            }
        }
        // Change layout for formatting reasons
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add all rows to panel
        for (int i = 0; i < grid.length; i++) panel.add(grid[i]);

        updateTextColor = false;
        addKeyboard(); // Add keyboard to the bottom of the screen
        panel.repaint(); // Update panel
        frame.requestFocus();
        return;
    }

    void addKeyboard() {
        panel.add(Box.createRigidArea(new Dimension(0, 25))); // Create small space
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new BoxLayout(keyboard, BoxLayout.Y_AXIS));
        JButton button = new JButton();
        for (int i = 0; i < 3; i++) {
            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            if (i == 2) {
                // Create enter button
                button = new JButton("Enter");
                button.setFont(new Font("Arial", Font.BOLD, 15));
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                button.setAlignmentY(Component.CENTER_ALIGNMENT);
                button.setHorizontalAlignment(SwingConstants.CENTER);
                button.setVerticalAlignment(SwingConstants.CENTER);
                button.setBackground(Color.decode(WHITE));
                button.setOpaque(true);
                button.setMinimumSize(new Dimension(75, 50));
                button.setMaximumSize(new Dimension(75, 50));
                button.setPreferredSize(new Dimension(75, 50));
                button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(1, 1, 1, 1),
                    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK)));
                button.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        doEnter(13);
                    }
                });
                row.add(button);
                row.add(Box.createRigidArea(new Dimension(5, 0)));
            }
            // Create button for each letter
            for (int j = 0; j < rows[i].length(); j++) {
                button = new JButton(Character.toString(rows[i].charAt(j)));
                button.setFont(new Font("Arial", Font.BOLD, 15));
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                button.setAlignmentY(Component.CENTER_ALIGNMENT);
                button.setHorizontalAlignment(SwingConstants.CENTER);
                button.setVerticalAlignment(SwingConstants.CENTER);
                button.setBackground(Color.decode(alphaColor[rows[i].charAt(j) - 'A']));
                button.setOpaque(true);
                button.setMinimumSize(new Dimension(50, 50));
                button.setMaximumSize(new Dimension(50, 50));
                button.setPreferredSize(new Dimension(50, 50));
                button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                button.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        JButton button = (JButton)e.getSource();
                        String text = button.getText().toLowerCase();
                        doAdd((int)text.charAt(0));
                    }
                });
                row.add(button);
                row.add(Box.createRigidArea(new Dimension(5, 0)));
            }
            //Create delete button
            if (i == 2) {
                button = new JButton("Del");
                button.setFont(new Font("Arial", Font.BOLD, 15));
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                button.setAlignmentY(Component.CENTER_ALIGNMENT);
                button.setHorizontalAlignment(SwingConstants.CENTER);
                button.setVerticalAlignment(SwingConstants.CENTER);
                button.setBackground(Color.decode(WHITE));
                button.setOpaque(true);
                button.setMinimumSize(new Dimension(75, 50));
                button.setMaximumSize(new Dimension(75, 50));
                button.setPreferredSize(new Dimension(75, 50));
                button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                button.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        doDelete(8);
                    }
                });
                row.add(button);
            }
            keyboard.add(row);
            JPanel space = new JPanel();
            // Add space between rows
            space.setMaximumSize(new Dimension(0, 5));
            space.setMinimumSize(new Dimension(0, 5));
            space.setPreferredSize(new Dimension(0, 5));
            keyboard.add(space);
        }
        // Add the keyboard panel to the viewable panel
        panel.add(keyboard);
        return;
    }

    // Reset colors of keyboard
    void resetKeyboard() {
        for (int i = 0; i < 26; i++) alphaColor[i] = WHITE;
        return;
    }

    // Function to calculate win / loss percentage
    JLabel addWinLoss() {
        int percent = (int)(Math.round(100 * wins / (double)(games)));
        JLabel ret = new JLabel("You have won " + percent + "% of the games.");
        ret.setFont(new Font("Arial", Font.BOLD, 50));
        ret.setAlignmentX(Component.CENTER_ALIGNMENT);
        return ret;
    }

    // Function to get the "Back" button
    JButton getBackButton() {
        JButton button = new JButton("Back");
        button.setFont(new Font("Montserrat", Font.PLAIN, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(WIDTH / (buttonText.length), HEIGHT / (buttonText.length + 2)));
        button.setMaximumSize(new Dimension(WIDTH / (buttonText.length), HEIGHT / (buttonText.length + 2)));
        button.setMinimumSize(new Dimension(WIDTH / (buttonText.length), HEIGHT / (buttonText.length + 2)));
        button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        button.setForeground(Color.white);
        button.setBackground(Color.decode(BLUE));
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                initializeStartingScreen();
                return;
            }
        });
        return button;
    }

    // Function to create game screen
    void initializeGameScreen() {
        games++;
        resetPanel();
        resetKeyboard();
        frame.addKeyListener(new Keychecker()); // Make Java listen for keypresses
        ANSWER = getRandomWord(); // Get random word

        // Reset variables
        for (int i = 0; i < 6; i++) for (int j = 0; j < 5; j++) {
            colorGrid[i][j] = WHITE; 
            stringGrid[i][j] = "";
        }

        grid = new JPanel[6];
        
        // Set up formatting
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JPanel();
            grid[i].setLayout(new FlowLayout());
            grid[i].setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }
        setGrid(); // Create grid
        return;
    }
    

    // Derived from https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
    class Keychecker extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            char c = (char)event.getKeyChar();
            if (Character.isLetter(c)) c = String.valueOf(c).toLowerCase().charAt(0);
            int ch = (int)c;
            doDelete(ch);
            doAdd(ch);
            doEnter(ch);
        }
    
    }

    // Function to create rules screen
    void initializeRulesScreen() {
        resetPanel();

        // Change format
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, HEIGHT / (buttonText.length + 2))));
        String txt = "Welcome to my take on Wordle! Like the traditional version of Wordle, the user is to guess a randomly generated, five lettered word within 6 guesses.\nSince there are thousands of possible words, upon entering a valid, English word, the letters of the word will be colored using the following algorithm:\nIf the character is not in the word, it will be colored gray.\nIf the character is in the word, but in the wrong spot, it will be colored orange/yellow.\nFinally, if the character is in the word and in the correct position, it will be coloured green.\nOnce you either guess a word or the game finishes, your score will be recorded. To view your stats, navigate to the \"Stats\" tab.\nGood luck!";
        String[] converted = txt.split("\n");
        // Style text properly
        for (int i = 0; i < converted.length; i++) {
            JLabel label = new JLabel(converted[i], SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setAlignmentY(Component.CENTER_ALIGNMENT);
            panel.add(label);
            JPanel space = new JPanel();
            space.setMaximumSize(new Dimension(0, 5));
            space.setMinimumSize(new Dimension(0, 5));
            space.setPreferredSize(new Dimension(0, 5));
            panel.add(space);
        }
        // Create space
        panel.add(Box.createRigidArea(new Dimension(0, 2 * HEIGHT / (buttonText.length + 2))));    
    
        // Add back button
        JButton back = getBackButton();
        panel.add(back);
        
        // Add panel to frame
        addPanel();
        return;
    }

    // Function to create stats screen
    void initializeStatsScreen() {
        resetPanel();
        // Set up formatting
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add and style starting information
        JPanel start = new JPanel();
        start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));
        start.add(Box.createRigidArea(new Dimension(100, 100)));
        JLabel label = new JLabel("Games Played: " + games);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.add(label);
        if (games > 0) start.add(addWinLoss());
        start.add(Box.createRigidArea(new Dimension(50, 50)));
        JLabel distrib = new JLabel("Distribution of Guesses in Games Won");
        distrib.setFont(new Font("Arial", Font.BOLD, 25));
        distrib.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.add(distrib);
        start.add(Box.createRigidArea(new Dimension(50, 50)));
        panel.add(start);

        // Add the guess numbers as the first column
        JPanel stats = new JPanel();
        stats.add(Box.createHorizontalGlue());
        JPanel col = new JPanel();
        col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
        JLabel text;
        for (int i = 1; i <= 6; i++) {
            text = new JLabel(Integer.toString(i));
            text.setFont(new Font("Arial", Font.BOLD, 15));
            text.setAlignmentY(Component.CENTER_ALIGNMENT);
            text.setPreferredSize(new Dimension(50, 50));
            text.setMaximumSize(new Dimension(50, 50));
            text.setMinimumSize(new Dimension(50, 50));
            col.add(text);
            col.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        stats.add(col);
        
        // Add the number of wins as a black rectangle in the second column
        col = new JPanel();
        col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 6; i++) {
            text = new JLabel();
            text.setPreferredSize(new Dimension((guessFreq[i] + 1) * 50, 50));
            text.setMaximumSize(new Dimension((guessFreq[i] + 1) * 50, 50));
            text.setMinimumSize(new Dimension((guessFreq[i] + 1) * 50, 50));
            text.setBackground(Color.black);
            text.setText(Integer.toString(guessFreq[i]));
            text.setForeground(Color.white);
            text.setHorizontalAlignment(SwingConstants.CENTER);
            text.setVerticalAlignment(SwingConstants.CENTER);
            text.setOpaque(true);
            col.add(text);
            col.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        stats.add(col);
        stats.add(Box.createHorizontalGlue());
        panel.add(stats);

        // Get back button
        JButton back = getBackButton();
        panel.add(back);

        // Add panel to frame
        addPanel();
        return;
    }

    // Function to create starting screen
    void initializeStartingScreen() {
        row = col = 0;
        // Reset frame and panel if it's been initialized already
        if (!firstTime) {
            resetPanel();
            resetFrame();
        }
        firstTime = false;
        
        panel = new JPanel();
        frame = new JFrame("Wordle");
        
        // Format frame
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        
        // Create and style navigation buttons
        JButton jButtons[] = new JButton[buttonText.length];
        generateTitle();
        for (int i = 0; i < buttonText.length; i++) {
            JButton button = new JButton(buttonText[i]);
            button.setFont(new Font("Montserrat", Font.PLAIN, 50));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setAlignmentY(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(WIDTH / (buttonText.length), HEIGHT / (buttonText.length + 2)));
            button.setMinimumSize(new Dimension(WIDTH / (buttonText.length), HEIGHT / (buttonText.length + 2)));
            button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
            button.setForeground(Color.white);
            button.setBackground(Color.decode(BLUE));
            jButtons[i] = button;
        }

        // Add action listeners to each button to allow them to bring user to their respective screens on-click
        jButtons[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initializeGameScreen();
            }
        });

        jButtons[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initializeRulesScreen();
            }
        });

        jButtons[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initializeStatsScreen();
            }
        });

        jButtons[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.dispose();
            }
        });

        // Add all buttons to panel
        for (int i = 0; i < jButtons.length; i++) {
            panel.add(jButtons[i]);
            panel.add(Box.createRigidArea(new Dimension(10, 25)));
        }

        // Add panel to frame
        addPanel();
        return;
    }
}