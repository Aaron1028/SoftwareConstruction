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
 * @author: ���һ
 * @className: Exercise
 * @packageName: test3
 * @description: ϰ����
 * @data: 2019-12-17
 **/
public class Exercise {
    /**��¼���Exercise����ʽ���� */
    private int OperationCount = 0;
    /**�ļ��� */
    protected String FileName;
    /**�ļ���ַ */
    public String Addr = "D:/�Ӽ�����ϰ/";
    /**��¼��ǰ����λ�� */
    private int current = 0;

    /**ArrayList�����������޶���BinaryOperation����� */
    private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();
    /**�û���д��������Ŀ�Ĵ��б� */
    private List<Answers> answers = new ArrayList<>();

    /**
     * @className: Answers
     * @description: ���ڲ���
    */
    class Answers {
        String content; // ������
        boolean correct; // ��ȷ��

        public Answers() {
            content = "";
            correct = false;
        }

        public Answers(String ans, boolean cr) {
            content = ans;
            correct = cr;
        }
    }

    /**��ǰ��Ŀ����*/
    private ExerciseType currentType;

    /**
     * @methodsName: getCurrentType
     * @description: ��ǰ��Ŀ���ͣ�Ϊ���л�������
     * @return: currentType
    */
    public ExerciseType getCurrentType() {
        return currentType;
    }

    /**
     * @methodsName: getExerciseType
     * @description: �õ���ʽ���ͣ� �Ӽ���� | ���ӷ� | ������
     * @return: s 
    */
    public String getExerciseType() {
        String s = new String();
        switch (currentType) {
        case ADDandSUB:
            s = "�Ӽ����";
            break;
        case ADD:
            s = "���ӷ�";
            break;
        case SUB:
            s = "������";
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
     * @description: ���ô����ݲ��ж���ȷ��
     * @param1: index
     * @param2: ans
    **/
    public void setAnswer(int index, String ans) {

        BinaryOperation op;
        op = operationList.get(index); // ��ȡ��ʽ
        String result = String.valueOf(op.getvalue()); // ��ȡ��ȷ���
        String tans = ans.trim();// ��ȡ�û�����Ĵ�
        answers.set(index, new Answers(tans, result.equals(tans)));
        // ���ô����ݺ���ȷ�ԣ�indexλ��������Ϊ��Ӧ��answer���󣬶������汣���û��𰸺��Ƿ���ȷ
    }

    /**
     * @methodsName: getAnswer
     * @description: ��ȡ��
     * @param: index
    **/
    public String getAnswer(int index) {
        return answers.get(index).content;
    }

    /**
     * @methodsName: clearAnswer
     * @description: ��մ�
    **/
    public void clearAnswers() {
        for (int i = 0; i < answers.size(); i++)
            answers.set(i, new Answers("", false));
    }

    /**
     * @methodsName: Correct
     * @description: ͳ����ȷ����
     * @return: correctAmount ��ȷ����
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
     * @description: ��ȡ������
    **/
    public boolean getJudgement(int index) {
        return answers.get(index).correct;
    }

    public enum ExerciseType {
        ADD, SUB, ADDandSUB,
    }

    /**�������ļ�����ΪAddr */
    public Exercise() {
        File aFile = new File(Addr);
        if (!aFile.exists())
            aFile.mkdir();
    }

    /**
     * @methodsName: hasNext
     * @description: ��������Ƿ���Ԫ�أ��򷵻��ǣ����򷵻ط�
     * @return1: true ���黹��Ԫ��
     * @return2: false ����û��Ԫ��
    */
    public boolean hasNext() {
        return current <= operationList.size() - 1;
    }

    /**
     * @methodsName: next
     * @description: �����Ԫ�أ���ǰ����λ���ƶ�����һ��λ��
     * @return: ���ص�ǰԪ��
    **/
    public BinaryOperation next() {
        return operationList.get(current++);
    }

    /**
     * @methodsName: contains
     * @description: ������ʽ���õ��ӷ��������ʽ�Ľ��
     * @param: anOperation BinaryOperation���ʵ��
     * @return1: flag(true)  �����ɵ���ʽ���������ʽ�ظ�
     * @return2: flag(false) �����ɵ���ʽ���������ʽû���ظ�
    */
    public boolean contains(BinaryOperation anOperation) {
        boolean flag = true;// ������flag��Ϊtrue
        int size = operationList.size();// ���鳤��
        if (size == 0) {// ���������û����ʽ������false�������������
            return false;
        }
        for (int i = 0; i < size; i++) {// �����������е���ʽ�������ɵ���ʽ���Ƚϣ�����Ƿ�����ظ�
            if (!operationList.get(i).equals(anOperation)) {
                flag = false;// û���ظ�
            }
        }
        return flag;
    }

    /**
     * @methodsName: generateOperation
     * @description: �������һ���ӷ����߼�����ʽ������
     * @return1: AdditionOperation �ӷ���ʽ
     * @return2: SubstractOperation ������ʽ
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
     * @description: ��������generateOperation��������ɼӷ���ʽ����������
     * @param: operationCount ��¼��ǰ����λ��
    */
    public void generateBinaryExercise(int operationCount) {
        setCurrentType(ExerciseType.ADDandSUB); // ������Ŀ����
        operationList.clear();// ���operationList����
        answers.clear();// ��մ�����
        current = 0;// ��ʼ����ǰ����λ��
        OperationCount = operationCount;// ��ֵ����Ա����
        FileName = "MixOperation_exercise_" + operationCount + "_";
        BinaryOperation anOperation;// anOperation1����BinaryOperation��
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();// �������ñ���
            } while (contains(anOperation));// ����contains��������ʽ���ظ�������ѭ��
            operationList.add(anOperation);// ��anOperation ���뵽Exercise��
            answers.add(new Answers());
            // ��anOperation ���뵽Exercise��
            operationCount--;
        }
    }

