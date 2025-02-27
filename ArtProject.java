
import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    @Override
    public void paintComponent(Graphics f) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(f);

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw some shapes and stuff
        setBackground(Color.lightGray);

        f.setColor(Color.magenta);
        f.drawRect(40,40,500,500);
        int[] xPoints = {100, 200};
        int[] yPoints = {400, 800};

        f.setColor(Color.red);
        f.drawPolygon(xPoints, yPoints,2);

        f.setColor(Color.green);
        f.fillOval(250, 250, 50, 50);

        f.setColor(Color.PINK);
        f.fillArc(100, 100, 200, 150, 45, 90);

        f.setColor(Color.orange);
        f.fillOval(150, 300, 400, 400);
    
    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("ArtProject");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}

    

