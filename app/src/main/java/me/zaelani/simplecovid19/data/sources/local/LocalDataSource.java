package me.zaelani.simplecovid19.data.sources.local;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import me.zaelani.simplecovid19.data.models.CountryModel;
import me.zaelani.simplecovid19.data.sources.DataSource;

public class LocalDataSource implements DataSource {

    private static AppDatabase db;

    public LocalDataSource(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class,"covid")
                .allowMainThreadQueries().build();
    }

    @Override
    public void getIndonesiaInfo(BaseCallback<List<CountryModel>> callback) {

    }

    @Override
    public CountryModel getLocalInfo() {
        return db.covidDao().get();
    }

    public void setLocalInfo(CountryModel countryModel) {
        db.covidDao().add(countryModel);
    }

    public void updateLocalInfo(CountryModel countryModel) {
        db.covidDao().update(countryModel);
    }
}
