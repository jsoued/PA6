package org.jbs2011.jsoued;

import android.content.Context;
import android.media.MediaPlayer;

public class BackgroundSound {
   
   private static MediaPlayer first = null;
   private static MediaPlayer second = null;

   
   public static void play(Context context, int resource) {
	   
	   stop(context);

	   first = MediaPlayer.create(context, resource);
       first.setLooping(true);
       first.start();
   }
   
   
   public static void playNext(Context context, int resource) {
	   
	   stop(context);
	   
       second = MediaPlayer.create(context, resource);
       second.setLooping(false);
       second.start();
   }
   
   
   public static void stop(Context context) { 
      
	  if (first != null) {
		  first.stop();
		  first.release();      
		  first = null;
      }
	  
      if (second != null){
    	  second.stop();
    	  second.release();
    	  second = null;
      }
   }  
}