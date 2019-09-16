package com.phuong.demoroomdatabase.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phuong.demoroomdatabase.R;
import com.phuong.demoroomdatabase.activity.UpdateTopicActyvity;
import com.phuong.demoroomdatabase.component.Topic;


public class AdapterTopic extends RecyclerView.Adapter<AdapterTopic.TopicViewHolder>  {
    private ITopic inter;
    private Activity activity;

    public AdapterTopic(ITopic inter, Activity activity) {
        this.inter = inter;
        this.activity=activity;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicViewHolder holder, int position) {
        final Topic topic = inter.getData(position);
        holder.tvTitle.setText(topic.getName());
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inter.onClick(holder.getAdapterPosition());
                Intent intent=new Intent();
                intent.setClass(activity,UpdateTopicActyvity.class);
                intent.putExtra("topic",topic);
                activity.startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inter.onClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return inter.getSize();
    }



    class TopicViewHolder extends RecyclerView.ViewHolder  {

        private TextView tvTitle;
        private ImageButton btnUpdate;

        public TopicViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            btnUpdate=itemView.findViewById(R.id.btn_edit);

        }

    }

    public interface ITopic{
        void onClick(int position);
        Topic getData(int position);
        int getSize();
    }
}
