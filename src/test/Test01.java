/****************************************************\
Author Info:
        Name:���һ           ID: 201609009 
Module Name:
        CalculateProject
History:
        Created on 2019/11/8 by ���һ
        Modified on 2019/11/15 by ���һ
\****************************************************/

package test;

import java.util.Random;

public class Test01 {
    static int i;
    static String Equation[][] = new String[51][3];
    static int Value[] = new int[51];

    /************************************************\ 
     * Function Name: PrintHeader 
     * Function Description: ���-�������50��100���ڵļӼ�����ʽ��ϰ��- 
     * Arguments:NULL 
     * Return Value:NULL 
     * History: 2019/11/14 by ���һ 
    \**********************************************/
    public void PrintHeader() {
        System.out.print("-�������50��100���ڵļӼ�����ʽ��ϰ��-");
    }

    /************************************************\ 
     * Function Name: PrintValue 
     * Function Description: ��� -������ϰ��Ĳο���-
     * Arguments:NULL Return 
     * Value:NULL 
     * History: 2019/11/14 by ���һ 
     \**********************************************/
    public void PrintBottom() {
        System.out.print("\n-������ϰ��Ĳο���-");
    }

    /***********************************************\
     *  Function Name: GenerateEquations 
     *  Function Description: ���ɲ���ͬ��100���Ӽ�����ʽ
     * Arguments:NULL
     *  Return Value:NULL 
     *  History: 2019/11/14 by ���һ 
     \**********************************************/
    public void GenerateEquations()// ������ʽ
    {
        int j;
        int op;
        int UPPER = 100; // ��ʽ�����ֵΪ100
        int LOWER = 0; // ��ʽ����СֵΪ0
        int left_operand = 0; // �ӺŻ������ߵ���
        int right_operand = 0; // �ӺŻ�����ұߵ���
        Random random = new Random();
        for (i = 0; i < 50; i++) { // ѭ������50����ʽ
            do { // ��do whileѭ��������ʽ���С��100������0
                left_operand = random.nextInt(UPPER + 1);
                right_operand = random.nextInt(UPPER + 1);
            } while (left_operand + right_operand >= UPPER || left_operand - right_operand <= LOWER);

            Equation[i][0] = String.valueOf(left_operand); // ��������ɵ����������������
            Equation[i][2] = String.valueOf(right_operand); // ��������ɵ��Ҳ�������������
            op = random.nextInt(2); // �������0����1
            if (op == 0) {
                Value[i] = left_operand + right_operand;
                Equation[i][1] = "+"; // op=0 �������ɼӺţ���������
            } else {
                Value[i] = left_operand + right_operand; // op=1 Ϊ+��
                Equation[i][1] = "-"; // op=1 �������ɼӺţ���������
            }

            for (j = 0; j < i; j++) {
                // ÿ�������ɵ���ʽ������ǰ�����ʽ���бȽ� ������������Ҳ�������ֵһ������λ���෴��Ҳ��ʽͬ������ʽ
                String equation1 = Equation[i][0] + Equation[i][1] + Equation[i][2];
                String equation2 = Equation[i][2] + Equation[i][1] + Equation[i][0];
                String equation3 = Equation[j][0] + Equation[j][1] + Equation[j][2];
                if (equation1 == equation3 || equation2 == equation3) {
                    break;
                }
            }
            if (j != i) { // ��������ͬ����ʽ�������������У�����Ҫ���´���
                i--;
            }
        }
    }

    /***********************************************\
     * Function Name: PrintEquations 
     * Function Description: ����ÿ��5���ĸ�ʽ�������ʽ
     * Arguments:NULL 
     * Return Value:NULL 
     * History: 2019/11/14 by ���һ 
     \*********************************************/
    public void PrintEquations() {
        for (i = 0; i < 50; i++) {
            if (i % 5 == 0) { //
                System.out.print("\n");
                System.out.print((i + 1) + "~" + (i + 5) + ":");
            }
            System.out.print("\t" + Equation[i][0] + Equation[i][1] + Equation[i][2] + "=");
        }
    }

    /************************************************ \ 
     * Function Name: PrintValue 
     * Function Description: ����ÿ��5���ĸ�ʽ�������
     * Arguments:NULL 
     * Return Value:NULL 
     * History: 2019/11/14 by ���һ 
     \**********************************************/
    private void PrintValue() {
        for (i = 0; i < 50; i++) {
            if (i % 5 == 0) {
                System.out.print("\n");
                System.out.print((i + 1) + "~" + (i + 5) + ":");
            }
            System.out.print("\t" + Value[i]);
        }
    }

    public static void main(String[] args) {
        Test01 T = new Test01();
        T.PrintHeader();
        T.GenerateEquations();
        T.PrintEquations();
        T.PrintBottom();
        T.PrintValue();

    }
}
