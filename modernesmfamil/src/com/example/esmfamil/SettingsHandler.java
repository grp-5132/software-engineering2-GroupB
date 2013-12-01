package com.example.esmfamil;
import android.util.Log;
import android.view.ViewDebug.IntToString;
import android.widget.ImageView;


/**
 * Control Class for settings
 * @author Amin Fallahi, Mahsa Asadi
 */
public class SettingsHandler {
	private static int appSound=1;
	private static int appVibra=1;
	private static int appMusic=1;
	private static int dbsaved=1;
	private static ImageView avatarImg;
//	private static DatabaseHelper db;
	
	/**
	 * Constructor reads settings from database using DatabaseHelper class 
	 * and sets private variables.
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public SettingsHandler() {
	}	
	public static void init(DatabaseHelper db){
		int gsv[]=new int[3];
		gsv=db.getSettingsValues();
		appVibra=gsv[0];
		appMusic=gsv[1];
		appSound=gsv[2];
		dbsaved=gsv[3];
		Log.d("ssss",Integer.toString(appVibra));
	}
	/**
	 * used for keeping the avatar image data in a static variable
	 * in order for it to be used in different activities.
	 * @param imgv which is the image passed to the method
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public static void setAvatarImg(ImageView imgv){
		avatarImg=imgv;
	}
	/**
	 * returns the status of the current sound status
	 * @return appSound
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public static int getSoundStatus(){
		return appSound;
	}
	/**
	 * returns the status of the current music settings
	 * @return appSound
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public static int getMusicStatus(){
		return appMusic;
	}
	/**
	 * returns the status of the current vibration settings
	 * @return appSound
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public static int getVibraStatus(){
		return appVibra;
	}
	/**
	 * sets the status of the current vibration settings
	 * @param appSound
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public static void setVibraStatus(int s){
		appVibra=s;
	}
	/**
	 * sets the status of the current music settings
	 * @param appMusic
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public static void setMusicStatus(int s){
		appMusic=s;
	}
	/**
	 * sets the status of the current sound settings
	 * @param appSound
	 * @author Amin Fallahi, Mahsa Asadi
	 */
	public static void setSoundStatus(int s){
		appSound=s;		
	}
	
	public static void saveSettings(DatabaseHelper db){
		db.setSettingsValues(appVibra, appMusic, appSound, dbsaved);		
	}
	
	public static int getDbSaveStatus(){
		return dbsaved;
	}
	
}
