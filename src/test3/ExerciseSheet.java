package test3;

import java.io.File;

/**
 * @version: V2.1
 * @author: 张宥一
 * @className: ExerciseSheet
 * @packageName: test3
 * @description: 格式化输出算式
 * @data: 2019-12-17
 **/
public class ExerciseSheet {
    /** 每行输出5个 */
    private static final short COLUMN_NUMBER = 5;

    public static void main(String[] args) throws Throwable {

        TestGenerateOperationBase();// 测试方法，算式基生成算式,输出到文件，并再次读入
        TestJugement();// 测试方法，检测练习文件生成批改文件

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
        while (ex.hasNext()) {
            col--;
            num++;
            System.out.printf("%-5s%-15s", num + ".", ex.next());// 输出算式
            if (col == 0) {
                System.out.println("");// 换行
                col = columns;// 换行结束后，再一次赋值
            }
        }
        System.out.println("");
    }

    /**
     * @methodsName: formattedDisplay
     * @description: 重载formattedDisplay
     * @param ex Exercise类的实例
    */
    public void formattedDisplay(Exercise ex) {
        formattedDisplay(ex, COLUMN_NUMBER);
    }

    /**
     * @methodsName: TestGenerateOperationBase
     * @description: 测试方法，调用算式基生成算式，并将习题保存到文件中
    */
    static public void TestGenerateOperationBase() throws Throwable {
        ExerciseSheet sheet = new ExerciseSheet();
        Exercise exercise = new Exercise();
        OperationBase Base = new OperationBase();

        System.out.println("随机生成加法算式");
        exercise = Base.generateAdditionExercise(50);
        exercise.writeCSVExercise();
        sheet.formattedDisplay(exercise, 5);

        System.out.println("随机生成减法算式");
        exercise = Base.generateSubstractExercise(50);
        exercise.writeCSVExercise();
        sheet.formattedDisplay(exercise, 5);

        System.out.println("随机生成混合算式");
        exercise = Base.generateBinaryExercise(50);
        exercise.writeCSVExercise();
        sheet.formattedDisplay(exercise, 5);

        File aFile;
        System.out.println("Base从文件读入加法算式");
        aFile = new File("d:/加减法练习/Addition_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        sheet.formattedDisplay(exercise);

        System.out.println("Base从文件读入减法算式");
        aFile = new File("d:/加减法练习/Substract_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        sheet.formattedDisplay(exercise);

        System.out.println("Base从文件读入混合算式");
        aFile = new File("d:/加减法练习/MixOperation_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        sheet.formattedDisplay(exercise);

    }

    /**
     * @methodsName: TestJugement
     * @description: 测试批改习题功能
    */
    static void TestJugement() throws Exception {

        Exercise exercise = new Exercise();
        Judgement ju = new Judgement();

        System.out.println("读入加法习题和练习，批改习题生成结果文件");
        File aFile = new File("d:/加减法练习/Addition_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        ju.Practice(exercise);

        System.out.println("读入减法习题和练习，批改习题生成结果文件");
        aFile = new File("d:/加减法练习/Substract_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        ju.Practice(exercise);

        System.out.println("读入混合习题和练习，批改习题生成结果文件");
        aFile = new File("d:/加减法练习/MixOperation_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        ju.Practice(exercise);
    }

}
