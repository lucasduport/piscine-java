package fr.epita.assistants.travel;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Country {
    String countryName;
    ZoneId countryZone;
    Map<String, Integer> travelTimes;

    public Country(String _countryName, String _countryZone, String _inputFilePath) {
        countryName = _countryName;
        countryZone = ZoneId.of(_countryZone);
        travelTimes = initTravelTimes(_inputFilePath);
    }
    public Map<String, Integer> initTravelTimes(String inputFilePath)
    {
        Map<String, Integer> tt = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(inputFilePath));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null)
            {
                if (values[0].equals(countryName)) {
                    tt.put(values[1], Integer.parseInt(values[2]));
                }
                else if (values[1].equals(countryName)) {
                    tt.put(values[0], Integer.parseInt(values[2]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tt;
    }
}
