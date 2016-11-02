package com.example.androidproject;



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
	//�ɹ��ʵ忡 �ʿ��� ��ü �����ϱ�
	EditText inputName;
	EditText inputPwd;
	ListView listView;
	ArrayList<String> list;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ȭ�� �����ϱ� 
		setContentView(R.layout.main2);
		//main2.xml �� ������ ��ü�� ������ ������
		inputName=(EditText)findViewById(R.id.inputName);
		inputPwd=(EditText)findViewById(R.id.inputPwd);
		listView=(ListView)findViewById(R.id.listView);
		
		//Adapter ��ü�� ������ �𵨰�ü �����ϱ�
		list=new ArrayList<String>();
		
		//����Ʈ�信 ������ Adapter ��ü �����ϱ�
		adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				list);
		
		//����Ʈ �信 �ƴ�Ÿ ��ü �����ϱ�
		listView.setAdapter(adapter);
		
	}
	//�߰� ��ư�� �������� ȣ��Ǵ� �޼ҵ�
	public void add(View v){
		//1. EditText ��ü�� �Է��� ���ڿ��� �о�´�.
		String name=inputName.getText().toString();
		
		//2. Adapter �� ����� �𵨰�ü�� �о�� ���ڿ��� �߰� �Ѵ�.
		list.add(name);
		//3. Adapter �� ���� �����Ͱ� �ٲ���ٰ� �˷��� ȭ�鿡 �ݿ��ǵ����Ѵ�.
		adapter.notifyDataSetChanged();
		//4. �Է�â �ʱ�ȭ
		inputName.setText("");
		inputPwd.setText("");
		//5. Ű���� �����
		Util.hideKeyboard(this, inputName);
		Util.hideKeyboard(this,inputPwd);
	}
	/*
	//Ű���� ����� �޼ҵ�
	public void hideKeyboard(){
		InputMethodManager iManager=(InputMethodManager)
				getSystemService(Context.INPUT_METHOD_SERVICE);
		
		iManager.hideSoftInputFromWindow(inputName.getWindowToken(),0);
	}
	*/
}








