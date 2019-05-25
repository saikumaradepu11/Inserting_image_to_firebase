package com.example.saikumar.image_ka_bap;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class secondpage extends AppCompatActivity {

    RecyclerView eventslist;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);

        eventslist = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        eventslist.setLayoutManager(linearLayoutManager);

        validateeventslist();


    }

    private void validateeventslist() {

        reference=FirebaseDatabase.getInstance().getReference().child("Malaiclub");

        FirebaseRecyclerAdapter<Events,eventslistviewholder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Events, eventslistviewholder>
                (
                        Events.class,R.layout.events_info,eventslistviewholder.class,reference
                ) {
            @Override
            protected void populateViewHolder(eventslistviewholder viewHolder, Events model, int position) {

               viewHolder.setEventname(model.getEventname());
               viewHolder.setBranch(model.getBranch());
               viewHolder.setImage(model.getImage());
            }
        };
        eventslist.setAdapter(firebaseRecyclerAdapter);


    }

    public static class eventslistviewholder extends RecyclerView.ViewHolder {
        View mview;

        public eventslistviewholder(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
        }

        public void setEventname(String eventname) {
            TextView t1 = mview.findViewById(R.id.retrivalevent);
            t1.setText(eventname);
        }

        public void setBranch(String branch) {
            TextView t2 = mview.findViewById(R.id.retrivalbranch);
            t2.setText(branch);
        }

        public void setImage(String image) {
            {
                ImageView imageView = mview.findViewById(R.id.retrivalimg);
                Picasso.get().load(image).into(imageView);
            }

        }
    }
}

