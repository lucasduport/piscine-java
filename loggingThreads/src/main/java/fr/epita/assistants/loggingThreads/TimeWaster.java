package fr.epita.assistants.loggingThreads;

import java.math.*;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
import org.slf4j.LoggerFactory;

public class TimeWaster {
    private final Logger LOGGER;
    public TimeWaster() {
        LOGGER = (Logger) LoggerFactory.getLogger(TimeWaster.class);
        LOGGER.setLevel(Level.TRACE);
    }

    /**
     * @param n Last natural number to sum
     * @return The sum of integers from 0 to n
     */
    public BigInteger sumUpTo(int n) {
        LOGGER.trace("Calculating");
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }
        LOGGER.debug("Finished calculating sum up to {}: {}", n, sum);
        return sum;
    }

    public void doImportantThing() {
        LOGGER.info("Waiting");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.error("Wait interrupted");
        }
    }
}
