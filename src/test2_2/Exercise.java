package test2_2;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {

    /**记录这个Exercise的算式总数 */
    private int OperationCount = 0;
    /**记录当前访问位置 */
    private int current = 0;
    /**ArrayList的数据类型限定是BinaryOperation对象的 */
    private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();

    /**
     * @methodsName: generateAdditionExercise
     * @description: 方法调用generateOperation，随机生成加法算式并加入数组
     * @param: operationCount 记录当前访问位置
    */
    public void generateAdditionExercise(int operationCount) {
        operationList.clear();// 清空operationList数组
        current = 0;// 初始化当前访问位置
        OperationCount = operationCount;// 赋值给成员变量
        BinaryOperation anOperation1;// anOperation1属于BinaryOperation类
        while (operationCount > 0) {
            do {
                anOperation1 = new AdditionOperation();// 创建引用变量
            } while (contains(anOperation1));// 调用contains方法，算式不重复，结束循环
            operationList.add(anOperation1);// 将anOperation 加入到Exercise中
            operationCount--;
        }
    }

    /**
     * @methodsName: generateSubstractExercise
     * @description: 方法调用generateOperation，随机生成减法算式并加入数组
     * @param: operationCount 记录当前访问位置
    */
    public void generateSubstractExercise(int operationCount) {
        operationList.clear();// 清空operationList数组
        current = 0;// 初始化当前访问位置
        OperationCount = operationCount;// 赋值给成员变量
        BinaryOperation anOperation1;// anOperation1属于BinaryOperation类
        while (operationCount > 0) {
            do {
                anOperation1 = new SubstractOperation();// 创建引用变量
            } while (contains(anOperation1));// 调用contains方法，算式不重复，结束循环
            operationList.add(anOperation1);// 将anOperation 加入到Exercise中
            operationCount--;
        }
    }

    /**
     * @methodsName: generateBinaryExercise
     * @description: 方法调用generateOperation，随机生成加法算式并加入数组
     * @param: operationCount 记录当前访问位置
    */
    public void generateBinaryExercise(int operationCount) {
        operationList.clear();// 清空operationList数组
        current = 0;// 初始化当前访问位置
        OperationCount = operationCount;// 赋值给成员变量
        BinaryOperation anOperation;// anOperation1属于BinaryOperation类
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();// 创建引用变量
            } while (contains(anOperation));// 调用contains方法，算式不重复，结束循环
            operationList.add(anOperation);// 将anOperation 加入到Exercise中
            operationCount--;
        }
    }

    /**
     * @methodsName: generateOperation
     * @description: 随机生成一个加法或者减法算式并返回
     * @return1: AdditionOperation() BinaryOperation的子类
     * @return2: SubstractOperation()  BinaryOperation的子类
    **/
    private BinaryOperation generateOperation() {
        Random random = new Random();
        int opValue = random.nextInt(2);// 随机生成1或者0
        if (opValue == 1) {
            return new AdditionOperation();// 生成1，则生成加法算式
        }
        return new SubstractOperation();// 生成0，则生成加法算式
    }

    /**
     * @methodsName: hasNext
     * @description: 检查数组是否还有元素，则返回是，否则返回否
     * @param1: true 数组还有元素
     * @param2: false 数组没有元素
    */
    public boolean hasNext() {
        return current <= operationList.size() - 1;
    }

    /**
     * @methodsName: next
     * @description: 如果有元素，当前访问位置移动到下一个位置
     * @return: 返回当前元素
    **/
    public BinaryOperation next() {
        return operationList.get(current++);
    }

    /**
     * @methodsName: contains
     * @description: 构造算式，得到加法或减法算式的结果
     * @param: anOperation BinaryOperation类的实例
     * @return1: flag(true)  新生成的算式与数组的算式重复
     * @return2: flag(false) 新生成的算式与数组的算式没有重复
    */
    public boolean contains(BinaryOperation anOperation) {
        boolean flag = true;// 初数化flag的为true
        int size = operationList.size();// 数组长度
        if (size == 0) {
            return false;// 如果数组里没有算式，返回false，允许加入数组
        }
        for (int i = 0; i < size; i++) {// 将数组里已有的算式和新生成的算式做比较，检查是否存在重复
            if (!operationList.get(i).equals(anOperation)) {
                flag = false;// 没有重复
            }
        }
        return flag;
    }
}
