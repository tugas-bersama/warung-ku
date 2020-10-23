package com.example.utsksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TambahBarang extends AppCompatActivity {

    private EditText edNama;
    private  EditText edHarga;
    private  EditText edStok;
    private DBDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_barang);
    edNama = findViewById(R.id.editText);
    edHarga = findViewById(R.id.editText2);
    edStok = findViewById(R.id.editText3);
    dataSource = new DBDataSource(this);
    dataSource.open();
    }


    public void onclickBack(View view) {
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
        this.finish();
    }

    public void onclickTambah(View view) {
        String nama = null;
        String stok = null;
        String harga = null;
        Barang barang = null;
        if(edNama.getText()!=null && edHarga.getText()!=null && edStok.getText()!=null)
        {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            nama = edNama.getText().toString();
            stok = edStok.getText().toString();
            harga = edHarga.getText().toString();

            barang = dataSource.createBarang(nama, harga, stok);
            edNama.setText(null);
            edHarga.setText(null);
            edStok.setText(null);

            //konfirmasi kesuksesan
            Toast.makeText(this, "masuk Barang\n\n" +
                    "nama : " + barang.getNama_barang()+"\n" +
                    "merk  : " + barang.getHarga_barang()+"\n" +
                    "harga : " + barang.getStok_barang(), Toast.LENGTH_LONG).show();
        }
    }
}
