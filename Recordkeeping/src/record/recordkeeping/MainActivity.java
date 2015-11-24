package record.recordkeeping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText productName,farmCode,budgetCost,productMonth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//find all views
		productName= (EditText) findViewById(R.id.txtproductname);
		farmCode= (EditText) findViewById(R.id.txtfarmcode);
		budgetCost= (EditText) findViewById(R.id.txbudgetcost);
		productMonth= (EditText) findViewById(R.id.txtmonth);
	
	}

	//button click
	public void Save(View v)
	{
		//get text from Edit Texts
       String product  = productName.getText().toString();		
       String f_code  = farmCode.getText().toString();
       String b_cost= budgetCost.getText().toString();
       String p_month  = productMonth.getText().toString();
       //Pass to SQLite DB Handler
       SQLiteHandler h = new SQLiteHandler(this);
       h.SaveData(product, f_code, b_cost, p_month);
	}
	//button links to search activity
	public void SearchRecord(View v)
	{
		Intent x1 = new Intent(this,SearchActivity.class);
	    startActivity(x1);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
