/****************************************************\
Author Info:
        Name:张宥一           ID: 201609009 
Module Name:
        CalculateProject
History:
        Created on 2019/11/8 by 张宥一
        Modified on 2019/11/15 by 张宥一
\****************************************************/

package test;

import java.util.Random;

public class Test01 {
    static int i;
    static String Equation[][] = new String[51][3];
    static int Value[] = new int[51];

    /************************************************\ 
     * Function Name: PrintHeader 
     * Function Description: 输出-程序输出50道100以内的加减法算式的习题- 
     * Arguments:NULL 
     * Return Value:NULL 
     * History: 2019/11/14 by 张宥一 
    \**********************************************/
    public void PrintHeader() {
        System.out.print("-程序输出50道100以内的加减法算式的习题-");
    }

    /************************************************\ 
     * Function Name: PrintValue 
     * Function Description: 输出 -下面是习题的参考答案-
     * Arguments:NULL Return 
     * Value:NULL 
     * History: 2019/11/14 by 张宥一 
     \**********************************************/
    public void PrintBottom() {
        System.out.print("\n-下面是习题的参考答案-");
    }

    /***********************************************\
     *  Function Name: GenerateEquations 
     *  Function Description: 生成不相同的100道加减法算式
     * Arguments:NULL
     *  Return Value:NULL 
     *  History: 2019/11/14 by 张宥一 
     \**********************************************/
    public void GenerateEquations()// 生成算式
    {
        int j;
        int op;
        int UPPER = 100; // 算式的最大值为100
        int LOWER = 0; // 算式的最小值为0
        int left_operand = 0; // 加号或减号左边的数
        int right_operand = 0; // 加号或减号右边的数
        Random random = new Random();
        for (i = 0; i < 50; i++) { // 循环生成50道算式
            do { // 用do while循环控制算式结果小于100，大于0
                left_operand = random.nextInt(UPPER + 1);
                right_operand = random.nextInt(UPPER + 1);
            } while (left_operand + right_operand >= UPPER || left_operand - right_operand <= LOWER);

            Equation[i][0] = String.valueOf(left_operand); // 将随机生成的左操作数存入数组
            Equation[i][2] = String.valueOf(right_operand); // 将随机生成的右操作数存入数组
            op = random.nextInt(2); // 随机生成0或者1
            if (op == 0) {
                Value[i] = left_operand + right_operand;
                Equation[i][1] = "+"; // op=0 代表生成加号，存入数组
            } else {
                Value[i] = left_operand + right_operand; // op=1 为+号
                Equation[i][1] = "-"; // op=1 代表生成加号，存数数组
            }

            for (j = 0; j < i; j++) {
                // 每个新生成的算式，都与前面的算式进行比较 ，左操作数、右操作数数值一样，但位置相反，也算式同样的算式
                String equation1 = Equation[i][0] + Equation[i][1] + Equation[i][2];
                String equation2 = Equation[i][2] + Equation[i][1] + Equation[i][0];
                String equation3 = Equation[j][0] + Equation[j][1] + Equation[j][2];
                if (equation1 == equation3 || equation2 == equation3) {
                    break;
                }
            }
            if (j != i) { // 生成了相同的算式，并存入数组中，数组要重新储存
                i--;
            }
        }
    }

    /***********************************************\
     * Function Name: PrintEquations 
     * Function Description: 按照每行5个的格式，输出算式
     * Arguments:NULL 
     * Return Value:NULL 
     * History: 2019/11/14 by 张宥一 
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
     * Function Description: 按照每行5个的格式，输出答案
     * Arguments:NULL 
     * Return Value:NULL 
     * History: 2019/11/14 by 张宥一 
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
