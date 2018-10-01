package com.privalia.csv;

import static java.time.DayOfWeek.THURSDAY;
import static java.time.temporal.TemporalAdjusters.lastInMonth;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class InvestedDays {

	public static void main(String[] args) {
		
		
		IntStream.range(2001, 2018).forEach( i -> {
			IntStream.range(1, 13).forEach( j -> {
				LocalDate lastThursday = LocalDate.of(i, j, 1).with(lastInMonth(THURSDAY));
				System.out.println("lastThursday = " + lastThursday);				
			});
		});

	}
}
