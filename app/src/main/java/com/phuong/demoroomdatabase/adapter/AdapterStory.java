package com.phuong.demoroomdatabase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.phuong.demoroomdatabase.R;
import com.phuong.demoroomdatabase.model.Story;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.StoryViewHolder> {
    private IStory inter;

    public AdapterStory(IStory inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story,parent,false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        final Story data=inter.getData(position);
    }

    @Override
    public int getItemCount() {
        return inter.getSize();
    }

    static class StoryViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title_story);
        }
    }

    public interface IStory{
        void onClick(int position);
        Story getData(int position);
        int getSize();
    }
}