    /**
     * @methodsName: generateAdditionExercise
     * @description: ��������generateOperation��������ɼӷ���ʽ����������
     * @param: operationCount ��¼��ǰ����λ��
    */
    public void generateAdditionExercise(int operationCount) {
        setCurrentType(ExerciseType.ADD); // ������Ŀ����

        answers.clear();// ��մ�����
        operationList.clear();// ���operationList����
        current = 0;// ��ʼ����ǰ����λ��
        OperationCount = operationCount;// ��ֵ����Ա����
        FileName = "Addition_exercise_" + operationCount + "_";
        BinaryOperation anOperation1;// anOperation1����BinaryOperation��
        while (operationCount > 0) {
            do {
                anOperation1 = new AdditionOperation();// �������ñ���
            } while (contains(anOperation1));// ����contains��������ʽ���ظ�������ѭ��
            operationList.add(anOperation1);// ��anOperation ���뵽Exercise��
            answers.add(new Answers());
            operationCount--;
        }
    }

    /**
     * @methodsName: generateSubstractExercise
     * @description: ��������generateOperation��������ɼ�����ʽ����������
     * @param: operationCount ��¼��ǰ����λ��
    */
    public void generateSubstractExercise(int operationCount) {

        setCurrentType(ExerciseType.SUB);
        operationList.clear();// ���operationList����
        answers.clear();// ��մ�����
        current = 0;// ��ʼ����ǰ����λ��
        OperationCount = operationCount;// ��ֵ����Ա����
        FileName = "Substract_exercise_" + operationCount + "_";
        BinaryOperation anOperation1;// anOperation1����BinaryOperation��
        while (operationCount > 0) {
            do {
                anOperation1 = new SubstractOperation();// �������ñ���
            } while (contains(anOperation1));// ����contains��������ʽ���ظ�������ѭ��
            operationList.add(anOperation1);// ��anOperation ���뵽Exercise��
            answers.add(new Answers());
            operationCount--;
        }
    }

    /**
     * @methodsName: writeCSVExercise
     * @description: �����ļ�
    */
    public void writeCSVExercise() {
        int count = OperationCount;// ��ʽ����
        FileName = Addr + FileName + ".csv";// ����ϰ���ļ�����
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
                fileWritter.write(operationList.get(i).toString());// ����ʽת��Ϊ�ַ�����ʽȻ��������ĵ�����
                fileWritter.write(",");
                if ((i + 1) % 5 == 0)
                    fileWritter.write("\r\n");
            }
            System.out.println("ϰ���ļ�������");
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @methodsName: readCSVExercise
     * @description: ��ϰ���ļ��н�ϰ����������
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
        System.out.println("ϰ���Ѿ�����");
        in.close();
    }

    /**
     * @methodsName: Add
     * @description: ��һ����ʽ���뵽exercise��
     * @param: op ������
    */
    void Add(BinaryOperation op) {
        operationList.add(op);
        OperationCount++;
    }

    /**
     * @methodsName: writeCSVAdditionEercise
     * @description: ������ɼӷ�ϰ��
     * @param: count 
    */
    public void writeCSVAdditionEercise(int count) {
        generateAdditionExercise(count);// ����ϰ��
        writeCSVExercise();// ������ļ�
    }

    /**
     * @methodsName: writeCSVAdditionEercise
     * @description: ������ɼ���ϰ��
     * @param: count 
    */
    public void writeCSVSubstractEercise(int count) {
        generateSubstractExercise(count);// ����ϰ��
        writeCSVExercise();// ������ļ�
    }

    /**
     * @methodsName: writeCSVAdditionEercise
     * @description: ������ɻ��ϰ��
     * @param: count 
    */
    public void writeCSVBinaryEercise(int count) {
        generateBinaryExercise(count);// ����ϰ��
        writeCSVExercise();// ������ļ�
    }

    /**
     * @methodsName: AddOrSub
     * @description: ����һ���ַ������жϸ��ַ����Ǽӷ����Ǽ���
     * @param: s
     * @return1: true �ӷ�
     * @return2: false �ӷ�
    */
    static boolean AddOrSub(String s) {
        int pos = s.indexOf("+");
        if (pos != -1)
            return true;// �ӷ�
        else
            return false;// ����
    }

    /**
     * @methodsName: AddOrSub
     * @description: ����һ����ʽ�ַ����������ַ���ת������ʽ���󣬷��������ʽ����
     * @param: s
     * @return1: true �ӷ�
     * @return2: false �ӷ�
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
     * @description: ����һ����ʽ�ַ����������ַ���ת������ʽ���󣬷��������ʽ����
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
     * @description: ���鳤��
     * @return: OperationCount
    */
    public int length() {
        return OperationCount;
    }
}
