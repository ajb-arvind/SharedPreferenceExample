package com.official19.ajb.sharedpreferenceexample;

import android.content.Context;
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
    }

    private void saveInfo(){
        SharedPreferences sharedPreferences = getSharedPreferences("INFO", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", NameEt.getText().toString());
        editor.putString("Branch", BranchSpn.getSelectedItem().toString());
        editor.putString("Year", YearSpn.getSelectedItem().toString());
        editor.putString("Semster", SemSpn.getSelectedItem().toString());
        editor.apply();
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    private void displayInfo(){
        SharedPreferences sharedPreferences = getSharedPreferences("INFO", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Name", "");
        String branch = sharedPreferences.getString("Branch", "");
        String year = sharedPreferences.getString("Year", "");
        String semster = sharedPreferences.getString("Semster", "");
        Print(name, branch+" "+year+" "+semster);
    }

    private void Print(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
