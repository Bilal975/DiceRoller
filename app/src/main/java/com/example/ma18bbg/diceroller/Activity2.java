package com.example.ma18bbg.diceroller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {


    private  Button button;
    private  EditText questionEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        questionEntered = (EditText) findViewById(R.id.questionEntered);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void savebutton(View view){

        MainActivity list = new MainActivity();
        list.getList(questionEntered);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openma1();
            }
        });
    }

    public void openma1(){
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void cancelbutton(View view){

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openma2();
            }
        });
    }

    public void openma2(){
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        startActivity(intent);
    }

}
