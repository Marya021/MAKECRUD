package com.shiend.makecrud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class adaptersiswa extends RecyclerView.Adapter<adaptersiswa.ViewHolder> {
    private final Context context;
    private final List<Responsiswa> list;

    LayoutInflater layoutInflater;

    public adaptersiswa(Context context, List<Responsiswa> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_siswa, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvid.setText(list.get(position).getNik());
        holder.Nama.setText(list.get(position).getName());
        holder.tvemail.setText(list.get(position).getEmail());
        holder.tvphone.setText(list.get(position).getPhone());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailRekap.class);
                intent.putExtra("tvid", list.get(position).getNik());
                intent.putExtra("Nama", list.get(position).getName());
                intent.putExtra("tvemail", list.get(position).getEmail());
                intent.putExtra("tvphone", list.get(position).getPhone());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvid)
        TextView tvid;
        @BindView(R.id.Nama)
        TextView Nama;
        @BindView(R.id.tvemail)
        TextView tvemail;
        @BindView(R.id.tvphone)
        TextView tvphone;
        @BindView(R.id.layout)
        RelativeLayout layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
