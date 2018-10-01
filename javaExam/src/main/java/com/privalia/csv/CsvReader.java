package com.privalia.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

	public static void main(String[] args) {

		String csvFile = "stocks-ITX.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] fields = line.split(cvsSplitBy);
				
				System.out.println("Fecha: " + fields[0] + "  Apertura: " + fields[2] + "  Cierre: " + fields[1]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
}