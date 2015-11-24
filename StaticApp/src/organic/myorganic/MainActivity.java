package organic.myorganic;

import organic.myorganic.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    //click listener
    public void Tap(View v)
    {
	    	switch(v.getId())
	    	{
		    	case R.id.btnartichokes:
		    		//do here
		    	
		    		Intent x = new Intent(this,SampleActivity.class);
		    		startActivity(x);
		    	break;
	    	
		    case R.id.btnasian:
		    		//do here
		      	Intent x1 = new Intent(this,Sample1Activity.class);
	    		    startActivity(x1);
		    	break;   
		    	
		    	
		    case R.id.btnblackberries:
	    		//do here
	      	Intent x2 = new Intent(this,Sample2Activity.class);
    		    startActivity(x2);
	    	    break; 
	    	    
		    case R.id.btncauliflower:
	    		//do here
	      	Intent x3 = new Intent(this,Sample3Activity.class);
    		    startActivity(x3);
	    	    break; 
	    	}
    }
    
    
    
    //social media links image-buttons
    //click listener
    public void Tap5(View v)
    {
	    	switch(v.getId())
	    	{
		    	case R.id.youtube:
		    		//do here
		    		Intent x = new Intent(Intent.ACTION_VIEW,
		    				Uri.parse("http://youtube.com"));
		    		startActivity(x);
		    	break;
	    	
		    case R.id.facebook:
		    		//do here
		    	Intent x1 = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse("http://facebook.com"));
	    		startActivity(x1);
		    	break;   
		    	
		    	
		    case R.id.gplus:
	    		//do here
		    	Intent x2 = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse("http://google.com"));
	    		startActivity(x2);
	    	    break; 
	    	    
		    case R.id.twitter:
	    		//do here
		    	Intent x3 = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse("http://twitter.com"));
	    		startActivity(x3);
	    	    break; 
	    	}
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    
    
    
    
    
    
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) 
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
