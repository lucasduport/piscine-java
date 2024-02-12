package fr.epita.assistants;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
import fr.epita.assistants.loggingThreads.TimeWaster;
import org.slf4j.LoggerFactory;

public class Main {
    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        LOGGER.info("Entering application");

        TimeWaster waster = new TimeWaster();

        Thread sum = new Thread(() -> waster.sumUpTo(123456789));
        Thread importantThing = new Thread(waster::doImportantThing);

        sum.start();
        importantThing.start();
        importantThing.interrupt();

        // FIXME: Manually interrupt importantThing to test your output

        sum.join();
        importantThing.join();

        LOGGER.info("Clean application exit");
    }
}