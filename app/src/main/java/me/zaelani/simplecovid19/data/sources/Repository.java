package me.zaelani.simplecovid19.data.sources;

import android.content.Context;

import java.util.List;

import me.zaelani.simplecovid19.data.models.CountryModel;
import me.zaelani.simplecovid19.data.sources.local.LocalDataSource;
import me.zaelani.simplecovid19.data.sources.remote.RemoteDataSource;

public class Repository implements DataSource {
    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    public Repository(Context context) {
        remoteDataSource = new RemoteDataSource(context);
        localDataSource = new LocalDataSource(context);
    }

    @Override
    public void getIndonesiaInfo(BaseCallback<List<CountryModel>> callback) {
        remoteDataSource.getIndonesiaInfo(callback);
    }

    @Override
    public CountryModel getLocalInfo() {
        return localDataSource.getLocalInfo();
    }

    public void setLocalInfo(CountryModel countryModel) {
        localDataSource.setLocalInfo(countryModel);
    }

    public void updateLocalInfo(CountryModel countryModel) {
        localDataSource.updateLocalInfo(countryModel);
    }
}
