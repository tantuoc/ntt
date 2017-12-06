package me.tnkid.smsserver.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.tnkid.smsserver.mystring.MyString;


/**
 * Created by tom on 12/5/2017.
 */

public class ScoreDb extends SQLiteOpenHelper {


    public ScoreDb(Context context) {
        super(context, MyString.DB_MY, null, MyString.DB_VER);
    }

    public ScoreDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + MyString.TB_SCORE + "(" + MyString.MA_HS +
                " INTEGER PRIMARY KEY, " + MyString.TEN_HS + " TEXT, " +
                MyString.D_TOAN + " INT DEFAULT NULL, " + MyString.D_LY + " INT DEFAULT NULL, " + MyString.D_HOA + " INT DEFAULT NULL)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE EXITS" + MyString.TB_SCORE);
    }
}
