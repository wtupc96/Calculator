package back;

public class Calculate {
	public strictfp static String calculate(double op1, double op2, char ch) {
		switch (ch) {
		case '+':
			return String.valueOf(op1 + op2);
		case '-':
			return String.valueOf(op1 - op2);
		case '*':
			return String.valueOf(op1 * op2);
		case '¡Â':
			return String.valueOf(op1 / op2);
		default:
			break;
		}
		return null;
	}
}
