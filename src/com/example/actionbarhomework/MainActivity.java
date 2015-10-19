package com.example.actionbarhomework;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	MenuItem actionAdd;
	MenuItem actionDelete;
	
	ArrayList<String> arrayList;
	ArrayAdapter<String> adapter;
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		arrayList = new ArrayList<String>();
		list = (ListView) findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
		
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		actionAdd = menu.findItem(R.id.action_add);
		actionDelete = menu.findItem(R.id.action_delete);
		
		final EditText etAdd = (EditText)actionAdd.getActionView().findViewById(R.id.etAdd);
		Button btnSave = (Button) actionAdd.getActionView().findViewById(R.id.btnAdd);
	
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
				
				arrayList.add(etAdd.getText().toString());
				adapter.notifyDataSetChanged();
				
			}
		});
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_delete){
			Toast.makeText(getApplicationContext(), "All Deleted", Toast.LENGTH_LONG).show();
			if (arrayList.size() > 0) 
				arrayList.clear();
				
			adapter.notifyDataSetChanged();	
			return true;
		}

		return super.onOptionsItemSelected(item);

	}
}
