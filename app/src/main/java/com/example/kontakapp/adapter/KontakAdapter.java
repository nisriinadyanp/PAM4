package com.example.kontakapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kontakapp.R;
import com.example.kontakapp.model.Kontak;
import com.example.kontakapp.viewholder.KontakViewHolder;

import java.util.ArrayList;

public class KontakAdapter extends RecyclerView.Adapter<KontakViewHolder> {

    private ArrayList<Kontak> _kontakList;
    private Context _context;

    public KontakAdapter(ArrayList<Kontak> _kontakList, Context context) {
        this._kontakList = _kontakList;
        this._context = context;
    }

    @NonNull
    @Override
    public KontakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        KontakViewHolder viewHolder = new KontakViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KontakViewHolder holder, int position) {

        holder.get_txNama().setText(_kontakList.get(position).get_nama());
        Glide.with(_context).load(_kontakList.get(position).get_foto()).into(holder.get_Foto());
        holder.get_txNoHp().setText(_kontakList.get(position).get_noHp());
    }

    @Override
    public int getItemCount() {
        return _kontakList.size();
    }
}
