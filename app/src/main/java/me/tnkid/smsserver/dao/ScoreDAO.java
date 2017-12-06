package me.tnkid.smsserver.dao;

/**
 * Created by tom on 12/5/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import me.tnkid.smsserver.database.ScoreDb;
import me.tnkid.smsserver.mystring.MyString;
import me.tnkid.smsserver.model.Score;





/**
 * Created by tom on 12/5/2017.
 */

public class ScoreDAO {
    private ScoreDb sqLite;
    private SQLiteDatabase sqLiteDatabase;
    private String[] coLums = {MyString.MA_HS,MyString.TEN_HS,
            MyString.D_TOAN, MyString.D_LY, MyString.D_HOA};

    public ScoreDAO(Context context) {
        sqLite = new ScoreDb(context);
        open();

    }
    public void open() {
        sqLiteDatabase = sqLite.getWritableDatabase();

    }

    public void close() {
        sqLite.close();

    }

    public boolean addScore(Score s){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyString.MA_HS,s.getMHS());
        contentValues.put(MyString.TEN_HS,s.getName());
        contentValues.put(MyString.D_TOAN,s.getdToan());
        contentValues.put(MyString.D_LY,s.getdLy());
        contentValues.put(MyString.D_HOA,s.getdHoa());
        long rs = sqLiteDatabase.insert(MyString.TB_SCORE,null,contentValues);
        if (rs!=0) return true;
        return  false;
    }


    public List<Score> getScore(){
        Score s;
        List<Score> arrs = new ArrayList<Score>();
        Cursor cur = sqLiteDatabase.query(MyString.TB_SCORE,coLums,null,null,null,null,null);
        cur.moveToFirst();

        while (!cur.isAfterLast()){
            int mhs =cur.getInt(0);
            String name =cur.getString(1);
            int dtoan =cur.getInt(2);
            int dly =cur.getInt(3);
            int dhoa =cur.getInt(4);
            s = new Score(mhs,name,dtoan,dly,dhoa);
            arrs.add(s);
            cur.moveToNext();
        }

        return arrs;
    }
    public Score findScoreByID(String id){
        Cursor cur = sqLiteDatabase.query(MyString.TB_SCORE, coLums,
                null, null, null, null, null);
        cur.moveToFirst();
        while (!cur.isAfterLast()) {
            int mhs =cur.getInt(0);
            String name =cur.getString(1);
            int dtoan =cur.getInt(2);
            int dly =cur.getInt(3);
            int dhoa =cur.getInt(4);

            if (id.equalsIgnoreCase(mhs+"")) {
              Score s = new Score(mhs,name,dtoan,dly,dhoa);
              return  s;
            } else {
                cur.moveToNext();
            }
        }
        return null;
    }

}
