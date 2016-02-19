package com.iba.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutput {
	private int flag;
	private String str;
	private DateDiff dateDiff = new DateDiff();
	
	public void readData() throws InputMismatchException{
		System.out.println("The allowable formats of date are 'dd.MM.yyyy' press 1, 'dd.MM.yyyy,HH:mm:ss' press 2");
		Scanner s = new Scanner(System.in);
		this.flag = s.nextInt();
		if (flag ==1 || flag==2){
		System.out.println("Input date: ");
		this.str = s.next();
		s.close();		
		}
		else {
			s.close();
			throw new InputMismatchException();
		}
	}
	
	public SimpleDateFormat setFormat(){
		if(flag==1){
			return new SimpleDateFormat("dd.MM.yyyy");
		}
		if (flag==2){
			return new SimpleDateFormat("dd.MM.yyyy,HH:mm:ss");
		}
		return new SimpleDateFormat("");
	}
	public void parseDate(SimpleDateFormat format) throws ParseException{
		format.setLenient(false);
		this.dateDiff.setNewDate(format.parse(this.str));
	}
	
	public void printResult(){
		if(flag==1){
			System.out.println("Days: "+dateDiff.getDiffInDays());
		}
		if(flag==2){
			System.out.println("Days: "+dateDiff.getDiffInDays());
			System.out.println("Hours: "+dateDiff.getDiffInHours());
			System.out.println("Minutes: "+dateDiff.getDiffInMinutes());
			System.out.println("Seconds: "+dateDiff.getDiffInSeconds());
		}
	}
}
