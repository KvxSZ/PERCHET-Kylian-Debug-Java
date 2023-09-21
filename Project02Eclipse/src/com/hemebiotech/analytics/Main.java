package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]){

        // Instanciation ISymptomReader
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");

        // Instanciation ISymptomWriter
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();

        // Instanciation AnalyticsCounter
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);

        // Calling AnalyticsCounter methods
        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);
        analyticsCounter.writeSymptoms(sortSymptoms);
    }

}
