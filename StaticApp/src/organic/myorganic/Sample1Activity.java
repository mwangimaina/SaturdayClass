package organic.myorganic;

import java.io.IOException;

import organic.myorganic.R;


import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Sample1Activity extends ActionBarActivity {

	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample1);
		
		TextView data = (TextView) findViewById(R.id.txtfarmhub);
	    //consult TextFileReader.java to read our 'sample.txt'
	    TextFilesReader tf = new TextFilesReader(this);
	    String response = null;
	    
	    
		try {
			response = tf.readTxt("sample1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//call a method to get resoponse 
		data.setText(Html.fromHtml(response));
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.farm_book, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
