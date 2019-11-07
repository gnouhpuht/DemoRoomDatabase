package com.phuong.demoroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.phuong.demoroomdatabase.model.Story;
import java.util.List;

@Dao
public interface StoriesDao {
    @Query("SELECT * FROM story WHERE idStory=idTopic")
    List<Story> getAllStory();

    @Insert
    void insert(Story story);

    @Delete
    void delete(Story story);

    @Update
    void update(Story story);
}
