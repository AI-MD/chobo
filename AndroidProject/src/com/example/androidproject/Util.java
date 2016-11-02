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
 * 개발기간?�� 줄일?�� ?��?�� ?��?��만의 Util ?��?��?�� 만들?���?�?.
 */
public class Util {
	
	
	/*
	 * [ ?��보드 ?��기는 메소?�� ]
	 * 
	 * ?��?���? Context 객체?? ?��?�� ?��커스�? ?��?�� EditText 객체�? ?��?��?��?��. 
	 */
	public static void hideKeyboard(Context context, EditText editText){
		InputMethodManager iManager=(InputMethodManager)
				context.getSystemService(Context.INPUT_METHOD_SERVICE);
		
		iManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
	}
	
	/*
	 * [ ?��?��?�� 메세�? ?��?���? ]
	 * 
	 * ?��?���? Context 객체?? ?��?�� String 객체�? ?��?��?��?��. 
	 */
	public static void makeToast(Context context, String msg){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	

	/*
	 *  [ ?��과음 ?��록과 ?��?��?�� ?��?���? ?��기위?�� ?��?��?�� ]
	 *  
	 *  1. SoundManager.getInstance() ?��?�� 객체?�� 참조값을 ?��?��?��?��?��
	 *  2. init() 메소?��?�� ?��?���? Context 객체�? ?��?��?��?�� 초기?�� ?��?�� ?��?��?��?��. 
	 */
	public static class SoundManager{
		private static SoundManager sManager; //?���??�� 
		private SoundPool soundPool;
		private HashMap<Integer, Integer> map;
		private Context context;
		//?���??��?�� 객체 ?��?��?��?�� ?��?���? ?��?��?���? private �? ?��?��
		private SoundManager(){}
		//참조값을 리턴?��?�� 메소?�� ?���?
		public static SoundManager getInstance(){
			if(sManager==null){
				sManager=new SoundManager();
			}
			return sManager;
		}
		//초기?�� 메소?�� 
		public void init(Context context){
			this.context=context;
			if(soundPool!=null){ //?��?��?���? ?��?�� 객체?���?
				//?��?�� ?��?��.
				soundPool.release();
			}
			soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
			//?��?��?��?�� ?��?��?���? �?리할 HashMap 객체 ?��?��?���?. 
			map=new HashMap<Integer, Integer>();
		}
		//?��?�� ?��록하?�� 메소?��
		public void addSound(int index, int resId){
			//?��?��?�� 로딩?���? ?��?��?�� 값을 받아?��?��.
			int id=soundPool.load(context, resId, 1);
			//받아?�� ?��?��?���? HashMap 객체?�� ???��?��?��.
			map.put(index, id);
		}
		//?��?�� ?��?��?��?�� 메소?��
		public void playSound(int index){
			//HashMap 객체?�� ???��?�� id 값을 불러???�� ?��?�� index ?�� ?��?�� ?��?��?��?��. 
			soundPool.play(map.get(index), 1, 1, 1, 0, 1);
		}
		//?��?�� 중�??��?�� 메소?��
		public void stopSound(int index){
			soundPool.stop(map.get(index));
		}
		//?��?��?��?�� ?��?�� 메소?��
		public void pauseSound(int index){
			soundPool.pause(map.get(index));
		}
		//?��?��?�� ?��?�� 메소?��
		public void resumeSound(int index){
			soundPool.resume(map.get(index));
		}
	}//class
	
	//방향 ?��?�� 값을 받아?���? ?��?�� ?��?��?��?��?�� 
	public static interface Orientation{
		public void orientationValue(float[] values);
	}
	/*
	 *  [ 방향?��?��값을 ?��?��?���? ?��?�� ?��?��?�� ]
	 *  
	 *  1. 방향?��?��값을 받을 ?��?��?��?��?�� Util.Orientation ?��?��?��?��?���? 구현?��?��.
	 *  2. ?��?��값을 받을 orientationValue() 메소?���? ?��버라?��?��?��?��.
	 *  3. Util.OrientationManager.getInstance() ?��?�� 참조값을 ?��?��?��?��.
	 *  4. init() 메소?�� ?��출하면서 Context 객체?? Orientation 객체�? ?��?��?��?��.
	 *  5. orientationValue() 메소?��?�� ?��?���? ?��?��?��?�� float[] 객체?�� 방향?��?��값이
	 *     ?��?��?��?��
	 *     -?��?�� : values[0]
	 *     -?���? : values[1]
	 *     -롤링 : values[2]
	 *  6. ?��?��?�� ?��?��값을 ?��?��?�� ?��?���? ?��?��?�� relase() 메소?���? ?��출해�??��.    
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
	    //?��?��?��. 
		private OrientationManager(){}
		//참조�? 리턴?��?�� 메소?�� 
		public static OrientationManager getInstance(){
			if(oManager==null){
				oManager=new OrientationManager();
			}
			return oManager;
		}
		//초기?�� 메소?�� 
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
		//리스?�� ?��?�� 메소?�� 
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






















































