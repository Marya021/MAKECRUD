package com.shiend.makecrud;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface service {

    @Headers("Accept: application/json")
    @GET("api.php")
    Call<Siswa> getdatasiswa();


    @Headers("Accept: application/json")
    @GET("api.php")
    Call<MRekap> getdatarekap();


    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("filter.php")
    Call<FilterRekap> getdatafilter(@Field("perihal") String perihal,
                                    @Field("tanggal") String tanggal);

}
