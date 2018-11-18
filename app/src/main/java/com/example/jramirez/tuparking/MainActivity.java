package com.example.jramirez.tuparking;
//this is a test for git
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button checkInButton, checkOutButton;
    Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.NumberOfSpots);
        checkInButton = (Button) findViewById(R.id.CheckInButton);
        checkOutButton = (Button) findViewById(R.id.CheckOutButton);
        counter = 7;
        txt.setText(Integer.toString(counter));

        checkInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                txt.setText(Integer.toString(counter));
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter = counter - 1;
                }
                txt.setText(Integer.toString(counter));
            }
        });
    }
}
