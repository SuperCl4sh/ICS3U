package Rectangle;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    final private int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    final private int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private Rectangle rectangles[] = new Rectangle[1000];
    private int MAX_Y = 25;
    private int MAX_X = 25;
    private boolean grid[][] = new boolean[MAX_Y + 1][MAX_X + 1];
    private JPanel gridPanel[] = new JPanel[MAX_Y + 1];
    final private int BLOCK_SIZE = 25;
    private int numRectangles = 0;
    private final int dx[] = { 0, 1, 0, -1 };
    private final int dy[] = { -1, 0, 1, 0 };
    private final Color BLUE = Color.decode("#32527B");

    GUI() {
        gameScreen();
        return;
    }

    // Create _assert function
    private void _assert(boolean condition) {
        if (!condition) throw new RuntimeException();
        return;
    }


    // Function to reset panel
    private void resetPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        return;
    }

    // Function to reset frame
    private void resetFrame() {
        frame.getContentPane().invalidate();
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        return;
    }

    // Function to add panel to frame
    private void addPanel() {
        frame.add(panel);
        frame.pack();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Set size to screen size of user
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allow the user to close the window
        frame.setResizable(false);
        frame.setVisible(true);
        return;
    }

    private void resetGrid() {
        for (int i = 0; i < grid.length; i++) for (int j = 0; j < grid[i].length; j++) grid[i][j] = false;
        return;
    }

    private void updateGrid(Rectangle r) {
        int bx = r.getX(), by = MAX_Y - r.getY() - 1, tx = bx + r.getWidth(), ty = by - r.getHeight();
        for (int i = bx; i < tx; i++) {
            for (int j = by; j > ty; j--) {
                grid[j][i] = true;
            }
        }
        return;
    }

    private void addRectangles() {
        for (int i = 0; i < numRectangles; i++) updateGrid(rectangles[i]);
        return;
    }

    private int getArea() {
        int area = 0;
        for (int i = 0; i < grid.length; i++) for (int j = 0; j < grid[i].length; j++) if (grid[i][j]) area++;
        return area;
    }

    private int getPerimeter() {
        int perimeter = 0;
        int perimeterGrid[][] = new int[MAX_Y + 1][MAX_X + 1];
        for (int i = 0; i < numRectangles; i++) {
            Rectangle r = rectangles[i];
            int bx = r.getX(), tx = bx + r.getWidth(), by = MAX_Y - r.getY(), ty = by - r.getHeight();
            for (int j = bx; j <= tx; j++) {
                for (int k = by; k >= ty; k--) {
                    if (j == bx || j == tx || k == by || k == ty) perimeterGrid[k][j] = 1;
                }
            }
        }

        for (int i = 0; i < numRectangles; i++) {
            Rectangle r = rectangles[i];
            int bx = r.getX(), tx = bx + r.getWidth(), by = MAX_Y - r.getY(), ty = by - r.getHeight();
            for (int j = bx + 1; j <= tx - 1; j++) {
                for (int k = by - 1; k >= ty + 1; k--) perimeterGrid[k][j] = 0;
            }
        }
        for (int i = 0; i < perimeterGrid.length; i++) for (int j = 0; j < perimeterGrid[i].length; j++) perimeter += perimeterGrid[i][j];

        return perimeter;
    }    

    private void gameScreen() {
        frame = new JFrame("Rectangle");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        resetGrid();

        panel.add(Box.createRigidArea(new Dimension(WIDTH, 50)));

        if (numRectangles == 0) for (int i = 0; i < rectangles.length; i++) rectangles[i] = new Rectangle();
        for (Rectangle r : rectangles) updateGrid(r);

        JPanel stats = new JPanel();
        stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
        JLabel area = new JLabel("Area: " + getArea());
        // Increase font size
        area.setFont(area.getFont().deriveFont(20.0f));

        JLabel perimeter = new JLabel("Perimeter: " + getPerimeter());
        // Increase font size
        perimeter.setFont(perimeter.getFont().deriveFont(20.0f));

        stats.add(area);
        stats.add(perimeter);
        panel.add(stats);

        panel.add(Box.createRigidArea(new Dimension(WIDTH, 50)));

        for (int i = 0; i < MAX_Y; i++) {
            gridPanel[i] = new JPanel();
            gridPanel[i].setLayout(new BoxLayout(gridPanel[i], BoxLayout.X_AXIS));
            
            JLabel num = new JLabel(Integer.toString(MAX_Y - i - 1) + (MAX_Y - i - 1 < 10 ? "   " : " "));
            num.setBackground(Color.WHITE);
            num.setPreferredSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
            num.setMinimumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
            num.setMaximumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
            num.setVerticalAlignment(SwingConstants.BOTTOM);
            num.setHorizontalAlignment(SwingConstants.RIGHT);
            gridPanel[i].add(num);

            for (int j = 0; j < MAX_X; j++) {
                JPanel block = new JPanel();
                block.setBackground((grid[i][j]) ? Color.RED : Color.WHITE);
                block.setPreferredSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                block.setMinimumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                block.setMaximumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                // Create white border around block
                block.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                gridPanel[i].add(block);
            }
            if (i == MAX_Y - 1) {
                gridPanel[i + 1] = new JPanel();
                gridPanel[i + 1].setLayout(new BoxLayout(gridPanel[i + 1], BoxLayout.X_AXIS));
                JLabel num2 = new JLabel("   ");
                num2.setBackground(Color.WHITE);
                num2.setPreferredSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                num2.setMinimumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                num2.setMaximumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                num2.setVerticalAlignment(SwingConstants.BOTTOM);
                num2.setHorizontalAlignment(SwingConstants.RIGHT);
                gridPanel[i + 1].add(num2);

                for (int j = 0; j < MAX_X; j++) {
                    JLabel num3 = new JLabel(Integer.toString(j) + (j < 10 ? "   " : " "));
                    num3.setBackground(Color.WHITE);
                    num3.setPreferredSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    num3.setMinimumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    num3.setMaximumSize(new Dimension(BLOCK_SIZE, BLOCK_SIZE));
                    num3.setVerticalAlignment(SwingConstants.TOP);
                    num3.setHorizontalAlignment(SwingConstants.LEFT);
                    //num3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    gridPanel[i + 1].add(num3);
                }
            }


        }
        for (int i = 0; i < MAX_Y + 1; i++) panel.add(gridPanel[i]);

        panel.add(Box.createRigidArea(new Dimension(WIDTH, 50)));

        // Add button to allow user to add more rectangles
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        JButton add = new JButton("Add");
        add.setPreferredSize(new Dimension(100, 100));
        add.setMinimumSize(new Dimension(100, 100));
        add.setMaximumSize(new Dimension(100, 100));
        add.setRolloverEnabled(false);
        add.setFocusable(false);
        // Add black border
        add.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add.addActionListener(e -> {
            // Check if user entered valid input
            int xCoord, yCoord, width, length;
            try {
                xCoord = Integer.parseInt(JOptionPane.showInputDialog("Enter x coordinate"));
                yCoord = Integer.parseInt(JOptionPane.showInputDialog("Enter y coordinate"));
                length = Integer.parseInt(JOptionPane.showInputDialog("Enter length"));
                width = Integer.parseInt(JOptionPane.showInputDialog("Enter width"));
                _assert(!(xCoord < 0 || yCoord < 0 || length < 0 || width < 0 || xCoord + length > MAX_X || yCoord + width > MAX_Y));
            }
            catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                return;
            }

            rectangles[numRectangles] = new Rectangle(xCoord, yCoord, length, width);
            updateGrid(rectangles[numRectangles]);
            numRectangles++;
            resetPanel();
            resetFrame();
            frame.dispose();
            gameScreen();
        });
        add.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Style button blue with white text
        add.setForeground(Color.WHITE);
        add.setBackground(BLUE);
        add.setFont(add.getFont().deriveFont(20.0f));

        buttons.add(add);

        buttons.add(Box.createRigidArea(new Dimension(50, 0)));

        // Add undo button
        JButton undo = new JButton("Undo");
        undo.setPreferredSize(new Dimension(100, 100));
        undo.setMinimumSize(new Dimension(100, 100));
        undo.setMaximumSize(new Dimension(100, 100));
        undo.setRolloverEnabled(false);
        undo.setFocusable(false);
        undo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        undo.addActionListener(e -> {
            if (numRectangles > 0) {
                rectangles[numRectangles - 1] = new Rectangle();
                numRectangles--;
                resetGrid();
                addRectangles();

                resetPanel();
                resetFrame();
                frame.dispose();
                gameScreen();
            }
        });
        undo.setAlignmentX(Component.CENTER_ALIGNMENT);
        undo.setForeground(Color.WHITE);
        undo.setBackground(BLUE);
        undo.setFont(undo.getFont().deriveFont(20.0f));
        buttons.add(undo);

        buttons.add(Box.createRigidArea(new Dimension(50, 0)));

        // Add clear button
        JButton clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(100, 100));
        clear.setMinimumSize(new Dimension(100, 100));
        clear.setMaximumSize(new Dimension(100, 100));
        clear.setRolloverEnabled(false);
        clear.setFocusable(false);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        clear.addActionListener(e -> {
            if (numRectangles == 0) return;
            numRectangles = 0;
            resetGrid();
            
            resetPanel();
            resetFrame();

            frame.dispose();
            gameScreen();
        });
        clear.setAlignmentX(Component.CENTER_ALIGNMENT);
        clear.setForeground(Color.WHITE);
        clear.setBackground(BLUE);
        clear.setFont(clear.getFont().deriveFont(20.0f));

        buttons.add(clear);

        panel.add(buttons);

        addPanel();
        return;
    }
}
