package test3;

/**
 * @version: V2.1
 * @author: ���һ
 * @className: AdditionOperation
 * @packageName: test3
 * @description: �ӷ��࣬BinaryOperation�������
 * @data: 2019-12-14
 **/
class AdditionOperation extends BinaryOperation {
    AdditionOperation() {
        generateBinaryOperation('+');// �ѼӺŸ�ֵ��generateBinaryOperation
    }

    /**
     * @methodsName: checkingCalculation
     * @description: ������д��ʹ�������ʽ���Ϲ涨�ļӷ���ʽ��׼
     * @param anInteger �ӷ���ʽ�Ľ��
     * @return1: true �ӷ���ʽ���С�ڵ���upper�����ϱ�׼
     * @return2: false �ӷ���ʽ�������upper�������ϱ�׼
    */
    @Override
    public boolean checkingCalculation(int anInteger) {
        if (anInteger <= upper) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @methodsName: Calculation
     * @description: ������д��������ʽ���
     * @param1: left �������
     * @param2: right �Ҳ�����
     * @return: �ӷ�����ʽ���
    */
    @Override
    int calculate(int left, int right) {
        return left + right;
    }
}
