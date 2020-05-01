package me.zaelani.simplecovid19.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "country")
public class CountryModel {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "positive")
    @SerializedName("positif")
    private String positive;

    @ColumnInfo(name = "cured")
    @SerializedName("sembuh")
    private String cured;

    @ColumnInfo(name = "died")
    @SerializedName("meninggal")
    private String died;

    @ColumnInfo(name = "createAt")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getCured() {
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }
}
