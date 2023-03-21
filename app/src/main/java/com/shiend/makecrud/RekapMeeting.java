package com.shiend.makecrud;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RekapMeeting extends AppCompatActivity {

//    @BindView(R.id.btnserach)
//    Button btnsearch;

    EditText etJudul;
    Button btnserach;
    String judul;
    String tanggal;

    @BindView(R.id.btnRekap)
    Button btnRekap;

//    @BindView(R.id.etJudul)
//    EditText etJudul;

    @BindView(R.id.etTanggal)
    EditText etTanggal;

    private EditText tanggalMeeting;
    private ImageButton ibMasuk;
    private service services;
    private SimpleDateFormat dateFormat;


    private int tglMasuk;
    private int blnMasuk;
    private int thnMasuk;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_rekap);

        ButterKnife.bind(this, this);
        ibMasuk = findViewById(R.id.ibTanggalMasuk);
        tanggalMeeting = findViewById(R.id.etTanggal);
        services = utils.getClient().create(service.class);

//        judul = etJudul.getText().toString();
//        tanggal = etTanggal.getText().toString();

        etJudul = findViewById(R.id.etJudul);
        btnserach = findViewById(R.id.btnserach);


        btnserach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(RekapMeeting.this, RekapActivity.class);
                judul = etJudul.getText().toString();
                tanggal=etTanggal.getText().toString();
                inte.putExtra("judul",judul);
                inte.putExtra("tanggal",tanggal);
                inte.putExtra("jenis","1");
//
//                    Log.d( "tesssssssssssssss: ",judul);
//                    Log.d( "tesssssssssssssss: ",tanggal);
                startActivity(inte);
                }
            });

//                inte.putExtra("judul",judul);
//                inte.putExtra("tanggal",tanggal);
//                     Log.d( "tessssssssssssss: ",judul );
//
//
//                startActivity(inte);
//
//            }
//        });


        btnRekap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d( "tessssssssssssss: ",judul +"" +tanggal );
                Intent inte = new Intent(RekapMeeting.this, RekapActivity.class);
                inte.putExtra("jenis","2");
                startActivity(inte);

            }
        });


        //dateFormat
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        ibMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                thnMasuk = calendar.get(Calendar.YEAR);
                blnMasuk = calendar.get(Calendar.MONTH);
                tglMasuk = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog pickerDialog;
                pickerDialog = new DatePickerDialog(RekapMeeting.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        thnMasuk = year;
                        blnMasuk = month;
                        tglMasuk = dayOfMonth;

                        tanggalMeeting.setText(thnMasuk + "-" + blnMasuk + "-" + tglMasuk);
                    }
                }, thnMasuk, blnMasuk, tglMasuk);
                pickerDialog.setTitle("Tanggal Masuk");
                pickerDialog.show();
            }
        });


    }

}
