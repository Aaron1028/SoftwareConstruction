package test2_2;

/**
 * @version: V1.1
 * @author: ���һ
 * @className: SubstractOperation
 * @packageName: test2_2
 * @description: �����࣬BinaryOperation�������
 * @data: 2019-11-27
 **/
class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        generateBinaryOperation('-');// �Ѽ��Ÿ�ֵ��generateBinaryOperation
    }

    /**
     * @methodsName: checkingCalculation
     * @description: ������д��ʹ�������ʽ���Ϲ涨�ļ�����ʽ��׼
     * @param anInteger ������ʽ�Ľ��
     * @return1: true ������ʽ���С�ڵ���lower�����ϱ�׼
     * @return2: false ������ʽ�������lower�������ϱ�׼
    */
    @Override
    public boolean checkingCalculation(int anInteger) {
        if (anInteger >= lower) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @methodsName: checkingCalculation
     * @description: ������д��������ʽ���
     * @param1: left �������
     * @param2: right �Ҳ�����
     * @return: ��������ʽ���
    */
    @Override
    int calculate(int left, int right) {
        return left - right;
    }
}
