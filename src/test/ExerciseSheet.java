package test;

public class ExerciseSheet {
    private static final short COLUM_NUMBER = 5;

    public void formattedDisplay(Exercise ex, int colums) {
        int col = colums;
        int num = 0;
        while (ex.hasNext()) {
            col--;
            num++;
            System.out.printf("%-5s%-15s", num + ".", ex.next());
            if (col == 0) {
                System.out.println("");
                col = colums;
            }
        }
        System.out.println("");
    }

    public void formattedDisplay(Exercise ex) {
        formattedDisplay(ex, COLUM_NUMBER);
    }

    public static void main(String[] args) {
        ExerciseSheet sheet = new ExerciseSheet();
        Exercise exercise = new Exercise();
        exercise.generateBinaryExercise(28);
        System.out.println("--generate and dispaly add exercise--");
        sheet.formattedDisplay(exercise, 5);

    }

}
