package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version: V2.1
 * @author: 张宥一
 * @className: Exercise
 * @packageName: test3
 * @description: 习题类
 * @data: 2019-12-17
 **/
public class Exercise {
    /**记录这个Exercise的算式总数 */
    private int OperationCount = 0;
    /**文件名 */
    protected String FileName;
    /**文件地址 */
    public String Addr = "D:/加减法练习/";
    /**记录当前访问位置 */
    private int current = 0;

    /**ArrayList的数据类型限定是BinaryOperation对象的 */
    private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();
    /**用户填写的所有题目的答案列表 */
    private List<Answers> answers = new ArrayList<>();

    /**
     * @className: Answers
     * @description: 答案内部类
    */
    class Answers {
        String content; // 答案内容
        boolean correct; // 正确性

        public Answers() {
            content = "";
            correct = false;
        }

        public Answers(String ans, boolean cr) {
            content = ans;
            correct = cr;
        }
    }

    /**当前题目类型*/
    private ExerciseType currentType;

    /**
     * @methodsName: getCurrentType
     * @description: 当前题目类型，为串行化保存用
     * @return: currentType
    */
    public ExerciseType getCurrentType() {
        return currentType;
    }

    /**
     * @methodsName: getExerciseType
     * @description: 得到算式类型， 加减混合 | 仅加法 | 仅减法
     * @return: s 
    */
    public String getExerciseType() {
        String s = new String();
        switch (currentType) {
        case ADDandSUB:
            s = "加减混合";
            break;
        case ADD:
            s = "仅加法";
            break;
        case SUB:
            s = "仅减法";
            break;
        }
        return s;
    }

    /**
     * @methodsName: setCurrentType
     * @param: type
    */
    private void setCurrentType(ExerciseType type) {
        this.currentType = type;
    }

    /**
     * @methodsName: setAnswer
     * @description: 设置答案内容并判断正确性
     * @param1: index
     * @param2: ans
    **/
    public void setAnswer(int index, String ans) {

        BinaryOperation op;
        op = operationList.get(index); // 获取算式
        String result = String.valueOf(op.getvalue()); // 获取正确结果
        String tans = ans.trim();// 获取用户输入的答案
        answers.set(index, new Answers(tans, result.equals(tans)));
        // 设置答案内容和正确性，index位置上设置为对应的answer对象，对象里面保存用户答案和是否正确
    }

    /**
     * @methodsName: getAnswer
     * @description: 获取答案
     * @param: index
    **/
    public String getAnswer(int index) {
        return answers.get(index).content;
    }

    /**
     * @methodsName: clearAnswer
     * @description: 清空答案
    **/
    public void clearAnswers() {
        for (int i = 0; i < answers.size(); i++)
            answers.set(i, new Answers("", false));
    }

