package fr.epita.assistants.travel;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Travel {
    public static void travelTo(Country source, Country destination) {
        System.out.printf("Boarding in %s, local date and time is: %s\n",
                source.countryName, ZonedDateTime.of(LocalDateTime.now(), source.countryZone).format(DateTimeFormatter.RFC_1123_DATE_TIME));
        System.out.printf("Landing in %s, local date and time on arrival will be: %s\n",
                destination.countryName,
                ZonedDateTime.of(LocalDateTime.now(), destination.countryZone).plusHours(source.travelTimes.get(destination.countryName)).format(DateTimeFormatter.RFC_1123_DATE_TIME));
    }
}
