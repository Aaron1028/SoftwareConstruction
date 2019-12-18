package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @version: V2.1
 * @author: 张宥一
 * @className: OperationBase
 * @packageName: test3
 * @description: 算式基类
 * @data: 2019-12-17
 **/
public class OperationBase {//
    /**算式最大值 */
    static final int UPPER = 100;
    /**加法算式基 */
    private BinaryOperation[][] AdditionBase;
    /**减法算式基 */
    private BinaryOperation[][] SubstractBase;

    /**
     * @methodsName: generationExercise
     * @description: 传入算式基，该算式基可以是加法算式基也可以是减法算式基，根据这个算式基随机生成算式并返回习题对象
     * @param1: count
     * @param2: base
    */
    public Exercise generationExercise(int count, BinaryOperation[][] Base) {

        Exercise anExercise = new Exercise();
        BinaryOperation anOperation;
        Random random = new Random();
        int i, j;
        while (count > 0) {
            do {
                i = random.nextInt(UPPER + 1);
                j = random.nextInt(UPPER + 1);
                anOperation = Base[i][j];
            } while (anOperation == null || anExercise.contains(anOperation));
            anExercise.Add(anOperation);
            count--;
        }
        return anExercise;
    }

    /**
     * @methodsName: generationExercise
     * @description: 传入两个算式基，既加法和减法算式基，根据这两个算式基随机生成混合算式并返回习题对象
     * @param1: count
     * @param2: AddBase
     * @param3: SubBase
     * @return: anExercise
    */
    public Exercise generationExercise(int count, BinaryOperation[][] AddBase, BinaryOperation[][] SubBase) {
        Exercise anExercise = new Exercise();
        BinaryOperation anOperation;
        Random random = new Random();
        int i, j, ran;
        while (count > 0) {
            ran = random.nextInt(2);
            switch (ran) {
            case 0:
                do {
                    i = random.nextInt(UPPER + 1);
                    j = random.nextInt(UPPER + 1);
                    anOperation = AddBase[i][j];
                } while (anOperation == null || anExercise.contains(anOperation));
                anExercise.Add(anOperation);
                count--;
                break;
            case 1:
                do {
                    i = random.nextInt(UPPER + 1);
                    j = random.nextInt(UPPER + 1);
                    anOperation = SubBase[i][j];
                } while (anOperation == null || anExercise.contains(anOperation));
                anExercise.Add(anOperation);
                count--;
                break;
            }
        }
        return anExercise;
    }

    /**
     * @methodsName: generateAdditionExercise
     * @description: 生成加法习题,生成文件
     * @param: count
     * @return: exercise
    */
    public Exercise generateAdditionExercise(int count) {
        Exercise exercise;
        exercise = generationExercise(count, AdditionBase);
        exercise.FileName = "Addition_exercise_" + count + "_";
        return exercise;
    }

    /**
     * @methodsName: generateSubstractExercise
     * @description: 生成减法习题,生成文件
     * @param: count
     * @return: exercise
    */
    public Exercise generateSubstractExercise(int count) {
        Exercise exercise;
        exercise = generationExercise(count, SubstractBase);
        exercise.FileName = "Substract_exercise_" + count + "_";
        return exercise;
    }

    /**
     * @methodsName: generateBinaryExercise
     * @description: 生成混合习题,生成文件
     * @param: count
     * @return: exercise
    */
    public Exercise generateBinaryExercise(int count) {
        Exercise exercise;
        exercise = generationExercise(count, AdditionBase, SubstractBase);
        exercise.FileName = "MixOperation_exercise_" + count + "_";
        return exercise;
    }

    /**
     * @methodsName:  OperationBase
     * @description: 构造函数，算式基对象实例化就判断算式基文件是否存在，若存在则直接读入，若不存在就生成
    */
    public OperationBase() throws Throwable {
        File aFile = new File("d:/加减法练习/AdditionOperationBase.csv");
        File bFile = new File("d:/加减法练习/SubstractOperationBase.csv");
        if (aFile.exists() && bFile.exists()) {
            readOperationBase(aFile, bFile);
            System.out.println("已从文件读入算式基");
        } else {
            writeOperationBase();
            System.out.println("已将算式基写入文件");
        }
    }

    /**
     * @methodsName: readOperationBase
     * @description: 读入算式基
     * @param1: aFile
     * @param1: bFile
    */
    public void readOperationBase(File aFile, File bFile) throws IOException {
        FileInputStream fisa = new FileInputStream(aFile);
        FileInputStream fisb = new FileInputStream(bFile);
        AdditionBase = new BinaryOperation[UPPER + 1][UPPER + 1];
        SubstractBase = new BinaryOperation[UPPER + 1][UPPER + 1];
        BinaryOperation op;
        String eqString = "";
        int b;
        for (int i = 0; i <= UPPER; i++) {
            for (int j = 0; j <= UPPER - i; j++) {
                while (true) {
                    b = fisa.read();
                    if (b == '\r' || b == '\n')
                        continue;
                    if (b == ',')
                        break;
                    else
                        eqString += (char) b;
                }
                op = Exercise.AddSubOperation(eqString);
                AdditionBase[i][j] = op;
                eqString = "";
            }
        }

        for (int i = 0; i <= UPPER; i++) {
            for (int j = 0; j <= i; j++) {
                while (true) {
                    b = fisb.read();
                    if (b == '\r' || b == '\n')
                        continue;
                    if (b == ',')
                        break;
                    else
                        eqString += (char) b;
                }
                op = Exercise.AddSubOperation(eqString);
                SubstractBase[i][j] = op;
                eqString = "";
            }
        }
        fisa.close();
        fisb.close();
    }

    /**
     * @methodsName: writeOperationBase
     * @description: 生成算式基文件
    */
    public void writeOperationBase() throws Throwable {
        AdditionBase = new BinaryOperation[UPPER + 1][UPPER + 1];
        SubstractBase = new BinaryOperation[UPPER + 1][UPPER + 1];
        BinaryOperation op;
        File aFile = new File("d:/加减法练习/AdditionOperationBase.csv");
        File bFile = new File("d:/加减法练习/SubstractOperationBase.csv");
        if (!aFile.exists())
            aFile.createNewFile();
        FileWriter FW = new FileWriter(aFile, false);
        for (int i = 0; i <= UPPER; i++) {
            for (int j = 0; j <= UPPER - i; j++) {
                op = new AdditionOperation();
                op.insert(i, j);
                AdditionBase[i][j] = op;
                FW.write(op.toString());
                FW.write(",");
            }
            FW.write("\r\n");
        }
        FW.close();
        op = new SubstractOperation();
        if (!bFile.exists())
            bFile.createNewFile();
        FW = new FileWriter(bFile, false);
        for (int i = 0; i <= UPPER; i++) {
            for (int j = 0; j <= i; j++) {
                op = new SubstractOperation();
                op.insert(i, j);
                SubstractBase[i][j] = op;
                FW.write(op.toString());
                FW.write(",");
            }
            FW.write("\r\n");
        }
        FW.close();

    }
}
