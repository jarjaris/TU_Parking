package com.example.jramirez.tuparking;
//this is a test for git
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
// android studio spinner
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemSelectedListener;



public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{
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
        txt = (TextView) findViewById(R.id.spotIndicator);
        inOutButton = (Button) findViewById(R.id.inOutButton);
        checkedIn = false;
        counter = 7;
        txt.setText(Integer.toString(counter));
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.lotSpinner);
        String[] lotNames={"Pioneer","Thompson","Hazelrigg","Forrer"};

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,lotNames);



        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


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

        spin.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Forrer");
        categories.add("Hazelrigg");
        categories.add("Thompson");
        categories.add("Pioneer");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin.setAdapter(dataAdapter);

    }
    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    // TODO Auto-generated method stub

    }

}
