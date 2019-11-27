package test2_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @version: V1.0
 * @author: ���һ
 * @testName: ExerciseTest
 * @packageName: test2_1
 * @description: ��Exercise����в���
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
     * @description: ����generateBinaryExercise����
     * 1.���50�������ʽ
     * 2.ÿ�����5����ʽ
    **/
    @Test
    void testGenerateBinaryExercise() {
        ex.generateBinaryExercise();
        System.out.print("\n--������������ʽ--\n");
        ex.formattedDisplay(ex, 5);

    }

    /**
     * @testName: testGenerateAdditionExercise
     * @description: ����generateAdditionExercise����
     * 1.���50���ӷ���ʽ
     * 2.ÿ�����5����ʽ
    **/
    @Test
    void testGenerateAdditionExercise() {
        ex.generateAdditionExercise();
        System.out.print("\n--��������ӷ���ʽ--\n");
        ex.formattedDisplay(ex, 5);
    }

    /**
     * @testName: testGenerateSubstractExercise
     * @description: ����generateSubstractExercise����
     * 1.���50��������ʽ
     * 2.ÿ�����5����ʽ
    **/
    @Test
    void testGenerateSubstractExercise() {
        ex.generateSubstractExercise();
        System.out.print("\n--�������������ʽ--\n");
        ex.formattedDisplay(ex, 5);
    }

    /**
     * @testName: testformattedDisplay
     * @description: ����formattedDisplay����
     * 1.���50��������ʽ
     * 2.ÿ�����4����ʽ
    **/
    @Test
    void testformattedDisplay() {
        ex.generateBinaryExercise();
        System.out.print("\n--�������4�л����ʽ--\n");
        ex.formattedDisplay(ex, 4);
    }
}
