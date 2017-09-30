import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main Class.
 */
public class MainClass extends JFrame {

	/** The button panel. */
	protected static JPanel cardPanel, jp1, jp2, buttonPanel;

	/** The btn 2. */
	protected static JButton btn1, btn2;
	
	/** The card layout. */
	protected static CardLayout cardLayout = new CardLayout();

	/**
	 * Constructor
	 */
	public MainClass() {

		setTitle("Weather Report");
		setSize(770, 470);
		setResizable(false);
		setLocationRelativeTo(null);
		cardPanel = new JPanel();
		buttonPanel = new JPanel();

		buttonPanel.setBackground(java.awt.Color.LIGHT_GRAY);

		cardPanel.setLayout(cardLayout);

		jp1 = new MapClass();
		jp2 = new SearchPNL();

		cardPanel.add(jp2, "2");
		cardPanel.add(jp1, "1");

		btn1 = new JButton("Results");
		btn1.setVisible(false);
		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
			}
		});

		btn2 = new JButton("Search");
		btn2.setVisible(false);

		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SearchPNL.userInput.setValue(0);
				SearchPNL.userInput.repaint();
				cardLayout.show(cardPanel, "2");

			}
		});

		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		add(cardPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		MainClass frame = new MainClass();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
