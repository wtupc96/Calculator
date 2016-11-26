package back;

public class Calculate {
	public strictfp static String calculate(double op1, double op2, char ch) {
		double result = 0;
		switch (ch) {
		case '+':
			result = op1 + op2;
			break;
		case '-':
			result = op1 - op2;
			break;
		case '*':
			result = op1 * op2;
			break;
		case '/':
			result = op1 / op2;
			break;
		default:
			break;
		}
		if ((int) result == result)
			return String.valueOf((int) result);
		else
			return String.valueOf(result);

	}
}
