package android.sample;



import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	UserDatabaseHelper helper;
     SQLiteDatabase sqlitedb;
     Button button;
     Button button2;
     MovieVO mvo=new MovieVO();
     ListAdapter adapter;
     CheckBox chb;
     ListView list;
     
   
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
        helper= new UserDatabaseHelper(this);
		sqlitedb = helper.getWritableDatabase();
        
        Bundle extras = getIntent().getExtras();//객체 직렬화는 bundle를 통해 인텐트로 넘어온 것들을 받아옴
        if (extras != null) {//그것이 널이 아니라면
            mvo = (MovieVO)getIntent().getSerializableExtra("mvo"); //Obtaining data //mvo 키값인 value들을  MemberVO 형태로 캐스팅해서 가져옴
        }
        
       
        if(mvo.getM_Name()!=null){
        	int day=Integer.parseInt(mvo.getD_day());
        	//System.out.println("이름 :" +uvo.getName()  +"나이"+uvo.getAge() +"도시" +uvo.getCity());
        	sqlitedb.execSQL("INSERT INTO M_List " + "(M_Name, S_day, D_day, Location )" + "VALUES ('"+mvo.getM_Name()+"', '" + mvo.getS_day() + "',"+day+",'"+mvo.getLocation() +"');");
        }
        
       
      
        
        OnItemClickListener item = null;
       // chb= (CheckBox)findViewById(R.id.CheckBox01);
       
        // 쿼리문을 통해 데이터 조회
        final Cursor cursor = sqlitedb.rawQuery("SELECT * FROM M_List ", null);
        
        list= (ListView) findViewById(R.id.ListView01);

        String[] data_columns = new String[] {"M_Name", "S_day", "D_day", "Location"};
        
        int[] widgets = new int[] {R.id.TextView01, R.id.TextView02, R.id.TextView03,R.id.TextView04};

        // 리스트 어댑터를 이용 리스트 뷰에 출력
        if (cursor != null ){
            startManagingCursor(cursor);
                       
            adapter =new SimpleCursorAdapter(this, R.layout.dbview, cursor, data_columns, widgets);
            
            
            
            list.setAdapter(adapter);
          
         
            item = new OnItemClickListener()
            {
            		public void onItemClick(AdapterView<?> adapter, View clickedView, int position, long id)
            		{
            			Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
            			intent.putExtra("data_name", cursor.getString(cursor.getColumnIndex("M_Name")));
            			intent.putExtra("data_sday", cursor.getString(cursor.getColumnIndex("S_day")));
            			intent.putExtra("data_dday", cursor.getString(cursor.getColumnIndex("D_day")));
            			intent.putExtra("data_location", cursor.getString(cursor.getColumnIndex("Location")));
            			intent.putExtra("data_id", cursor.getString(cursor.getColumnIndex("_id")));
            			startActivity(intent);
            		
            		}
            };
            
            list.setOnItemClickListener(item);
        }        
         
        // 데이터베이스 종료
        //sqlitedb.close();
        
        
        button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(MainActivity.this, Register.class);

				startActivity(intent);
				
			}
		});
		 
        
  }
    
    @Override
    protected void onDestroy() {
    	sqlitedb.close();//앱종료시 데이터베이스 종료 
    	super.onDestroy();
    }
}    
    


