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
		
		Bundle extras = getIntent().getExtras();//��ü ����ȭ�� bundle�� ���� ����Ʈ�� �Ѿ�� �͵��� �޾ƿ�
         if (extras != null) {//�װ��� ���� �ƴ϶��
             mvo = (MemberVO)getIntent().getSerializableExtra("mvo"); //Obtaining data //mvo Ű���� value����  MemberVO ���·� ĳ�����ؼ� ������
         }
         
         
        SingleList sl=SingleList.getInstance();//�̱��� �������� ����� ���� Ŭ���� �ν��Ͻ� ���� �޼ҵ� ȣ��(arrayList�� ���� ��Ƽ��Ƽ���� �����ϱ� ����)
        sl.add(mvo);//�� �ν��Ͻ� add �޼ҵ忡 Member ��ü �߰�
        alist=sl.getList();// ListActivity �� ����Ʈ ����� �����Ϳ� �̱��� ����Ʈ�� �޾ƿ�
         
	
        //items =new ArrayList<String>();
		//for(MemberVO mem : alist){//����Ʈ�信 �ѷ��� ���� ����� ����
	   //     items.add("name : " +mem.getName()+" addr : " + mem.getAddr() +"number" +mem.getPhoneNum());
		//}
       
		
		adapter1=new MyAdapter(this, R.layout.item, alist);
         
		if(alist.size()!=0){
			adapter1.notifyDataSetChanged();
         }
       
		list=(ListView)findViewById(R.id.list);
 		list.setAdapter(adapter1);
         
 		
		
		//�ڷΰ���
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
		
		//����
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
