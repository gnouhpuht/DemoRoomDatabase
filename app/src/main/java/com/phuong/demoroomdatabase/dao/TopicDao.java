package com.phuong.demoroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.phuong.demoroomdatabase.model.Topic;
import java.util.List;


@Dao
public interface TopicDao {
    @Query("SELECT * FROM topic")
    List<Topic> getAll();

    @Insert
    void insert(Topic task);

    @Delete
    void delete(Topic task);

    @Update
    void update(Topic task);
}
