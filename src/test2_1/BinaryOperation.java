package test2_1;

import java.util.Random;

/**
 * @version: V1.0
 * @author: 张宥一
 * @className: BinaryOperation
 * @packageName: test2_1
 * @description: 算式类，生成加减法算式以及结果
 * @data: 2019-11-26
 **/
public class BinaryOperation {

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
    /** 初始化算式结果 */
    private int value = 0;

    /**
     * @methodsName: construct
     * @description: 构造算式，得到加法或减法算式的结果
     * @param1 left 左操作数
     * @param2 right 右操作数
     * @param3 op 操作符
    */
    void construct(int left, int right, char op) {
        left_operand = left;// 左操作数
        right_operand = right;// 右操作数
        operator = op;// 操作符
        if (op == '+') {
            value = left + right;// 得到加法结果
        } else {
            value = left - right;// 得到减法结果
        }
    }

    /**
     * @methodsName: generateBinaryOperation
     * @description: 产生加减法混合算式
     * @return: bop BinaryOperation类的实例
    **/
    public BinaryOperation generateBinaryOperation() {
        Random random = new Random();
        int left;// 左操作数
        int right;// 右操作数
        int op;// 表示操作符
        int result;// 结果
        BinaryOperation bop = new BinaryOperation();// 创建一个新的对象
        left = random.nextInt(upper + 1); // 随机生成左操作数
        do {
            right = random.nextInt(upper + 1); // 随机生成右操作数
            op = random.nextInt(2); // 随机生成0或1
            if (op == 1) {
                result = left + right;// 生成1则为加法
                bop.construct(left, right, '+'); // 掉用方法得到算式结果
            } else {
                result = left - right;// 生成0则为减法
                bop.construct(left, right, '-'); // 调用方法得到算式结果
            }
        } while (result > upper || result < lower);// do-while循环控制算式结果大于0，小于100
        return bop;
    }

    /**
     * 构造函数
     * @description: 产生加法算式
     * @return: bop BinaryOperation类的实例
    **/
    public BinaryOperation generateAdditionOperation() {
        Random random = new Random();
        BinaryOperation bop = new BinaryOperation();// 创建一个新的对象
        int left;// 左操作数
        int right;// 右操作数
        int result;// 结果
        left = random.nextInt(upper + 1); // 随机生成左操作数
        do {
            right = random.nextInt(upper + 1); // 随机生称号右操作数
            result = left + right;// 得到结果
        } while (result > upper || result < lower);// do-while循环控制加法算式结果大于0、小于100
        bop.construct(left, right, '+'); // 调用方法得到算式结果
        return bop;
    }

    /**
     * 构造函数
     * @description: 产生减法算式
     * @return: bop BinaryOperation类的实例
    **/
    public BinaryOperation generateSubstractOperation() {
        Random random = new Random();
        BinaryOperation bop = new BinaryOperation();// 创建一个新的对象
        int left;// 左操作数
        int right;// 右操作数
        int result;// 结果
        left = random.nextInt(upper + 1); // 随机生成左操作数
        do {

            right = random.nextInt(upper + 1); // 随机乘车右操作数
            result = left - right;// 得到结果
        } while (result < lower);// do-while循环控制减法算式结果大于0
        bop.construct(left, right, '-'); // 调用方法得到算式结果
        return bop;
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

    /**
     * @methodsName: getValue
     * @description: 返回结果
     * @return: value
    */
    public int getValue() {
        return value;
    }

    /**
     * @methodsName: equals
     * @description: 将该对象的数字符号与另一个对象的数字符号做比较，起到检查是否重复的作用
     * @param anOperation BinaryOperation类的实例
     * @return1: true 重复了
     * @return2: false 没有重复
    */
    public boolean equals(BinaryOperation anOperation) {
        return operator == anOperation.getOperator() && right_operand == anOperation.getright_operand()
                && left_operand == anOperation.getleft_operand();
    }

    /**
     * @methodsName: toString
     * @description: 返回算式
     * @return: 示例：对运算32+5返回字符串“32+5=”
    */
    public String toString() {
        return " " + left_operand + operator + right_operand + "=";
    }

    /**
     * @methodsName: fullString
     * @description: 返回算式
     * @return: 示例：对运算32+5返回字符串“32+5=37”
    */
    public String fullString() {
        return " " + left_operand + operator + right_operand + "=" + value;
    }

}
