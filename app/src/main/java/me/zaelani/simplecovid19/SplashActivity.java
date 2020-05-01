package me.zaelani.simplecovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import me.zaelani.simplecovid19.data.models.CountryModel;
import me.zaelani.simplecovid19.data.sources.DataSource;
import me.zaelani.simplecovid19.data.sources.Repository;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final Repository repository = new Repository(getApplicationContext());

        repository.getIndonesiaInfo(new DataSource.BaseCallback<List<CountryModel>>() {
            @Override
            public void onSuccess(List<CountryModel> data) {
                CountryModel countryModel = data.get(0);
                countryModel.setDate(getDate());
                if (repository.getLocalInfo() != null) {
                    repository.updateLocalInfo(countryModel);
                } else {
                    repository.setLocalInfo(countryModel);
                }
                next();
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(SplashActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                next();
            }
        });
    }

    void next() {
        startActivity(new Intent(this, MainActivity.class));
    }

    String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yy", new Locale("ID"));
        Date date = new Date();
        return dateFormat.format(date);
    }
}
