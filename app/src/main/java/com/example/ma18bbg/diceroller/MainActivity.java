package com.example.ma18bbg.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.ma18bbg.diceroller.R.id.numberTextView;

public class MainActivity extends AppCompatActivity {


    private TextView mgTv;
    private EditText numberEntered;
    private Button validate;
    private Object numberToFind;
    private int counter = 0;
    private TextView cb;
    private TextView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgTv = (TextView) findViewById(R.id.msg);
        numberEntered = (EditText) findViewById(R.id.numberEntered);
        cb = (TextView) findViewById(R.id.counter);
        cv = (TextView) findViewById(R.id.cview);



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void on_butoon_click(View view){

        TextView tv = (TextView) this.findViewById(numberTextView);

        Random r = new Random();
        int number = r.nextInt(6);

        tv.setText(Integer.toString(number));

        int n = Integer.parseInt(numberEntered.getText().toString());

            if (n < 1 || n > 6) {
                Toast.makeText(this, "Invalid input, number must be within range", Toast.LENGTH_SHORT).show();
            } else if (n == number) {
                Toast.makeText(this, "Congratulations ! Numbers match bossman", Toast.LENGTH_SHORT).show();
                counter = counter + 1;
                cb.setText(Integer.toString(counter));
            }


    }
}