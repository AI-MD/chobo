package com.example.memberlist_201240113;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {
	
	//ArrayAdapter<String> adapter;
	ArrayList<MemberVO> alist; 
	ArrayList<String> items;
	MyAdapter adapter1;
	Button button1, button2;
	MemberVO mvo;
	ListView list;
	//static ArrayList<MemberVO> slist;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		Bundle extras = getIntent().getExtras();//객체 직렬화는 bundle를 통해 인텐트로 넘어온 것들을 받아옴
         if (extras != null) {//그것이 널이 아니라면
             mvo = (MemberVO)getIntent().getSerializableExtra("mvo"); //Obtaining data //mvo 키값인 value들을  MemberVO 형태로 캐스팅해서 가져옴
         }
         
         
        SingleList sl=SingleList.getInstance();//싱글톤 패턴으로 만들어 놓은 클래스 인스턴스 생성 메소드 호출(arrayList를 여러 액티비티에서 공유하기 위함)
        sl.add(mvo);//위 인스턴스 add 메소드에 Member 객체 추가
        alist=sl.getList();// ListActivity 에 리스트 만들어 놓은것에 싱글톤 리스트를 받아옴
         
	
        //items =new ArrayList<String>();
		//for(MemberVO mem : alist){//리스트뷰에 뿌려줄 형태 만드는 로직
	   //     items.add("name : " +mem.getName()+" addr : " + mem.getAddr() +"number" +mem.getPhoneNum());
		//}
       
		
		adapter1=new MyAdapter(this, R.layout.item, alist);
         
		if(alist.size()!=0){
			adapter1.notifyDataSetChanged();
         }
       
		list=(ListView)findViewById(R.id.list);
 		list.setAdapter(adapter1);
         
 		
		
		//뒤로가기
		button1 = (Button)findViewById(R.id.back);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//adapter.notifyDataSetChanged();
				// TODO Auto-generated method stub
				Intent intent = new Intent(ListActivity.this, Register.class);
				
				startActivity(intent);
				

			}
		});
		
		//종료
		button2 = (Button)findViewById(R.id.exit);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				moveTaskToBack(true);
				finish();
				
			}
		});
		
	}

	

}
