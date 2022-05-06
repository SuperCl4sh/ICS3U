package Rectangle;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    final private int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    final private int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private Rectangle rectangles[] = new Rectangle[1000];
    private int MAX_Y = 20;
    private int MAX_X = 40;
    private boolean grid[][] = new boolean[2 * MAX_Y + 1][2 * MAX_X + 1];
    private JPanel gridPanel[] = new JPanel[MAX_Y + 1];
    final private int BLOCK_SIZE = 35;
    

    GUI() {
        gameScreen();
        return;
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

    void resetGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) grid[i][j] = false;
        }
        return;
    }

    void updateGrid(Rectangle r) {
        int bx = r.getX(), by = r.getY(), tx = bx + r.getWidth(), ty = by - r.getHeight();

        for (int i = bx; i < tx; i++) {
            for (int j = by; j > ty; j--) {
                grid[i][j] = true;
            }
        }
        return;
    }

    void gameScreen() {
        frame = new JFrame("Rectangle");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        resetGrid();

        int extraHeight = HEIGHT % 100;
        JPanel row = new JPanel();
        row.add(Box.createRigidArea(new Dimension(WIDTH, extraHeight)));
        panel.add(row);

        for (int i = 0; i < rectangles.length; i++) rectangles[i] = new Rectangle(5, 5, 2, 2);
        for (Rectangle r : rectangles) updateGrid(r);
        for (int i = 0; i < MAX_Y; i++) {
            for (int j = 0; j < MAX_X; j++) System.out.print((grid[i][j] == false) ? 0 : 1);
            System.out.println();
        }
        for (int i = 0; i < MAX_Y; i++) {
            gridPanel[i] = new JPanel();
            gridPanel[i].setLayout(new BoxLayout(gridPanel[i], BoxLayout.X_AXIS));
            for (int j = 0; j < MAX_X; j++) {
                if (grid[i][j]) {
                    JPanel block = new JPanel();
                    block.setBackground(Color.RED);
                    block.setPreferredSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    block.setMinimumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    block.setMaximumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    // Create white border around block
                    block.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    gridPanel[i].add(block);
                } else {
                    JPanel block = new JPanel();
                    block.setBackground(Color.WHITE);
                    block.setPreferredSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    block.setMinimumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    block.setMaximumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    block.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    gridPanel[i].add(block);
                }
            }
        }
        for (int i = 0; i < MAX_Y; i++) {
            panel.add(gridPanel[i]);
        }

        JPanel row2 = new JPanel();
        row2.add(Box.createRigidArea(new Dimension(WIDTH, extraHeight)));
        panel.add(row2);

        addPanel();
        return;
    }
}
