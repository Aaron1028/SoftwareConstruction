package test;

import java.io.Serializable;
import java.util.Random;

abstract class BinaryOperation implements Serializable {
    int UPPER = 100;
    int LOWER = 0;
    int left_operand = 0;
    int right_operand = 0;
    char operator = '+';
    int value = 0;

    // ÷ÿ‘ÿpublic String toString
    public String toString() {
        String s;
        String Charop = String.valueOf(operator);
        s = left_operand + Charop + right_operand + "=";
        return s;
    }

    protected void generateBinaryOperation(char anOperator) {
        int left, right, result;
        Random random = new Random();
        left = random.nextInt(UPPER + 1);
        do {
            right = random.nextInt(UPPER + 1);
            result = calculate(left, right);
        } while (!(checkingCalculation(result)));
        left_operand = left;
        right_operand = right;
        operator = anOperator;
        value = result;
    }

    public int getLeftOperand() {
        return left_operand;
    }

    public int getRightOperand() {
        return right_operand;
    }

    public char getOperator() {
        return operator;
    }

    abstract boolean checkingCalculation(int anInteger);

    abstract int calculate(int left, int right);

    public boolean equals(BinaryOperation anOperation) {
        return left_operand == anOperation.getLeftOperand() && right_operand == anOperation.getRightOperand()
                && operator == anOperation.getOperator();
    }
}

class AdditionOperation extends BinaryOperation {
    AdditionOperation() {
        // TODO Auto-generated constructor stub
        generateBinaryOperation('+');
    }

    @Override
    public boolean checkingCalculation(int anInteger) {
        // TODO Auto-generated method stub
        if (anInteger <= UPPER) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int calculate(int left, int right) {
        // TODO Auto-generated method stub
        return left + right;
    }

}

class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        // TODO Auto-generated constructor stub
        generateBinaryOperation('-');
    }

    @Override
    public boolean checkingCalculation(int anInteger) {
        // TODO Auto-generated method stub
        if (anInteger >= LOWER) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int calculate(int left, int right) {
        // TODO Auto-generated method stub
        return left - right;
    }

}
