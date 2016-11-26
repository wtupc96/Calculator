package front;

import static back.Calculate.calculate;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalBtn extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3844880290601819738L;
	// The number and operation buttons.
	private static JButton[][] jButtons = new JButton[4][4];
	// The area showing calculation result.
	private static JTextField jTextField = new JTextField();
	// Two operands and final result.
	private static double op1, op2, result = 0;
	// Define the operation.
	private static char ch;
	// To control user's input
	private static boolean flag1 = true, flag2 = true;

	public CalBtn() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout(2, 2));
		add(jTextField, BorderLayout.NORTH);
		add(new MainBtn(), BorderLayout.CENTER);

	}

	// Inner class intended for all buttons.
	class MainBtn extends JPanel implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1993959670179184498L;

		public MainBtn() {
			// TODO Auto-generated constructor stub
			setLayout(new GridLayout(4, 4));
			// Set all buttons(Old version).
			// for (int i = 0; i < 4; ++i)
			// for (int j = 0; j < 4; ++j) {
			// if (j == 3)
			// switch (i) {
			// case 0:
			// jButtons[i][j] = new JButton("+");
			// break;
			// case 1:
			// jButtons[i][j] = new JButton("-");
			// break;
			// case 2:
			// jButtons[i][j] = new JButton("*");
			// break;
			// case 3:
			// jButtons[i][j] = new JButton("¡Â");
			// break;
			// default:
			// break;
			// }
			// else if (i == 3 && j == 1)
			// jButtons[i][j] = new JButton(".");
			// else if (i == 3 && j == 2)
			// jButtons[i][j] = new JButton("=");
			// else
			// jButtons[i][j] = new JButton(String.valueOf(((3 - i) * 3 - j)));
			//
			// jButtons[i][j].addActionListener(this);
			//
			// add(jButtons[i][j]);
			// }
			
			// Set all the buttons.(New)
			jButtons[0] = new JButton[]{new JButton("7"),new JButton("8"),new JButton("9"),new JButton("+")};
			jButtons[1] = new JButton[]{new JButton("4"),new JButton("5"),new JButton("6"),new JButton("-")};
			jButtons[2] = new JButton[]{new JButton("1"),new JButton("2"),new JButton("3"),new JButton("*")};
			jButtons[3] = new JButton[]{new JButton("0"),new JButton("."),new JButton("="),new JButton("¡Â")};
			// Add action listener to all buttons.
			for (JButton[] jButtons2 : jButtons)
				for (JButton jButton : jButtons2){
					jButton.addActionListener(this);
					add(jButton);
				}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String text;
			switch (text = ((JButton) e.getSource()).getText()) {
			case "9":
			case "8":
			case "7":
			case "6":
			case "5":
			case "4":
			case "3":
			case "2":
			case "1":
				jTextField.setText(jTextField.getText() + text);
				break;
			case "0":
				if (jTextField.getText().length() != 0)
					jTextField.setText(jTextField.getText() + text);
				break;
			case ".":
				if (flag1) {
					jTextField.setText(jTextField.getText() + text);
					flag1 = false;
				}
				break;
			case "+":
				if (flag2) {
					op1 = Double.valueOf(jTextField.getText());
					jTextField.setText("");
					ch = '+';
					flag2 = false;
					flag1 = true;
				}
				break;
			case "-":
				if (flag2) {
					op1 = Double.valueOf(jTextField.getText());
					jTextField.setText("");
					ch = '-';
					flag2 = false;
					flag1 = true;
				}
				break;
			case "*":
				if (flag2) {
					op1 = Double.valueOf(jTextField.getText());
					jTextField.setText("");
					ch = '*';
					flag2 = false;
					flag1 = true;
				}
				break;
			case "Ã·":
				if (flag2) {
					op1 = Double.valueOf(jTextField.getText());
					jTextField.setText("");
					ch = '/';
					flag2 = false;
					flag1 = true;
				}
				break;
			case "=":
				// jTextField.setText();
				op2 = Double.valueOf(jTextField.getText());
				jTextField.setText(calculate(op1, op2, ch));
				break;
			default:
				break;
			}
		}

	}

	public static void setJtf(String text) {
		jTextField.setText(text);
	}

	public static void setFlag1(boolean b) {
		flag1 = b;
	}

	public static void setFlag2(boolean b) {
		flag2 = b;
	}

	public static void setFlag3(boolean b) {
	}

	public static void open() {
		setFlag1(true);
		setFlag2(true);
		setFlag3(true);
		jTextField.setText(String.valueOf(result));
	}

	public static void save() {
		setFlag1(true);
		setFlag2(true);
		setFlag3(true);
		result = Double.parseDouble(calculate(op1, op2, ch));
	}
}
