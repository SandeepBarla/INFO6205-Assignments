package edu.neu.coe.info6205.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtil {

    public static List<String> hindiWordsList(String fileName) throws FileNotFoundException {
        List<String> hindiWords = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(fileName)))) {

            String word = br.readLine();

            while(word != null) {
                hindiWords.add(word);
                word = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return hindiWords;
    }

}
