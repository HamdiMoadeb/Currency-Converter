package com.outsider.currencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.scrounger.countrycurrencypicker.library.Buttons.CountryCurrencyButton;
import com.scrounger.countrycurrencypicker.library.Country;
import com.scrounger.countrycurrencypicker.library.CountryCurrencyPicker;
import com.scrounger.countrycurrencypicker.library.Currency;
import com.scrounger.countrycurrencypicker.library.Listener.CountryCurrencyPickerListener;
import com.scrounger.countrycurrencypicker.library.PickerType;

public class MainActivity extends AppCompatActivity {

    CountryCurrencyButton btnhello;
    TextView textcurr;
    Button btnconcurr, btnbtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textcurr = findViewById(R.id.textcurr);
        btnconcurr = findViewById(R.id.currconvbtn);
        btnbtc = findViewById(R.id.btcbtn);

        btnhello = findViewById(R.id.button);
        btnhello.setShowCurrency(true);

        btnconcurr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrConvertActivity.class);
                startActivity(intent);
            }
        });

        btnbtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, BitcoinActivity.class);
                startActivity(intent);
            }
        });


    }

//    CountryCurrencyPicker pickerDialog = CountryCurrencyPicker.newInstance(PickerType.COUNTRYandCURRENCY, new CountryCurrencyPickerListener() {
//        @Override
//        public void onSelectCountry(Country country) {
//            textcurr.setText(country.getCode()+"\n"+country.getCurrency().getSymbol()+"\n"+country.getName());
//        }
//
//        @Override
//        public void onSelectCurrency(Currency currency) {
//            if (currency.getCountries() == null) {
//                Toast.makeText(MainActivity.this,
//                        String.format("name: %s\nsymbol: %s", currency.getName(), currency.getSymbol())
//                        , Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(MainActivity.this,
//                        String.format("name: %s\ncurrencySymbol: %s\ncountries: %s", currency.getName(), currency.getSymbol(), TextUtils.join(", ", currency.getCountriesNames()))
//                        , Toast.LENGTH_SHORT).show();
//            }
//        }
//    });
//
//                pickerDialog.show(getSupportFragmentManager(), CountryCurrencyPicker.DIALOG_NAME);
}
