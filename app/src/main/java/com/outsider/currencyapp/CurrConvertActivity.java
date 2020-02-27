package com.outsider.currencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.scrounger.countrycurrencypicker.library.Buttons.CountryCurrencyButton;
import com.scrounger.countrycurrencypicker.library.Country;
import com.scrounger.countrycurrencypicker.library.Currency;
import com.scrounger.countrycurrencypicker.library.Listener.CountryCurrencyPickerListener;

public class CurrConvertActivity extends AppCompatActivity {

    CountryCurrencyButton btnto, btnfrom;
    EditText editText;
    TextView fromtext, totext;
    Button btnconvert;

    String fromCode = "TND";
    String toCode = "EUR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curr_convert);

        btnto = findViewById(R.id.btnto);
        btnfrom = findViewById(R.id.btnfrom);

        editText = findViewById(R.id.editnb);
        fromtext = findViewById(R.id.fromtext);
        totext = findViewById(R.id.totext);
        btnconvert = findViewById(R.id.convertcurr);

        btnto.setShowCurrency(true);
        btnfrom.setShowCurrency(true);

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nb = editText.getText().toString();
                fromtext.setText(nb+" "+fromCode+" =");

                final String request = fromCode+"_"+toCode;

                Ion.with(CurrConvertActivity.this)
                        .load("https://free.currconv.com/api/v7/convert?q="+request+"&compact=ultra&apiKey=f0e3549dd56c799164d0")
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {

                                if(e == null){
                                    System.out.println("///////"+result+"///////"+request);
                                    if(result.get(request).getAsString() != null){
                                        float cuur = result.get(request).getAsFloat();
                                        float finalres = cuur * Integer.parseInt(nb);
                                        totext.setText(finalres+" "+toCode);
                                    }
                                }
                            }
                        });
            }
        });


        btnto.setOnClickListener(new CountryCurrencyPickerListener() {
            @Override
            public void onSelectCountry(Country country) {
                toCode = country.getCurrency().getCode();
                //textcurr.setText(country.getCode()+"\n"+country.getCurrency().getCode()+"\n"+country.getName());
            }
            @Override
            public void onSelectCurrency(Currency currency) {

            }
        });

        btnfrom.setOnClickListener(new CountryCurrencyPickerListener() {
            @Override
            public void onSelectCountry(Country country) {
                fromCode = country.getCurrency().getCode();
                //textcurr.setText(country.getCode()+"\n"+country.getCurrency().getCode()+"\n"+country.getName());
            }
            @Override
            public void onSelectCurrency(Currency currency) {

            }
        });

    }
}
