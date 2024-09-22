package com.example.kontakapp.viewholder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kontakapp.R;

public class KontakViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView _txNama;
    TextView _txNoHp;
    ImageView _Foto;
    Context _context;

    public TextView get_txNama() {
        return _txNama;
    }

    public TextView get_txNoHp() {
        return _txNoHp;
    }

    public ImageView get_Foto() {
        return _Foto;
    }

    public Context get_context() {
        return _context;
    }

    @SuppressLint("WrongViewCast")
    public KontakViewHolder(@NonNull View itemView) {
        super(itemView);
        _context = itemView.getContext();
        _txNama = itemView.findViewById(R.id.id_txNama);
        _txNoHp = itemView.findViewById(R.id.id_txNoHp);
        _txNoHp.setOnClickListener(this);
        _Foto = itemView.findViewById(R.id.id_foto);
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse("tel:"+ _txNoHp.getText().toString());
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        _context.startActivity(it);
    }
}
