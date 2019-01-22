package com.group10.indoormap.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.github.chrisbanes.photoview.PhotoView;
import com.group10.indoormap.R;

import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> iconList;

    //getting the context and product list with constructor
    public IconAdapter(Context mCtx, List<String> iconList) {
        this.mCtx = mCtx;
        this.iconList = iconList;
    }

    @Override
    public IconViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_highlighted_icon, null);
        return new IconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IconViewHolder holder, int position) {
        //getting the product of the specified position
        String iconName = iconList.get(position);
        //System.out.println(iconName);
        String roomPath;
        roomPath = "drawable/" + iconName;
        int resourceID = mCtx.getResources().getIdentifier(roomPath, null, mCtx.getPackageName());
        System.out.println(resourceID);
        //binding the data with the viewholder views
        holder.imageView.setImageResource(resourceID);

    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    class IconViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public IconViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.photo_view3);
        }
    }
}
