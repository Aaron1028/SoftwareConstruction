package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Exercise implements Serializable {
    private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();
    private int current = 0;
    private int operationCount = 0;

    public void generateAdditionExercise(int operationCount) {
        BinaryOperation anOperation1;
        while (operationCount > 0) {
            do {
                anOperation1 = generateOperation();
            } while (Contains(anOperation1));
            operationCount--;
        }
    }

    public void generateSubstractExercise(int operationCount) {
        BinaryOperation anOperation1;
        while (operationCount > 0) {
            do {
                anOperation1 = generateOperation();
            } while (Contains(anOperation1));
            operationCount--;
        }
    }

    public boolean contains(BinaryOperation anOperation) {
        boolean flag = true;
        int size = operationList.size();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!operationList.get(i).equals(anOperation)) {
                flag = false;
            }
        }
        return flag;
    }

    public void generateBinaryExercise(int operationCount) {
        BinaryOperation anOperation;
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();
            } while (Contains(anOperation));
            operationCount--;
        }
    }

    private boolean Contains(Object anOperation2) {
        // TODO Auto-generated method stub
        return false;
    }

    private BinaryOperation generateOperation() {
        Random random = new Random();
        int opValue = random.nextInt(2);
        if (opValue == 1) {
            return new AdditionOperation();
        }
        return new SubstractOperation();
    }

    public boolean hasNext() {
        return current <= operationList.size() - 1;
    }

    public BinaryOperation next() {
        return operationList.get(current++);
    }

    void Add(BinaryOperation op) {
        operationList.add(op);
        operationCount++;
    }

    public void writeCSVAdditionEercise(int count) {
        generateAdditionExercise(count);
    }

    public void writeCSVSubstractEercise(int count) {
        generateSubstractExercise(count);
    }

    public void writeCSVBinaryEercise(int count)
    // 随机生成混合习题
    {
        generateBinaryExercise(count);// 生成习题
    }

    static boolean AddOrSub(String s) {
        // 传入一个字符串，判断该字符串是加法还是减法
        int pos = s.indexOf("+");
        if (pos != -1)
            return true;// 加法
        else
            return false;// 减法
    }

}
