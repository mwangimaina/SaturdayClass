package record.recordkeeping;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends ActionBarActivity {
//This Activity is for searching by Farm code
	EditText searchbycode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		//find the edit text
		searchbycode = (EditText) findViewById(R.id.txtsearchbycode);
	}
 //Search button click
	public void Search(View v)
	{
		//get text
		String f_code  = searchbycode.getText().toString();
		//here we pass the entered farm code to SQLie Handler
		SQLiteHandler h = new SQLiteHandler(this);
		String res = h.getData(f_code);
		//display Result in a Toast
		Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

	
}
