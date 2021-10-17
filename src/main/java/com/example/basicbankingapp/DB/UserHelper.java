package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    private static final String DATABASE_NAME = "User.db";

    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_USER_TABLE);

        db.execSQL("insert into " + TABLE_NAME + " values(9660,'Anshul Baretiya', 'ab@gmail.com', '7584','7895645238', 46852)");
        db.execSQL("insert into " + TABLE_NAME + " values(5262,'Geetanshu Khandagade', 'gk@gmail.com','1258','899565238', 87520)");
        db.execSQL("insert into " + TABLE_NAME + " values(6395,'Naina Singh', 'ns@gmail.com','8896','7595686896', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9658,'Garima Dubey', 'gd@gmail.com','7752','9965640038', 65482)");
        db.execSQL("insert into " + TABLE_NAME + " values(8510,'Ayushi Dubey', 'ad@gmail.com','3669','9095645662', 78558)");
        db.execSQL("insert into " + TABLE_NAME + " values(7429,'Vansh Singla', 'vs@gmail.com','9985','8965640238', 44650)");
        db.execSQL("insert into " + TABLE_NAME + " values(4198,'Naman Lahoti', 'nl@gmail.com','1207','8895646515', 45656)");
        db.execSQL("insert into " + TABLE_NAME + " values(5253,'Aditya Rawal', 'ar@gmail.com','4522','9954221539', 8896)");
        db.execSQL("insert into " + TABLE_NAME + " values(6362,'Dadda Tyagi', 'dt@gmail.com','6582','6909565238', 215437)");
        db.execSQL("insert into " + TABLE_NAME + " values(1065,'Golu Gupta', 'gg@gmail.com','5450','8230591201', 85244)");
        db.execSQL("insert into " + TABLE_NAME + " values(2054,'Kaleen Bhaiya', 'kb@gmail.com','2656','9015641230', 32145)");
        db.execSQL("insert into " + TABLE_NAME + " values(9321,'Faizal Khan', 'fk@gmail.com','1203','9665641999', 32465)");
        db.execSQL("insert into " + TABLE_NAME + " values(8222,'Sonu Gupta', 'sg@gmail.com','5566','9132541001', 87365)");
        db.execSQL("insert into " + TABLE_NAME + " values(7112,'Mukesh Ambani', 'ma@gmail.com','2236','6253642205', 64352)");
        db.execSQL("insert into " + TABLE_NAME + " values(9130,'Sheldon Cooper', 'sc@gmail.com','6692','6893641355', 13645)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}