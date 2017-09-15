package com.example.admin.w3d4celeblistfrag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 9/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private View rlContainer;
    private View glContainer;
    List<Celebrity> celeberties = new ArrayList<>();
    Context context;
    int layout;
    public PositionClickListener listener;

    public RecyclerViewAdapter(List<Celebrity> animals, Context context, int layout) {
        this.celeberties = animals;
        this.context = context;
        this.layout = layout;
    }

    public void setAdapter2(PositionClickListener pcl){
        listener = pcl;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Celebrity celebrity = celeberties.get(position);

        Bitmap tmp = BitmapFactory.decodeResource(context.getResources(), celebrity.getPicID());
        holder.celebImg.setImageBitmap(tmp);

        /*String info = "NAME: " + celebrity.getName() + " MOVIE: " + celebrity.getMovie() +
                "\n" + "AGE: " + celebrity.getAge() + " WEIGHT " + celebrity.getWeight();*/
        holder.celebName.setText(celebrity.getName());



    }

    @Override
    public int getItemCount() {
        return celeberties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView celebName;
        private final ImageView celebImg;

        public ViewHolder(final View itemView) {
            super(itemView);

            celebName = itemView.findViewById(R.id.tvCelebName);
            celebImg = itemView.findViewById(R.id.ivCelebImg);
            rlContainer = itemView.findViewById(R.id.rlContainer);
            glContainer = itemView.findViewById(R.id.glContainer);

            if(rlContainer != null) {
                rlContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();
                        listener.itemClicked(position);
                    }
                });
            }

            if(glContainer != null) {
                glContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();
                        listener.itemClicked(position);
                    }
                });
            }

        }
    }

    public interface PositionClickListener
    {
        void itemClicked(int position);
    }


}
