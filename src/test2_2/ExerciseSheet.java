package test2_2;

/**
 * @version: V1.1
 * @author: 张宥一
 * @className: ExerciseSheet
 * @packageName: test2_2
 * @description: 格式化输出算式
 * @data: 2019-11-27
 **/
public class ExerciseSheet {

    /** 每行输出5个 */
    private static final short COLUMN_NUMBER = 5;

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
            if (col == 0) {// col=0，即一行已生成5个
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

    public static void main(String[] args) {

        ExerciseSheet sheet = new ExerciseSheet();// 创建一个ExerciseSheet类的对象
        Exercise exercise = new Exercise();// 创建一个Exercise类的对象
        System.out.println("随机生成加法算式");
        exercise.generateAdditionExercise(50);
        sheet.formattedDisplay(exercise, 5);
        System.out.println("随机生成减法算式");
        exercise.generateSubstractExercise(50);
        sheet.formattedDisplay(exercise, 5);
        System.out.println("随机生成混合算式");
        exercise.generateBinaryExercise(50);
        sheet.formattedDisplay(exercise, 5);

    }

}
