package test2_1;

/**
 * @version: V1.0
 * @author: 张宥一
 * @className: Exercise
 * @packageName: test2_1
 * @description: 习题类，生成50道不重复的算式
 * @data: 2019-11-26
 **/
public class Exercise {

    /** 每行输出5个 */
    private static final short COLUMN_NUMBER = 5;
    /** 输出50道算式 */
    private static final short OPERATION_NUMBER = 50;
    /** 生成一个长度位50的数组 */
    BinaryOperation operationList[] = new BinaryOperation[OPERATION_NUMBER];

    /**
     * @methodsName: generateBinaryExercise
     * @description: 把不重复的混合算式存入数组中
    */
    public void generateBinaryExercise() {
        BinaryOperation anOperation = new BinaryOperation();// 创建一个新的对象
        BinaryOperation opCreator = new BinaryOperation();// 创建一个新的对象
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateBinaryOperation();
            while (contains(anOperation, i) == false) {// 调用contains，判断算式是否重复
                anOperation = opCreator.generateBinaryOperation();
            }
            operationList[i] = anOperation;// 没有重复，存入数组
        }
    }

    /**
     * @methodsName: generateAdditionExercise
     * @description: 把不重复的加法算式存入数组中
    */
    public void generateAdditionExercise() {
        BinaryOperation anOperation = new BinaryOperation();// 创建一个新的对象
        BinaryOperation opCreator = new BinaryOperation();// 创建一个新的对象
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateAdditionOperation();
            while (contains(anOperation, i) == false) {// 调用contains，判断算式是否重复
                anOperation = opCreator.generateAdditionOperation();
            }
            operationList[i] = anOperation;// 没有重复，存入数组
        }
    }

    /**
     * @methodsName: generateSubstractExercise
     * @description: 把不重复的减法算式存入数组中
    */
    public void generateSubstractExercise() {
        BinaryOperation anOperation = new BinaryOperation();// 创建一个新的对象
        BinaryOperation opCreator = new BinaryOperation();// 创建一个新的对象
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateSubstractOperation();
            while (contains(anOperation, i) == false) {// 调用contains，判断算式是否重复
                anOperation = opCreator.generateSubstractOperation();
            }
            operationList[i] = anOperation;// 没有重复，存入数组
        }
    }

    /**
     * @methodsName: contains
     * @description: 构造算式，得到加法或减法算式的结果
     * @param1 anOperation BinaryOperation类的实例
     * @param2 length 数组当前长度
     * @return1 false 生成了重复的算式
     * @return2 true 生成了新算式
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
     * @description: 调用Exercise对象将其算式按规定格式显示输出
     * @param1 ex Exercise类的实例
     * @param2 columns 一行显示colums个算式
    */
    public void formattedDisplay(Exercise ex, int columns) {
        int col = columns;// 一行有columns个算式
        int num = 0;// 初始化算式的序号
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            col--;
            num++;
            System.out.printf("%-5s%-15s", num + ".", operationList[i]);// 输出算式
            if (col == 0) {// col=0，即一行已生成5个
                System.out.println("");// 换行
                col = columns;// 换行结束后，再一次赋值
            }
        }
    }

    /**
     * @methodsName: formattedDisplay
     * @description: 重载formattedDisplay
     * @param ex Exercise类的实例
    */
    public void formattedDisplay(Exercise ex) {
        formattedDisplay(ex, COLUMN_NUMBER);
    }

}
