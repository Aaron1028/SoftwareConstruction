package test2_2;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {

    /**��¼���Exercise����ʽ���� */
    private int OperationCount = 0;
    /**��¼��ǰ����λ�� */
    private int current = 0;
    /**ArrayList�����������޶���BinaryOperation����� */
    private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();

    /**
     * @methodsName: generateAdditionExercise
     * @description: ��������generateOperation��������ɼӷ���ʽ����������
     * @param: operationCount ��¼��ǰ����λ��
    */
    public void generateAdditionExercise(int operationCount) {
        operationList.clear();// ���operationList����
        current = 0;// ��ʼ����ǰ����λ��
        OperationCount = operationCount;// ��ֵ����Ա����
        BinaryOperation anOperation1;// anOperation1����BinaryOperation��
        while (operationCount > 0) {
            do {
                anOperation1 = new AdditionOperation();// �������ñ���
            } while (contains(anOperation1));// ����contains��������ʽ���ظ�������ѭ��
            operationList.add(anOperation1);// ��anOperation ���뵽Exercise��
            operationCount--;
        }
    }

    /**
     * @methodsName: generateSubstractExercise
     * @description: ��������generateOperation��������ɼ�����ʽ����������
     * @param: operationCount ��¼��ǰ����λ��
    */
    public void generateSubstractExercise(int operationCount) {
        operationList.clear();// ���operationList����
        current = 0;// ��ʼ����ǰ����λ��
        OperationCount = operationCount;// ��ֵ����Ա����
        BinaryOperation anOperation1;// anOperation1����BinaryOperation��
        while (operationCount > 0) {
            do {
                anOperation1 = new SubstractOperation();// �������ñ���
            } while (contains(anOperation1));// ����contains��������ʽ���ظ�������ѭ��
            operationList.add(anOperation1);// ��anOperation ���뵽Exercise��
            operationCount--;
        }
    }

    /**
     * @methodsName: generateBinaryExercise
     * @description: ��������generateOperation��������ɼӷ���ʽ����������
     * @param: operationCount ��¼��ǰ����λ��
    */
    public void generateBinaryExercise(int operationCount) {
        operationList.clear();// ���operationList����
        current = 0;// ��ʼ����ǰ����λ��
        OperationCount = operationCount;// ��ֵ����Ա����
        BinaryOperation anOperation;// anOperation1����BinaryOperation��
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();// �������ñ���
            } while (contains(anOperation));// ����contains��������ʽ���ظ�������ѭ��
            operationList.add(anOperation);// ��anOperation ���뵽Exercise��
            operationCount--;
        }
    }

    /**
     * @methodsName: generateOperation
     * @description: �������һ���ӷ����߼�����ʽ������
     * @return1: AdditionOperation() BinaryOperation������
     * @return2: SubstractOperation()  BinaryOperation������
    **/
    private BinaryOperation generateOperation() {
        Random random = new Random();
        int opValue = random.nextInt(2);// �������1����0
        if (opValue == 1) {
            return new AdditionOperation();// ����1�������ɼӷ���ʽ
        }
        return new SubstractOperation();// ����0�������ɼӷ���ʽ
    }

    /**
     * @methodsName: hasNext
     * @description: ��������Ƿ���Ԫ�أ��򷵻��ǣ����򷵻ط�
     * @param1: true ���黹��Ԫ��
     * @param2: false ����û��Ԫ��
    */
    public boolean hasNext() {
        return current <= operationList.size() - 1;
    }

    /**
     * @methodsName: next
     * @description: �����Ԫ�أ���ǰ����λ���ƶ�����һ��λ��
     * @return: ���ص�ǰԪ��
    **/
    public BinaryOperation next() {
        return operationList.get(current++);
    }

    /**
     * @methodsName: contains
     * @description: ������ʽ���õ��ӷ��������ʽ�Ľ��
     * @param: anOperation BinaryOperation���ʵ��
     * @return1: flag(true)  �����ɵ���ʽ���������ʽ�ظ�
     * @return2: flag(false) �����ɵ���ʽ���������ʽû���ظ�
    */
    public boolean contains(BinaryOperation anOperation) {
        boolean flag = true;// ������flag��Ϊtrue
        int size = operationList.size();// ���鳤��
        if (size == 0) {
            return false;// ���������û����ʽ������false�������������
        }
        for (int i = 0; i < size; i++) {// �����������е���ʽ�������ɵ���ʽ���Ƚϣ�����Ƿ�����ظ�
            if (!operationList.get(i).equals(anOperation)) {
                flag = false;// û���ظ�
            }
        }
        return flag;
    }
}
