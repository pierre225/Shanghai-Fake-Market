package com.perso.pierre.shanghaifakemarket.Helper;

import com.perso.pierre.shanghaifakemarket.Models.ResponseAPICurrencyModel;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Pithou on 01/04/2016.
 */
public interface CurrenciesAPI {

    @GET("v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22CNYUSD%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=")
    public Call<ResponseAPICurrencyModel> getCurrenciesUSD();


    @GET("v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22CNYEUR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=")
    public Call<ResponseAPICurrencyModel> getCurrenciesEUR();


    @GET("v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22CNYGBP%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=")
    public Call<ResponseAPICurrencyModel> getCurrenciesGBP();


    @GET("v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22CNYJPY%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=")
    public Call<ResponseAPICurrencyModel> getCurrenciesJPY();

}
