package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {

		// Create an ArrayList to store the results
		ArrayList<String> result = new ArrayList<String>();

		// Checks if the file exists
		if (filepath != null) {
			try {

				// Get the file
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				// Loop over all the lines in the file to send them to the ArrayList result
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Return the result ArrayList
		return result;
	}

}
