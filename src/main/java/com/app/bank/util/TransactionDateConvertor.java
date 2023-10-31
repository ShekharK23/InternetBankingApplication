<<<<<<< HEAD
package com.app.bank.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionDateConvertor {

	public static String convertCurrentDateToString(String dateFormatPattern) {
		LocalDate currentDate = LocalDate.now(); // Get the current date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern);
		return currentDate.format(formatter);
	}

	public static void main(String[] args) {
		String dateFormatPattern = "yyyy-MM-dd"; // The format pattern for the date

		String currentDateAsString = convertCurrentDateToString(dateFormatPattern);

		System.out.println("Current date as a string: " + currentDateAsString);
	}
}
=======
package com.app.bank.util;

import java.time.LocalDate;

public class TransactionDateConvertor {
	
	public static LocalDate getDateFromString(String str) {

		String arr[] = str.split("-");

		if (arr.length == 3) {
			int year = Integer.parseInt(arr[2]);
			int month = Integer.parseInt(arr[1]);
			int date = Integer.parseInt(arr[0]);

			LocalDate d1 = LocalDate.now();
			return d1;
		}
		else return null;
	}
}

>>>>>>> 7ef2464f9802c2f68997c33d5b457686e1833e4d
