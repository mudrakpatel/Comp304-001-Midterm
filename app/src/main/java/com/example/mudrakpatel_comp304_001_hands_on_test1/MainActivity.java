package com.example.mudrakpatel_comp304_001_hands_on_test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup contactsRadioGroupMainActivity;
    String[] contactsArray;
    public static String contactName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get the array items in our contactsArray
        contactsArray = getResources().getStringArray(R.array.contactsArray);
        //Initialize the RadioGroup
        contactsRadioGroupMainActivity = (RadioGroup) findViewById(R.id.contactsRadioGroupMainActivity);
        //Add radio buttons to the RadioGroup
        for(String contact : contactsArray){
            RadioButton contactRadioButton = new RadioButton(this);
            contactRadioButton.setText(contact);
            contactRadioButton.setTextSize(25);
            contactRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    //set the contactName to text of the RadioButton that is clicked
                    contactName = compoundButton.getText().toString();
                    //Start the new activity through which message will be sent
                    startActivity(new Intent(getApplicationContext(), SendMessageActivity.class));
                }
            });
            contactsRadioGroupMainActivity.addView(contactRadioButton);
        }
    }
}
