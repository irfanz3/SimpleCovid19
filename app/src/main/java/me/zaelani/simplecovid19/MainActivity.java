package me.zaelani.simplecovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import me.zaelani.simplecovid19.data.models.CountryModel;
import me.zaelani.simplecovid19.data.sources.Repository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repository = new Repository(this);

        TextView positive = findViewById(R.id.positive);
        TextView cured = findViewById(R.id.cured);
        TextView died = findViewById(R.id.died);
        TextView country = findViewById(R.id.country);
        TextView date = findViewById(R.id.dateTime);

        CountryModel countryModel = repository.getLocalInfo();

        positive.setText(countryModel.getPositive() + " Orang");
        cured.setText(countryModel.getCured() + " Orang");
        died.setText(countryModel.getDied() + " Orang");

        country.setText(countryModel.getName());
        date.setText(countryModel.getDate());
    }
}
