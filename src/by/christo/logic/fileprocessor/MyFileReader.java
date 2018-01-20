package by.christo.logic.fileprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyFileReader {
    private String filePath;

    public MyFileReader(String filePath) {
        this.filePath = filePath;
    }


    public List<String> getHeaders() throws IOException {
        List<String> headers;
        String[] values;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            values = br.readLine().replaceAll("\\s", "").split(";");
        }

        headers = Arrays.asList(values);
        return headers;
    }



    public List<String> getLines() throws IOException {
        List<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line = null;

            while((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}
