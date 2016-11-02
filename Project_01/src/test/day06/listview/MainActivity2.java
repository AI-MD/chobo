package test.day06.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity2 extends Activity{
	//맴버필드에 필요한 객체 선언하기
	EditText id;
	
	ListView listView;
	ArrayList<String> list;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//화면 구성하기 
		setContentView(R.layout.main2);
		//main2.xml 에 전개된 객체의 참조값 얻어오기
		id=(EditText)findViewById(R.id.id);
		//pwd=(EditText)findViewById(R.id.pwd);
		listView=(ListView)findViewById(R.id.listView);
		
		//Adapter 객체에 연결할 모델객체 생성하기
		list=new ArrayList<String>();
		
		//리스트뷰에 연결할 Adapter 객체 생성하기
		adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				list);
		
		//리스트 뷰에 아답타 객체 연결하기
		listView.setAdapter(adapter);
		
	}
	//추가 버튼을 눌렀을때 호출되는 메소드
	public void add(View v){
		//1. EditText 객체에 입력한 문자열을 읽어온다.
		String name=id.getText().toString();
		//2. Adapter 에 연결된 모델객체에 읽어온 문자열을 추가 한다.
		list.add(name);
		//3. Adapter 에 모델의 데이터가 바뀌었다고 알려서 화면에 반영되도록한다.
		adapter.notifyDataSetChanged();
		//4. 입력창 초기화
		id.setText("");
		
		//5. 키보드 숨기기
		Util.hideKeyboard(this, id);
		
	}

}








