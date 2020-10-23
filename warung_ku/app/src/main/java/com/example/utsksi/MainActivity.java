package com.example.utsksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickTambah(View view) {
        Intent tambah = new Intent(this,TambahBarang.class );
      startActivity(tambah);
      this.finish();
    }

    public void onclickCari(View view) {
        Intent cari = new Intent(this,CariBarang.class );
        startActivity(cari);
        this.finish();
    }

    public void onclickEdit(View view) {
        Intent data = new Intent(this, ViewData.class);
        startActivity(data);
        this.finish();
    }

    public void onclickExit(View view) {
        this.finish();
    }

}
