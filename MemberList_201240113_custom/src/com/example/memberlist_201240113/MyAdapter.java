package com.example.memberlist_201240113;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    // Adapter?�� 추�??�� ?��?��?���? ???��?���? ?��?�� ArrayList
   
  //?��?��?���? ?��?��받�? ?��?��?���? ???��?�� 맴버 ?��?���? ?��?��?��?��. 
  	Context context;
  	int layoutRes;
  	ArrayList<MemberVO> list;
  	//?? ?��?��?��?��?�� xml 문서�? ?��?��?��?�� ?��?��?��?��?�� ?��개할 ?��?��?��?��?��개자 객체�? ?��?��?��?��.
  	LayoutInflater inflater;
  //?��?��?��
  	public MyAdapter(Context context, 
  			int layoutRes, ArrayList<MemberVO> list){
  		this.context=context;
  		this.layoutRes=layoutRes;
  		this.list=list;
  		//?��?��?��?��?�� LayoutInflater 객체�? ?��?��???�� 맴버?��?��?�� ???��?��?��.
  		inflater=LayoutInflater.from(context);
  	}

    // Adapter?�� ?��?��?��?�� ?��?��?��?�� 개수�? 리턴. : ?��?�� 구현
    @Override
    public int getCount() {
        return list.size() ;
    }

    // position?�� ?��치한 ?��?��?���? ?��면에 출력?��?��?�� ?��?��?�� View�? 리턴. : ?��?�� 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout?�� inflate?��?�� convertView 참조 ?��?��.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        // ?��면에 ?��?��?�� View(Layout?�� inflate?��)?��로�??�� ?��?��?�� ???�� 참조 ?��?��
        
        TextView name = (TextView) convertView.findViewById(R.id.tAddr);
        TextView addr = (TextView) convertView.findViewById(R.id.tName);
        TextView pnum = (TextView) convertView.findViewById(R.id.tNum);
        
        MemberVO mem=list.get(position);
        name.setText("�̸� : "+mem.getName());
        addr.setText("�ּ� "+ mem.getAddr());
        pnum.setText("����ȣ"  +mem.getPhoneNum());
        
        return convertView;
    }

    // �??��?�� ?���?(position)?�� ?��?�� ?��?��?��?? �?계된 ?��?��?��(row)?�� ID�? 리턴. : ?��?�� 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // �??��?�� ?���?(position)?�� ?��?�� ?��?��?�� 리턴 : ?��?�� 구현
    @Override
    public Object getItem(int position) {
        return list.get(position) ;
    }

 
}
