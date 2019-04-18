package fiona.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] songsNames= {
                getResources().getString(R.string.across_the_lines),
                getResources().getString(R.string.break_free),
                getResources().getString(R.string.kryptonite),
                getResources().getString(R.string.hey_brother),
                getResources().getString(R.string.chasing_pavements),
                getResources().getString(R.string.pompeii),
                getResources().getString(R.string.hungry_heart),
                getResources().getString(R.string.good_girls),
                getResources().getString(R.string.summer)
        };
        ListView songsList = findViewById(R.id.song_list);
        ArrayAdapter<String> adapt=new ArrayAdapter<String>(this, R.layout.main ,songsNames);
        songsList.setAdapter(adapt);

        songsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView= (TextView) view;
                Intent i;
                String str = textView.getText().toString();
              if(str.equalsIgnoreCase(getString(R.string.across_the_lines))){
                  i = new Intent(MainActivity.this, SongActivity.class);
                  i.putExtra("song",getResources().getString(R.string.across_the_lines));
                  startActivity(i);
              }else if(str.equalsIgnoreCase(getString(R.string.break_free))){
                  i = new Intent(MainActivity.this, SongActivity.class);
                  i.putExtra("song",getResources().getString(R.string.break_free));
                  startActivity(i);
              }else if(str.equalsIgnoreCase(getString(R.string.bastille))){
                    i = new Intent(MainActivity.this, SongActivity.class);
                    i.putExtra("song",getResources().getString(R.string.bastille));
                    startActivity(i);
                }
              else if(str.equalsIgnoreCase(getString(R.string.hey_brother))){
                    i = new Intent(MainActivity.this, SongActivity.class);
                    i.putExtra("song",getResources().getString(R.string.hey_brother));
                    startActivity(i);
                }
              else if(str.equalsIgnoreCase(getString(R.string.hungry_heart))){
                    i = new Intent(MainActivity.this, SongActivity.class);
                    i.putExtra("song",getResources().getString(R.string.hungry_heart));
                    startActivity(i);
                }
              else if(str.equalsIgnoreCase(getString(R.string.summer))){
                    i = new Intent(MainActivity.this, SongActivity.class);
                    i.putExtra("song",getResources().getString(R.string.summer));
                    startActivity(i);
                }
              else if(str.equalsIgnoreCase(getString(R.string.good_girls))){
                    i = new Intent(MainActivity.this, SongActivity.class);
                    i.putExtra("song",getResources().getString(R.string.good_girls));
                  startActivity(i);
                }
              else if(str.equalsIgnoreCase(getString(R.string.chasing_pavements))){
                  i = new Intent(MainActivity.this, SongActivity.class);
                  i.putExtra("song",getResources().getString(R.string.chasing_pavements));
                  startActivity(i);
              }
              else if(str.equalsIgnoreCase(getString(R.string.pompeii))){
                  i = new Intent(MainActivity.this, SongActivity.class);
                  i.putExtra("song",getResources().getString(R.string.pompeii));
                  startActivity(i);
              }
            }
        });
    }
}
