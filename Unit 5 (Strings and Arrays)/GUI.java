import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    final private Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
    final private int WIDTH = (int) SCREENSIZE.getWidth();
    final private int HEIGHT = (int) SCREENSIZE.getHeight();

    public GUI() {
        initializeStartingScreen();
    }

    void initializeGameScreen() {
        return;
    }

    void initializeRulesScreen() {
        return;
    }

    void initializeStartingScreen() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wordle");
        panel = new JPanel(); 
        //panel.setLayout(new GridLayout(3, 0));
        String buttons[] = {"Start", "Rules", "Exit"};
        for (int i = 0, x = HEIGHT / 2, y = (int)(WIDTH / 3.0 * 2); i < buttons.length && x < HEIGHT && y < WIDTH; y += 250, i++) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(x, y, 500, 500);
            button.setFont(new Font("Arial", Font.PLAIN, 50));
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    frame.dispose();
                }
            });
            panel.add(button);
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(SCREENSIZE);
        frame.setVisible(true);
    }   
    public static void main(String[] args) {
        new GUI();
        return;
    }
}
