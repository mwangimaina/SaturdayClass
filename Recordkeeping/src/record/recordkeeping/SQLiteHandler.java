package record.recordkeeping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class SQLiteHandler extends SQLiteOpenHelper {

protected Context context;
  public SQLiteHandler(final Context connection) {
		//create database and set version
  super(connection, "recordskeeping", null, 1);
  this.context = connection;
 }
 //create table
 String table = "details"; 
 @Override
 public void onCreate(SQLiteDatabase db) {
	 	db.execSQL("CREATE TABLE IF NOT EXISTS " +
    table +" (productName VARCHAR,farmCode INT(5), budgetCost INT(6),productMonth TEXT);");
	 
 }
//Save data method
 public void SaveData(String product,String code,String cost,String month)
 {
	 //get writable database
	 SQLiteDatabase db = this.getWritableDatabase();
	 //put your values in a Content Values
	 ContentValues col = new ContentValues();
	 col.put("productName", product);
	 col.put("farmCode", code);
	 col.put("budgetCost", cost);
	 col.put("productMonth", month);
	 //insert your content values in table
	 long res = db.insert(table, null, col);
	 //check response
	 if(res < 1)
	 {
		 Toast.makeText(context, "Error!!", Toast.LENGTH_LONG).show();	 
	 }	 
	 
	 else if(res >= 1 )
	 {
		 Toast.makeText(context, "Success", Toast.LENGTH_LONG).show(); 
	 }
	 else 
	 {
		 Toast.makeText(context, "Something weng wrong!!", Toast.LENGTH_LONG).show(); 
	 }
	 
 }
 
 
 //not required for now
 @Override
 public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
   //db.execSQL("DROP TABLE IF EXIST o");
//  onCreate(db);
 }

 

 //this method retrieves data based on ID provided. takes in one parameter id
 public String getData(String code) {
     //allow database to be read
	 SQLiteDatabase db = this.getReadableDatabase();

	 //use select query to search data in table - save found record in a cursor
	 final Cursor c = db.rawQuery("SELECT productName, budgetCost,productMonth,farmCode FROM " +
	 			table +
	 			" where farmCode =  '"+code+"'", null);
	 
	 //count number of rows returned by the cursor
	 int count = c.getCount();
	 
	 //if its zero, no records found
    if(count == 0){
 	
 		Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
 		c.close();
 	}
    //else retrieve the data from their collumns
     String result = "";
     
     int pname = c.getColumnIndex("productName");
     int b_cost = c.getColumnIndex("budgetCost");
     int p_month = c.getColumnIndex("productMonth");
     //converts collumn indexes to Strings - as it loops all records
     for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
         result = result + "Product Name:"+c.getString(pname) + "\n\nBudget Cost " + c.getString(b_cost) + "\n\nMonth: " + c.getString(p_month) + "\n";
  
     }
    //return a String with results
     return result;
    
 
}
 

}
 
