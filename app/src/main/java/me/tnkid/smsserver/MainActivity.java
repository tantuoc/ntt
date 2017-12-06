package me.tnkid.smsserver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import me.tnkid.smsserver.adapter.ScoreAdapter;
import me.tnkid.smsserver.dao.ScoreDAO;
import me.tnkid.smsserver.model.Score;


public class MainActivity extends AppCompatActivity {
    Button them,statesv;
    ListView ls;
    ScoreDAO scoredao;
    List<Score> scoreList;
    BaseAdapter scoreAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoredao = new ScoreDAO(getApplicationContext());
        them = findViewById(R.id.themdiem);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(MainActivity.this,AddActivity.class);
            startActivity(i);

            }
        });



        ls = findViewById(R.id.list_score);
        scoreList = scoredao.getScore();
        scoreAdapter = new ScoreAdapter(this,R.layout.list_score,scoreList);
        scoreAdapter.notifyDataSetChanged();
        ls.setAdapter(scoreAdapter);

    }



}