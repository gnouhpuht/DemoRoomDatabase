package com.phuong.demoroomdatabase.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.phuong.demoroomdatabase.component.Topic;
import com.phuong.demoroomdatabase.dao.TopicDao;



@Database(entities = {Topic.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TopicDao topicDao();
}
