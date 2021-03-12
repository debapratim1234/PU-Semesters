import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class ChangeBallColor{

    public static void main (String[] args) {
        ColorBallFrame frame = new ColorBallFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
    }
}


class ColorBallFrame extends JFrame { 
    public ColorBallFrame() {
        setTitle("ChangeBallColor");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        ColorBallPanel panel = new ColorBallPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);
    }
    public static final int DEFAULT_WIDTH=500;
    public static final int DEFAULT_HEIGHT=500;
}


class ColorBallPanel extends JPanel {
    private static final int SIZE=50;
    private int x;
    private int y;
    Color currentColor = Color.darkGray;
    Graphics2D g2;

    public ColorBallPanel() {
        setBackground(Color.white);
        makeButton(Color.blue);
        makeButton(Color.red);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D)g;
        int x = 250;
        int y = 200;
        
        g2.setColor(currentColor);
        Ellipse2D current = new Ellipse2D.Double(x-SIZE/2,y-SIZE/2,SIZE,SIZE);
        g2.fill(current);
    }

    private void makeButton(final Color inColor) {
        JButton button = new JButton(" ");
        button.setBackground(inColor);
        add(button);
        button.addActionListener(new
                ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        currentColor = inColor;
                        Toolkit.getDefaultToolkit().beep();
                        repaint();
                    }
                });
    }
}

