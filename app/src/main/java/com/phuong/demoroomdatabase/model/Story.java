package com.phuong.demoroomdatabase.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Topic.class,
                                    parentColumns = "id",
                                    childColumns = "idTopic",
                                    onDelete = CASCADE))
public class Story implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int idStory;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "content")
    private String content;

    private int idTopic;

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    @ColumnInfo(name = "finished")
    private boolean finished;

    public int getIdStory() {
        return idStory;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
