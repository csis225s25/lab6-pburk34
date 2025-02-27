import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import org.w3c.dom.events.MouseEvent;

public class MousePressCounter extends MouseAdapter implements Runnable {
    int count = 0;
    String toDisplay = "Mouse press count: " + count;
    
	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {
		//String toDisplay = "Mouse Around and See!";

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				//String toDisplay = "Mouse Around and See!";
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}
		};
		frame.add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);
		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

    @Override 
	public void mouseClicked(MouseEvent e) {
        count++;
		System.out.println("mouseClicked: " + e);
        System.out.println("Mouse press count: " + count);
	}

    @Override
	public void mousePressed(MouseEvent e) {
        count++;
		System.out.println("mousePressed: " + e);
        System.out.println("Mouse press count: " + count);
	}
    public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}

	
