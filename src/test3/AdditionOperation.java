package test3;

/**
 * @version: V2.1
 * @author: 张宥一
 * @className: AdditionOperation
 * @packageName: test3
 * @description: 加法类，BinaryOperation类的子类
 * @data: 2019-12-14
 **/
class AdditionOperation extends BinaryOperation {
    AdditionOperation() {
        generateBinaryOperation('+');// 把加号赋值给generateBinaryOperation
    }

    /**
     * @methodsName: checkingCalculation
     * @description: 方法重写，使该类的算式符合规定的加法算式标准
     * @param anInteger 加法算式的结果
     * @return1: true 加法算式结果小于等于upper，符合标准
     * @return2: false 加法算式结果大于upper，不符合标准
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
     * @description: 方法重写，计算算式结果
     * @param1: left 左操作数
     * @param2: right 右操作数
     * @return: 加法的算式结果
    */
    @Override
    int calculate(int left, int right) {
        return left + right;
    }
}
