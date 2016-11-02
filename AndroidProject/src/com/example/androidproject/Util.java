package com.example.androidproject;

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
 * ê°œë°œê¸°ê°„?„ ì¤„ì¼?ˆ˜ ?ˆ?Š” ??‹ ë§Œì˜ Util ?´?˜?Š¤ ë§Œë“¤?–´ê°?ê¸?.
 */
public class Util {
	
	
	/*
	 * [ ?‚¤ë³´ë“œ ?ˆ¨ê¸°ëŠ” ë©”ì†Œ?“œ ]
	 * 
	 * ?¸?ë¡? Context ê°ì²´?? ?˜„?¬ ?¬ì»¤ìŠ¤ê°? ?ˆ?Š” EditText ê°ì²´ë¥? ? „?‹¬?•œ?‹¤. 
	 */
	public static void hideKeyboard(Context context, EditText editText){
		InputMethodManager iManager=(InputMethodManager)
				context.getSystemService(Context.INPUT_METHOD_SERVICE);
		
		iManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
	}
	
	/*
	 * [ ?† ?Š¤?Š¸ ë©”ì„¸ì§? ?„?š°ê¸? ]
	 * 
	 * ?¸?ë¡? Context ê°ì²´?? ?„?š¸ String ê°ì²´ë¥? ? „?‹¬?•œ?‹¤. 
	 */
	public static void makeToast(Context context, String msg){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	

	/*
	 *  [ ?š¨ê³¼ìŒ ?“±ë¡ê³¼ ?¬?ƒ?„ ?¸?•˜ê²? ?•˜ê¸°ìœ„?•œ ?´?˜?Š¤ ]
	 *  
	 *  1. SoundManager.getInstance() ?•´?„œ ê°ì²´?˜ ì°¸ì¡°ê°’ì„ ?–»?–´?˜¨?‹¤?Œ
	 *  2. init() ë©”ì†Œ?“œ?˜ ?¸?ë¡? Context ê°ì²´ë¥? ? „?‹¬?•´?„œ ì´ˆê¸°?™” ?•´?„œ ?‚¬?š©?•œ?‹¤. 
	 */
	public static class SoundManager{
		private static SoundManager sManager; //?‹±ê¸??†¤ 
		private SoundPool soundPool;
		private HashMap<Integer, Integer> map;
		private Context context;
		//?™¸ë¶??—?„œ ê°ì²´ ?ƒ?„±?• ?ˆ˜ ?—†?„ë¡? ?ƒ?„±?ë¥? private ë¡? ?„¤? •
		private SoundManager(){}
		//ì°¸ì¡°ê°’ì„ ë¦¬í„´?•˜?Š” ë©”ì†Œ?“œ ? œê³?
		public static SoundManager getInstance(){
			if(sManager==null){
				sManager=new SoundManager();
			}
			return sManager;
		}
		//ì´ˆê¸°?™” ë©”ì†Œ?“œ 
		public void init(Context context){
			this.context=context;
			if(soundPool!=null){ //?‚¬?š©?•˜ê³? ?ˆ?˜ ê°ì²´?¼ë©?
				//??› ?•´? œ.
				soundPool.release();
			}
			soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
			//?‚¬?š´?“œ?˜ ?•„?´?””ë¥? ê´?ë¦¬í•  HashMap ê°ì²´ ?ƒ?„±?•˜ê¸?. 
			map=new HashMap<Integer, Integer>();
		}
		//?Œ?› ?“±ë¡í•˜?Š” ë©”ì†Œ?“œ
		public void addSound(int index, int resId){
			//?‚¬?š´?“œ ë¡œë”©?•˜ê³? ?•„?´?”” ê°’ì„ ë°›ì•„?˜¨?‹¤.
			int id=soundPool.load(context, resId, 1);
			//ë°›ì•„?˜¨ ?•„?´?””ë¥? HashMap ê°ì²´?— ???¥?•œ?‹¤.
			map.put(index, id);
		}
		//?Œ?› ?¬?ƒ?•˜?Š” ë©”ì†Œ?“œ
		public void playSound(int index){
			//HashMap ê°ì²´?— ???¥?œ id ê°’ì„ ë¶ˆëŸ¬???„œ ?•´?‹¹ index ?˜ ?Œ?„ ?¬?ƒ?•œ?‹¤. 
			soundPool.play(map.get(index), 1, 1, 1, 0, 1);
		}
		//?¬?ƒ ì¤‘ì??•˜?Š” ë©”ì†Œ?“œ
		public void stopSound(int index){
			soundPool.stop(map.get(index));
		}
		//?¼?‹œ? •?‹œ ?•˜?Š” ë©”ì†Œ?“œ
		public void pauseSound(int index){
			soundPool.pause(map.get(index));
		}
		//?¬?‹œ?‘ ?•˜?Š” ë©”ì†Œ?“œ
		public void resumeSound(int index){
			soundPool.resume(map.get(index));
		}
	}//class
	
	//ë°©í–¥ ?„¼?„œ ê°’ì„ ë°›ì•„?˜¤ê¸? ?œ„?•œ ?¸?„°?˜?´?Š¤ 
	public static interface Orientation{
		public void orientationValue(float[] values);
	}
	/*
	 *  [ ë°©í–¥?„¼?„œê°’ì„ ?–»?–´?˜¤ê¸? ?œ„?•œ ?´?˜?Š¤ ]
	 *  
	 *  1. ë°©í–¥?„¼?„œê°’ì„ ë°›ì„ ?´?˜?Š¤?—?„œ Util.Orientation ?¸?„°?˜?´?Š¤ë¥? êµ¬í˜„?•œ?‹¤.
	 *  2. ?„¼?„œê°’ì„ ë°›ì„ orientationValue() ë©”ì†Œ?“œë¥? ?˜¤ë²„ë¼?´?”©?•œ?‹¤.
	 *  3. Util.OrientationManager.getInstance() ?•´?„œ ì°¸ì¡°ê°’ì„ ?–»?–´?˜¨?‹¤.
	 *  4. init() ë©”ì†Œ?“œ ?˜¸ì¶œí•˜ë©´ì„œ Context ê°ì²´?? Orientation ê°ì²´ë¥? ? „?‹¬?•œ?‹¤.
	 *  5. orientationValue() ë©”ì†Œ?“œ?— ?¸?ë¡? ? „?‹¬?˜?Š” float[] ê°ì²´?— ë°©í–¥?„¼?„œê°’ì´
	 *     ?“¤?–´?ˆ?‹¤
	 *     -?—¤?”© : values[0]
	 *     -?”¼ì¹? : values[1]
	 *     -ë¡¤ë§ : values[2]
	 *  6. ?”?´?ƒ ?„¼?„œê°’ì„ ?–»?–´?˜¬ ?•„?š”ê°? ?—†?„?•Œ relase() ë©”ì†Œ?“œë¥? ?˜¸ì¶œí•´ì¤??‹¤.    
	 */
	public static class OrientationManager implements SensorEventListener{
		
		private static OrientationManager oManager;
		
		private SensorManager mSensorManager;
	    private Sensor mAccelerometer;
	    private Sensor mMagnetometer;

	    private float[] mLastAccelerometer = new float[3];
	    private float[] mLastMagnetometer = new float[3];
	    private boolean mLastAccelerometerSet = false;
	    private boolean mLastMagnetometerSet = false;

	    private float[] mR = new float[9];
	    private float[] mOrientation = new float[3];
	    
	    private Orientation orientation;
	    //?ƒ?„±?. 
		private OrientationManager(){}
		//ì°¸ì¡°ê°? ë¦¬í„´?•˜?Š” ë©”ì†Œ?“œ 
		public static OrientationManager getInstance(){
			if(oManager==null){
				oManager=new OrientationManager();
			}
			return oManager;
		}
		//ì´ˆê¸°?™” ë©”ì†Œ?“œ 
		public void init(Context context, Orientation orientation){
			 this.orientation=orientation;
			 mSensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
		     mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		     mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		     mLastAccelerometerSet = false;
		     mLastMagnetometerSet = false;
		     mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		     mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
		}
		//ë¦¬ìŠ¤?„ˆ ?•´? œ ë©”ì†Œ?“œ 
		public void release(){
			mSensorManager.unregisterListener(this);
		}
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {}

		@Override
		public void onSensorChanged(SensorEvent event) {
			if (event.sensor == mAccelerometer) {
	            System.arraycopy(event.values, 0, mLastAccelerometer, 0, event.values.length);
	            mLastAccelerometerSet = true;
	        } else if (event.sensor == mMagnetometer) {
	            System.arraycopy(event.values, 0, mLastMagnetometer, 0, event.values.length);
	            mLastMagnetometerSet = true;
	        }
	        if (mLastAccelerometerSet && mLastMagnetometerSet) {
	            SensorManager.getRotationMatrix(mR, null, mLastAccelerometer, mLastMagnetometer);
	            SensorManager.getOrientation(mR, mOrientation);
	            Log.i("OrientationTestActivity", String.format("Orientation: %f, %f, %f",
	                                                           mOrientation[0], mOrientation[1], mOrientation[2]));
	            float heading=(float)(mOrientation[0]*(180/Math.PI));
	            if(heading<0){
	            	heading=360+heading;
	            }
	            float pitch=(float)(mOrientation[1]*(180/Math.PI));
	            float rolling=(float)(mOrientation[2]*(180/Math.PI));
	            
	            float[] values={heading,pitch,rolling };
	            
	            orientation.orientationValue(values);
	        }
		}
		
	}
}






















































