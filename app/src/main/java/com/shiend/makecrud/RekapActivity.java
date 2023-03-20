package com.shiend.makecrud;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RekapActivity extends AppCompatActivity {
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    private service services;
    private List<Rekapresp> data;
    String perihal, tanggal,jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        ButterKnife.bind(this, this);
        services = utils.getClient().create(service.class);
        perihal = getIntent().getStringExtra("judul");
        tanggal = getIntent().getStringExtra("tanggal");
        jenis = getIntent().getStringExtra("jenis");

        Log.d( "onCreate: ", jenis);

        if(jenis.equals("1")) {
            getFilter();
        } else{
            loadData();
        }

//

//

    }

    private void loadData() {
        services.getdatarekap().enqueue(new Callback<MRekap>() {
            @Override
            public void onResponse(Call<MRekap> call, Response<MRekap> response) {
                if (response.body().getMessage().equals("sukses")) {
                   List<Rekapresp> list = response.body().getData();
                    Log.d("onResponse: ", String.valueOf(list.size()));
                    progressBar.setVisibility(View.GONE);
                    showData(list);
                } else {
                    Log.d("onResponse: ", "tidak ada data");
                    Toast.makeText(RekapActivity.this, "tidak ada data", Toast.LENGTH_SHORT).show();
                }

            }
                @Override
            public void onFailure(Call<MRekap> call, Throwable t) {
                    Log.d("onResponse: ", "gagal" +t.getMessage());
            }
        });
        
        
    }

    private void getFilter(){

        Log.d( "getFilter: ",perihal+"-"+tanggal);

        services.getdatafilter(perihal,tanggal).enqueue(new Callback<FilterRekap>() {
            @Override
            public void onResponse(Call<FilterRekap> call, Response<FilterRekap> response) {
                if (response.body().getMessage().equals("sukses")) {
                    List<Rekapresp> list = response.body().getData();
                    Log.d("onResponse: ", String.valueOf(list.size()));
                    progressBar.setVisibility(View.GONE);
                    showData(list);
                } else {
                    Log.d("onResponse: ", "tidak ada data");
                    Toast.makeText(RekapActivity.this, "tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FilterRekap> call, Throwable t) {
                Log.d("onResponse: ", "gagal" +t.getMessage());
            }
        });
    }


    private void showData(List<Rekapresp> list) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new adapterrekap(this, list));
    }



}
