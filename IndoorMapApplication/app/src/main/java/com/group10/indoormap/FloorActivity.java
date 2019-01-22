package com.group10.indoormap;

import android.content.Context;
import android.content.Intent;
import android.opengl.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.group10.indoormap.adaptor.IconAdapter;
import com.shawnlin.numberpicker.NumberPicker;
import android.widget.TextView;
import com.github.chrisbanes.photoview.PhotoView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FloorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_features);

        NumberPicker np = (NumberPicker) findViewById(R.id.np);
        np.setWrapSelectorWheel(false);
        np.setOrientation(LinearLayout.HORIZONTAL);

        // Receive message.
        Intent intent = getIntent();
        String message = intent.getStringExtra("name_of_extra");

        // Check the required feature written in message
        String building = "";
        String floor = "";
        String feature = "";
        String ID = "";
        int checkPoint = 0;
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) == '_'){
                checkPoint++;
                continue;
            }
            if(checkPoint == 0){
                building += message.charAt(i);
            }
            else if(checkPoint == 1){
                floor += message.charAt(i);
            }
            else if(checkPoint == 2){
                feature += message.charAt(i);
            }
            else if(checkPoint == 3){
                ID += message.charAt(i);
            }
        }

        System.out.println(feature);
        // Find images in drawable folder based on received message.
        if(feature.equals("room")){
            String floorMapPath;
            floorMapPath = "drawable/ic_" + building + "_" + floor + "_map";
            int resourceID;
            resourceID = getResources().getIdentifier(floorMapPath, null, getPackageName());
            ImageView photoView = (ImageView) findViewById(R.id.photo_view);
            photoView.setImageResource(resourceID);

            String roomPath;
            roomPath = "drawable/ic_" + message;
            resourceID = getResources().getIdentifier(roomPath, null, getPackageName());
            ImageView photoView2 = (ImageView) findViewById(R.id.photo_view0);
            photoView2.setImageResource(resourceID);

            np.setMaxValue(floor.charAt(0) - '0');
            np.setMinValue(floor.charAt(0) - '0');
            np.setValue(floor.charAt(0) - '0');
        }
        else {
            final List<String> iconsName = new ArrayList<String>();
            ArrayList<String> arrayForNumberPicker = new ArrayList<String>();

            // Find images in drawable folder based on received message.
            Field[] drawables = com.group10.indoormap.R.drawable.class.getFields();
            for (Field f : drawables) {
                try {
                    String iconName;
                    iconName = f.getName();
                    if(iconName.contains(feature)){
                        // Store the icon name.
                        System.out.println(iconName);
                        iconsName.add(iconName);
                        // Extract the floor where it is in
                        checkPoint = 0;
                        String fl = "";
                        for(int i = 0; checkPoint < 3; i++){
                            if(iconName.charAt(i) == '_'){
                                checkPoint++;
                                continue;
                            }
                            if(checkPoint == 2){
                                fl += iconName.charAt(i);
                            }
                        }
                        System.out.println(fl);
                        // Store the floor in an array
                        boolean alreadyHave = false;
                        for(int i = 0; i < arrayForNumberPicker.size(); i++){
                            if(arrayForNumberPicker.get(i).equals(fl)){
                                alreadyHave = true;
                            }
                        }
                        if(alreadyHave == false){
                            arrayForNumberPicker.add(fl);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //Collections.sort(arrayForNumberPicker);
            final String[] Floor = new String[arrayForNumberPicker.size()];
            for(int i = 0; i < arrayForNumberPicker.size(); i++){
                Floor[i] = arrayForNumberPicker.get(i);
            }

            np.setMinValue(0);
            if(Floor.length > 1){
                np.setMaxValue(Floor.length - 1);
            }
            else{
                np.setMaxValue(0);
            }
            np.setDisplayedValues(Floor);
            np.setValue(0);

            // Show default floor map
            final String build = building;
            String floorMapPath;
            floorMapPath = "drawable/ic_" + build + "_" + Floor[0] + "_map";
            int resourceID;
            resourceID = getResources().getIdentifier(floorMapPath, null, getPackageName());
            ImageView photoView = (ImageView) findViewById(R.id.photo_view);
            photoView.setImageResource(resourceID);

            List<String> iconForThisFloor = new ArrayList<>();
            for(int i = 0; i < iconsName.size(); i++){
                if(iconsName.get(i).contains(build + "_" + Floor[0])){
                    iconForThisFloor.add(iconsName.get(i));
                }
            }

            for(int i = 0; i < iconForThisFloor.size(); i++){
                String roomPath;
                roomPath = "drawable/" + iconForThisFloor.get(i);
                resourceID = getResources().getIdentifier(roomPath, null, getPackageName());
                int viewID = getResources().getIdentifier("photo_view" + Integer.toString(i), "id", getPackageName());
                ImageView photoView2 = (ImageView) findViewById(viewID);
                photoView2.setImageResource(resourceID);
            }

            // Change floor map when value changed
            np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String floorMapPath;
                    floorMapPath = "drawable/ic_" + build + "_" + Floor[newVal] + "_map";
                    int resourceID;
                    resourceID = getResources().getIdentifier(floorMapPath, null, getPackageName());
                    ImageView photoView = (ImageView) findViewById(R.id.photo_view);
                    photoView.setImageResource(resourceID);

                    List<String> iconForThisFloor = new ArrayList<>();
                    for(int i = 0; i < iconsName.size(); i++){
                        if(iconsName.get(i).contains(build + "_" + Floor[newVal])){
                            iconForThisFloor.add(iconsName.get(i));
                        }
                    }

                    for(int i = 0; i < 24; i++){
                        int viewID = getResources().getIdentifier("photo_view" + Integer.toString(i), "id", getPackageName());
                        ImageView photoView2 = (ImageView) findViewById(viewID);
                        photoView2.setImageResource(0);
                    }

                    for(int i = 0; i < iconForThisFloor.size(); i++){
                        String roomPath;
                        roomPath = "drawable/" + iconForThisFloor.get(i);
                        resourceID = getResources().getIdentifier(roomPath, null, getPackageName());
                        int viewID = getResources().getIdentifier("photo_view" + Integer.toString(i), "id", getPackageName());
                        ImageView photoView2 = (ImageView) findViewById(viewID);
                        photoView2.setImageResource(resourceID);
                    }

                }
            });
        }

    }

}
