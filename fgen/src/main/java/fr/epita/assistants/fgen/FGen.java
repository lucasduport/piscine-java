package fr.epita.assistants.fgen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;

public class FGen extends ClassLoader{

    private String currPath;

    private void create_dir(final String path)
    {
            if (!new File(currPath + File.separator + path).mkdirs())
                return;
    }

    private void create(final String path) throws RuntimeException
    {
        try {
            int idx = path.lastIndexOf(File.separator);
            if (idx != -1) {
                String nameofdirs = path.substring(0, idx);
                if (!nameofdirs.equals(""))
                    create_dir(nameofdirs);
            }
            File file = new File(currPath + File.separator+ path);
            file.createNewFile();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private void deleteDirectory (File file){
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDirectory(f.getAbsoluteFile());
            }
        }
        file.delete();
    }
    private void delete(final String path)
    {
        deleteDirectory(new File(currPath + File.separator+ path));
    }

    private void chdir(final String path)
    {
        currPath += File.separator + path;
    }

    public FGen(final String inputPath) {
        currPath = new File("").getAbsolutePath();
        InputStream is = getClass().getClassLoader().getResourceAsStream(inputPath);
        if (is == null)
            throw new RuntimeException();

        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        try (BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '+')
                    create(line.substring(2));
                else if (line.charAt(0) == '-')
                    delete(line.substring(2));
                else if (line.charAt(0) == '>')
                    chdir(line.substring(2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
