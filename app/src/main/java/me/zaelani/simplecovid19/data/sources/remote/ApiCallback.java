package me.zaelani.simplecovid19.data.sources.remote;

import java.net.UnknownHostException;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public abstract class ApiCallback<T> implements Callback<T> {

    abstract void onSuccess(T data);

    abstract void onFailure(int code, String errorMessage);

    @SuppressWarnings({"ConstantConditions", "unchecked"})
    @Override
    public void onResponse(@NonNull Call<T> call, Response<T> response) {
        onSuccess(response.body());
    }

    @Override public void onFailure(@NonNull Call<T> call, @NonNull Throwable throwable) {
        if (throwable instanceof HttpException) {
            int code = ((HttpException) throwable).code();
            String message = ((HttpException) throwable).message();

            onFailure(code, message);
        }

        if (throwable instanceof UnknownHostException) {
            onFailure(-1, "Telah terjadi kesalahan ketika koneksi ke server: " + throwable.getMessage());
        }

        onFailure(-1, "Tidak dapat terkoneksi dengan internet, Menjalankan Offline Mode");
    }
}
