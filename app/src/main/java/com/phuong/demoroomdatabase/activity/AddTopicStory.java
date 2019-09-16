package com.phuong.demoroomdatabase.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phuong.demoroomdatabase.R;
import com.phuong.demoroomdatabase.component.Topic;
import com.phuong.demoroomdatabase.db.DatabaseClient;

public class AddTopicStory extends AppCompatActivity {

    private EditText editTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_topic);
        editTitle=findViewById(R.id.et_topic);
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTopic();
            }
        });
    }


    private void saveTopic() {
        final String title = editTitle.getText().toString().trim();

        if (title.isEmpty()) {
            editTitle.setError("Topic required");
            editTitle.requestFocus();
            return;
        }


        class SaveTopic extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Topic topic=new Topic();
                topic.setName(title);

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .topicDao().insert(topic);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveTopic st = new SaveTopic();
        st.execute();
    }
}
