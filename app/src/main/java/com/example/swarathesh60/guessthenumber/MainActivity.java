package com.example.swarathesh60.guessthenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int score=0,life,initial,fin,answer;
    TextView question,points,health;
    Button click;
    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initiate views
        question = (TextView) findViewById(R.id.textView);
        click = (Button) findViewById(R.id.button2);
        input = (EditText) findViewById(R.id.editText);
        points =  (TextView) findViewById(R.id.textView2);
        health = (TextView) findViewById(R.id.textView3);


        NextQuestion();
        ResetHealth();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(life>0) {
                    String str = input.getText().toString();
                    int inputanswer = Integer.parseInt(str);

                    if (inputanswer > answer) {
                        Toast.makeText(getApplicationContext(), "the number is lower ", Toast.LENGTH_LONG).show();
                        Health();
                    } else if (inputanswer < answer) {
                        Toast.makeText(getApplicationContext(), "the number is higer ", Toast.LENGTH_LONG).show();
                        Health();
                    } else if (inputanswer == answer) {
                        Toast.makeText(getApplicationContext(), "BAzingaaa you are right ", Toast.LENGTH_LONG).show();
                        NextQuestion();
                        Score();
                        ResetHealth();

                    }
                }else {
                    Toast.makeText(getApplicationContext(),"you are dead ",Toast.LENGTH_LONG).show();
                    ResetHealth();
                }

            }
        });


    }

    private void ResetHealth() {
        life =3 ;
        SetHealth(life);
    }

    private void SetHealth(int life) {
        health.setText("life "+String.valueOf(life));

    }

    private void Health() {
        SetHealth(--life);
    }

    private void Score() {
        points.setText("score "+String.valueOf(++score));

    }

    private void NextQuestion() {
        Random random = new Random();
        initial = random.nextInt(10)+1;
        fin = random.nextInt(11)+20;
        Random ran = new Random();
        answer = ran.nextInt(fin)+initial;
        question.setText("Guess The Number in between "+initial+" and "+fin+" ?");
        
    }
}
