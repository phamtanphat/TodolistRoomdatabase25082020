package com.example.todolistroomdatabase25082020.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.util.TableInfo;

import java.sql.Blob;

@Entity(tableName = "Word")
public class WordEntity{

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "en")
    private String en;

    @ColumnInfo(name = "vn")
    private String vn;

    @ColumnInfo(name = "isMemorized" , typeAffinity = ColumnInfo.INTEGER)
    private Integer isMemorized;

    public WordEntity(long id, String en, String vn, Integer isMemorized) {
        this.id = id;
        this.en = en;
        this.vn = vn;
        this.isMemorized = isMemorized;
    }

    @Ignore
    public WordEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public Integer getIsMemorized() {
        return isMemorized;
    }

    public void setIsMemorized(Integer isMemorized) {
        this.isMemorized = isMemorized;
    }
}
