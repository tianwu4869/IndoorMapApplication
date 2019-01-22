package com.group10.indoormap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class FeedBackActivity extends AppCompatActivity {
    private static final String OUTPUT_PATH = "feedback.txt";

    private CheckBox missInfoErr;
    private CheckBox errInfoErr;
    private CheckBox statusErr;
    private CheckBox otherErr;
    private List<CheckBox> checkBoxList = new ArrayList<>();
    private EditText otherText;
    private Button submit;

    private String lines = "Hi, here is the feedback.\n";

    private void sendFeedBack(String s) {
        String[] receiver = new String[]{"dasong2296@gmail.com"};
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, receiver);
        email.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
        email.putExtra(Intent.EXTRA_TEXT, s);
        startActivity(Intent.createChooser(email, "please choose the mailbox"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        otherErr = (CheckBox) findViewById(R.id.checkBox);
        statusErr = (CheckBox) findViewById(R.id.checkBox2);
        missInfoErr = (CheckBox) findViewById(R.id.checkBox3);
        errInfoErr = (CheckBox) findViewById(R.id.checkBox4);
        otherText = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.button);

        otherErr.setChecked(false);
        statusErr.setChecked(false);
        missInfoErr.setChecked(false);
        errInfoErr.setChecked(false);


        checkBoxList.add(errInfoErr);
        checkBoxList.add(missInfoErr);
        checkBoxList.add(statusErr);
        checkBoxList.add(otherErr);

        errInfoErr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (errInfoErr.isChecked()) {
                    lines.concat("Error Information\n");

                }
            }
        });

        missInfoErr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (missInfoErr.isChecked()) {
                    lines.concat("Miss Information\n");
                }
            }
        });

        statusErr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statusErr.isChecked()) {
                    lines.concat("Status Error\n");
                }
            }
        });

        otherErr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otherErr.isChecked()) {
                    lines.concat("Other Information: ");
                    lines.concat(otherText.getText().toString());
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedBack(lines);
            }
        });
    }
}
