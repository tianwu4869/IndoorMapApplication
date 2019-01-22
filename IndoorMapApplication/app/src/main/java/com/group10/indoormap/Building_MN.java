package com.group10.indoormap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group10.indoormap.adaptor.BuildingAdaptor;
import com.group10.indoormap.entity.Building;
import com.group10.indoormap.entity.Feature;

import java.util.ArrayList;
import java.util.List;

public class Building_MN extends Fragment{
    RecyclerView recyclerView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_menu_building, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        recyclerView = (RecyclerView) getView().findViewById(R.id.RV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Building> buildingList = new ArrayList<>();

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

        BuildingAdaptor adaptor = new BuildingAdaptor(getActivity(), buildingList);

        recyclerView.setAdapter(adaptor);
        getActivity().setTitle("Building_MN");
    }


}
