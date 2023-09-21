package com.hemebiotech.analytics;


import java.util.*;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;


	// Create the constructor
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		// Retrieves the list of symptoms using ISymptomReader's GetSymptoms method
		List<String> symptoms = reader.GetSymptoms();

		// Returns the list of symptoms
		return symptoms;
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms){

		// Create a Map to store symptom counts
		Map<String, Integer> symptomCount = new HashMap<>();

		// Browse the map of symptoms
		for (String symptom : symptoms){

			//Check if the symptom is already in the map
			if(symptomCount.containsKey(symptom)) {

				//If so, it adds one to the counter
				symptomCount.put(symptom, symptomCount.get(symptom) + 1);

			} else {

				// If not, add the symptom to the map with an initial counter of 1
				symptomCount.put(symptom, 1);

			}
		}

		// Return the map with the symptom counts
		return symptomCount;
	}


	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){

		// Creation of the list of entries
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(symptoms.entrySet());

		// Use a comparator to sort alphabetically
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
				return entry1.getKey().compareTo(entry2.getKey());
			}
		});


		// Create a new sorted map
		Map<String, Integer> sortedSymptoms = new LinkedHashMap<>();

		// Add sorted items to the new map
		for (Map.Entry<String, Integer> entry : entryList){
			sortedSymptoms.put(entry.getKey(), entry.getValue());
		}

		// Returns the new sorted map
		return sortedSymptoms;
	}

	// Call the writeSymptoms method
	public void writeSymptoms(Map<String, Integer> symptoms){
		writer.writeSymptoms(symptoms);
	}


}


