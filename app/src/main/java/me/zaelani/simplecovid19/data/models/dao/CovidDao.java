package me.zaelani.simplecovid19.data.models.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import me.zaelani.simplecovid19.data.models.CountryModel;

@Dao
public interface CovidDao {
    @Insert
    void add(CountryModel countryModel);

    @Update
    void update(CountryModel countryModel);

    @Query("SELECT * FROM country LIMIT 1")
    CountryModel get();
}
