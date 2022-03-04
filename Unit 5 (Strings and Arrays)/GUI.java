import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

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
        panel = new JPanel();
        frame = new JFrame();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // align component vertically
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        String buttonText[] = {"Start", "Rules"};
        JButton jButtons[] = new JButton[buttonText.length];
        panel.add(Box.createRigidArea(new Dimension(WIDTH / 3, HEIGHT / 6)));
        for (int i = 0; i < buttonText.length; i++) {
            JButton button = new JButton(buttonText[i]);
            button.setFont(new Font("Montserrat", Font.PLAIN, 50));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setAlignmentY(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(WIDTH / 3, HEIGHT / 5));
            button.setMinimumSize(new Dimension(WIDTH / 3, HEIGHT / 5));
            jButtons[i] = button;
        }
        // create actionListener for each button
        jButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.dispose();
                initializeGameScreen();
            }
        });

        jButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.dispose();
                initializeRulesScreen();
            }
        });

        for (int i = 0; i < jButtons.length; i++) {
            panel.add(jButtons[i]);
            panel.add(Box.createRigidArea(new Dimension(10, 10)));
        }

        frame.add(panel);
        frame.pack();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
        return;
    }
}