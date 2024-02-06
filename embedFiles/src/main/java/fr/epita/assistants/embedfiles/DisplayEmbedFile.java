package fr.epita.assistants.embedfiles;


import java.io.*;
import java.util.Objects;
import java.util.Optional;


public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {
        if (Objects.equals(filename, ""))
            return Optional.empty();
        File file = new File(getClass().getClassLoader().getResource("fileTest.txt").getFile());
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            return Optional.empty();
        }
        try( BufferedReader br =
                     new BufferedReader( new InputStreamReader(inputStream, "UTF-8" )))
        {
            StringBuilder sb = new StringBuilder();
            String line;
            while(( line = br.readLine()) != null ) {
                sb.append( line );
                sb.append( '\n' );
            }
            Optional<String> o = (Optional.of(sb.toString()));
            return o;
        } catch (IOException ex) {
            return Optional.empty();
        }
    }
}
