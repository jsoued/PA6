package org.jbs2011.jsoued;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class OpenScreen extends Activity implements OnClickListener{

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.openscreen);
    
		View play = findViewById(R.id.start);
		play.setOnClickListener(this);
    }

	public void onClick(View v) {
		switch(v.getId()) {	
		case R.id.start:
			Intent i = new Intent(this, Memory.class);
			startActivity(i);
			break;
		}
	}    
}