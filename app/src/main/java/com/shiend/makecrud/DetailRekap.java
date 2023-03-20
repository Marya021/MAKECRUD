package com.shiend.makecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailRekap extends AppCompatActivity {

    private String tvid;
    @BindView(R.id.tvid)
    TextView nama;
    private String perihal;
    @BindView(R.id.perihal)
    TextView Perihal;
    private String nikpic;
    @BindView(R.id.nikpic)
    TextView Nikpic;
    private String namapic;
    @BindView(R.id.namapic)
    TextView Namapic;
    private String tvtarget;
    @BindView(R.id.tvtarget)
    TextView Tvtarget;
    private String ket;
    @BindView(R.id.ket)
    TextView Ket;
    private String tvnik;
    @BindView(R.id.tvnik)
    TextView Tvnik;
    private String tvnamapic;
    @BindView(R.id.tvnamapic)
    TextView Tvnamapic;
    private String tviddl;
    @BindView(R.id.tviddl)
    TextView Tviddl;

    private String tvket;
    @BindView(R.id.tvket)
    TextView Tvket;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rekap2);


        ButterKnife.bind(this);
        tvid = getIntent().getStringExtra("tvid");
        perihal = getIntent().getStringExtra("perihal");
        nikpic = getIntent().getStringExtra("nikpic");
        namapic = getIntent().getStringExtra("namapic");
        tvtarget = getIntent().getStringExtra("tvtarget");
        ket = getIntent().getStringExtra("ket");
        tvnik = getIntent().getStringExtra("tvnik");
        tvnamapic = getIntent().getStringExtra("tvnamapic");
        tvket = getIntent().getStringExtra("tvket");
        tviddl = getIntent().getStringExtra("tviddl");

        nama.setText(tvid);
        Perihal.setText(perihal);
        Nikpic.setText(nikpic);
        Namapic.setText(namapic);
        Tvtarget.setText(tvtarget);
        Ket.setText(ket);
        Tvnik.setText(tvnik);
        Tvket.setText(tvket);
        Tvnamapic.setText(tvnamapic);
        Tviddl.setText(tviddl);

    }
}