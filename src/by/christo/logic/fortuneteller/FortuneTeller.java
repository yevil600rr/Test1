package by.christo.logic.fortuneteller;

import by.christo.bean.Chamomile;
import by.christo.logic.fileprocessor.FileData;
import by.christo.logic.fileprocessor.FileFiller;
import by.christo.logic.fileprocessor.MyFileReader;

import java.io.IOException;
import java.util.*;

public class FortuneTeller {
    private LinkedHashMap<String, HashSet<String>> predictions;
    private String finalPrediction = null;

    public void start() throws IOException {
        MyFileReader fileReader = new MyFileReader("predictions.txt");
        FileData fileData = new FileData();

        fileData.addData(new FileFiller().populateFileDate(fileReader.getHeaders(), fileReader.getLines()));
        this.predictions = fileData.getFileData();

        showMnu();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        String userInput = scanner.nextLine();

        while(!userInput.equals("0")) {


            switch(userInput) {
                case "1":
                    predictionProcces("Love");
                    break;

                case "2":
                    predictionProcces("Money");
                    break;

                case "3":
                    predictionProcces("Happiness");
                    break;

                 default:
                     System.out.println("\nType a number from 1 through 3 to get a prediction!" +
                             " And 0 if you wanna leave!");
            }

            System.out.print("\nYour choice: ");
            userInput = scanner.nextLine();
        }

        System.out.println("\nGOODBYE! GOOD LUCK!");
    }

    private List<String> pickPredictions(String header) {
        List<String> headerPrediction = null;

        for(Map.Entry<String, HashSet<String>> entry: predictions.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(header)) {
                headerPrediction  = new ArrayList<>(entry.getValue());
            }
        }
        return headerPrediction;
    }

    private void predictionProcces(String direction) {
        List<String> prediction = pickPredictions(direction);

        int petals = new Chamomile().getPetalsNum();
        int petalsCounter = petals;
        int counter = 0;
        System.out.println("\nFORTUNE TELLER: \"I'm picking up a Chamomile and it " +
                "has " + petals + " petals.\"");

        for(int i = 0; i < petalsCounter; i++) {
            if(counter == prediction.size()) {
                counter = 0;
            }
            finalPrediction = prediction.get(counter);
            counter++;

            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {}

            System.out.println("\nThere's left " + petals-- + " petals");
        }

        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {}

        char[] letters = finalPrediction.toUpperCase().toCharArray();

        System.out.print("\nFORTUNE TELLER: \"");

        for(char letter: letters) {
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {}

            System.out.print(letter);
        }

        System.out.println("\"");
    }

    private void showMnu() {
        System.out.println("****************************************");
        System.out.println("DESTINY PREDICTION!");
        System.out.println("****************************************\n");

        System.out.println("FORTUNE TELLER: \"Hello my dear friend. I can predict your destiny!\n" +
                "Just type a number to choose a direction to predict for!\"\n");

        System.out.println("1) Love.");
        System.out.println("2) Money.");
        System.out.println("3) Happiness.");
        System.out.println("0) Quit from here.\n");
    }
}
