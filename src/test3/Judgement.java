package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @version: V2.1
 * @author: ���һ
 * @className: ExerciseSheet
 * @packageName: test3
 * @description: �ж�����Ĵ�����ȷ�Ĵ𰸣�����¼
 * @data: 2019-12-17
 **/
public class Judgement {
    /**��¼��ȷ����ʽ */
    private int correct;
    /**��¼�������ʽ */
    private int wrong;
    /**��¼���Exercise����ʽ���� */
    private int OperationCount = 0;
    /**��¼�ɼ� */
    private int score = 0;
    /**���ĳɼ��ļ��� */
    private String CheckingName = "";
    /**��ʽ��ϰ�ļ��� */
    private String PracticeName = "";

    /**
     * @methodsName: evaluate
     * @description: �Ƚ�����������
     * @param1: answers ��ȷ�Ĵ�
     * @param2: results �û��Ĵ�
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
     * @description: ����û��Ĵ�
     * @param: exercise
    */
    private Integer[] getResults(Exercise exercise) throws Exception {
        //
        String Addr_Name = exercise.Addr + PracticeName;
        File anExerciseFile = new File(Addr_Name);
        System.out.println("�Ѿ�ȡ��" + Addr_Name + "����ϰ�Ĵ�");
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
     * @description: �����ȷ��
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
     * @description: ����һ���ļ��������Ľ����������ļ���
     * @param: aReportFile
    */
    public void writeCSVReport(File aReportFile) throws IOException {
        OperationCount = correct + wrong;// ��ʽ����
        String str;
        str = "��:" + CheckingName;
        FileWriter FW = new FileWriter(aReportFile, false);
        FW.write(str + ",\r\n");
        str = "������:" + OperationCount;
        FW.write(str + ",\r\n");
        str = "��ȷ:" + correct;
        FW.write(str + ",\r\n");
        str = "����:" + wrong;
        FW.write(str + ",\r\n");
        str = "�÷�:" + score;
        FW.write(str + ",\r\n");
        System.out.println("�����ļ�������");
        FW.close();
    }

    /**
     * @methodsName: Practice
     * @description: ����һ��ϰ����󣬲�����Ŀ¼�µ���ϰ�ļ���Ȼ���������,�����ļ�
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
     * @description: �ֽ�ϰ���ļ����ƣ������ҵ���ϰ�ļ����ƺ����������ļ�����
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
