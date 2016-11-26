package front;

import static back.Calculate.calculate;
import static back.StoreAndRestore.getBackResult;
import static back.StoreAndRestore.setBackResult;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalBtn extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3844880290601819738L;
	// The number and operation buttons.
	private static JButton[][] jButtons = new JButton[4][];
	// The area showing calculation result.
	private static JTextField jTextField = new JTextField();
	// Two operands and final result.
	private static double op1, op2;
	// Define the operation.
	private static char operationChar;
	// To control user's input
	private static boolean canInputAnotherDot = true, hasInputAnOperationChar = true;

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
			// Set all the buttons.(New)
			jButtons[0] = new JButton[] { new JButton("7"), new JButton("8"), new JButton("9"), new JButton("+") };
			jButtons[1] = new JButton[] { new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-") };
			jButtons[2] = new JButton[] { new JButton("1"), new JButton("2"), new JButton("3"), new JButton("*") };
			jButtons[3] = new JButton[] { new JButton("0"), new JButton("."), new JButton("="), new JButton("/") };
			// Add action listener to all buttons.
			for (JButton[] jButtons2 : jButtons)
				for (JButton jButton : jButtons2) {
					jButton.addActionListener(this);
					add(jButton);
				}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String text = ((JButton) e.getSource()).getText();
			// Use regular expression to know which button has been pressed.
			Pattern pattern1 = Pattern.compile("[0-9]"), pattern2 = Pattern.compile("[+,-,*,/]");
			Matcher matcher = pattern1.matcher(text);
			// If the input is a number.
			if (matcher.matches()) {
				if (!(text.equals("0") && jTextField.getText().equals("0")))
					jTextField.setText(jTextField.getText() + text);
			} else if (text.equals(".")) {
				if (canInputAnotherDot) {
					jTextField.setText(jTextField.getText() + text);
					canInputAnotherDot = false;
				}
			} else if (text.equals("=")) {
				op2 = Double.valueOf(jTextField.getText());
				jTextField.setText(calculate(op1, op2, operationChar));
//				op1 = Double.valueOf(jTextField.getText());
			} else {
				// If the input is an operation character.
				matcher = pattern2.matcher(text);
				if (matcher.matches() && hasInputAnOperationChar) {
					hasInputAnOperationChar = false;
					canInputAnotherDot = true;
					op1 = Double.valueOf(jTextField.getText());
					// Get the operation.
					operationChar = text.toCharArray()[0];
					// Clear the first operator.
					jTextField.setText("");
				}
			}
		}
	}

	public static void setJtf(String text) {
		jTextField.setText(text);
	}

	public static void setcanInputAnotherDot(boolean b) {
		canInputAnotherDot = b;
	}

	public static void hasInputAnOperationChar(boolean b) {
		hasInputAnOperationChar = b;
	}

	public static void open() {
		setcanInputAnotherDot(true);
		hasInputAnOperationChar(true);
		jTextField.setText(String.valueOf(getBackResult()));
	}

	public static void save() {
		setcanInputAnotherDot(true);
		hasInputAnOperationChar(true);
		setBackResult(Double.parseDouble(calculate(op1, op2, operationChar)));
	}
}
