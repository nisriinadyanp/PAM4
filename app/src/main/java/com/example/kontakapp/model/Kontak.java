package com.example.kontakapp.model;

public class Kontak {

    String _nama;
    String _noHp;
    int _foto;

    public Kontak(String _nama, String _noHp, int _foto) {
        this._nama = _nama;
        this._noHp = _noHp;
        this._foto = _foto;
    }

    public String get_nama() {
        return _nama;
    }

    public String get_noHp() {
        return _noHp;
    }

    public int get_foto() {
        return _foto;
    }
}
