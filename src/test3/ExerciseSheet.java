package test3;

import java.io.File;

/**
 * @version: V2.1
 * @author: ���һ
 * @className: ExerciseSheet
 * @packageName: test3
 * @description: ��ʽ�������ʽ
 * @data: 2019-12-17
 **/
public class ExerciseSheet {
    /** ÿ�����5�� */
    private static final short COLUMN_NUMBER = 5;

    public static void main(String[] args) throws Throwable {

        TestGenerateOperationBase();// ���Է�������ʽ��������ʽ,������ļ������ٴζ���
        TestJugement();// ���Է����������ϰ�ļ����������ļ�

    }

    /**
     * @methodsName: formattedDisplay
     * @description: ����Exercise��������ʽ���涨��ʽ��ʾ���
     * @param1 ex Exercise���ʵ��
     * @param2 columns һ����ʾcolums����ʽ
    */
    public void formattedDisplay(Exercise ex, int columns) {
        int col = columns;// һ����columns����ʽ
        int num = 0;// ��ʼ����ʽ�����
        while (ex.hasNext()) {
            col--;
            num++;
            System.out.printf("%-5s%-15s", num + ".", ex.next());// �����ʽ
            if (col == 0) {
                System.out.println("");// ����
                col = columns;// ���н�������һ�θ�ֵ
            }
        }
        System.out.println("");
    }

    /**
     * @methodsName: formattedDisplay
     * @description: ����formattedDisplay
     * @param ex Exercise���ʵ��
    */
    public void formattedDisplay(Exercise ex) {
        formattedDisplay(ex, COLUMN_NUMBER);
    }

    /**
     * @methodsName: TestGenerateOperationBase
     * @description: ���Է�����������ʽ��������ʽ������ϰ�Ᵽ�浽�ļ���
    */
    static public void TestGenerateOperationBase() throws Throwable {
        ExerciseSheet sheet = new ExerciseSheet();
        Exercise exercise = new Exercise();
        OperationBase Base = new OperationBase();

        System.out.println("������ɼӷ���ʽ");
        exercise = Base.generateAdditionExercise(50);
        exercise.writeCSVExercise();
        sheet.formattedDisplay(exercise, 5);

        System.out.println("������ɼ�����ʽ");
        exercise = Base.generateSubstractExercise(50);
        exercise.writeCSVExercise();
        sheet.formattedDisplay(exercise, 5);

        System.out.println("������ɻ����ʽ");
        exercise = Base.generateBinaryExercise(50);
        exercise.writeCSVExercise();
        sheet.formattedDisplay(exercise, 5);

        File aFile;
        System.out.println("Base���ļ�����ӷ���ʽ");
        aFile = new File("d:/�Ӽ�����ϰ/Addition_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        sheet.formattedDisplay(exercise);

        System.out.println("Base���ļ����������ʽ");
        aFile = new File("d:/�Ӽ�����ϰ/Substract_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        sheet.formattedDisplay(exercise);

        System.out.println("Base���ļ���������ʽ");
        aFile = new File("d:/�Ӽ�����ϰ/MixOperation_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        sheet.formattedDisplay(exercise);

    }

    /**
     * @methodsName: TestJugement
     * @description: ��������ϰ�⹦��
    */
    static void TestJugement() throws Exception {

        Exercise exercise = new Exercise();
        Judgement ju = new Judgement();

        System.out.println("����ӷ�ϰ�����ϰ������ϰ�����ɽ���ļ�");
        File aFile = new File("d:/�Ӽ�����ϰ/Addition_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        ju.Practice(exercise);

        System.out.println("�������ϰ�����ϰ������ϰ�����ɽ���ļ�");
        aFile = new File("d:/�Ӽ�����ϰ/Substract_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        ju.Practice(exercise);

        System.out.println("������ϰ�����ϰ������ϰ�����ɽ���ļ�");
        aFile = new File("d:/�Ӽ�����ϰ/MixOperation_exercise_50_.csv");
        exercise.readCSVExercise(aFile);
        ju.Practice(exercise);
    }

}
