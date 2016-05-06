package com.example.csastudent2015.taskapp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by csastudent2015 on 2/25/16.
 */
public class Validator2 {
    public static boolean isNameValid(Context context, CharSequence name){
        // only has letters
        if (name.toString().isEmpty()) {
            Toast.makeText(context, "You must enter a name", Toast.LENGTH_LONG).show();
            return false;
        }
        if(name.toString().matches("[a-zA-Z]+") == false)
        {
            Toast.makeText(context, "Your name must contain only letters", Toast.LENGTH_LONG).show();
            return false;
        }

        if(name.toString().length() <= 2){
            Toast. makeText(context, "Your name must be at least 3 letters long",Toast.LENGTH_LONG).show();
            return false;
        }
        if(name.toString().substring(0,1).equals(name.toString().substring(0,1).toLowerCase()))
        {
            Toast.makeText(context, "First letter must be capitalized", Toast.LENGTH_LONG).show();
            return false;
        }
        if (name.toString().length() >= 63){
            Toast. makeText(context, "Your name is too long",Toast.LENGTH_LONG).show();
            return false;
        }


        return true;

    }
    public static boolean isPasswordValid(Context context, CharSequence password){
        if(password.toString().isEmpty()){
            Toast.makeText(context, "You must enter a password", Toast.LENGTH_LONG ).show();
            return false;

        }
        if(password.toString().length() <= 3){
            Toast.makeText(context, "Your password must be at least 4 letters long", Toast.LENGTH_LONG).show();
            return false;

        }


        return true;
    }
    public static boolean PasswordMatch(Context context, CharSequence password, CharSequence confirmPassword){
        if(!password.toString().equals(confirmPassword.toString())){
            Toast.makeText(context, "Your passwords must match" , Toast.LENGTH_LONG).show();
            return false;

        }
        return true;
    }
    public static boolean isEmailValid(Context context, CharSequence email){
        if(email.toString().isEmpty()){
            Toast.makeText(context, "You must enter an email address", Toast.LENGTH_LONG).show();
            return false;
        }
        if(email.toString().contains("@") == false){
            Toast.makeText(context, "Not a valid email address", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public static boolean isUserNameValid(Context context, CharSequence username){
        if(username.toString().isEmpty()){
            Toast.makeText(context, "You must enter a username", Toast.LENGTH_LONG).show();
            return false;
        }
        if(username.toString().length() <= 2){
            Toast.makeText(context, "Your username must be at least three letters long", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }



}
