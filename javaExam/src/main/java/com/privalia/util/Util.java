package com.privalia.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.IntStream;

import static java.time.DayOfWeek.THURSDAY;
import static java.time.temporal.TemporalAdjusters.lastInMonth;

public class Util {

	public void readCSV() {

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

	public void investedDays() {
		IntStream.range(2001, 2018).forEach(i -> {
			IntStream.range(1, 13).forEach(j -> {
				LocalDate lastThursday = LocalDate.of(i, j, 1).with(lastInMonth(THURSDAY));
				System.out.println("lastThursday = " + lastThursday);
			});
		});
	}

}