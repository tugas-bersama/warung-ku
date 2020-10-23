package com.example.utsksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CariBarang extends AppCompatActivity {

    private EditText edNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_barang);
        edNama = findViewById(R.id.cari);

    }

    public void onClickBack(View view) {
        Intent cari = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(cari);
        this.finish();
    }

    public void oncari(View view) {
        String nama = null;
        if(edNama.getText()!=null){
            nama = edNama.getText().toString();
           final DBDataSource dataSource = new DBDataSource(this);
            dataSource.open();
           final ArrayList<Barang> dtbarang;
           dtbarang = dataSource.CARI(nama);
           final ArrayAdapter<Barang> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dtbarang);
           final ListView lv = findViewById(R.id.listCari);
           lv.setAdapter(adapter);
           edNama.setText(null);
           edNama.isFocused();
           if (dtbarang.isEmpty()){
               Toast.makeText(this,"Barang tidak di temukan \n masukan kata kunci yang lain",Toast.LENGTH_LONG).show();
               edNama.setText(null);
               edNama.isFocused();
               lv.setAdapter(adapter);
           }
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Barang c = dtbarang.get(position);
                    long idbarang = c.getId();
                    Barang b = dataSource.getBarang(idbarang);
                    Intent i = new Intent(getApplicationContext(), EditBarang.class);
                    Bundle bun = new Bundle();
                    bun.putLong("id", b.getId());
                    bun.putString("nama", b.getNama_barang());
                    bun.putString("harga", b.getHarga_barang());
                    bun.putString("stok", b.getStok_barang());
                    i.putExtras(bun);
                    CariBarang.this.finish();
                    dataSource.close();
                    startActivity(i);
                }
            });
           }
    }
}
