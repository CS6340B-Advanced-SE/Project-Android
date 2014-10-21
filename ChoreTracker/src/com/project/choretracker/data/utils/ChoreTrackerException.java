package com.project.choretracker.data.utils;

public class ChoreTrackerException extends Exception {


	public ChoreTrackerException(String message){
		super(message);
	}
	
	public ChoreTrackerException(Throwable e){
		super(e);
	}
	
	public ChoreTrackerException(String message, Throwable e){
		super(message, e);
	}
	
	@Override
	public String toString(){
		String returnStr = "";

		return returnStr;
	}
}
