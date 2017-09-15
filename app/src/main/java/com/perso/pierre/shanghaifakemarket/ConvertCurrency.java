package com.perso.pierre.shanghaifakemarket;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.perso.pierre.shanghaifakemarket.Helper.CurrenciesAPI;
import com.perso.pierre.shanghaifakemarket.Models.ResponseAPICurrencyModel;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ConvertCurrency extends Activity implements Callback<ResponseAPICurrencyModel> {

    private TextView tvPriceUSD;
    private TextView tvPriceEUR;
    private TextView tvPriceGBP;
    private TextView tvPriceJPY;
    private EditText etPriceInput;
    private double rateUSD = 0.153;
    private double rateEUR = 0.14;
    private double rateGBP = 0.108;
    private double rateJPY = 17.5;

    private double rate1USD = 0;
    private double rate1EUR = 0;
    private double rate1GBP = 0;
    private double rate1JPY = 0;


    private TextView mTvRateUSD;
    private TextView mTvRateEUR;
    private TextView mTvRateGBP;
    private TextView mTvRateJPY;

    private int succesCall;
    private int failCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_PROGRESS);


        setContentView(R.layout.activity_convert_currency);



        etPriceInput = (EditText) findViewById(R.id.convert_et_priceInput);
        etPriceInput.setText("10");
        etPriceInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etPriceInput.getText().length() < 5) {
                    calculateAndSet();
                } else {
                    reset();
                }
            }
        });

        tvPriceUSD = (TextView) findViewById(R.id.convert_tv_result_dollar);
        tvPriceEUR = (TextView) findViewById(R.id.convert_tv_result_euros);
        tvPriceGBP = (TextView) findViewById(R.id.convert_tv_result_pound);
        tvPriceJPY = (TextView) findViewById(R.id.convert_tv_result_yen);

        mTvRateUSD = (TextView) findViewById(R.id.convert_tv_rate_usd);
        mTvRateEUR = (TextView) findViewById(R.id.convert_tv_rate_eur);
        mTvRateGBP = (TextView) findViewById(R.id.convert_tv_rate_gbp);
        mTvRateJPY = (TextView) findViewById(R.id.convert_tv_rate_jpy);

        calculateAndSet();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        succesCall = 0;
        failCall = 0;

        CurrenciesAPI api = retrofit.create(CurrenciesAPI.class);


        Call<ResponseAPICurrencyModel> callUSD = api.getCurrenciesUSD();
        callUSD.enqueue(this);

        Call<ResponseAPICurrencyModel> callEUR = api.getCurrenciesEUR();
        callEUR.enqueue(this);

        Call<ResponseAPICurrencyModel> callGBP = api.getCurrenciesGBP();
        callGBP.enqueue(this);

        Call<ResponseAPICurrencyModel> callJPY = api.getCurrenciesJPY();
        callJPY.enqueue(this);








    }

    public void reset() {
        tvPriceUSD.setText(this.getString(R.string.convert_currency_too_expensive));
        tvPriceEUR.setText(this.getString(R.string.convert_currency_too_expensive));
        tvPriceGBP.setText(this.getString(R.string.convert_currency_too_expensive));
        tvPriceJPY.setText(this.getString(R.string.convert_currency_too_expensive));
    }

    public void calculateAndSet() {
        tvPriceUSD.setText(calculateUSD(rateUSD, etPriceInput.getText().toString()));
        tvPriceEUR.setText(calculateEUR(rateEUR, etPriceInput.getText().toString()));
        tvPriceGBP.setText(calculateGBP(rateGBP, etPriceInput.getText().toString()));
        tvPriceJPY.setText(calculateJPY(rateJPY, etPriceInput.getText().toString()));
        rate1USD = Math.floor(getOppositeNumber(rateUSD) * 100) / 100;
        mTvRateUSD.setText("( " + Double.toString(rate1USD) + " )");
        rate1EUR = Math.floor(getOppositeNumber(rateEUR) * 100) / 100;
        mTvRateEUR.setText("( " + Double.toString(rate1EUR) + " )");
        rate1GBP = Math.floor(getOppositeNumber(rateGBP) * 100) / 100;
        mTvRateGBP.setText("( " + Double.toString(rate1GBP) + " )");
        rate1JPY = Math.floor(getOppositeNumber(rateJPY) * 10000) / 10000;
        mTvRateJPY.setText("( " + Double.toString(rate1JPY) + " )");

    }

    public double getOppositeNumber(double input) {
        return 1 / input;
    }


    public String calculateUSD(double rate, String priceInput) {
        if (priceInput.length() > 0) {
            Double priceInputDouble = Double.parseDouble(priceInput);
            double result = rate * priceInputDouble;
            result = Math.floor(result * 10) / 10;
            return Double.toString(result);
        }
        return null;
    }

    public String calculateEUR(double rate, String priceInput) {
        if (priceInput.length() > 0) {
            Double priceInputDouble = Double.parseDouble(priceInput);
            double result = rate * priceInputDouble;
            result = Math.floor(result * 100) / 100;
            return Double.toString(result);
        }
        return null;
    }

    public String calculateGBP(double rate, String priceInput) {
        if (priceInput.length() > 0) {
            Double priceInputDouble = Double.parseDouble(priceInput);
            double result = rate * priceInputDouble;
            result = Math.floor(result * 100) / 100;
            return Double.toString(result);
        }
        return null;
    }

    public String calculateJPY(double rate, String priceInput) {
        if (priceInput.length() > 0) {
            Double priceInputDouble = Double.parseDouble(priceInput);
            double result = rate * priceInputDouble;
            result = Math.floor(result * 100) / 100;
            return Double.toString(result);
        }
        return null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convert_currency, menu);
        return true;
    }


    @Override
    public void onResponse(Response<ResponseAPICurrencyModel> response, Retrofit retrofit) {
        response.body();
        succesCall++;

        if(response.body().query.results.rate.id.toString().equals("CNYUSD") == true){
            rateUSD = Double.parseDouble(response.body().query.results.rate.Ask);
        }

        if(response.body().query.results.rate.id.toString().equals("CNYEUR") == true){
            rateEUR = Double.parseDouble(response.body().query.results.rate.Ask);
        }

        if(response.body().query.results.rate.id.toString().equals("CNYGBP") == true){
            rateGBP = Double.parseDouble(response.body().query.results.rate.Ask);
        }

        if(response.body().query.results.rate.id.toString().equals("CNYJPY") == true){
            rateJPY = Double.parseDouble(response.body().query.results.rate.Ask);
        }

        if(succesCall == 4){
            Toast.makeText(this, R.string.convert_currency_toast_succes, Toast.LENGTH_SHORT).show();
            calculateAndSet();
        }

    }

    @Override
    public void onFailure(Throwable t) {
        failCall++;

        Toast.makeText(this, R.string.convert_currency_toast_no_internet, Toast.LENGTH_SHORT).show();

    }
}