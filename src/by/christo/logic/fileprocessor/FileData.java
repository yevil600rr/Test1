package by.christo.logic.fileprocessor;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileData {
    private LinkedHashMap<String, HashSet<String>> fileData = null;

    public FileData() {
        this.fileData = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, HashSet<String>> getFileData() {
        return fileData;
    }

    public void addData(LinkedHashMap<String, HashSet<String>> data) {
        this.fileData = data;
    }

    public void printFileData() {
        for(Map.Entry<String, HashSet<String>> entry: fileData.entrySet()) {
            System.out.println(entry);
        }
    }
}
