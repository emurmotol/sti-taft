package com.example.sti.sti_taft.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.sti.sti_taft.R;

import java.util.ArrayList;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinnerCat= (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterBranch=ArrayAdapter.createFromResource(this, R.array.branches,android.R.layout.simple_spinner_item);
        spinnerCat.setAdapter(adapterBranch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id==android.R.id.home)
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void button_Register_Click(View view) {
        //insert f
    }
}
