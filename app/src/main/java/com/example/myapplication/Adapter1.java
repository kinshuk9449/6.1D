package com.example.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {

    Context context;
    Activity activity;
    List<Model1> myList;

    public Adapter1(Context context, Activity activity, List<Model1> myList) {
        this.context = context;
        this.activity = activity;
        this.myList = myList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout1,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.image.setImageBitmap(myList.get(position).getImage());
        holder.title.setText(myList.get(position).getTitle());
        holder.description.setText(myList.get(position).getDescription());
        holder.date.setText(myList.get(position).getDate());
        holder.time.setText(myList.get(position).getTime());
        holder.quantity.setText(myList.get(position).getQuantity());
        holder.location.setText(myList.get(position).getLocation());


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = myList.get(position).getTitle();
                String description = myList.get(position).getDescription();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,title);
                intent.putExtra(Intent.EXTRA_TEXT,description);

                Intent shareIntent = Intent.createChooser(intent,"Share using");
                activity.startActivity(shareIntent);



                //activity.startActivityForResult(intent,1);

            }
        });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,description,date,time,quantity,location;
        ImageView image;
        RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image1);
            title = itemView.findViewById(R.id.title1);
            description = itemView.findViewById(R.id.description1);
            time = itemView.findViewById(R.id.time1);
            date = itemView.findViewById(R.id.date1);
            quantity = itemView.findViewById(R.id.quantity1);
            location = itemView.findViewById(R.id.location1);
            layout = itemView.findViewById(R.id.note_layout1);
        }
    }
}
