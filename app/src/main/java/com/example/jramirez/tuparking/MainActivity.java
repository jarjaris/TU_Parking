package com.example.jramirez.tuparking;
//this is a test for git
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button inOutButton;
    boolean checkedIn;
    Integer counter;
    String lotdata;
    JSONfunctions j;
    DBConnect connect = new DBConnect();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.NumberOfSpots);
        inOutButton = (Button) findViewById(R.id.CheckOutButton);
        checkedIn = false;
        counter = 7;
        txt.setText(Integer.toString(counter));

        inOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedIn) {
                    counter = counter + 1;
                    checkedIn = false;
                }
                else if(!checkedIn && counter > 0) {
                    counter = counter - 1;
                    checkedIn = true;
                }
                txt.setText(Integer.toString(counter));
            }
        });
    }
}
