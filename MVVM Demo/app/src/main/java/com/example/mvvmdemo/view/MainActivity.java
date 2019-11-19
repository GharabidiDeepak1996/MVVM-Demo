package com.example.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.databinding.ActivityMainBinding;
import com.example.mvvmdemo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
//https://www.journaldev.com/20292/android-mvvm-design-pattern
    //https://www.androidhive.info/android-working-with-databinding/
    //https://medium.com/@b.chandrasaimohan/data-binding-kotlin-login-screen-using-mvvm-6274979f4b83
private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();
    }
    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        Log.d( TAG, "runMe: "+message );
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
