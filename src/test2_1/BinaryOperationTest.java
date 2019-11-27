package test2_1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @version: V1.0
 * @author: ���һ
 * @testName: BinaryOperationTest
 * @packageName: test2_1
 * @description: ��BinaryOperation����в���
 * @data: 2019-11-26
 **/
class BinaryOperationTest {
    BinaryOperation bo;

    @BeforeEach
    void setUp() throws Exception {
        bo = new BinaryOperation();
    }

    /**
     * @testName: testConstruct1
     * @description: ����construct������������串�Ƿ���Ʋ�������
    **/
    @Test
    void testConstruct1() {
        bo.construct(1, 5, '+');
        assertEquals(6, bo.getValue());// ����ͨ������
    }

    /**
     * @testName: testConstruct2
     * @description: ����construct������������串�Ƿ���Ʋ�������
    **/
    @Test
    void testConstruct2() {
        bo.construct(50, 6, '-');
        assertEquals(44, bo.getValue());// ����ͨ������
    }

    /**
     * @testName: testConstruct3
     * @description: ����construct������������串�Ƿ���Ʋ�������
    **/
    @Test
    void testConstruct3() {
        bo.construct(90, 10, '/');
        assertEquals(9, bo.getValue());// ������ͨ������
    }

    /**
     * @testName: ToString
     * @description: ����toString������������串�Ƿ���Ʋ�������
    **/
    @Test
    void testToString() {
        bo.construct(90, 20, '-');
        assertEquals(" " + 90 + '-' + 20 + "=", bo.toString());// ����ͨ������
    }

    /**
     * @testName: testFullString
     * @description: ����fullString������������串�Ƿ���Ʋ�������
    **/
    @Test
    void testFullString() {
        bo.construct(50, 20, '-');
        assertEquals(" " + 50 + '-' + 20 + "=" + 30, bo.fullString());// ����ͨ������
    }

    /**
     * @testName: testGetOperator1
     * @description: 
     * 1.����getOperator������������串�Ƿ���Ʋ�������
     * 2.��ֵ������Ϊ-
    **/
    @Test
    void testGetOperator1() {
        bo.construct(47, 24, '-');
        assertEquals('-', bo.getOperator());// ����ͨ������
    }

    /**
     * @testName: testGetOperator2
     * @description: 
     * 1.����getOperator������������串�Ƿ���Ʋ�������
     * 2.��ֵ������Ϊ+
    **/
    @Test
    void testGetOperator2() {
        bo.construct(63, 20, '+');
        assertEquals('+', bo.getOperator());// ����ͨ������
    }

    /**
     * @testName: testGetleft_operand1
     * @description: ����getleft_operand�����������ж����Ƿ���Ʋ�������
    **/
    @Test
    void testGetleft_operand1() {
        bo.construct(5, 50, '+');
        assertEquals(5, bo.getleft_operand());// ����ͨ������
    }

    /**
     * @testName: testGetleft_operand2
     * @description: ����getleft_operand�����������ж����Ƿ���Ʋ�������
    **/
    @Test
    void testGetleft_operand2() {
        bo.construct(30, 53, '+');
        assertEquals(53, bo.getleft_operand());// ������ͨ������
    }

    /**
     * @testName: testGetright_operand1
     * @description: ����getright_operand�����������ж����Ƿ���Ʋ�������
    **/
    @Test
    void testGetright_operand1() {
        bo.construct(-1, 60, '+');
        assertEquals(60, bo.getright_operand());// ����ͨ������
    }

    /**
     * @testName: testGetright_operand2
     * @description: ����getright_operand�����������ж����Ƿ���Ʋ�������
    **/
    @Test
    void testGetright_operand2() {
        bo.construct(10, 60, '+');
        assertEquals(10, bo.getright_operand());// ������ͨ������
    }

    /**
     * @testName: testGetValue1
     * @description: ����getValue�����������ж����Ƿ���Ʋ�������
    **/
    @Test
    void testGetValue1() {
        bo.construct(5, 6, '+');
        assertEquals(11, bo.getValue());// ����ͨ������
    }

    /**
     * @testName: testGetValue2
     * @description: ����getValue�����������ж����Ƿ���Ʋ�������
    **/
    @Test
    void testGetValue2() {
        bo.construct(71, 50, '-');
        assertEquals(31, bo.getValue());// ������ͨ������
    }
}
