package android.sample;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Activity {
	
	
	
	Button button;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		
		button = (Button)findViewById(R.id.button02);
		button.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText movie_name = (EditText)findViewById(R.id.movie_name);
				EditText s_day = (EditText)findViewById(R.id.s_day);
				EditText d_day = (EditText)findViewById(R.id.d_day);
				EditText location = (EditText)findViewById(R.id.location);
				String na =  movie_name.getText().toString();
				String sd = s_day.getText().toString();
				String dd = d_day.getText().toString();
				String lo = location.getText().toString();
				
				MovieVO mvo=new MovieVO();
				mvo.setM_Name(na);
				mvo.setS_day(sd);
				mvo.setD_day(dd);
				mvo.setLocation(lo);
				Intent intent = new Intent(Register.this, MainActivity.class);

				intent.putExtra("mvo",mvo);
				startActivity(intent);
				
           
	                         
			
			}
		});
	}
	
	
}
