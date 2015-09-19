package com.example.drew.helpem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuItem;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.*;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText eName;
    private EditText eEmail;
    private EditText eUsername;
    private EditText ePassword;

    private Button userButton;
    private Button organizationButton;

    private ParseUser user = new ParseUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        eName= (EditText) findViewById(R.id.name);
        eEmail= (EditText) findViewById(R.id.email);
        eUsername= (EditText)findViewById(R.id.un);
        ePassword = (EditText) findViewById(R.id.pw);

        userButton = (Button)findViewById(R.id.user);
        organizationButton = (Button) findViewById(R.id.organization);

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameText = eName.getText().toString();
                String emailText = eEmail.getText().toString();
                String usernameText = eUsername.getText().toString();
                String passwordText = ePassword.getText().toString();

                user.setUsername(usernameText);
                user.setPassword(passwordText);
                user.setEmail(emailText);

                // user.put("v_or_c", "v");

                user.signUpInBackground(new SignUpCallback() {
                    public void done(com.parse.ParseException e) {
                        if (e == null) {
                            //start next activity
                            //start sinch service
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "There was an error signing up."
                                    , Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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

        return super.onOptionsItemSelected(item);
    }
}

