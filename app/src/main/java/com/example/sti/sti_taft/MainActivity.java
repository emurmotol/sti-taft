package com.example.sti.sti_taft;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sti.sti_taft.activities.DetailActivity;
import com.example.sti.sti_taft.db.Product;
import com.example.sti.sti_taft.db.ProwareDataSource;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class MainActivity extends Activity {
    public static final int REQUEST_CODE = 1002;
    public static final String PRODUCT_ID = "productID";
    public static final String PRODUCT_IMAGE = "productImage";
    private List<Product> productList;
    ProwareDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //datasource
        dataSource=new ProwareDataSource(this);
        dataSource.open();
        productList=dataSource.findAllProducts();
        ListView listView_products=(ListView)findViewById(R.id.listView_products);
        ArrayAdapter<Product> adapterproducts= new ProductsArrayAdapter(this,0,productList);
        listView_products.setAdapter(adapterproducts);
        listView_products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product productItem = productList.get(position);
                displayDetail(productItem);
            }
        });

    }

    public void displayDetail(Product product)
    {//goes to 2nd classs
        Intent intent=new Intent(this, DetailActivity.class);
        intent.putExtra(PRODUCT_ID,product.getProductId());
        intent.putExtra(PRODUCT_IMAGE,product.getProductImage());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.action_view_cart:
                //intent go to cartActivity
                break;
            case R.id.action_logout:
                    finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public String convertToMoney(Double money)
    {
        Locale peso=new Locale("ph","PH");
        NumberFormat nf=NumberFormat.getCurrencyInstance(peso);
        return nf.format(money);
    }

    public class ProductsArrayAdapter extends ArrayAdapter<Product>
    {
        Context context;
        List<Product> productList;
        public ProductsArrayAdapter(Context context, int resource, List<Product> objects) {
            super(context, resource, objects);
            this.context=context;
            this.productList=objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Product productItem =productList.get(position);
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.list_item,null);
            TextView tvName=(TextView)view.findViewById(R.id.textView_product_name);
            tvName.setText(productItem.getProductName());
            TextView tvPrice=(TextView)view.findViewById(R.id.textView_product_price);
            String price=convertToMoney(productItem.getProductPrice());
            tvPrice.setText(price);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView_product_picture);
            String source= "R.drawable."+productItem.getProductImage();
            imageView.setImageResource(R.drawable.anniv_tshirt);

            return view;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE && resultCode==1)
        {
            ListView listView_products=(ListView)findViewById(R.id.listView_products);
            ArrayAdapter<Product> adapterproducts= new ProductsArrayAdapter(this,0,productList);
            listView_products.setAdapter(adapterproducts);
        }
    }
}
