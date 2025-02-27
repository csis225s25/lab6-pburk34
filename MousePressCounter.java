import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * 
 * @author Payton Burke and Toben Feltman
 * @version 2/27/2025
 * 
 */

public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {
   //keeps track of the count
	int count = 0;
	//the original display in the center 
    String toDisplay = "Mouse press count: " + count;
	//variables for the reset button and panel so it can be used across classes 
    JButton r;
	JPanel p;
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
		//reset button
		JButton reset = new JButton("Reset");

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel(new BorderLayout()) {
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
		JPanel graphicsPanel = new JPanel();
		frame.add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);
		graphicsPanel.add(reset);
		panel.add(graphicsPanel, BorderLayout.SOUTH);
		// display the window we've created
		frame.pack();
		frame.setVisible(true);
		//makes the reset button actually work 
		reset.addActionListener(this);
		//stores the initialzed values of reset and panel into the instance variables so they can be used outside of run()
		r= reset;
		p = panel;

	}
	
    //keeps track of how many times the mouse is clicked in the window 
    @Override
	public void mousePressed(MouseEvent e) {
        count++;
		toDisplay="Mouse press count: " + count;
		System.out.println("mousePressed: " + e);
		e.getComponent().repaint();
	}
	//rests the value of count and changes the display so it actually shows the value being reset 
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==r){
			count = 0;
			toDisplay="Mouse press count: " + count;
			System.out.println("mousePressed: " + e);
			p.repaint();

		}
	}
    public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}

	
