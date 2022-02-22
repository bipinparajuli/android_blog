package com.example.travelblog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;


public class LoginActivity extends AppCompatActivity{

    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordInput;
    private Button loginButton;
    private ProgressBar progressBar;
    private BlogPreference blogPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        blogPreference = new BlogPreference(this);
        blogPreference.setLoggedIn(false);

        if(blogPreference.isLoggedIn())
        {
            startMainActivity();
            finish();
            return;
        }

        setContentView(R.layout.activity_login);

        textUsernameLayout = findViewById(R.id.textUsernameLayout);
        textPasswordInput = findViewById(R.id.textPasswordInput);
        loginButton = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.progressBar);

        textUsernameLayout.getEditText().addTextChangedListener(createTextWatcher(textUsernameLayout));
        textPasswordInput.getEditText().addTextChangedListener(createTextWatcher(textPasswordInput));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.this.onLoginClicked();
            }
        });

    }

    //handles changes
    private TextWatcher createTextWatcher(TextInputLayout textPasswordInput){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textPasswordInput.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    //handles click
    private void onLoginClicked(){
        String username = textUsernameLayout.getEditText().getText().toString();
        String password = textPasswordInput.getEditText().getText().toString();

        if(username.isEmpty()){
            textUsernameLayout.setError("Username must not be Empty");
        }else if(password.isEmpty()){
            textPasswordInput.setError("Password must not be Empty");
        }else if(!username.equals("admin") && !password.equals("admin")){
            showErrorDialog();
        }
        else {
            performLogin();
        }

    }

    //spinner setting
    private void performLogin(){

        blogPreference.setLoggedIn(true);

        textUsernameLayout.setEnabled(false);
        textPasswordInput.setEnabled(false);
        loginButton.setVisibility(View.INVISIBLE);
        progressBar.setVisibility((View.VISIBLE));

        //Navigating
        Handler handler = new Handler();
        handler.postDelayed(()->{
            startMainActivity();
            finish();
        },2000);
    }

    //function for starting main activity

    private void startMainActivity()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    //show dialog function
    private void showErrorDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Login Filed")
                .setMessage("Username or Password is incorrect")
                .setPositiveButton("Ok",(dialog,which)->dialog.dismiss())
                .show();
    }

}
