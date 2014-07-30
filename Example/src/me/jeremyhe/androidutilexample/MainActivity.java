package me.jeremyhe.androidutilexample;

import me.jeremyhe.lib.widget.FlipDigitView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FlipDigitView view = new FlipDigitView(this);
		setContentView(view);
		view.setValue(100.09f);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
