package com.iba.dates;

import java.text.ParseException;
import java.util.InputMismatchException;

public class Test {
	
	public static void main(String[] args) {
		try{
			InputOutput io = new InputOutput();
			io.readData();
			io.parseDate(io.setFormat());
			io.printResult();
		}
		catch(InputMismatchException e){
			System.out.println("Incorrect number");
		}
		catch (ParseException e) {
			System.out.println("Incorrect date");
		}
	}
}
