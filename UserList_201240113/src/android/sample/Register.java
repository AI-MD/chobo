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
				
				EditText name = (EditText)findViewById(R.id.name);
				EditText city = (EditText)findViewById(R.id.city);
				EditText age = (EditText)findViewById(R.id.age);
				String na =  name.getText().toString();
				String ci = city.getText().toString();
				String ag = age.getText().toString();
				
				UserrVO vo=new UserrVO();
				vo.setName(na);
				vo.setCity(ci);
				vo.setAge(ag);

				Intent intent = new Intent(Register.this, MainActivity.class);

				intent.putExtra("uvo",vo);
				startActivity(intent);
				
           
	                         
			
			}
		});
	}
	
	
}
