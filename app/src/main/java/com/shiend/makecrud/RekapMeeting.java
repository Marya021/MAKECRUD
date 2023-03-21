package com.shiend.makecrud;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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

    @BindView(R.id.etTanggal)
    EditText etTanggal;

    private EditText tanggalMeeting;
    private ImageButton ibMasuk;
    private service services;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat;
    private Calendar calendar;
    private SimpleDateFormat simpleDateFormat;

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

        etJudul = findViewById(R.id.etJudul);
        btnserach = findViewById(R.id.btnserach);

        setDate();
        initData();
        initClick();

        btnserach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(RekapMeeting.this, RekapActivity.class);
                judul = etJudul.getText().toString();
                tanggal = etTanggal.getText().toString();
                inte.putExtra("judul", judul);
                inte.putExtra("tanggal", tanggal);
                inte.putExtra("jenis", "1");
                startActivity(inte);
            }
        });


        btnRekap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("tessssssssssssss: ", judul + "" + tanggal);
                Intent inte = new Intent(RekapMeeting.this, RekapActivity.class);
                inte.putExtra("jenis", "2");
                startActivity(inte);

            }
        });


        ibMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

    }

    private void initClick() {
        ibMasuk.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    datePickerDialog.show();
                } else {
                    datePickerDialog.dismiss();
                }
            }
        });
    }

    private void initData() {
        calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
        blnMasuk = calendar.get(Calendar.MONTH);
        tglMasuk = calendar.get(Calendar.DATE);
        thnMasuk = calendar.get(Calendar.YEAR);


        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String DateNow = simpleDateFormat.format(calendar.getTime());
    }

    private void setDate() {
        datePickerDialog = new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog_Alert,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        calendar.set(year, monthOfYear, dayOfMonth);
                        String formattedDate = simpleDateFormat.format(calendar.getTime());
                        tanggalMeeting.setText(formattedDate);
                    }
                }, thnMasuk, blnMasuk, tglMasuk);
        datePickerDialog.setCancelable(false);
        datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                tanggalMeeting.clearFocus();
            }
        });
    }
}
