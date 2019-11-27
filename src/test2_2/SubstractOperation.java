package test2_2;

/**
 * @version: V1.1
 * @author: 张宥一
 * @className: SubstractOperation
 * @packageName: test2_2
 * @description: 减法类，BinaryOperation类的子类
 * @data: 2019-11-27
 **/
class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        generateBinaryOperation('-');// 把减号赋值给generateBinaryOperation
    }

    /**
     * @methodsName: checkingCalculation
     * @description: 方法重写，使该类的算式符合规定的减法算式标准
     * @param anInteger 减法算式的结果
     * @return1: true 减法算式结果小于等于lower，符合标准
     * @return2: false 减法算式结果大于lower，不符合标准
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
     * @description: 方法重写，计算算式结果
     * @param1: left 左操作数
     * @param2: right 右操作数
     * @return: 减法的算式结果
    */
    @Override
    int calculate(int left, int right) {
        return left - right;
    }
}
