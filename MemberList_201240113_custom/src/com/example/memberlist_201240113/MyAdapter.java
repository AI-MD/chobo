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
    // Adapter?— ì¶”ê??œ ?°?´?„°ë¥? ???¥?•˜ê¸? ?œ„?•œ ArrayList
   
  //?ƒ?„±?ë¡? ? „?‹¬ë°›ì? ?°?´?„°ë¥? ???¥?•  ë§´ë²„ ?•„?“œë¥? ? •?˜?•œ?‹¤. 
  	Context context;
  	int layoutRes;
  	ArrayList<MemberVO> list;
  	//?? ?•˜?‚˜?•˜?‚˜?— xml ë¬¸ì„œë¥? ?´?š©?•´?„œ ? ˆ?´?•„?›ƒ?„ ? „ê°œí•  ? ˆ?´?•„?›ƒ? „ê°œì ê°ì²´ê°? ?•„?š”?•˜?‹¤.
  	LayoutInflater inflater;
  //?ƒ?„±?
  	public MyAdapter(Context context, 
  			int layoutRes, ArrayList<MemberVO> list){
  		this.context=context;
  		this.layoutRes=layoutRes;
  		this.list=list;
  		//?ƒ?„±??—?„œ LayoutInflater ê°ì²´ë¥? ?–»?–´???„œ ë§´ë²„?•„?“œ?— ???¥?•œ?‹¤.
  		inflater=LayoutInflater.from(context);
  	}

    // Adapter?— ?‚¬?š©?˜?Š” ?°?´?„°?˜ ê°œìˆ˜ë¥? ë¦¬í„´. : ?•„?ˆ˜ êµ¬í˜„
    @Override
    public int getCount() {
        return list.size() ;
    }

    // position?— ?œ„ì¹˜í•œ ?°?´?„°ë¥? ?™”ë©´ì— ì¶œë ¥?•˜?Š”?° ?‚¬?š©?  Viewë¥? ë¦¬í„´. : ?•„?ˆ˜ êµ¬í˜„
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout?„ inflate?•˜?—¬ convertView ì°¸ì¡° ?š?“.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        // ?™”ë©´ì— ?‘œ?‹œ?  View(Layout?´ inflate?œ)?œ¼ë¡œë??„° ?œ„? ¯?— ???•œ ì°¸ì¡° ?š?“
        
        TextView name = (TextView) convertView.findViewById(R.id.tAddr);
        TextView addr = (TextView) convertView.findViewById(R.id.tName);
        TextView pnum = (TextView) convertView.findViewById(R.id.tNum);
        
        MemberVO mem=list.get(position);
        name.setText("ÀÌ¸§ : "+mem.getName());
        addr.setText("ÁÖ¼Ò "+ mem.getAddr());
        pnum.setText("Æù¹øÈ£"  +mem.getPhoneNum());
        
        return convertView;
    }

    // ì§?? •?•œ ?œ„ì¹?(position)?— ?ˆ?Š” ?°?´?„°?? ê´?ê³„ëœ ?•„?´?…œ(row)?˜ IDë¥? ë¦¬í„´. : ?•„?ˆ˜ êµ¬í˜„
    @Override
    public long getItemId(int position) {
        return position;
    }

    // ì§?? •?•œ ?œ„ì¹?(position)?— ?ˆ?Š” ?°?´?„° ë¦¬í„´ : ?•„?ˆ˜ êµ¬í˜„
    @Override
    public Object getItem(int position) {
        return list.get(position) ;
    }

 
}
