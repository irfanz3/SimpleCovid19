package me.zaelani.simplecovid19.data.sources.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import me.zaelani.simplecovid19.data.models.CountryModel;
import me.zaelani.simplecovid19.data.models.dao.CovidDao;

@Database(entities = {CountryModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CovidDao covidDao();
}