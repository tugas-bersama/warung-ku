package com.example.utsksi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
  //  public DBHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
   //     super(context, name, factory, version);
 //   }
    public static final String TABLE_NAME = "data_inventori";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "nama_barang";
    public static final String COLUMN_STOK = "stok_barang";
    public static final String COLUMN_HARGA = "harga_barang";
    private static final String db_name ="inventori.db";
    private static final int db_version=1;
    private final int textInputLayout = R.id.textInputLayout;
    // Perintah SQL untuk membuat tabel database baru
    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_HARGA+ " varchar(50) not null, "
            + COLUMN_STOK+ " varchar(50) not null);";
      String cari = "select * from"
                +DBHelper.TABLE_NAME+"where"
            +DBHelper.COLUMN_NAME+"= "+ textInputLayout;

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
        // Auto generated
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
