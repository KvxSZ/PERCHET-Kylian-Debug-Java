package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            if (!symptoms.isEmpty()){
                FileWriter writer = new FileWriter("result.out");
                for (String symptom : symptoms.keySet()){
                    int nbr = symptoms.get(symptom);
                    writer.write("symptom: " + nbr + "\n"); 
                }
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
