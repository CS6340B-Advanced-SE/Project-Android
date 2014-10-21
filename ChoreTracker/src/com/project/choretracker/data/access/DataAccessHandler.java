package com.project.choretracker.data.access;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.project.choretracker.data.access.vo.ChildVO;
import com.project.choretracker.data.utils.DataAccessConstants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class DataAccessHandler {

	DataAccessHelper dataHelper;
	SQLiteDatabase database;
	
	public DataAccessHandler(Context context){
		super();
		dataHelper = new DataAccessHelper(context);
	}

	/*
	 * Database Connection Operations
	 */
	public void openConnection() throws SQLException {
		database = dataHelper.getWritableDatabase();
	}
	
	public void closeConnection(){
		dataHelper.close();
	}
	
	/*
	 * CRUD Operations
	 */
	
	public void insertValue(ContentValues value, String table){
		long insertID = database.insert(table, null, value);
		Log.w("DataAccessHandler", "insertID = " + insertID);
	}
	
	public void deleteRecord(String table, String whereClause, String[] whereArgs){
		database.delete(table, whereClause, whereArgs);
	}
	
	public List<ChildVO> getAllChildren(String whereClause, String[] whereArgs){
		List<ChildVO> children = new ArrayList<ChildVO>();
		Cursor cursor = database.query(
							DataAccessConstants.CHILDREN_TABLE, 
							null,
							whereClause, 
							whereArgs,
							null, 
							null,
							null);
		
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			ChildVO child = cursorToChild(cursor);
			children.add(child);
			cursor.moveToNext();
		}
		
		cursor.close();
		return children;
	}
	
	public ChildVO cursorToChild(Cursor cursor){
		ChildVO child = new ChildVO();
		child.setId(cursor.getLong(0));
		child.setDob(cursor.getString(1));
		child.setName(cursor.getString(2));
		return child;
	}
}
