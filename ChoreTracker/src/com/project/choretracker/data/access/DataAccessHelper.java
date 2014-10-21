package com.project.choretracker.data.access;

import com.project.choretracker.data.utils.DataAccessConstants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataAccessHelper extends SQLiteOpenHelper{

	public DataAccessHelper(Context context){
		super(context, DataAccessConstants.DATA_SOURCE, 
				null, DataAccessConstants.DATA_SOURCE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DataAccessConstants.CREATE_DATABASE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS " + DataAccessConstants.CHILDREN_TABLE);
		onCreate(db);
	}

}
