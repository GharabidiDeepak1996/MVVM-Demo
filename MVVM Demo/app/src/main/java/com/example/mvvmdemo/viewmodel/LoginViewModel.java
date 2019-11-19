package com.example.mvvmdemo.viewmodel;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mvvmdemo.model.User;

public class LoginViewModel extends BaseObservable {
    private static final String TAG = "LoginViewModel";
    private User user;
    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    //Toast messages------------------------------------------------------------------------------------------------

    private String toastMessage = null;

    @Bindable
    public String getToastMessage() {
        return toastMessage;
// use @Bindable annotation on getter method.because of send back to UI.
    }

    private void mToastMessage(String toastMessage) {
        Log.d( TAG, "setToastMessage1: "+this.toastMessage );
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }
  //  --------------------------------------------------------------------------------------------------------------------------------
   //emailID
    public void setUserEmail(String email) {
        user.setEmail(email);
       notifyPropertyChanged(BR.userEmail);
        Log.d( TAG, "getUserEmail56: "+getUserEmail() );
//Call notifyPropertyChanged(BR.property) in setter method to update the UI whenever the data is changed.
    }
    @Bindable
    public String getUserEmail() {
        return user.getEmail();
//The BR class will be generated automatically when data binding is enabled.
        //BR--->(binding resources).
    }
//--------------------------------------------------------------------------------------------------------------------
  //password.
    public void setUserPassword(String password) {
    user.setPassword(password);
    notifyPropertyChanged( BR.userPassword);
}
    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

  //-------------------------------------------------------------------------------------------------------------
//constructor
    public LoginViewModel() {
        user = new User("","");
    }
    //----------------------------------------------------------------------------------
//validating
    public void onLoginClicked() {
        if (isInputDataValid())
            mToastMessage(successMessage);
        else
            mToastMessage(errorMessage);

    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
    //--------------------------------------------------------------------------------------------------
}
