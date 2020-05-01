package me.zaelani.simplecovid19.data.sources;

import java.util.List;

import me.zaelani.simplecovid19.data.models.CountryModel;

public interface DataSource {
    void getIndonesiaInfo(BaseCallback<List<CountryModel>> callback);
    CountryModel getLocalInfo();

    interface BaseCallback<T> {
        void onSuccess(T data);

        void onFailed(String errorMessage);
    }
}
