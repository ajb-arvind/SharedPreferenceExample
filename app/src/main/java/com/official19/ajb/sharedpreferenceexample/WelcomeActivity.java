package com.official19.ajb.sharedpreferenceexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView TitleTv;
    SaveUser user;
    Button LogOutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TitleTv = (TextView)findViewById(R.id.tvTitle);
        LogOutBtn = (Button)findViewById(R.id.btnLogOut);
        user = new SaveUser(this);

        TitleTv.setText(user.getName());

        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.removeUser();
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
