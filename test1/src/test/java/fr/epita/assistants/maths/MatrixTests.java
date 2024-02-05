package fr.epita.assistants.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTests {
    @Test
    void constructTest() {
        int[][] val = new int[2][2];
        Matrix m = new Matrix(val);
        assertEquals(m.getMatrix(), val);
        assertInstanceOf(Matrix.class, m);
    }

    @Test
    void constructTest1() {
        int[][] val = new int[3][3];
        val[0][2] = 8;
        Matrix m = new Matrix(val);
        assertInstanceOf(Matrix.class, m);
        assertEquals(m.getMatrix(), val);
    }

    @Test
    void constructTest2() {
        int[][] val = null;
        Matrix m = new Matrix(val);
        assertEquals(m.getMatrix(), val);
    }

    @Test
    void constructTest3() {
        int[][] val = new int[0][0];
        Matrix m = new Matrix(val);
        assertEquals(m.getMatrix(), val);
        assertInstanceOf(Matrix.class, m);
    }

    @Test
    void constructTest4() {
        int[][] val = new int[2][5];
        Matrix m = new Matrix(val);
        Matrix m2 = new Matrix(new int[2][3]);
        assertNotEquals(m,m2);
        assertNotSame(m,m2);
    }

    @Test
    void constructTest5() {
        int[][] val = new int[2][3];
        Matrix m = new Matrix(val);
        Matrix m2 = new Matrix(new int[2][3]);
        assertNotEquals(m,m2);
        assertNotSame(m,m2);
    }
    @Test
    void constructTest6() {
        Matrix m = new Matrix(null);
        assertEquals(m.getMatrix(), null);
        assertThrows(NullPointerException.class, () -> m.getMatrix());
    }

    @Test
    void constructTest7() {
        int[][] val = new int[3][3];
        val[0] = null;
        Matrix m = new Matrix(val);
        assertInstanceOf(Matrix.class, m);
        assertEquals(m.getMatrix(), val);
    }


    @Test
    void equalTest1() {
        int[][] val = new int[2][2];
        val[1][0] = 5;
        Matrix m = new Matrix(val);
        Matrix j = new Matrix(val);
        assertTrue(m.equals(m));
        assertFalse(m.equals(j));
    }

    @Test
    void equalTest2() {
        int[][] val = new int[2][2];
        val[1][0] = 5;
        Matrix m = new Matrix(val);
        Matrix j = null;
        assertTrue(m.equals(m));
        assertFalse(m.equals(j));
    }

    @Test
    void equalTest3() {
        int[][] val = new int[2][2];
        val[1][0] = 5;
        Matrix m = new Matrix(val);
        assertTrue(m.equals(m));
        val[0][1] = 3;
        assertFalse(m.equals(m));
    }

    @Test
    void equalTest4() {
        int[][] val = new int[3][2];
        val[1][0] = 5;
        Matrix m = new Matrix(val);
        Matrix j = new Matrix(new int[3][7]);
        assertFalse(m.equals(j));
        assertFalse(j.equals(m));
        assertEquals(m.equals(j), j.equals(m));
    }

    @Test
    void multiplyTest1()
    {
        int [][] val = new int[1][1];
        val[0][0] = 0;
        Matrix m = new Matrix(val);
        assertFalse(m.multiply(m).equals(m));
    }

    @Test
    void multiplyTest2()
    {
        int [][] val = new int[2][1];
        val[0][0] = 0;
        int [][] val1 = new int[2][3];
        val[0][1] = 0;
        Matrix m = new Matrix(val);
        Matrix m1 = new Matrix(val1);
        assertFalse(m.multiply(m1).equals(m1.multiply(m)));
    }
    @Test

    void multiplyTest3()
    {
        int [][] val = new int[2][1];
        val[0][0] = 0;
        Matrix m = new Matrix(val);
        Matrix m1 = new Matrix(null);
        assertTrue(m.multiply(m1).equals(m1.multiply(m)));
    }
    @Test
    void multiplyTest4()
    {
        int [][] val = new int[3][2];
        val[0][0] = 0;
        int [][] val1 = new int[2][3];
        val[0][1] = 0;
        Matrix m = new Matrix(val);
        Matrix m1 = new Matrix(val1);
        assertTrue(m.multiply(m1).equals(m1.multiply(m)));
    }

    @Test
    void multiplyTest5()
    {
        int [][] val = new int[5][5];
        val[0][0] = 0;
        val[3][3] = 2;
        int [][] val1 = new int[5][5];
        val1[0][1] = 0;
        val1[3][3] = 2;

        Matrix m = new Matrix(val);
        Matrix m1 = new Matrix(val1);
        assertFalse(m.multiply(m1).equals(m1.multiply(m)));
    }


    @Test
    void multiplyTest6()
    {
        int [][] val = new int[2][1];
        val[0][0] = 0;
        Matrix m = new Matrix(val);
        Matrix m1 = null;
        assertTrue(m.multiply(m1).equals(m1.multiply(m)));
    }

    @Test
    void multiplyTest7()
    {
        int [][] val = new int[2][1];
        val[0][0] = 0;
        int [][] val1 = new int[1][2];
        val1[0][0] = 0;
        Matrix m = new Matrix(val);
        Matrix m1 = new Matrix(val1);
        assertThrows(IndexOutOfBoundsException.class, () -> m.multiply(m1));
    }

    @Test
    void multiplyTest8()
    {
        int [][] val = new int[2][1];
        val[0][0] = 0;
        int [][] val1 = new int[1][2];
        val1[0] = null;
        Matrix m = new Matrix(val);
        Matrix m1 = new Matrix(val1);
        assertThrows(NullPointerException.class, () -> m.multiply(m1));
    }
}
