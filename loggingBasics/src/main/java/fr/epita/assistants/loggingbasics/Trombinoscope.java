package fr.epita.assistants.loggingbasics;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import fr.epita.assistants.Main;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Trombinoscope {
    private final Logger LOGGER;
    private final HashMap<String, Long> map;

    public Trombinoscope() {
        LOGGER = (Logger) LoggerFactory.getLogger(Trombinoscope.class);
        LOGGER.setLevel(Level.TRACE);
        LOGGER.trace("Instantiating new Trombinoscope");
        map = new HashMap<>();
    }

    public Long putPerson(String name, long photoId) {

        LOGGER.debug("Putting person (\"{}\", {})", name, photoId);
        Long oldPhotoId = map.put(name,
                                  photoId);
        if (oldPhotoId == null)
            LOGGER.trace("Added entry for person \"{}\"", name);
        else
            LOGGER.trace("Updated entry for person \"{}\"", name);

        // FIXME: Add logging here

        return oldPhotoId;
    }
}
