package id.twooh.appinvetory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "data_inventory";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "nama_barang";
    public static final String COLUMN_MERK = "merk_barang";
    public static final String COLUMN_HARGA = "harga_barang";
    public static final String db_name = "inventory.db";
    public static final int db_version = 1;

    //Perintah SQL untuk membuat tabel database baru
    public static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " varchar(50) not null, "
            + COLUMN_MERK + " varchar(50) not null, "
            + COLUMN_HARGA + " varchar(50) not null); ";

    public DBHelper (Context context) {
        super(context, db_name, null, db_version);
        //auto generate
    }

    //method untuk eksekusi perintah create database
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
