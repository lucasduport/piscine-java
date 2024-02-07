package fr.epita.assistants.test2;

    import com.jcraft.jsch.IO;
    import fr.epita.assistants.server.MyServer;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.Timeout;

    import java.io.IOException;

    import static fr.epita.assistants.test2.Test2.*;
    import static org.junit.jupiter.api.Assertions.*;

    public class Test2Test {
        @Test
        void divTest1() {
            assertEquals(division(4,2), 2);
        }
        @Test
        void divTest2() {
            assertEquals(division(0,2), 0);
        }
        @Test
        void divTest3() {
            assertThrowsExactly(ArithmeticException.class, () -> division(4,0));
        }
        @Test
        @Timeout(3)
        void divTest4() {
            assertEquals(division(Integer.MAX_VALUE,5), 5);
        }
        @Test
        void divTest5() {
            assertEquals(division(-1, -7), 0);
        }

        @Test
        void triboTest1() {
            assertEquals(tribonacci(0),0);
        }
        @Test
        void triboTest2() {
            assertThrowsExactly(IllegalArgumentException.class,() -> tribonacci(-1) );
        }
        @Test
        void triboTest3() {
            assertEquals(tribonacci(5),11);
        }
        @Test
        void triboTest4() {
            assertEquals(tribonacci(8),33);
        }
        @Test
        void triboTest5() {
            assertEquals(tribonacci(Integer.MAX_VALUE),Long.MAX_VALUE);
        }

        @Test
        void servTest1()
        {
            assertDoesNotThrow(() -> {
                serverGetResponseCode();
                assertTrue(true);
            });
        }

        @Test
        void servTest2()
        {

            assertDoesNotThrow(() -> {
                MyServer.launchServer();
                serverGetResponseCode();
                serverGetResponseCode();
                serverGetResponseCode();
            });
        }

        @Test
        void servTest3()
        {

            assertDoesNotThrow(() -> {
                MyServer.launchServer();
                serverGetResponseCode();
                serverGetResponseCode();
                serverGetResponseCode();
                MyServer.stopServer();
            });
        }

        @Test
        void servTest4()
        {

            assertDoesNotThrow(() -> {
                serverGetResponseCode();
                serverGetResponseCode();
                MyServer.stopServer();
            });
        }
        @Test
        void servTest5()
        {
            MyServer.stopServer();
            assertTrue(true);
        }
        @Test
        void servTest6()
        {

            MyServer.stopServer();
            assertTrue(true);

        }
}
