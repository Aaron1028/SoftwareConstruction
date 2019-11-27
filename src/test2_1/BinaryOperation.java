package test2_1;

import java.util.Random;

/**
 * @version: V1.0
 * @author: ���һ
 * @className: BinaryOperation
 * @packageName: test2_1
 * @description: ��ʽ�࣬���ɼӼ�����ʽ�Լ����
 * @data: 2019-11-26
 **/
public class BinaryOperation {

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
    /** ��ʼ����ʽ��� */
    private int value = 0;

    /**
     * @methodsName: construct
     * @description: ������ʽ���õ��ӷ��������ʽ�Ľ��
     * @param1 left �������
     * @param2 right �Ҳ�����
     * @param3 op ������
    */
    void construct(int left, int right, char op) {
        left_operand = left;// �������
        right_operand = right;// �Ҳ�����
        operator = op;// ������
        if (op == '+') {
            value = left + right;// �õ��ӷ����
        } else {
            value = left - right;// �õ��������
        }
    }

    /**
     * @methodsName: generateBinaryOperation
     * @description: �����Ӽ��������ʽ
     * @return: bop BinaryOperation���ʵ��
    **/
    public BinaryOperation generateBinaryOperation() {
        Random random = new Random();
        int left;// �������
        int right;// �Ҳ�����
        int op;// ��ʾ������
        int result;// ���
        BinaryOperation bop = new BinaryOperation();// ����һ���µĶ���
        left = random.nextInt(upper + 1); // ��������������
        do {
            right = random.nextInt(upper + 1); // ��������Ҳ�����
            op = random.nextInt(2); // �������0��1
            if (op == 1) {
                result = left + right;// ����1��Ϊ�ӷ�
                bop.construct(left, right, '+'); // ���÷����õ���ʽ���
            } else {
                result = left - right;// ����0��Ϊ����
                bop.construct(left, right, '-'); // ���÷����õ���ʽ���
            }
        } while (result > upper || result < lower);// do-whileѭ��������ʽ�������0��С��100
        return bop;
    }

    /**
     * ���캯��
     * @description: �����ӷ���ʽ
     * @return: bop BinaryOperation���ʵ��
    **/
    public BinaryOperation generateAdditionOperation() {
        Random random = new Random();
        BinaryOperation bop = new BinaryOperation();// ����һ���µĶ���
        int left;// �������
        int right;// �Ҳ�����
        int result;// ���
        left = random.nextInt(upper + 1); // ��������������
        do {
            right = random.nextInt(upper + 1); // ������ƺ��Ҳ�����
            result = left + right;// �õ����
        } while (result > upper || result < lower);// do-whileѭ�����Ƽӷ���ʽ�������0��С��100
        bop.construct(left, right, '+'); // ���÷����õ���ʽ���
        return bop;
    }

    /**
     * ���캯��
     * @description: ����������ʽ
     * @return: bop BinaryOperation���ʵ��
    **/
    public BinaryOperation generateSubstractOperation() {
        Random random = new Random();
        BinaryOperation bop = new BinaryOperation();// ����һ���µĶ���
        int left;// �������
        int right;// �Ҳ�����
        int result;// ���
        left = random.nextInt(upper + 1); // ��������������
        do {

            right = random.nextInt(upper + 1); // ����˳��Ҳ�����
            result = left - right;// �õ����
        } while (result < lower);// do-whileѭ�����Ƽ�����ʽ�������0
        bop.construct(left, right, '-'); // ���÷����õ���ʽ���
        return bop;
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
     * @methodsName: getValue
     * @description: ���ؽ��
     * @return: value
    */
    public int getValue() {
        return value;
    }

    /**
     * @methodsName: equals
     * @description: ���ö�������ַ�������һ����������ַ������Ƚϣ��𵽼���Ƿ��ظ�������
     * @param anOperation BinaryOperation���ʵ��
     * @return1: true �ظ���
     * @return2: false û���ظ�
    */
    public boolean equals(BinaryOperation anOperation) {
        return operator == anOperation.getOperator() && right_operand == anOperation.getright_operand()
                && left_operand == anOperation.getleft_operand();
    }

    /**
     * @methodsName: toString
     * @description: ������ʽ
     * @return: ʾ����������32+5�����ַ�����32+5=��
    */
    public String toString() {
        return " " + left_operand + operator + right_operand + "=";
    }

    /**
     * @methodsName: fullString
     * @description: ������ʽ
     * @return: ʾ����������32+5�����ַ�����32+5=37��
    */
    public String fullString() {
        return " " + left_operand + operator + right_operand + "=" + value;
    }

}
