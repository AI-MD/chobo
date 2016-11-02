package android.sample;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        // SQLiteOpenHelper의 확장 구현을 통해 데이터베이스 생성
        UserDatabaseHelper helper = new UserDatabaseHelper(this);
        SQLiteDatabase sqlitedb = helper.getWritableDatabase();
        
        String temp = "111";
        sqlitedb.execSQL(UserDatabaseHelper.DROP_TABLE_USERS);
        sqlitedb.execSQL(UserDatabaseHelper.CREATE_TABLE_USERS);
       
        // 쿼리문을 통해 데이터 추가
        sqlitedb.execSQL("INSERT INTO users " + "(name, city, age, stuNum)" + "VALUES ('Tang', " + temp + ", 30, 201240113);");
        
        // 쿼리문을 통해 데이터 수정
        sqlitedb.execSQL("UPDATE users " + "SET city = 'Chungnam' " + "WHERE name = 'Hong';");
        
        // 쿼리문을 통해 데이터 조회
        Cursor cursor = sqlitedb.rawQuery("SELECT * FROM users ", null);
        
        ListView list = (ListView) findViewById(R.id.ListView01);

        String[] data_columns = new String[] {"name", "city", "age", "stuNum"};
        int[] widgets = new int[] {R.id.TextView01, R.id.TextView02, R.id.TextView03,R.id.TextView04};

        // 리스트 어댑터를 이용 리스트 뷰에 출력
        if (cursor != null ){
            startManagingCursor(cursor);

            ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.dbview, cursor, data_columns, widgets);

            list.setAdapter(adapter);
        }        
         
        // 데이터베이스 종료
        sqlitedb.close();
        
    }
    
    private class UserDatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "samples3.db";
        private static final int DATABASE_VERSION = 1;
        // _id 컬럼 : CursorAdaptor로 데이터바인딩 하기위해 PRIMARY KEY를 _id로 설정해야함...
        private static final String CREATE_TABLE_USERS =
            "CREATE TABLE users (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
            "name TEXT NOT NULL, " +
            "city TEXT NOT NULL," +
            "age INTEGER NOT NULL,"+
            "stuNum INTEGER NOT NULL);";
        private static final String DROP_TABLE_USERS =
           "DROP TABLE IF EXISTS users";

        public UserDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public UserDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DROP_TABLE_USERS);
            db.execSQL(CREATE_TABLE_USERS);
         }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE_USERS);
            onCreate(db);
        }
    }
}



