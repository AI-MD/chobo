package test.parkjungwhan.project;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import test.day06.listview.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
   
  //생성자로 전달받은 데이터를 저장할 맴버 필드를 정의한다. 
  	Context context;
  	int layoutRes;
  	ArrayList<Member> list;
  	//셀 하나하나에 xml 문서를 이용해서 레이아웃을 전개할 레이아웃전개자 객체가 필요하다.
  	LayoutInflater inflater;
  //생성자
  	public MyAdapter(Context context, 
  			int layoutRes, ArrayList<Member> list){
  		this.context=context;
  		this.layoutRes=layoutRes;
  		this.list=list;
  		//생성자에서 LayoutInflater 객체를 얻어와서 맴버필드에 저장한다.
  		inflater=LayoutInflater.from(context);
  	}

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return list.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        
        TextView idTexttView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView dTextView = (TextView) convertView.findViewById(R.id.textView2) ;
        
        Member mem=list.get(position);
        idTexttView.setText(mem.getId());
        dTextView.setText(mem.getDate());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return list.get(position) ;
    }

 
}
