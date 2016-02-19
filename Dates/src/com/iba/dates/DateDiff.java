package com.iba.dates;

import java.util.Date;


public class DateDiff implements Constants{
	private Date curDate;
	private Date newDate;

	public DateDiff(){
		this.curDate = new Date();
		this.newDate = new Date();
	}
	
	private long getDiffInMilisec(){
		return this.curDate.getTime()-this.newDate.getTime();
	}
	public long getDiffInDays() {
		long diff = this.getDiffInMilisec();
		 return diff / days;
	}
	public long getDiffInHours() {
		long diff = this.getDiffInMilisec();
		 return (diff % days)/hours;
	}
	public long getDiffInMinutes() {
		long diff = this.getDiffInMilisec();
		 return ((diff % days)%hours)/minutes;
	}
	public long getDiffInSeconds() {
		long diff = this.getDiffInMilisec();
		 return (((diff % days)%hours)%minutes)/seconds;
	}

	public Date getCurDate() {
		return curDate;
	}

	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}
		

	}