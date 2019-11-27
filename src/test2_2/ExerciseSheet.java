package test2_2;

/**
 * @version: V1.1
 * @author: ���һ
 * @className: ExerciseSheet
 * @packageName: test2_2
 * @description: ��ʽ�������ʽ
 * @data: 2019-11-27
 **/
public class ExerciseSheet {

    /** ÿ�����5�� */
    private static final short COLUMN_NUMBER = 5;

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
            if (col == 0) {// col=0����һ��������5��
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

    public static void main(String[] args) {

        ExerciseSheet sheet = new ExerciseSheet();// ����һ��ExerciseSheet��Ķ���
        Exercise exercise = new Exercise();// ����һ��Exercise��Ķ���
        System.out.println("������ɼӷ���ʽ");
        exercise.generateAdditionExercise(50);
        sheet.formattedDisplay(exercise, 5);
        System.out.println("������ɼ�����ʽ");
        exercise.generateSubstractExercise(50);
        sheet.formattedDisplay(exercise, 5);
        System.out.println("������ɻ����ʽ");
        exercise.generateBinaryExercise(50);
        sheet.formattedDisplay(exercise, 5);

    }

}
