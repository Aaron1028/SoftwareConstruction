package test2_1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @version: V1.0
 * @author: 张宥一
 * @testName: BinaryOperationTest
 * @packageName: test2_1
 * @description: 对BinaryOperation类进行测试
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
     * @description: 测试construct方法，利用语句覆盖法设计测试用例
    **/
    @Test
    void testConstruct1() {
        bo.construct(1, 5, '+');
        assertEquals(6, bo.getValue());// 可以通过测试
    }

    /**
     * @testName: testConstruct2
     * @description: 测试construct方法，利用语句覆盖法设计测试用例
    **/
    @Test
    void testConstruct2() {
        bo.construct(50, 6, '-');
        assertEquals(44, bo.getValue());// 可以通过测试
    }

    /**
     * @testName: testConstruct3
     * @description: 测试construct方法，利用语句覆盖法设计测试用例
    **/
    @Test
    void testConstruct3() {
        bo.construct(90, 10, '/');
        assertEquals(9, bo.getValue());// 不可以通过测试
    }

    /**
     * @testName: ToString
     * @description: 测试toString方法，利用语句覆盖发设计测试用例
    **/
    @Test
    void testToString() {
        bo.construct(90, 20, '-');
        assertEquals(" " + 90 + '-' + 20 + "=", bo.toString());// 可以通过测试
    }

    /**
     * @testName: testFullString
     * @description: 测试fullString方法，利用语句覆盖发设计测试用例
    **/
    @Test
    void testFullString() {
        bo.construct(50, 20, '-');
        assertEquals(" " + 50 + '-' + 20 + "=" + 30, bo.fullString());// 可以通过测试
    }

    /**
     * @testName: testGetOperator1
     * @description: 
     * 1.测试getOperator方法，利用语句覆盖法设计测试用例
     * 2.赋值操作符为-
    **/
    @Test
    void testGetOperator1() {
        bo.construct(47, 24, '-');
        assertEquals('-', bo.getOperator());// 可以通过测试
    }

    /**
     * @testName: testGetOperator2
     * @description: 
     * 1.测试getOperator方法，利用语句覆盖法设计测试用例
     * 2.赋值操作符为+
    **/
    @Test
    void testGetOperator2() {
        bo.construct(63, 20, '+');
        assertEquals('+', bo.getOperator());// 可以通过测试
    }

    /**
     * @testName: testGetleft_operand1
     * @description: 测试getleft_operand方法，利用判定覆盖法设计测试用例
    **/
    @Test
    void testGetleft_operand1() {
        bo.construct(5, 50, '+');
        assertEquals(5, bo.getleft_operand());// 可以通过测试
    }

    /**
     * @testName: testGetleft_operand2
     * @description: 测试getleft_operand方法，利用判定覆盖法设计测试用例
    **/
    @Test
    void testGetleft_operand2() {
        bo.construct(30, 53, '+');
        assertEquals(53, bo.getleft_operand());// 不可以通过测试
    }

    /**
     * @testName: testGetright_operand1
     * @description: 测试getright_operand方法，利用判定覆盖法设计测试用例
    **/
    @Test
    void testGetright_operand1() {
        bo.construct(-1, 60, '+');
        assertEquals(60, bo.getright_operand());// 可以通过测试
    }

    /**
     * @testName: testGetright_operand2
     * @description: 测试getright_operand方法，利用判定覆盖法设计测试用例
    **/
    @Test
    void testGetright_operand2() {
        bo.construct(10, 60, '+');
        assertEquals(10, bo.getright_operand());// 不可以通过测试
    }

    /**
     * @testName: testGetValue1
     * @description: 测试getValue方法，利用判定覆盖法设计测试用例
    **/
    @Test
    void testGetValue1() {
        bo.construct(5, 6, '+');
        assertEquals(11, bo.getValue());// 可以通过测试
    }

    /**
     * @testName: testGetValue2
     * @description: 测试getValue方法，利用判定覆盖法设计测试用例
    **/
    @Test
    void testGetValue2() {
        bo.construct(71, 50, '-');
        assertEquals(31, bo.getValue());// 不可以通过测试
    }
}
