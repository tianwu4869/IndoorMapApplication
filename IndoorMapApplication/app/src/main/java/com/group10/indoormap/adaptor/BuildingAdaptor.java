package com.group10.indoormap.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.group10.indoormap.R;
import com.group10.indoormap.entity.Building;

import java.util.List;

public class BuildingAdaptor extends RecyclerView.Adapter<BuildingAdaptor.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Building> buildingList;

    //getting the context and product list with constructor
    public BuildingAdaptor(Context mCtx, List<Building> buildingList) {
        this.mCtx = mCtx;
        this.buildingList = buildingList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Building building = buildingList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(building.getName());
        holder.textViewShortDesc.setText("Hour: " + building.getOpening() + " - " + building.getClosing());

    }


    @Override
    public int getItemCount() {
        return buildingList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
