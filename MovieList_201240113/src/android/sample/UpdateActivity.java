package android.sample;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;

public class UpdateActivity extends Activity {
	UserDatabaseHelper helper;
    SQLiteDatabase sqlitedb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.udateview);
		helper= new UserDatabaseHelper(this);
        
		sqlitedb = helper.getWritableDatabase();
        
		Intent intent =getIntent();
		final String id=intent.getStringExtra("data_id");
		String name=intent.getStringExtra("data_name");
		String s_day=intent.getStringExtra("data_sday");
		String d_day=intent.getStringExtra("data_dday");
		String location=intent.getStringExtra("data_location");
		
		
		//System.out.println("확인" + id);
		final EditText text1 =(EditText)findViewById(R.id.editText2);
		final EditText tex2 =(EditText)findViewById(R.id.editText3);
		final EditText text3 =(EditText)findViewById(R.id.editText4);
		final EditText text4 =(EditText)findViewById(R.id.editText5);
		
		text1.setText(name);
		tex2.setText(s_day);
		text3.setText(d_day);
		text4.setText(location);
		
		Button btn1;
		Button btn2;
		Button btn3;
		
		/*
		 * 수정과 삭제 
		btn1 = (Button)findViewById(R.id.button1);
		
		
		btn2 = (Button)findViewById(R.id.button2);
		*/
		btn3 = (Button)findViewById(R.id.button3);
		
		
		
		/*수정과 삭제 기능구현 
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

//				
				String nam=text1.getText().toString();
				String sd=tex2.getText().toString();
			    String dd=text3.getText().toString();
			    String lo=text4.getText().toString();
		       int day=Integer.parseInt(dd);
				// SQLiteOpenHelper의 확장 구현을 통해 데이터베이스 생성
		        
		       
				sqlitedb.execSQL("UPDATE M_List " + "SET M_Name ='"+nam+"', S_day='"+sd+"', D_day="+day+",Location='"+lo + "' WHERE _id="+id+";");
		        //sqlitedb.close();
				
				Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
				
		        
				startActivity(intent);
				
			}
		});
		
		
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("확인" +id);
				sqlitedb.execSQL("DELETE from  M_List  WHERE _id="+id+";");
		        
				Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
				
				startActivity(intent);
				
			}
		});
		*/
		
		btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
				
				startActivity(intent);
				
			}
		});
	}

	@Override
	protected void onDestroy() {
		sqlitedb.close();
	}
	
}
