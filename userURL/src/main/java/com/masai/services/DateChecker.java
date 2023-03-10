package com.masai.services;

import java.time.LocalDate;

public class DateChecker{

	public static boolean checkDate(LocalDate date) {
		
		if(LocalDate.now().compareTo(date)>=0) {
			return false;
		}else {
			return true;
		}
		
	}
	
}
