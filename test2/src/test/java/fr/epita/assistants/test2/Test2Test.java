package fr.epita.assistants.test2;

import fr.epita.assistants.server.MyServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static fr.epita.assistants.test2.Test2.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

public class Test2Test {
    @Test
    void divTest1() {
        assertEquals(division(4, 2), 2);
    }

    @Test
    void divTest2() {
        assertEquals(division(0, 2), 0);
    }

    @Test
    void divTest3() {
        assertThrowsExactly(ArithmeticException.class, () -> division(4, 0));
    }

    @Test
    @Timeout(value = 3, unit = SECONDS)
    void divTest4() {
        assertEquals(division(Integer.MAX_VALUE, 5), 5);
    }

    @Test
    void divTest5() {
        assertEquals(division(-1, -7), 0);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest1() {
        assertEquals(tribonacci(0), 0);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest2() {
        assertThrowsExactly(IllegalArgumentException.class, () -> tribonacci(-1));
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest50() {
        assertThrowsExactly(IllegalArgumentException.class, () -> tribonacci(-15));
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest3() {
        assertEquals(tribonacci(5), 11);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest4() {
        assertEquals(tribonacci(8), 33);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest5() {
        assertEquals(tribonacci(Integer.MAX_VALUE), 3);
    }

    @Test
    void triboTest6() {
        assertEquals(tribonacci(0), 0);
    }

    @Test
    void triboTest7() {
        assertThrowsExactly(IllegalArgumentException.class, () -> tribonacci(-1));
    }

    @Test
    void triboTest8() {
        assertEquals(tribonacci(5), 11);
    }

    @Test
    void triboTest9() {
        assertEquals(tribonacci(8), 33);
    }

    @Test
    void triboTest10() {
        assertEquals(tribonacci(Integer.MAX_VALUE), 3);
    }

    @Test
    void triboTest11() {

        assertEquals(tribonacci(545448494), 5);
    }
    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest12() {
        assertEquals(tribonacci(0) + tribonacci(1) + tribonacci(2),tribonacci(3));
    }
    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest13() {
        assertEquals(tribonacci(0), 0);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest14() {
        assertThrowsExactly(IllegalArgumentException.class, () -> tribonacci(-1));
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest15() {
        assertEquals(tribonacci(5), 11);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest16() {
        assertEquals(tribonacci(8), 33);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest17() {
        assertEquals(tribonacci(Integer.MAX_VALUE), 3);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest18() {

        assertEquals(tribonacci(545448494), 5);
    }
    @Test
    @Timeout(value = 1, unit = SECONDS)
    void triboTest19() {
        assertEquals(tribonacci(0) + tribonacci(1) + tribonacci(2),tribonacci(3));
    }

    @Test
    void servTest1() {
        assertDoesNotThrow(() -> {
            serverGetResponseCode();
            assertTrue(true);
        });
    }

    @Test
    void servTest2() {

        assertDoesNotThrow(() -> {
            MyServer.launchServer();
            serverGetResponseCode();
            serverGetResponseCode();
            serverGetResponseCode();
        });
    }

    @Test
    void servTest3() {

        assertDoesNotThrow(() -> {
            MyServer.launchServer();
            serverGetResponseCode();
            serverGetResponseCode();
            serverGetResponseCode();
            MyServer.stopServer();
        });
    }

    @Test
    void servTest15() {

        assertDoesNotThrow(() -> {
            MyServer.launchServer();
            serverGetResponseCode();
            serverGetResponseCode();
            serverGetResponseCode();
            MyServer.stopServer();
            serverGetResponseCode();
        });
    }

    @Test
    void servTest4() {

        assertDoesNotThrow(() -> {
            serverGetResponseCode();
            serverGetResponseCode();
            MyServer.stopServer();
        });
    }

    @Test
    void servTest6() {
        MyServer.stopServer();
    }

    @Test
    void servTest16() {
        MyServer.stopServer();
        MyServer.stopServer();
        MyServer.stopServer();
    }

    @Test
    void servTest13() {
        assertDoesNotThrow(MyServer::launchServer);
    }

    @Test
    void servTest17() {
        assertDoesNotThrow(() -> {
            MyServer.launchServer();
            MyServer.launchServer();
            MyServer.launchServer();
        });
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void servTest7() {
        assertDoesNotThrow(() -> {
            serverGetResponseCode();
            assertTrue(true);
        });
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void servTest8() {

        assertDoesNotThrow(() -> {
            MyServer.launchServer();
            serverGetResponseCode();
            serverGetResponseCode();
            serverGetResponseCode();
        });
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void servTest9() {

        assertDoesNotThrow(() -> {
            MyServer.launchServer();
            serverGetResponseCode();
            serverGetResponseCode();
            serverGetResponseCode();
            MyServer.stopServer();
        });
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void servTest10() {

        assertDoesNotThrow(() -> {
            serverGetResponseCode();
            serverGetResponseCode();
            MyServer.stopServer();
        });
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void servTest11() {
        MyServer.stopServer();
        assertTrue(true);
    }

    @Test
    @Timeout(value = 1, unit = SECONDS)
    void servTest12() {

        MyServer.stopServer();
        assertTrue(true);

    }
}
