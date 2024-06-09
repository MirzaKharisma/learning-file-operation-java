package com.enigmacamp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LearnIOCSV {
    public static void main(String[] args) {
        String path = "src/com/enigmacamp/excel/crime-data-1000.csv";
        try{
            readCsv(path);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void readCsv(String fileName) throws FileNotFoundException, IOException {
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while((line = br.readLine()) != null){
            String[] data = line.split(",");
            System.out.println("date: " + data[2] + " type of crime: " + data[5]);
        }
    }
}
