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

public class adapterrekap extends RecyclerView.Adapter<adapterrekap.ViewHolder> {
    private final Context context;
    private final List<Rekapresp> list;

    LayoutInflater layoutInflater;

    public adapterrekap(Context context, List<Rekapresp> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.listrekap, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvid.setText(list.get(position).getIdmeeting());
        holder.perihal.setText(list.get(position).getPerihal());
        holder.nikpic.setText(list.get(position).getNikpic());
        holder.namapic.setText(list.get(position).getNamapic());
        holder.tvtarget.setText(list.get(position).getTgltarget());
//        holder.ket.setText(list.get(position).getKethasil());
        holder.tvnik.setText(list.get(position).getTvnik());
        holder.tvket.setText(list.get(position).getTvket());
        holder.tvnamapic.setText(list.get(position).getTvnamapic());
        holder.ket.setText(list.get(position).getKeterangan());
        holder.tviddl.setText(list.get(position).getIddlmeeting());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailRekap.class);
                intent.putExtra("tvid", list.get(position).getIdmeeting());
                intent.putExtra("perihal", list.get(position).getPerihal());
                intent.putExtra("nikpic", list.get(position).getNikpic());
                intent.putExtra("namapic", list.get(position).getNamapic());
                intent.putExtra("tvtarget", list.get(position).getTgltarget());
//                intent.putExtra("ket", list.get(position).getKethasil());
                intent.putExtra("tvnik", list.get(position).getTvnik());
                intent.putExtra("tvket", list.get(position).getTvket());
                intent.putExtra("tvnamapic", list.get(position).getTvnamapic());
                intent.putExtra("ket", list.get(position).getKeterangan());
                intent.putExtra("tviddl", list.get(position).getIddlmeeting());
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
        @BindView(R.id.perihal)
        TextView perihal;
        @BindView(R.id.nikpic)
        TextView nikpic;
        @BindView(R.id.namapic)
        TextView namapic;
        @BindView(R.id.tvtarget)
        TextView tvtarget;
        @BindView(R.id.ket)
        TextView ket;
        @BindView(R.id.tvnik)
        TextView tvnik;
        @BindView(R.id.tvket)
        TextView tvket;
        @BindView(R.id.tvnamapic)
        TextView tvnamapic;
        @BindView(R.id.tviddl)
        TextView tviddl;
        @BindView(R.id.layout)
        RelativeLayout layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
