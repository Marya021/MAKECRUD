package com.shiend.makecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainSiswa extends AppCompatActivity {

    private service services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_siswa);
        services = utils.getClient().create(service.class);

        services.getdatasiswa().enqueue(new Callback<Siswa>() {
            @Override
            public void onResponse(Call<Siswa> call, Response<Siswa> response) {
                if (response.body().getMessage().equals("sukses")) {
                    Log.d( "onResponse: ",response.body().getMessage());
                    Toast.makeText(mainSiswa.this, "ada data" , Toast.LENGTH_SHORT).show();

                } else {
                    Log.d( "onResponse: ","gagal");
                    Toast.makeText(mainSiswa.this, "GAGAL" , Toast.LENGTH_SHORT).show();}

            }


            @Override
            public void onFailure(Call<Siswa> call, Throwable t) {
                Log.d( "onResponse: ","tidak ada data");

            }
        });

    }
}