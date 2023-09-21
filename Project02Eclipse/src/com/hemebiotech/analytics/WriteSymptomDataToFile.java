package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {

            // Check if the symptoms map is not empty
            if (!symptoms.isEmpty()){

                // Create the result.out file
                FileWriter writer = new FileWriter("result.out");

                for (String symptom : symptoms.keySet()){

                    // Get the count of symptom
                    int count = symptoms.get(symptom);

                    // Writes the symptom and counter to the result.out file
                    writer.write(symptom + ": " + count + "\n");
                }
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
