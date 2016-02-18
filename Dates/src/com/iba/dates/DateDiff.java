package com.iba.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DateDiff implements Constants{
	private Date curDate;
	private Date newDate;
	
	public DateDiff(){
		this.curDate = new Date();
		this.newDate = new Date();
	}

	private void differenceInDays() {
		long diff = this.curDate.getTime()-this.newDate.getTime();
		System.out.println("Days: " + diff / Constants.days);
	}
	
	private void differenceBigFormat() {
		long diff = this.curDate.getTime()-this.newDate.getTime();
		System.out.println("Days: " + diff / Constants.days);
		System.out.println("Hours: " + (diff % Constants.days)/Constants.hours);
		System.out.println("Minutes: " + ((diff % Constants.days)%Constants.hours)/Constants.minutes);
		System.out.println("Seconds: " + (((diff % Constants.days)%Constants.hours)%Constants.minutes)/Constants.seconds);
	}
	
	private void inputDate(SimpleDateFormat format,String s) throws ParseException{
		format.setLenient(false);	
		this.newDate = format.parse(s);
		System.out.println(this.newDate);	
		System.out.println(this.curDate);
	}

	public void doCalculate(){
		System.out.println("The allowable formats of date are 'dd.MM.yyyy' press 1, 'dd.MM.yyyy,HH:mm:ss' press 2");
		Scanner s = new Scanner(System.in);
		try{
			int flag = s.nextInt();
			if (flag==1){
				System.out.println("Input date: ");
				String str = s.next();
				SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
				inputDate(format,str);
				differenceInDays() ;
			}
			else if (flag==2){
				System.out.println("Input date: ");
				String str = s.next();
				SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy,HH:mm:ss");
				inputDate(format,str);
				differenceBigFormat();
			}
			else{
				System.out.println("Incorrect number.");
				return;
			}
				
		}
		catch(InputMismatchException e){
			System.out.println("Incorrect number");
		}
		catch (ParseException e) {
			System.out.println("Incorrect date");
			}
		finally{
			s.close();
		}
	}
}