package test2_2;

import java.util.Random;

/**
 * @version: V1.1
 * @author: 张宥一
 * @className: BinaryOperation
 * @packageName: test2_2
 * @description: 算式类，生成加减法算式以及结果
 * @data: 2019-11-27
 **/
public abstract class BinaryOperation {
    /** 算式最大值 */
    static final int upper = 100;
    /** 算式最小值 */
    static final int lower = 0;
    /** 初始化左操作数 */
    private int left_operand = 0;
    /** 初始化右操作数 */
    private int right_operand = 0;
    /** 初始化操作符 */
    private char operator = '+';

    /**
     * @methodsName: generateBinaryOperation
     * @description: 构造加法或减法算式
     * @param anOperator 算式的运算符号
    */
    protected void generateBinaryOperation(char anOperator) {
        int left;// 左操作数
        int right;// 右操作数
        int result;// 结果
        Random random = new Random();
        left = random.nextInt(upper + 1);// 随机生成左操作数
        do {
            right = random.nextInt(upper + 1);// 随机生成右操作数
            result = calculate(left, right);// 结果需要调用calculate方法
        } while (!(checkingCalculation(result)));// 调用方法，结果必须满足约束
        left_operand = left;// 赋值给成员变量
        right_operand = right;// 赋值给成员变量
        operator = anOperator;// 赋值给成员变量
    }

    /**检查是否符合算式标准 */
    abstract boolean checkingCalculation(int anInteger);

    /**计算算式结果*/
    abstract int calculate(int left, int right);

    /**
     * @methodsName: equals
     * @description: 该对象的数字符号与另一个对象的数字符号做比较，起到检查是否重复的作用
     * @param anOperator BinaryOperation类的实例
    */
    public boolean equals(BinaryOperation anOperation) {
        return operator == anOperation.getOperator() && right_operand == anOperation.getright_operand()
                && left_operand == anOperation.getleft_operand();
    }

    /**
     * @methodsName: toString
     * @description: 返回算式
     * @return: 算式格式
    */
    public String toString() {
        String s;
        String Charop = String.valueOf(operator);
        s = left_operand + Charop + right_operand + "=";
        return s;
    }

    /**
     * @methodsName: getOperator
     * @description: 返回操作符
     * @return: operator
    */
    public char getOperator() {
        return operator;
    }

    /**
     * @methodsName: getleft_operand
     * @description: 返回左操作数
     * @return: left_operand
    */
    public int getleft_operand() {
        return left_operand;
    }

    /**
     * @methodsName: getright_operand
     * @description: 返回右操作数
     * @return: right_operand
    */
    public int getright_operand() {
        return right_operand;
    }

}
