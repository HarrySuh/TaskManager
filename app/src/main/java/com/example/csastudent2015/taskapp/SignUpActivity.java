package com.example.csastudent2015.taskapp;


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




/**
 * Created by csastudent2015 on 2/19/16.
 */
public class SignUpActivity extends AppCompatActivity {
    private Button SignUp;
    private EditText firstName;
    private EditText lastName;
    private EditText Username;
    private EditText Password;
    private EditText email;
    private EditText mConfirmPassword;



    @Override
    protected void onCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        setContentView(R.layout.activity_sign_up);
        SignUp = (Button) findViewById(R.id.sign_up_button);
        firstName = (EditText)findViewById(R.id.enter_first_name);
        lastName = (EditText)findViewById(R.id.enter_last_name);
        Username = (EditText)findViewById(R.id.enter_username);
        Password = (EditText)findViewById(R.id.enter_password);
        email = (EditText)findViewById(R.id.enter_email_address);
        mConfirmPassword = (EditText) findViewById(R.id.confirm_password);



        Backendless.initApp( this, BackendSettings.APPLICATION_ID,
                BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION );

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Validator2.isNameValid(SignUpActivity.this, firstName.getText().toString()) &&
                        Validator2.isNameValid(SignUpActivity.this, lastName.getText().toString()) &&
                        Validator2.isPasswordValid(SignUpActivity.this, Password.getText().toString()) &&
                        Validator2.isEmailValid(SignUpActivity.this, email.getText().toString()) &&
                        Validator2.PasswordMatch(SignUpActivity.this, Password.getText(),mConfirmPassword.getText())) {



                    LoadingCallback<BackendlessUser> regCallback = createRegCallBack();
                    regCallback.showDialog();
                    Log.e("email", email.getText().toString());

                    registerUser("Nancy", "Fry", "cosmic",
                            email.getText().toString(), "fry", regCallback);}
                else{
                    DialogueHelper.createErrorDialog(SignUpActivity.this, "Alert!",
                            "You messed something up", "Dismiss").show();

                }

            }

        });
    }
    public void registerUser(String firstName, String lastName, String username, String email, String password,
                             AsyncCallback<BackendlessUser> regCallBack){
        BackendlessUser user = new BackendlessUser();
        user.setProperty("email" ,email);
        user.setPassword(password);
        user.setProperty("firstName", firstName);
        user.setProperty("lastName" , lastName);
        user.setProperty("username" , username);

        Backendless.UserService.register(user, regCallBack);


    }
    public LoadingCallback<BackendlessUser> createRegCallBack(){
        return new LoadingCallback<BackendlessUser>(this, "Registering...") {
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
