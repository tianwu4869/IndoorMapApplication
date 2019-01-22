package com.group10.indoormap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;



public class SelectFeature extends AppCompatActivity {

    private RadioGroup featureGroup;
    private RadioButton featureButton;
    private Button submitButton;

    private RadioButton showInput;
    private RadioButton noShow2;
    private RadioButton noShow3;
    private RadioButton noShow1;
    private RadioButton noShow4;
    private RadioButton noShow5;
    private Intent intent;



    private TextView errorMessage;
    private String classRooms[] = {"231", "256", "211"};
    private EditText eText;
    private String imageSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_feature);
        addTextBoxListener();
        addListenerOnButton();
    }






    //  If User clicked on Class Room, Show the input box
    public void addTextBoxListener(){
        showInput = (RadioButton)findViewById(R.id.radioButton6);
        noShow1 =  (RadioButton)findViewById(R.id.radioButton);
        noShow2 =  (RadioButton)findViewById(R.id.radioButton2);
        noShow3 = (RadioButton)findViewById(R.id.radioButton3);
        noShow4 = (RadioButton)findViewById(R.id.radioButton4);
        noShow5 = (RadioButton)findViewById(R.id.radioButton5);
        eText = (EditText) findViewById(R.id.editText);
        intent = new Intent(this, FloorActivity.class);

        // Show the text input for class room input
        showInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText.setVisibility(View.VISIBLE);
            }
        });

        // Rest button hide the the text input filed
        noShow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText.setVisibility(View.GONE);
            }
        });
        noShow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText.setVisibility(View.GONE);
            }
        });
        noShow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText.setVisibility(View.GONE);
            }
        });
        noShow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText.setVisibility(View.GONE);
            }
        });
        noShow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText.setVisibility(View.GONE);
            }
        });

    }


    // Makesure the room number from user is existing
    public boolean checkRoom(String roomNumber) {
        for(String e:classRooms) {
            if(roomNumber.equals(e)) return true;
        }
        return false;
    }


    public void setIntent() {

    }


    // Add event listener on submit button
    public void addListenerOnButton() {

        featureGroup = (RadioGroup)findViewById(R.id.radioGroup);
        submitButton = (Button)findViewById(R.id.button);
        errorMessage = (TextView)findViewById(R.id.textView17);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v ) {
                // get selected radio button from radioGroup

                int selectedId = featureGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                featureButton = (RadioButton) findViewById(selectedId);
                String featureText;


                // If no Feature Selected, Show error message, and hide room input if visiable
                if(featureGroup == null){
                    errorMessage.setText("No feature Selected");
                    errorMessage.setVisibility(View.VISIBLE);
                    // If the User Choose Room Get the room Number
                } else if (featureButton.getText().toString().equals("room")) {
                    String text= eText.getText().toString();
                    String floor = text.substring(0,1);
                    imageSrc = "coffman_";

                    imageSrc.concat(floor);
                    imageSrc.concat("_room_");
                    imageSrc = imageSrc.concat(floor);
                    imageSrc = imageSrc.concat("_room_");

                    imageSrc = imageSrc.concat(text);
                    System.out.println("SRC:  --------------- ----------" +imageSrc);
                    intent.putExtra("name_of_extra", imageSrc);
                    startActivity(intent);
                } else {        //Get the feature Name
                    String text = featureButton.getText().toString();
                    imageSrc = "coffman_1_";
                    imageSrc = imageSrc.concat(text);
                    imageSrc = imageSrc.concat("_");
                    System.out.println("SRC:  --------------- ----------" + imageSrc);
                    intent.putExtra("name_of_extra", imageSrc);
                    startActivity(intent);
                }
            }

        });

    }
}
