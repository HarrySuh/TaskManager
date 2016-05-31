package com.example.csastudent2015.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

/**
 * Created by csastudent2015 on 4/12/16.00
 */
public class LoginActivity extends AppCompatActivity {

    private static final int REGISTER_REQUEST_CODE = 1;
    private EditText mUsername;
    private EditText mPassword;
    private Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Backendless.initApp(this, BackendSettings.APPLICATION_ID, BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION);
        setContentView(R.layout.activity_login);

        final TextView register = (TextView) findViewById(R.id.sign_up_text);
        mUsername = (EditText) findViewById(R.id.enter_username);
        mPassword = (EditText) findViewById(R.id.enter_password);


        final Button loginBtn = (Button) findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                LoadingCallback<BackendlessUser> logCallback = createLoginCallback();
                logCallback.showDialog();
                loginUser(mUsername.getText().toString(), mPassword.getText().toString(), logCallback);

            }
        });

        mPassword.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginBtn.performClick();
                    return true;
                }
                return false;
            }
        });


        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(i, REGISTER_REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case REGISTER_REQUEST_CODE:
                    String username = data.getStringExtra(BackendlessUser.ID_KEY);
                    mUsername.setText(username);

                    mPassword.requestFocus();

                    Toast.makeText(this, "Registration Successful!", Toast.LENGTH_LONG).show();
            };
        }
    }

    public LoadingCallback<BackendlessUser> createLoginCallback(){

        return new LoadingCallback<BackendlessUser>(this, "Logging in...") {

            @Override
            public void handleResponse(BackendlessUser user) {
                super.handleResponse(user);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

    }

    public void loginUser(String username, String password, LoadingCallback<BackendlessUser> loadingCallback){
        Backendless.UserService.login(username, password, loadingCallback);
    }


}