    /**
     * @methodsName: Correct
     * @description: 统计正确题数
     * @return: correctAmount 正确题数
    **/
    public int Correct() { //
        int correctAmount = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (getJudgement(i))
                correctAmount++;
        }
        return correctAmount;
    }

    /**
     * @methodsName: getJudgement
     * @description: 获取判题结果
    **/
    public boolean getJudgement(int index) {
        return answers.get(index).correct;
    }

    public enum ExerciseType {
        ADD, SUB, ADDandSUB,
    }

    /**构建新文件，名为Addr */
    public Exercise() {
        File aFile = new File(Addr);
        if (!aFile.exists())
            aFile.mkdir();
    }

    /**
     * @methodsName: hasNext
     * @description: 检查数组是否还有元素，则返回是，否则返回否
     * @return1: true 数组还有元素
     * @return2: false 数组没有元素
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
        if (size == 0) {// 如果数组里没有算式，返回false，允许加入数组
            return false;
        }
        for (int i = 0; i < size; i++) {// 将数组里已有的算式和新生成的算式做比较，检查是否存在重复
            if (!operationList.get(i).equals(anOperation)) {
                flag = false;// 没有重复
            }
        }
        return flag;
    }

    /**
     * @methodsName: generateOperation
     * @description: 随机生成一个加法或者减法算式并返回
     * @return1: AdditionOperation 加法算式
     * @return2: SubstractOperation 减法算式
    */
    private BinaryOperation generateOperation() {
        //
        Random random = new Random();
        int opValue = random.nextInt(2);
        if (opValue == 1) {
            return new AdditionOperation();
        }
        return new SubstractOperation();
    }

    /**
     * @methodsName: generateBinaryExercise
     * @description: 方法调用generateOperation，随机生成加法算式并加入数组
     * @param: operationCount 记录当前访问位置
    */
    public void generateBinaryExercise(int operationCount) {
        setCurrentType(ExerciseType.ADDandSUB); // 设置题目类型
        operationList.clear();// 清空operationList数组
        answers.clear();// 清空答案数组
        current = 0;// 初始化当前访问位置
        OperationCount = operationCount;// 赋值给成员变量
        FileName = "MixOperation_exercise_" + operationCount + "_";
        BinaryOperation anOperation;// anOperation1属于BinaryOperation类
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();// 创建引用变量
            } while (contains(anOperation));// 调用contains方法，算式不重复，结束循环
            operationList.add(anOperation);// 将anOperation 加入到Exercise中
            answers.add(new Answers());
            // 将anOperation 加入到Exercise中
            operationCount--;
        }
    }

    /**
     * @methodsName: generateAdditionExercise
     * @description: 方法调用generateOperation，随机生成加法算式并加入数组
     * @param: operationCount 记录当前访问位置
    */
    public void generateAdditionExercise(int operationCount) {
        setCurrentType(ExerciseType.ADD); // 设置题目类型

        answers.clear();// 清空答案数组
        operationList.clear();// 清空operationList数组
        current = 0;// 初始化当前访问位置
        OperationCount = operationCount;// 赋值给成员变量
        FileName = "Addition_exercise_" + operationCount + "_";
        BinaryOperation anOperation1;// anOperation1属于BinaryOperation类
        while (operationCount > 0) {
            do {
                anOperation1 = new AdditionOperation();// 创建引用变量
            } while (contains(anOperation1));// 调用contains方法，算式不重复，结束循环
            operationList.add(anOperation1);// 将anOperation 加入到Exercise中
            answers.add(new Answers());
            operationCount--;
        }
    }

    /**
     * @methodsName: generateSubstractExercise
     * @description: 方法调用generateOperation，随机生成减法算式并加入数组
     * @param: operationCount 记录当前访问位置
    */
    public void generateSubstractExercise(int operationCount) {

        setCurrentType(ExerciseType.SUB);
        operationList.clear();// 清空operationList数组
        answers.clear();// 清空答案数组
        current = 0;// 初始化当前访问位置
        OperationCount = operationCount;// 赋值给成员变量
        FileName = "Substract_exercise_" + operationCount + "_";
        BinaryOperation anOperation1;// anOperation1属于BinaryOperation类
        while (operationCount > 0) {
            do {
                anOperation1 = new SubstractOperation();// 创建引用变量
            } while (contains(anOperation1));// 调用contains方法，算式不重复，结束循环
            operationList.add(anOperation1);// 将anOperation 加入到Exercise中
            answers.add(new Answers());
            operationCount--;
        }
    }

    /**
     * @methodsName: writeCSVExercise
     * @description: 生成文件
    */
    public void writeCSVExercise() {
        int count = OperationCount;// 算式数量
        FileName = Addr + FileName + ".csv";// 生成习题文件名称
        String PracticeName = FileName.replaceAll("exercise", "practice");
        System.out.println(FileName);
        System.out.println(PracticeName);
        try {
            File file = new File(FileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            File pfile = new File(PracticeName);
            if (!pfile.exists()) {
                pfile.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file, false);
            for (int i = 0; i < count; i++) {
                fileWritter.write(operationList.get(i).toString());// 把算式转换为字符串形式然后输出到文档里面
                fileWritter.write(",");
                if ((i + 1) % 5 == 0)
                    fileWritter.write("\r\n");
            }
            System.out.println("习题文件已生成");
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @methodsName: readCSVExercise
     * @description: 从习题文件中将习题读入程序中
    */
    public void readCSVExercise(File aFile) throws Exception {
        FileName = aFile.getName();
        operationList.clear();
        current = 0;
        String eqString = "";
        BinaryOperation op;
        FileInputStream in = new FileInputStream(aFile);
        int b = 0;
        while (b != -1) {
            b = in.read();
            if ((char) b == ',') {
                op = AddSubOperation(eqString);
                Add(op);
                eqString = "";
            } else if (b != '\r' && b != '\n')
                eqString += (char) b;
        }
        System.out.println("习题已经读入");
        in.close();
    }

    /**
     * @methodsName: Add
     * @description: 将一个算式加入到exercise中
     * @param: op 操作符
    */
    void Add(BinaryOperation op) {
        operationList.add(op);
        OperationCount++;
    }

    /**
     * @methodsName: writeCSVAdditionEercise
     * @description: 随机生成加法习题
     * @param: count 
    */
    public void writeCSVAdditionEercise(int count) {
        generateAdditionExercise(count);// 生成习题
        writeCSVExercise();// 输出成文件
    }

    /**
     * @methodsName: writeCSVAdditionEercise
     * @description: 随机生成减法习题
     * @param: count 
    */
    public void writeCSVSubstractEercise(int count) {
        generateSubstractExercise(count);// 生成习题
        writeCSVExercise();// 输出成文件
    }

    /**
     * @methodsName: writeCSVAdditionEercise
     * @description: 随机生成混合习题
     * @param: count 
    */
    public void writeCSVBinaryEercise(int count) {
        generateBinaryExercise(count);// 生成习题
        writeCSVExercise();// 输出成文件
    }

    /**
     * @methodsName: AddOrSub
     * @description: 传入一个字符串，判断该字符串是加法还是减法
     * @param: s
     * @return1: true 加法
     * @return2: false 加法
    */
    static boolean AddOrSub(String s) {
        int pos = s.indexOf("+");
        if (pos != -1)
            return true;// 加法
        else
            return false;// 减法
    }

    /**
     * @methodsName: AddOrSub
     * @description: 传入一个算式字符串，将该字符串转换成算式对象，返回这个算式对象
     * @param: s
     * @return1: true 加法
     * @return2: false 加法
    */
    public static BinaryOperation AddSubOperation(String s) {
        BinaryOperation bo;
        String left, right;
        int len = s.length();
        int pos;
        if (AddOrSub(s)) {
            pos = s.indexOf('+');
            bo = new AdditionOperation();
        } else {
            pos = s.indexOf('-');
            bo = new SubstractOperation();
        }
        left = s.substring(0, pos);
        right = s.substring(pos + 1, len - 1);
        bo.insert(left, right);
        return bo;
    }

    /**
     * @methodsName: getOperation
     * @description: 传入一个算式字符串，将该字符串转换成算式对象，返回这个算式对象
     * @param: index
     * @return1: 
     * @return2: null
    */
    public BinaryOperation getOperation(int index) {
        if (index < operationList.size())
            return operationList.get(index);
        else
            return null;
    }

    /**
     * @methodsName: length
     * @description: 数组长度
     * @return: OperationCount
    */
    public int length() {
        return OperationCount;
    }
}
