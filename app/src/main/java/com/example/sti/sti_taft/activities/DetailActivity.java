package com.example.sti.sti_taft.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sti.sti_taft.MainActivity;
import com.example.sti.sti_taft.R;

public class DetailActivity extends Activity {
    long prodID;
    int prodImage;
    boolean cart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        prodID = getIntent().getLongExtra(MainActivity.PRODUCT_ID, 0);
        ImageView imgView = (ImageView) findViewById(R.id.imageView_detail_products);
        int image = getIntent().getIntExtra(MainActivity.PRODUCT_IMAGE, 0);
        imgView.setImageResource(image);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (cart == false) {
            getMenuInflater().inflate(R.menu.menu_detail, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_detail, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
            case R.id.action_AddtoCart:
                //insert to cart
                Toast.makeText(this, "Product included to your cart", Toast.LENGTH_SHORT).show();
                setResult(1);
                finish();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
