package org.jbs2011.jsoued;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundEffects {
	
	private static MediaPlayer first = null;


	public static void play(Context context, int resource) {
		
		stop(context);

		first = MediaPlayer.create(context, resource);
		first.setLooping(false);
		first.start();
	}
	   

	public static void stop(Context context) { 
		
		if (first != null) {
			first.stop();
	        first.release();
	        first = null;
		}
	}
}
