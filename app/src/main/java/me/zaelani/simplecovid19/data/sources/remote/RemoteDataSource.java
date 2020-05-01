package me.zaelani.simplecovid19.data.sources.remote;

import android.content.Context;

import com.readystatesoftware.chuck.ChuckInterceptor;

import java.util.List;

import me.zaelani.simplecovid19.data.models.CountryModel;
import me.zaelani.simplecovid19.data.sources.DataSource;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource implements DataSource {
    private KawalCoronaServices mService;

    public RemoteDataSource(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.kawalcorona.com/")
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(KawalCoronaServices.class);
    }

    @Override
    public void getIndonesiaInfo(final BaseCallback<List<CountryModel>> callback) {
        mService.indonesia().enqueue(new ApiCallback<List<CountryModel>>() {
            @Override
            void onSuccess(List<CountryModel> data) {
                callback.onSuccess(data);
            }

            @Override
            void onFailure(int code, String errorMessage) {
                callback.onFailed(errorMessage);
            }
        });
    }

    @Override
    public CountryModel getLocalInfo() {
        return null;
    }
}
