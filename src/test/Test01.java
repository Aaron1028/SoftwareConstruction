package test;
import java.util.Random;
public class Test01 {
	static final int UPPER = 100;
	static final int LOWER = 0;
	private static int left_operand = 0;
	private static int right_operand = 0;
	private static char operator = '+';
	private static int value = 0;
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int op;
			left_operand = random.nextInt(UPPER + 1);
			right_operand = random.nextInt(UPPER + 1);
			op = random.nextInt(2);
			if (op == 1) {
				operator = '+';
				value = left_operand + right_operand;
			} else {
				operator = '-';
				value = left_operand - right_operand;
			}
			System.out.println("" + (i + 1) + ":\t" + left_operand + operator
					+ right_operand + "=");
		}
	}
}
