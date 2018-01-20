package by.christo.runner;

import by.christo.logic.fortuneteller.FortuneTeller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FortuneTeller fortuneTeller = new FortuneTeller();
        fortuneTeller.start();




    }
}
