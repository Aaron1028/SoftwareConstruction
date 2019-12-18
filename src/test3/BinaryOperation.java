package test3;

import java.util.Random;

/**
 * @version: V2.1
 * @author: ���һ
 * @className: BinaryOperation
 * @packageName: test3
 * @description: ��ʽ�࣬���ɼӼ�����ʽ�Լ����
 * @data: 2019-11-27
 **/
public abstract class BinaryOperation {
    /** ��ʽ���ֵ */
    static final int upper = 100;
    /** ��ʽ��Сֵ */
    static final int lower = 0;
    /** ��ʼ��������� */
    private int left_operand = 0;
    /** ��ʼ���Ҳ����� */
    private int right_operand = 0;
    /** ��ʼ�������� */
    private char operator = '+';
    /** ��ʼ����� */
    private int value = 0;

    public void insert(String left, String right) {
        // ������insertͨ�����������������ֱ�Ӳ�����ʽ
        left_operand = Integer.valueOf(left);
        right_operand = Integer.valueOf(right);
        value = calculate(left_operand, right_operand);
    }

    public void insert(int left, int right) {
        // ������int������insert
        left_operand = left;
        right_operand = right;
        value = calculate(left_operand, right_operand);
    }

    /**
     * @methodsName: generateBinaryOperation
     * @description: ����ӷ��������ʽ
     * @param anOperator ��ʽ���������
    */
    protected void generateBinaryOperation(char anOperator) {
        int left;// �������
        int right;// �Ҳ�����
        int result;// ���
        Random random = new Random();
        left = random.nextInt(upper + 1);// ��������������
        do {
            right = random.nextInt(upper + 1);// ��������Ҳ�����
            result = calculate(left, right);// �����Ҫ����calculate����
        } while (!(checkingCalculation(result)));// ���÷����������������Լ��
        left_operand = left;// ��ֵ����Ա������ͬ��
        right_operand = right;
        operator = anOperator;
        value = result;
    }

    /**����Ƿ������ʽ��׼ */
    abstract boolean checkingCalculation(int anInteger);

    /**������ʽ���*/
    abstract int calculate(int left, int right);

    /**
     * @methodsName: equals
     * @description: �ö�������ַ�������һ����������ַ������Ƚϣ��𵽼���Ƿ��ظ�������
     * @param anOperator BinaryOperation���ʵ��
    */
    public boolean equals(BinaryOperation anOperation) {
        return operator == anOperation.getOperator() && right_operand == anOperation.getright_operand()
                && left_operand == anOperation.getleft_operand();
    }

    /**
     * @methodsName: toString
     * @description: ������ʽ
     * @return: ��ʽ��ʽ
    */
    public String toString() {
        String s;
        String Charop = String.valueOf(operator);
        s = left_operand + Charop + right_operand + "=";
        return s;
    }

    /**
     * @methodsName: getOperator
     * @description: ���ز�����
     * @return: operator
    */
    public char getOperator() {
        return operator;
    }

    /**
     * @methodsName: getleft_operand
     * @description: �����������
     * @return: left_operand
    */
    public int getleft_operand() {
        return left_operand;
    }

    /**
     * @methodsName: getright_operand
     * @description: �����Ҳ�����
     * @return: right_operand
    */
    public int getright_operand() {
        return right_operand;
    }

    /**
     * @methodsName: getvalue
     * @description: ���ؽ��
     * @return: value
    */
    public int getvalue() {
        return value;
    }
}
