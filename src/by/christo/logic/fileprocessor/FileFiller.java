package by.christo.logic.fileprocessor;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class FileFiller {

    public LinkedHashMap<String, HashSet<String>> populateFileDate(List<String> headers, List<String> lines) {
        LinkedHashMap<String, HashSet<String>> mapData = new LinkedHashMap<>();
        int counter = 0;

        while(counter < headers.size()) {
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i).split(";");
                set.add(line[counter].trim());
            }
            mapData.put(headers.get(counter), set);
            counter++;
        }

        return mapData;
    }

}
