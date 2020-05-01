package me.zaelani.simplecovid19.data.sources.remote;

import java.util.List;

import me.zaelani.simplecovid19.data.models.CountryModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface KawalCoronaServices {
    @GET("/indonesia")
    Call<List<CountryModel>> indonesia();
}
