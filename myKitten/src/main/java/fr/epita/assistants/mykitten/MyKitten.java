package fr.epita.assistants.mykitten;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyKitten {
    public Stream<String> streamContent;;

    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */
    public MyKitten(String srcPath) {
        try  {
            streamContent = Files.lines(Paths.get(srcPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {
        List<String> l = streamContent.toList();
        streamContent = l.stream().map(
                i -> (l.indexOf(i)+1) +  " " + i.replace(wordToReplace, "miaou"));

    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
            streamContent.forEach(
                    line -> {
                        try {
                            bw.write(line);
                            bw.write("\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            streamContent.close();
        }
    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) {
        MyKitten m = new MyKitten(srcPath);
        m.replaceByMiaou(wordToReplace);
        m.toFile(destPath);
    }


}
