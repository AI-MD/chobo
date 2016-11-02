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
		String city=intent.getStringExtra("data_city");
		String age=intent.getStringExtra("data_age");
		
		
		//System.out.println("확인" + id);
		final EditText text1 =(EditText)findViewById(R.id.editText2);
		final EditText tex2 =(EditText)findViewById(R.id.editText3);
		final EditText text3 =(EditText)findViewById(R.id.editText4);
		
		text1.setText(name);
		tex2.setText(city);
		text3.setText(age);
		
		Button btn1;
		Button btn2;
		Button btn3;
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);
		btn3 = (Button)findViewById(R.id.button3);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

//				
				String nam=text1.getText().toString();
				String ci=tex2.getText().toString();
			    String ag=text3.getText().toString();

		       
				// SQLiteOpenHelper의 확장 구현을 통해 데이터베이스 생성
		        
		       
				sqlitedb.execSQL("UPDATE users " + "SET name ='"+nam+"', city='"+ci+"',age="+ag + " WHERE _id="+id+";");
		        //sqlitedb.close();
				
				Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
				
		        
				startActivity(intent);
				
			}
		});
		
		
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("확인" +id);
				sqlitedb.execSQL("DELETE from  users  WHERE _id="+id+";");
		        
				Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
				
				startActivity(intent);
				
			}
		});
		
		
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
