package com.aakash.android.inventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aakas on 12/25/2017.
 */

public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = InventoryDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "warehouse.db";

    public static final int DATABASE_VERSION = 1;

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_INVENTORY_TABLE = "CREATE TABLE " +
                InventoryContract.InventoryEdit.TABLE_NAME + " (" +
                InventoryContract.InventoryEdit._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                InventoryContract.InventoryEdit.COLUMN_ITEM_NAME + " TEXT NOT NULL, " +
                InventoryContract.InventoryEdit.COLUMN_ITEM_PRICE + " INTEGER NOT NULL, " +
                InventoryContract.InventoryEdit.COLUMN_ITEM_QUANTITY + " INTEGER NOT NULL DEFAULT 0);";

        sqLiteDatabase.execSQL(SQL_CREATE_INVENTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
