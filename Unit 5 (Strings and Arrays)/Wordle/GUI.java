package Wordle;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    final private int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    final private int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    final private String ORANGE = "#FFA500", GREEN = "#00FF00", GRAY = "#808080", WHITE = "#FFFFFF";
    private int row = 0, col = 0;
    private Boolean firstTime = true;
    private JPanel grid[];
    private String[][] colorGrid = new String[6][5];
    private String[][] stringGrid = new String[6][5];
    private String ANSWER = "";
    private String[] WORDLE_WORDS, ENGLISH_WORDS;
    private int wins = 0, losses = 0;

    public GUI(String[] wordle, String[] english ) {
        WORDLE_WORDS = wordle;
        ENGLISH_WORDS = english;
        initializeStartingScreen();
    }

    String getRandomWord() {
        return WORDLE_WORDS[(int) (Math.random() * WORDLE_WORDS.length)];
    }

    void doWin() {
        JOptionPane.showMessageDialog(null, "You won!");
        wins++;
        return;
    }

    void doLose() {
        JOptionPane.showMessageDialog(null, "You lost! The correct answer was: " + ANSWER);
        losses++;
        return;
    }

    void invalidWord() {
        JOptionPane.showMessageDialog(null, "Invalid word!");
        return;
    }

    Boolean invalidWord(String word) {
        Boolean valid = false; for (int i = 0; i < ENGLISH_WORDS.length; i++) if (ENGLISH_WORDS[i].equals(word)) valid = true;
        return !valid;
    }

    void resetPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        return;
    }

    void resetFrame() {
        frame.getContentPane().invalidate();
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        return;
    }

    void doDelete(int ch) {
        if (ch == 8 || ch == 127) {
            if (col >= 0) {
                stringGrid[row][col] = "";
                if (col > 0) col--;
                setGrid();
            }
        }
        return;
    }

    void doAdd(int ch) {
        if ((int)'a' <= ch && ch <= (int)'z') {
            stringGrid[row][col] = Character.toString(ch).toUpperCase();
            setGrid();
            if (col < 4) col++;
        }
        return;
    }

    void doEnter(int ch) {
        if (ch == 10 || ch == 13) {
            String entered = ""; for (int i = 0; i < 5; i++) entered += stringGrid[row][i];
            if (invalidWord(entered)) {
                invalidWord();
                return;
            }
            for (int i = 0; i < 5; i++) colorGrid[row][i] = GRAY;
            for (int i = 0; i < 5; i++) if (stringGrid[row][i].equals(Character.toString(ANSWER.charAt(i)))) colorGrid[row][i] = GREEN;
            int freq[] = new int[26];
            for (int i = 0; i < 5; i++) freq[ANSWER.charAt(i) - 'A']++;
            for (int i = 0; i < 5; i++) if (colorGrid[row][i].equals(GREEN)) freq[stringGrid[row][i].charAt(0) - 'A']--;
            for (int i = 0; i < 5; i++) if (!colorGrid[row][i].equals(GREEN) && freq[stringGrid[row][i].charAt(0) - 'A'] > 0) {
                colorGrid[row][i] = ORANGE;
                freq[stringGrid[row][i].charAt(0) - 'A']--;
            }
            
            setGrid();
            row++;
            col = 0;
            if (entered.equals(ANSWER)) {
                doWin();
                resetPanel();
                frame.dispose();
                initializeStartingScreen();
                return;
            }
            else if (row == 6) {
                doLose();
                resetPanel();
                frame.dispose();
                initializeStartingScreen();
                return;
            }
        }
        return;
    }


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

    void addPanel() {
        frame.add(panel);
        frame.pack();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        return;
    }

    void setGrid() {
        resetPanel();
        panel.add(Box.createRigidArea(new Dimension(0, HEIGHT / 7)));

        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JPanel();
            grid[i].setMaximumSize(new Dimension(750, 110));
            grid[i].setMinimumSize(new Dimension(750, 110));
            grid[i].setPreferredSize(new Dimension(750, 110));
            for (int j = 0; j < 5; j++) {
                JLabel label = new JLabel(stringGrid[i][j], SwingConstants.CENTER);
                label.setFont(new Font("Arial", Font.BOLD, 50));
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                label.setAlignmentY(Component.CENTER_ALIGNMENT);
                label.setBackground(Color.decode(colorGrid[i][j]));
                label.setOpaque(true);
                label.setMinimumSize(new Dimension(100, 100));
                label.setMaximumSize(new Dimension(100, 100));
                label.setPreferredSize(new Dimension(100, 100));
                label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, 0, 0),
                    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK)));
                grid[i].add(label);
            }
        }
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < grid.length; i++) panel.add(grid[i]);

        panel.repaint();
        frame.requestFocus();
        return;
    }

    void initializeGameScreen() {
        resetPanel();
        frame.addKeyListener(new Keychecker());
        ANSWER = getRandomWord();

        for (int i = 0; i < 6; i++) for (int j = 0; j < 5; j++) {
            colorGrid[i][j] = WHITE;
            stringGrid[i][j] = "";
        }

        grid = new JPanel[6];
        
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JPanel();
            grid[i].setLayout(new FlowLayout());
            grid[i].setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }
        setGrid();
        return;
    }
    

    // Derived from https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
    class Keychecker extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            int ch = (int)event.getKeyChar();
            doDelete(ch);
            doAdd(ch);
            doEnter(ch);
        }
    
    }

    void initializeRulesScreen() {
        resetPanel();

        addPanel();
        return;
    }

    void initializeStatsScreen() {
        resetPanel();

        addPanel();
        return;
    }

    void initializeStartingScreen() {
        row = col = 0;
        if (!firstTime) {
            resetPanel();
            resetFrame();
        }
        firstTime = false;
        
        panel = new JPanel();
        frame = new JFrame("Wordle");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        

        String buttonText[] = {"Start", "Rules", "Stats", "Exit"};
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
            button.setBackground(new Color(0, 255, 255));
            jButtons[i] = button;
        }

        jButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initializeGameScreen();
            }
        });

        jButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initializeRulesScreen();
            }
        });

        jButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initializeStatsScreen();
            }
        });

        jButtons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.dispose();
            }
        });

        for (int i = 0; i < jButtons.length; i++) {
            panel.add(jButtons[i]);
            panel.add(Box.createRigidArea(new Dimension(10, 25)));
        }

        addPanel();
        return;
    }
}