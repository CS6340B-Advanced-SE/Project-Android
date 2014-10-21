package com.project.choretracker.data.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import android.util.Log;

public class QueryUtility {
	
	final static String CLASS_NAME = "QueryUtility";

	static public String constructWhereClause(NameValuePair[] pairs) throws ChoreTrackerException{
		
		final String METHOD = "constructWhereClause";
		String whereClause = "";
		
		if(pairs == null){
			String message = CLASS_NAME + " " + METHOD + " Parameter <pairs> is null. Unable to " + METHOD;
			Log.e(CLASS_NAME, message);
			throw new ChoreTrackerException(message);
		}
		
		for(int i = 0; i < pairs.length; i++){
			whereClause += pairs[i].getName() + " ";
		}
		
		return whereClause;
	}
	
	static public String[] constructWhereArgs(NameValuePair[] pairs) throws ChoreTrackerException{
		final String METHOD = "constructWhereArgs";
		List<String> args = new ArrayList<String>();

		if(pairs == null){
			String message = CLASS_NAME + " " + METHOD + " Parameter <pairs> is null. Unable to " + METHOD;
			Log.e(CLASS_NAME, message);
			throw new ChoreTrackerException(message);
		}
		
		for(NameValuePair pair : pairs)
		{
			args.add(pair.getValue());
		}
		
		return (String[]) args.toArray();
	}
}
