package test.parkjungwhan.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import test.day06.listview.R;

public class MainActivity2 extends Activity{
	//맴버필드에 필요한 객체 선언하기
	EditText inputName;
	EditText inputPwd;
	ListView listView;
	
	Button btn;
	ArrayList<Member> list;
//	ArrayAdapter<String> adapter;
	MyAdapter adapter;
	Member member;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//화면 구성하기 
		setContentView(R.layout.main2);
		//main2.xml 에 전개된 객체의 참조값 얻어오기
		inputName=(EditText)findViewById(R.id.inputName);
		inputPwd=(EditText)findViewById(R.id.inputPwd);
		listView=(ListView)findViewById(R.id.listView);
		
		//Adapter 객체에 연결할 모델객체 생성하기
		list=new ArrayList<Member>();
		
		//리스트뷰에 연결할 Adapter 객체 생성하기
		adapter=new MyAdapter(this,
				R.layout.item,
				list);
		
		//리스트 뷰에 아답타 객체 연결하기
		listView.setAdapter(adapter);
		
		//버튼 선언
		btn=(Button)findViewById(R.id.login);
		
		//버튼 클릭시
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//1. EditText 객체에 입력한 문자열을 읽어온다. 그리고 시간을 가져온다. 
				String name=inputName.getText().toString();
				SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
				String date=day.format(new Date());
				Context context = getApplicationContext();
				//2. Adapter 에 연결된 모델객체에 읽어온 문자열을 추가 한다.
				member= new Member();
				member.setId(name);
				member.setDate(date);
				//list.add("ID : "+ name+"          Time : "+ date);
				list.add(member);
				//3. Adapter 에 모델의 데이터가 바뀌었다고 알려서 화면에 반영되도록한다.
				adapter.notifyDataSetChanged();
				//4. 입력창 초기화
				inputName.setText("");
				inputPwd.setText("");
				//5. 키보드 숨기기
				
				Util.hideKeyboard(context, inputName);
				Util.hideKeyboard(context, inputPwd);
			}
		});
		
		
		
	}
	
	
	/*
	 * XML에서 버튼에 OnCLick 하는 경우
	
	//추가 버튼을 눌렀을때 호출되는 메소드
	public void add(View v){
		//1. EditText 객체에 입력한 문자열을 읽어온다. 그리고 시간을 가져온다. 
		String name=inputName.getText().toString();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		String date=day.format(new Date());
		
		//2. Adapter 에 연결된 모델객체에 읽어온 문자열을 추가 한다.
		list.add("아이디 :"+name+"           시간:"+date);
		
		//3. Adapter 에 모델의 데이터가 바뀌었다고 알려서 화면에 반영되도록한다.
		adapter.notifyDataSetChanged();
		//4. 입력창 초기화
		inputName.setText("");
		inputPwd.setText("");
		//5. 키보드 숨기기
		Util.hideKeyboard(this, inputName);
		Util.hideKeyboard(this,inputPwd);
	}
	 */
	/*
	//키보드 숨기는 메소드
	public void hideKeyboard(){
		InputMethodManager iManager=(InputMethodManager)
				getSystemService(Context.INPUT_METHOD_SERVICE);
		
		iManager.hideSoftInputFromWindow(inputName.getWindowToken(),0);
	}
	*/
}








