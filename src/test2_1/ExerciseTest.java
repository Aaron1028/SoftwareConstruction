package test2_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @version: V1.0
 * @author: 张宥一
 * @testName: ExerciseTest
 * @packageName: test2_1
 * @description: 对Exercise类进行测试
 * @data: 2019-11-26
 **/
class ExerciseTest {
    Exercise ex;
    BinaryOperation operationList[] = new BinaryOperation[50];

    @BeforeEach
    void setUp() throws Exception {
        ex = new Exercise();
    }

    /**
     * @testName: testGenerateBinaryExercise
     * @description: 测试generateBinaryExercise方法
     * 1.输出50道混合算式
     * 2.每行输出5个算式
    **/
    @Test
    void testGenerateBinaryExercise() {
        ex.generateBinaryExercise();
        System.out.print("\n--以下输出混合算式--\n");
        ex.formattedDisplay(ex, 5);

    }

    /**
     * @testName: testGenerateAdditionExercise
     * @description: 测试generateAdditionExercise方法
     * 1.输出50道加法算式
     * 2.每行输出5个算式
    **/
    @Test
    void testGenerateAdditionExercise() {
        ex.generateAdditionExercise();
        System.out.print("\n--以下输出加法算式--\n");
        ex.formattedDisplay(ex, 5);
    }

    /**
     * @testName: testGenerateSubstractExercise
     * @description: 测试generateSubstractExercise方法
     * 1.输出50道减法算式
     * 2.每行输出5个算式
    **/
    @Test
    void testGenerateSubstractExercise() {
        ex.generateSubstractExercise();
        System.out.print("\n--以下输出减法算式--\n");
        ex.formattedDisplay(ex, 5);
    }

    /**
     * @testName: testformattedDisplay
     * @description: 测试formattedDisplay方法
     * 1.输出50道减法算式
     * 2.每行输出4个算式
    **/
    @Test
    void testformattedDisplay() {
        ex.generateBinaryExercise();
        System.out.print("\n--以下输出4列混合算式--\n");
        ex.formattedDisplay(ex, 4);
    }
}
