package test2_1;

/**
 * @version: V1.0
 * @author: ���һ
 * @className: Exercise
 * @packageName: test2_1
 * @description: ϰ���࣬����50�����ظ�����ʽ
 * @data: 2019-11-26
 **/
public class Exercise {

    /** ÿ�����5�� */
    private static final short COLUMN_NUMBER = 5;
    /** ���50����ʽ */
    private static final short OPERATION_NUMBER = 50;
    /** ����һ������λ50������ */
    BinaryOperation operationList[] = new BinaryOperation[OPERATION_NUMBER];

    /**
     * @methodsName: generateBinaryExercise
     * @description: �Ѳ��ظ��Ļ����ʽ����������
    */
    public void generateBinaryExercise() {
        BinaryOperation anOperation = new BinaryOperation();// ����һ���µĶ���
        BinaryOperation opCreator = new BinaryOperation();// ����һ���µĶ���
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateBinaryOperation();
            while (contains(anOperation, i) == false) {// ����contains���ж���ʽ�Ƿ��ظ�
                anOperation = opCreator.generateBinaryOperation();
            }
            operationList[i] = anOperation;// û���ظ�����������
        }
    }

    /**
     * @methodsName: generateAdditionExercise
     * @description: �Ѳ��ظ��ļӷ���ʽ����������
    */
    public void generateAdditionExercise() {
        BinaryOperation anOperation = new BinaryOperation();// ����һ���µĶ���
        BinaryOperation opCreator = new BinaryOperation();// ����һ���µĶ���
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateAdditionOperation();
            while (contains(anOperation, i) == false) {// ����contains���ж���ʽ�Ƿ��ظ�
                anOperation = opCreator.generateAdditionOperation();
            }
            operationList[i] = anOperation;// û���ظ�����������
        }
    }

    /**
     * @methodsName: generateSubstractExercise
     * @description: �Ѳ��ظ��ļ�����ʽ����������
    */
    public void generateSubstractExercise() {
        BinaryOperation anOperation = new BinaryOperation();// ����һ���µĶ���
        BinaryOperation opCreator = new BinaryOperation();// ����һ���µĶ���
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateSubstractOperation();
            while (contains(anOperation, i) == false) {// ����contains���ж���ʽ�Ƿ��ظ�
                anOperation = opCreator.generateSubstractOperation();
            }
            operationList[i] = anOperation;// û���ظ�����������
        }
    }

    /**
     * @methodsName: contains
     * @description: ������ʽ���õ��ӷ��������ʽ�Ľ��
     * @param1 anOperation BinaryOperation���ʵ��
     * @param2 length ���鵱ǰ����
     * @return1 false �������ظ�����ʽ
     * @return2 true ����������ʽ
    */
    public boolean contains(BinaryOperation anOperation, int length) {
        for (int i = 0; i < length; i++) {
            if (anOperation.equals(operationList[i]) == true) {
                return false;
            }
        }
        return true;
    }

    /**
     * @methodsName: formattedDisplay
     * @description: ����Exercise��������ʽ���涨��ʽ��ʾ���
     * @param1 ex Exercise���ʵ��
     * @param2 columns һ����ʾcolums����ʽ
    */
    public void formattedDisplay(Exercise ex, int columns) {
        int col = columns;// һ����columns����ʽ
        int num = 0;// ��ʼ����ʽ�����
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            col--;
            num++;
            System.out.printf("%-5s%-15s", num + ".", operationList[i]);// �����ʽ
            if (col == 0) {// col=0����һ��������5��
                System.out.println("");// ����
                col = columns;// ���н�������һ�θ�ֵ
            }
        }
    }

    /**
     * @methodsName: formattedDisplay
     * @description: ����formattedDisplay
     * @param ex Exercise���ʵ��
    */
    public void formattedDisplay(Exercise ex) {
        formattedDisplay(ex, COLUMN_NUMBER);
    }

}
