package com.example.ma18bbg.diceroller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.ma18bbg.diceroller.R.id.listview;
import static com.example.ma18bbg.diceroller.R.id.numberTextView;

public class MainActivity extends AppCompatActivity {


    private TextView mgTv;
    private EditText numberEntered;
    private Button validate;
    private Object numberToFind;
    private int counter = 0;
    private TextView cb;
    private TextView cv;
    private TextView ls;
    private  Button button;
    ArrayList<String> rndlist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgTv = (TextView) findViewById(R.id.msg);
        numberEntered = (EditText) findViewById(R.id.numberEntered);
        cb = (TextView) findViewById(R.id.counter);
        cv = (TextView) findViewById(R.id.cview);
        ls = (TextView) this.findViewById(R.id.listview);


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

        int num = rnd_num();

        TextView tv = (TextView) this.findViewById(numberTextView);

        tv.setText(Integer.toString(num));

        int n = Integer.parseInt(numberEntered.getText().toString());

            if (n < 1 || n > 6) {
                Toast.makeText(this, "Invalid input, number must be within range", Toast.LENGTH_SHORT).show();
            } else if (n == num) {
                Toast.makeText(this, "Congratulations ! Numbers match bossman", Toast.LENGTH_SHORT).show();
                counter = counter + 1;
                cb.setText(Integer.toString(counter));
            }


    }


    public void on_butoon_click2(View view){

        ArrayList<String> rndlist = new ArrayList<>();
        rndlist.add("1) If you could go anywhere in the world, where would you go?");
        rndlist.add("2) If you were stranded on a desert island, what three things would you want to take with you?");
        rndlist.add("3) If you could eat only one food for the rest of your life, what would that be?");
        rndlist.add("4) If you won a million dollars, what is the first thing you would buy?");
        rndlist.add("5) If you could spaned the day with one fictional character, who would it be?");
        rndlist.add("6) If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Random rand = new Random();

        int numberOfElements = 1;

        for (int i = 0; i < numberOfElements; i++) {

            int randomIndex = rand.nextInt(rndlist.size());
            String randomElement = rndlist.get(randomIndex);
           ls.setText(randomElement);
        }
    }

    public int rnd_num(){

        Random r = new Random();
        int number = r.nextInt(6);
        return number;
    }

    public void on_butoon_click3(View view){

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }


}