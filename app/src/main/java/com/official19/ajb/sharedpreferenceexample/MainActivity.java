package com.official19.ajb.sharedpreferenceexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText NameEt;
    Spinner BranchSpn, YearSpn, SemSpn;
    Button LogInBtn, ClearBtn;
    SaveUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        LogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInfo();
            }
        });

        ClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInfo();
            }
        });
    }

    private void init(){
        NameEt = (EditText)findViewById(R.id.etName);
        BranchSpn = (Spinner)findViewById(R.id.spnBranch);
        YearSpn = (Spinner)findViewById(R.id.spnYear);
        SemSpn = (Spinner)findViewById(R.id.spnSem);
        LogInBtn = (Button) findViewById(R.id.btnLogIn);
        ClearBtn = (Button)findViewById(R.id.btnClear);
        user = new SaveUser(this);
    }

    private void saveInfo(){
            if(checkSppiner()) {
                String name = NameEt.getText().toString();
                String branch = BranchSpn.getSelectedItem().toString();
                String year = YearSpn.getSelectedItem().toString();
                String sem = SemSpn.getSelectedItem().toString();
                boolean isSaved = user.saveInfo(name, branch, year, sem);
                if(isSaved) {
                    Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                }
                else
                    Toast.makeText(this, "Error while Saving!", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Please Select!!!", Toast.LENGTH_SHORT).show();
    }

    private void displayInfo(){
        user.displayInfo();
    }

    private boolean checkSppiner(){
        if(BranchSpn.getSelectedItemPosition()>0 &&
                YearSpn.getSelectedItemPosition()>0 && SemSpn.getSelectedItemPosition()>0){
            return true;
        }
        else
            return false;
    }


}
