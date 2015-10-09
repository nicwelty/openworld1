package openworld1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UIOpen {
	JTextField input;
	JTextArea output = new JTextArea();
	JButton btnConfirm = new JButton("Confirm");
	JButton btnAttack = new JButton("ATTACK!!");
	JTextArea txtrEnemy = new JTextArea();
	JTextArea txtrYou = new JTextArea();
	boolean ConfirmPressed = false;
	boolean attackPressed = false;
	JComboBox comboBox = new JComboBox();
	JTextArea txtrYourMissions = new JTextArea();
	/**
	 * @wbp.parser.entryPoint
	 */
	public UIOpen() {
		JFrame window = new JFrame("Window v:1.0");
		window.getContentPane().setLayout(null);
		window.setIconImage(new ImageIcon(getClass().getResource("icon_64.png"))
				.getImage());
		input = new JTextField();
		input.setToolTipText("Type a command or response");
		input.setBounds(10, 390, 310, 20);
		window.getContentPane().add(input);
		input.setColumns(10);
		
		
		output.setBounds(330, 11, 692, 399);
		window.getContentPane().add(output);
		comboBox.setToolTipText("Weapon...");
		
		comboBox.setBounds(10, 276, 102, 20);
		window.getContentPane().add(comboBox);
		
		
		btnConfirm.setBackground(Color.GREEN);
		btnConfirm.setBounds(231, 356, 89, 23);
		btnConfirm.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent e){
			ConfirmPressed = true;
		}});
		window.getContentPane().add(btnConfirm);
		
		
		btnAttack.setBackground(Color.RED);
		btnAttack.setBounds(7, 307, 89, 23);
		btnAttack.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent e){
			attackPressed = true;
		}});
		window.getContentPane().add(btnAttack);
		
		
		txtrEnemy.setText("Enemy:");
		txtrEnemy.setToolTipText("Enemy:");
		txtrEnemy.setBounds(106, 13, 89, 252);
		window.getContentPane().add(txtrEnemy);
		
		
		txtrYou.setEditable(false);
		txtrYou.setText("You:");
		txtrYou.setBounds(10, 11, 86, 254);
		window.getContentPane().add(txtrYou);
		txtrYourMissions.setText("Your Missions:");
		txtrYourMissions.setBounds(1032, 11, 268, 399);
		
		window.getContentPane().add(txtrYourMissions);
		window.setVisible(true);
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
				if(ConfirmPressed == true){
					output.setText(text);
					ConfirmPressed = false;
					return;
				}
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
					sleep = 0.25;
					break;
				case '(':
				case ')':
				case '[':
				case ']':
				case '{':
				case '}':
					sleep = 0.09;
					break;
				case '~':
				case ' ':
					sleep = 0;
					break;
				}
				sleep(sleep);
			}
			sleep = 0.5;
		}
		ConfirmPressed = false;
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
