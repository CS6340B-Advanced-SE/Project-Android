package com.project.choretracker.data.utils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DataAccessConstants {
	// Database Authentication Constants
	public static final String DATA_SOURCE = "";
	public static final String CONNECTION_STRING = "";
	public static final String APPLICATION_ID = "";
	public static final String PASSWORD = "";
	public static final int DATA_SOURCE_VERSION = 1;
	
	// Database Query Constants
	public static final String SELECT_ALL = "SELECT * FROM";
	public static final String INSERT = "INSERT INTO";
	public static final String WHERE = "WHERE";
	public static final String AND = "AND";
	
	// Database create statement constant
	public static final String CREATE_DATABASE = "create table Children(UID integer primary key autoincrement, DOB text not null, Name text not null);";
	
	// Database Tables
	public static final String CHILDREN_TABLE = "CHILDREN";
}
