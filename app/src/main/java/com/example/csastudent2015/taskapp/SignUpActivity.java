package com.example.csastudent2015.taskapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;

public class SignUpActivity extends AppCompatActivity
{

    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private EditText mReEnterPasswordEditText;
    private EditText mEmailEditText;
    private Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirstNameEditText = (EditText) findViewById(R.id.enter_firstname);
        mLastNameEditText = (EditText) findViewById(R.id.enter_lastname);
        mUsernameEditText = (EditText) findViewById(R.id.enter_username);
        mPasswordEditText = (EditText) findViewById(R.id.enter_password);
        mReEnterPasswordEditText = (EditText) findViewById(R.id.reenter_password);
        mEmailEditText = (EditText) findViewById(R.id.enter_email);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button);
        mSignUpButton.setOnClickListener(new MySignUpOnClickListener());
    }


    private class MySignUpOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v){
            String firstName = mFirstNameEditText.getText().toString();
            String lastName = mLastNameEditText.getText().toString();
            String username = mUsernameEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            String reEnterPassword = mReEnterPasswordEditText.getText().toString();
            String email = mEmailEditText.getText().toString();

            firstName = firstName.trim();
            lastName = lastName.trim();
            username = username.trim();
            password = password.trim();
            reEnterPassword = reEnterPassword.trim();
            email = email.trim();

            if (firstName.isEmpty()) {
                //Toast.makeText(SignUpActivity.this, "First name field is empty", Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage(R.string.signUpName_error_message);
                builder.setTitle(R.string.login_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if (lastName.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage(R.string.signUpLastName_error_message);
                builder.setTitle(R.string.login_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if (username.isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage(R.string.signUpUsername_message);
                builder.setTitle(R.string.login_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if (password.isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage(R.string.signUpPassword_message);
                builder.setTitle(R.string.login_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if (reEnterPassword.isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage(R.string.signUpReEnterPassword_message);
                builder.setTitle(R.string.login_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if(email.isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage(R.string.signUpEmail_message);
                builder.setTitle(R.string.login_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }

            else if(!password.equals(reEnterPassword)){
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage(R.string.passwordDoNotMatch_message);
                builder.setTitle(R.string.login_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                LoadingCallback<BackendlessUser> regCallback = createRegCallback();
                regCallback.showDialog();
                registerUser(mFirstNameEditText.getText().toString(), mLastNameEditText.getText().toString(), mUsernameEditText.getText().toString(), mPasswordEditText.getText().toString(), mEmailEditText.getText().toString(), regCallback);
            }
        }
    }
    public void registerUser(String firstName, String lastname, String username, String password, String email, AsyncCallback<BackendlessUser> regCallback){
        BackendlessUser user = new BackendlessUser();
        user.setEmail(email);
        user.setPassword(password);
        user.setProperty("firstName", firstName);
        user.setProperty("lastName", lastname);
        user.setProperty("username", username);
        Log.e("email", "registerUser: " + email);
        Backendless.UserService.register(user, regCallback);
    }

    public LoadingCallback<BackendlessUser> createRegCallback() {
        return new LoadingCallback<BackendlessUser>(this, "Registering..."){
            @Override
            public void handleResponse(BackendlessUser user) {
                super.handleResponse(user);
                Intent registrationResult = new Intent();
                registrationResult.putExtra(BackendlessUser.ID_KEY, user.getProperty("username").toString());
                setResult(RESULT_OK, registrationResult);
                SignUpActivity.this.finish();
            }
        };
    }
}

