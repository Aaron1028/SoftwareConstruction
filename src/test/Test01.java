package test;
import java.util.Random;
public class Test01 {
	static final int UPPER = 100;
	static final int LOWER = 0;
	private static int left_operand = 0;
	private static int right_operand = 0;
	private static char operator = '+';
	private static int value = 0;
	static int[][] arr = new int[50][3];
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			do {
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
				arr[i][0] = left_operand;
				arr[i][1] = right_operand;
				arr[i][2] = op;
			} while (value >= 100 || value <= 0);

			if (i % 5 == 0) {
				System.out.print("\n");
				System.out.print((i + 1) + "~" + (i + 5) + ":");
			}
			System.out.print(
					"\t" + left_operand + operator + right_operand + "=");
		}
	}
}
