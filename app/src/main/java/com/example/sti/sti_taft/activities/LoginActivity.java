package com.example.sti.sti_taft.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sti.sti_taft.MainActivity;
import com.example.sti.sti_taft.R;
import com.example.sti.sti_taft.db.ProwareDataSource;
import com.example.sti.sti_taft.db.User;

import java.util.List;

public class LoginActivity extends Activity {
    public static final int REQUEST_CODE1 = 1004;
    public static final int REQUEST_CODE2 = 1005;
    ProwareDataSource dataSource;
    public static final int REQUEST_CODE = 1001;
    EditText etUName, etPass;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataSource = new ProwareDataSource(this);
        dataSource.open();
//        if (dataSource.findLogIn()==true)
//        {
//            Intent intent=new Intent(this, MainActivity.class);
//            startActivityForResult(intent, REQUEST_CODE2);
//        }
        etUName = (EditText) findViewById(R.id.editText_login_Uname);
        etPass = (EditText) findViewById(R.id.editText_login_pass);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
        } else if (id == R.id.action_register) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == 1) {
            //toast
        }
    }

    private boolean checkUser(String username, String password) {
        userList = dataSource.findUsers(username, password);
        return true;
    }

    public void button_login_Click(View view) {
        if (etUName.getText().toString().isEmpty() && etPass.getText().toString().isEmpty()) {
            Toast.makeText(this, "please enter your username and password", Toast.LENGTH_SHORT).show();
        } else if (etPass.getText().toString().isEmpty()) {
            //enter password
            Toast.makeText(this, "please enter your password", Toast.LENGTH_SHORT).show();
        } else if (etUName.getText().toString().isEmpty()) {
            //enter username
            Toast.makeText(this, "please enter your username", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivityForResult(intent, REQUEST_CODE1);
        }
    }
}
