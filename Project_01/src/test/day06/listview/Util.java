package test.day06.listview;

import java.util.HashMap;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

/*
 * 개발기간을 줄일수 있는 자신만의 Util 클래스 만들어가기.
 */
public class Util {
	
	
	/*
	 * [ 키보드 숨기는 메소드 ]
	 * 
	 * 인자로 Context 객체와 현재 포커스가 있는 EditText 객체를 전달한다. 
	 */
	public static void hideKeyboard(Context context, EditText editText){
		InputMethodManager iManager=(InputMethodManager)
				context.getSystemService(Context.INPUT_METHOD_SERVICE);
		
		iManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
	}
	
	/*
	 * [ 토스트 메세지 띄우기 ]
	 * 
	 * 인자로 Context 객체와 띄울 String 객체를 전달한다. 
	 */
	public static void makeToast(Context context, String msg){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	

	
}






















































