package android.sample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

class UserDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "samples6.db";
    private static final int DATABASE_VERSION = 1;
    // _id �÷� : CursorAdaptor�� �����͹��ε� �ϱ����� PRIMARY KEY�� _id�� �����ؾ���...
     static final String CREATE_TABLE_USERS =
        "CREATE TABLE M_List (" +
        "_id INTEGER PRIMARY KEY AUTOINCREMENT , " +  
        "M_Name TEXT NOT NULL, " +
        "S_day TEXT NOT NULL," +
        "D_day INTEGER NOT NULL," +
        "Location TEXT NOT NULL);";
    private static final String DROP_TABLE_USERS =
       "DROP TABLE IF EXISTS M_List";

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public UserDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    	//System.out.println("Ȯ��qwdqwdqwdwqdqwd");
        //db.execSQL(DROP_TABLE_USERS);
        //db.execSQL(CREATE_TABLE_USERS);
    	//sqllite ����� �����Ǵ� �޼ҵ�...������ users table�� �ִٸ� ���̺��� �������� �ʰ�.. ������ �Ʒ��� ���� �����. 
    	final Cursor cursor1 =db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' and name='M_List';",null);
    	 
        System.out.println("Ȯ��"+cursor1.getCount());
        
       // String temp = "111";
        
        if(cursor1 !=null){
	        //sqlitedb.execSQL(UserDatabaseHelper.DROP_TABLE_USERS);
        	db.execSQL(UserDatabaseHelper.CREATE_TABLE_USERS);
	        // �������� ���� ������ �߰�
        	
        	/*
        	db.execSQL("INSERT INTO users " + "(name, city, age)" + "VALUES ('Tang', " + temp + ", 12);");
        	db.execSQL("INSERT INTO users " + "(name, city, age)" + "VALUES ('Tang', " + temp + ", 14);");
        	db.execSQL("INSERT INTO users " + "(name, city, age)" + "VALUES ('Tang', " + temp + ", 154);");
        	db.execSQL("INSERT INTO users " + "(name, city, age)" + "VALUES ('Tang', " + temp + ", 12);");
        	db.execSQL("INSERT INTO users " + "(name, city, age)" + "VALUES ('Tang', " + temp + ", 143);");
        	db.execSQL("INSERT INTO users " + "(name, city, age)" + "VALUES ('Tang', " + temp + ", 12);");
	        */
        	
	        
        }
    	
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(DROP_TABLE_USERS);
        //onCreate(db);
    }
}

