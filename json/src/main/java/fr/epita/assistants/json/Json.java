package fr.epita.assistants.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json {
    public static void addToJson(String foo, String bar, String s){
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            File f = new File(s);
            Map<String, String> map;
            if (f.exists())
                 map = mapper.readValue(Paths.get(s).toFile(), Map.class);
            else
                map = new HashMap<>();

            // print map entries
            map.put(foo, bar);

            ObjectMapper om = new ObjectMapper();
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(s)))
            {
                bw.write(om.writeValueAsString(map));
            }
            catch (IOException e)
            {
                throw new RuntimeException();
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
