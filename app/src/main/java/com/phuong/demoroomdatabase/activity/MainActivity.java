package com.phuong.demoroomdatabase.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.phuong.demoroomdatabase.R;
import com.phuong.demoroomdatabase.adapter.AdapterTopic;
import com.phuong.demoroomdatabase.component.Topic;
import com.phuong.demoroomdatabase.db.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterTopic.ITopic {
    private FloatingActionButton buttonAddTask;
    private RecyclerView recyclerView;
    private List<Topic> topicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rc_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        topicList=new ArrayList<>();
        buttonAddTask = findViewById(R.id.fab_add);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTopicStory.class);
                startActivity(intent);
            }
        });
        getTopic(this);

    }

    private void getTopic(final Activity activity) {
        class GetTopic extends AsyncTask<Void, Void, List<Topic>> implements AdapterTopic.ITopic {
            @Override
            protected List<Topic> doInBackground(Void... voids) {
                topicList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .topicDao()
                        .getAll();
                return topicList;
            }

            @Override
            protected void onPostExecute(List<Topic> topic) {
                super.onPostExecute(topic);
                AdapterTopic adapter = new AdapterTopic(this,activity);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onClick(int position) {

            }

            @Override
            public Topic getData(int position) {
                return topicList.get(position);
            }

            @Override
            public int getSize() {
                return topicList.size();
            }
        }

        GetTopic gt = new GetTopic();
        gt.execute();
    }

    @Override
    public void onClick(int position) {

    }

    @Override
    public Topic getData(int position) {
        return topicList.get(position);
    }

    @Override
    public int getSize() {
        return topicList.size();
    }
}
