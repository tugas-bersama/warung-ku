package com.example.utsksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditBarang extends AppCompatActivity  {
    private DBDataSource dataSource;

    private long id;
    private String harga;
    private String stok;
    private String nama;

    private EditText edNama;
    private EditText edHarga;
    private EditText edStok;

    private TextView txId;

    private Button btnSave;
    private Button btnCancel;

    private Barang barang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_stok);
        //inisialisasi variabel
        edNama = (EditText) findViewById(R.id.editText4);
        edHarga = (EditText) findViewById(R.id.editText5);
        edStok = (EditText) findViewById(R.id.editText6);
       // txId = (TextView) findViewById(R.id.text_id_barang);
        //buat sambungan baru ke database
        dataSource = new DBDataSource(this);
        dataSource.open();
        // ambil data barang dari extras
        Bundle bun = this.getIntent().getExtras();
        id = bun.getLong("id");
        harga = bun.getString("harga");
        stok = bun.getString("stok");
        nama = bun.getString("nama");
        //masukkan data-data barang tersebut ke field editor
     //   txId.append(String.valueOf(id));
        edNama.setText(nama);
        edHarga.setText(harga);
        edStok.setText(stok);
    }
    public void onClickBack(View view) {
        Intent cari = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(cari);
        this.finish();
    }

    public void onclickEditdata(View view) {
        barang = new Barang();
        barang.setHarga_barang(edHarga.getText().toString());
        barang.setNama_barang(edNama.getText().toString());
        barang.setStok_barang(edStok.getText().toString());
        barang.setId(id);
        dataSource.updateBarang(barang);
        Intent i = new Intent(this, ViewData.class);
        startActivity(i);
        EditBarang.this.finish();
        dataSource.close();
    }
    public void onclickHapus(View view) {
        barang = new Barang();
        barang.setHarga_barang(edHarga.getText().toString());
        barang.setNama_barang(edNama.getText().toString());
        barang.setStok_barang(edStok.getText().toString());
        barang.setId(id);
        dataSource.deleteNote(barang);
        Intent i = new Intent(this, ViewData.class);
        startActivity(i);
        EditBarang.this.finish();
        dataSource.close();
    }
}
