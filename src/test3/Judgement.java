package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @version: V2.1
 * @author: 张宥一
 * @className: ExerciseSheet
 * @packageName: test3
 * @description: 判断输入的答案与正确的答案，并记录
 * @data: 2019-12-17
 **/
public class Judgement {
    /**记录正确的算式 */
    private int correct;
    /**记录错误的算式 */
    private int wrong;
    /**记录这个Exercise的算式总数 */
    private int OperationCount = 0;
    /**记录成绩 */
    private int score = 0;
    /**批改成绩文件名 */
    private String CheckingName = "";
    /**算式练习文件名 */
    private String PracticeName = "";

    /**
     * @methodsName: evaluate
     * @description: 比较两个答案正误
     * @param1: answers 正确的答案
     * @param2: results 用户的答案
    */
    public void evaluate(Integer[] answers, Integer[] results) {
        correct = 0;
        wrong = 0;
        int length = answers.length < results.length ? answers.length : results.length;
        for (int i = 0; i < length; i++)
            if (answers[i] == results[i])
                correct++;
            else
                wrong++;
        wrong += Math.abs(answers.length - results.length);
        OperationCount = correct + wrong;
        score = correct * 2;
    }

    /**
     * @methodsName: getResults
     * @description: 获得用户的答案
     * @param: exercise
    */
    private Integer[] getResults(Exercise exercise) throws Exception {
        //
        String Addr_Name = exercise.Addr + PracticeName;
        File anExerciseFile = new File(Addr_Name);
        System.out.println("已经取得" + Addr_Name + "中练习的答案");
        ArrayList<Integer> opResults = new ArrayList<Integer>();
        FileInputStream in = new FileInputStream(anExerciseFile);
        int b = 0;
        String eqString = "";
        while (b != -1) {
            b = in.read();
            if ((char) b == ',' || (char) b == '\r') {
                opResults.add(Integer.valueOf(eqString));
                eqString = "";
            } else if ((char) b != '\r' && (char) b != '\n')
                eqString += (char) b;
        }
        in.close();
        Integer[] bb = new Integer[opResults.size()];
        return opResults.toArray(bb);
    }

    /**
     * @methodsName: getAnswers
     * @description: 获得正确答案
     * @param: exercise
    */
    private Integer[] getAnswers(Exercise exercise) throws Exception {
        //
        ArrayList<Integer> opAnswer = new ArrayList<Integer>();
        while (exercise.hasNext()) {
            opAnswer.add(exercise.next().getvalue());
        }
        Integer[] bb = new Integer[opAnswer.size()];
        return opAnswer.toArray(bb);
    }

    /**
     * @methodsName: writeCSVReport
     * @description: 传入一个文件，将批改结果输出到该文件中
     * @param: aReportFile
    */
    public void writeCSVReport(File aReportFile) throws IOException {
        OperationCount = correct + wrong;// 算式数量
        String str;
        str = "答案:" + CheckingName;
        FileWriter FW = new FileWriter(aReportFile, false);
        FW.write(str + ",\r\n");
        str = "答案总数:" + OperationCount;
        FW.write(str + ",\r\n");
        str = "正确:" + correct;
        FW.write(str + ",\r\n");
        str = "错误:" + wrong;
        FW.write(str + ",\r\n");
        str = "得分:" + score;
        FW.write(str + ",\r\n");
        System.out.println("批改文件已生成");
        FW.close();
    }

    /**
     * @methodsName: Practice
     * @description: 传入一个习题对象，并查找目录下的练习文件，然后进行批改,生成文件
     * @param: anExercise
    */
    public void Practice(Exercise anExercise) throws Exception {
        //
        getAllName(anExercise.FileName);
        Integer[] Results = getResults(anExercise);
        Integer[] Answers = getAnswers(anExercise);
        evaluate(Answers, Results);
        String Addr_Name = anExercise.Addr + CheckingName;
        File file = new File(Addr_Name);

        if (!file.exists())
            file.createNewFile();
        writeCSVReport(file);
    }

    /**
     * @methodsName: getAllName
     * @description: 分解习题文件名称，便于找到练习文件名称和生成批改文件名称
     * @param: Name
    */
    public void getAllName(String Name) {
        //
        String type, count;
        int a, b, c;
        a = Name.indexOf("_");
        b = Name.indexOf("_", a + 1);
        c = Name.indexOf("_", b + 1);
        type = Name.substring(0, a);
        count = Name.substring(b + 1, c);
        CheckingName = type + "_checking_" + count + "_.csv";
        PracticeName = type + "_practice_" + count + "_.csv";
    }

}
