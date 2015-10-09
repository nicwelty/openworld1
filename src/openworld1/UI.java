package openworld1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI implements KeyListener {
	// Scanner scan = new Scanner (System.in);
	JFrame window = new JFrame("Window v:1.0");
	JPanel panel1 = new JPanel();
	JTextArea output = new JTextArea(40, 50);
	JTextArea map = new JTextArea(40, 50);
	JTextArea inv = new JTextArea(40, 50);
	JTextField input = new JTextField(40);
	String outText;
	static boolean wPressed;
	int width = 1360;
	int height = 700;

	/**
	 * @wbp.parser.entryPoint
	 */
	public UI() {
		panel1.setSize(new Dimension(width, height));

		input.addKeyListener(this);

		inv.setEditable(false);
		inv.setText("Inventory and Stats:");

		map.setEditable(false);
		map.setText("Current Area:");

		output.setEditable(false);

		window.getContentPane().add(map, BorderLayout.CENTER);
		window.getContentPane().add(inv, BorderLayout.EAST);
		window.getContentPane().add(output, BorderLayout.WEST);
		window.getContentPane().add(input, BorderLayout.SOUTH);

		// String s1 = scan.next();

		// window.setSize(width, height);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setFocusable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setVisible(true);

	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void sleep(double seconds) {
		double ms = seconds * 1000;
		try {
			Thread.sleep((long) ms);
		} catch (Exception x) {
			System.err.println("The Sleep function threw an Exception");
		}
	}

	public void appendText(String text) {
		double sleep;
		char cha;
		String[] lines = text.split("[|]");
		for (String line : lines) {
			for (int i = 0; i < line.length(); i++) {
				cha = line.charAt(i);
				if (cha == '~') {
					cha = '\n';
				}
				output.setText(output.getText() + cha);
				sleep = 0.025;
				switch (cha) {
				case '.':
				case '?':
				case '!':
					sleep = 0.4;
					break;
				case ',':
				case ':':
					sleep = 0.1;
					break;
				case '(':
				case ')':
				case '[':
				case ']':
				case '{':
				case '}':
					sleep = 0.07;
					break;
				case '~':
				case ' ':
					sleep = 0;
					break;
				}
				sleep(sleep);
			}
			output.setText(output.getText() + "\n");
			sleep(1.0);
		}
	}
	
	
	
	
	
	
	public void newEvent(String text) {
		output.setText(text);
	}

	public static int stringToInteger(String s) {
		String str = s;
		Integer temp = 0;
		int number = 0;
		temp = Integer.parseInt(s);
		number = temp;
		return number;
	}

	public static void main(String[] args) {
		
	}

}
