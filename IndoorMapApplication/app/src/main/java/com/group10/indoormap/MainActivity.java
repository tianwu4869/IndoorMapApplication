package com.group10.indoormap;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.group10.indoormap.adaptor.BuildingAdaptor;
import com.group10.indoormap.entity.Building;
import com.group10.indoormap.entity.Feature;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //a list to store all the products
    List<Building> buildingList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                jumpToFB(view);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        recyclerView = (RecyclerView) findViewById(R.id.RV);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buildingList = new ArrayList<>();

        List floors = new ArrayList();
        floors.add("basement");
        floors.add("ground floor");
        floors.add("first floor");
        floors.add("second floor");
        floors.add("third floor");

        List<Feature> printer = new ArrayList();

        List<Feature> vender = new ArrayList();
        List<Feature> classroom = new ArrayList();

        List<Feature> coffee = new ArrayList();
        List<Feature> computerLab = new ArrayList();
        buildingList.add(new Building("Coffman Memorial Union", "", "6:55 AM", "11:00 PM", floors, printer, vender, classroom, coffee, computerLab, R.drawable.cmu));

        BuildingAdaptor adaptor = new BuildingAdaptor(this, buildingList);

//        recyclerView.setAdapter(adaptor);
    }

    public void jumpToBd(View view) {
        Intent intent = new Intent(this, BuildingInfoActivity.class);
        startActivity(intent);
    }

    public void jumpToHM(View view) {
        Intent intent = new Intent(this, HelpMenu.class);
        startActivity(intent);
    }

    public void jumpToFB(View view) {
        Intent intent = new Intent(this, FeedBackActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;


        if (id == R.id.nav_camera) {
            fragment = new Campus_MN();
        } else if (id == R.id.nav_gallery) {
            fragment = new Building_MN();
        } else if (id == R.id.nav_share) {
            fragment = new HelpMenu();
        }
        // Replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
