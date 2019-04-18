package fiona.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {
Bundle b;
Intent i;
TextView songN,songA;
ImageView img;
MediaPlayer mp;
ImageView play,pre,next;
int songNo=0;
int[][] songs_details = {
    {(R.raw.across_the_lines), (R.string.across_the_lines), (R.string.tracy),(R.drawable.tracy)},
    {(R.raw.ariana_grande_break_free), (R.string.break_free), (R.string.ariana),(R.drawable.break_free)},
    {(R.raw.kryptonite_3_doors_down), (R.string.kryptonite), (R.string._3_doors_down),(R.drawable.kryptonite_3_doors_)},
    {(R.raw.avicii_hey_brother), (R.string.hey_brother), (R.string.avicii),(R.drawable.avicii_hey_brother)},
    {(R.raw.adele_chasing_pavements), (R.string.chasing_pavements), (R.string.adele),(R.drawable.chasing_pavements)},
    {(R.raw.bastille_pompeii), (R.string.pompeii), (R.string.bastille),(R.drawable.pompeii)},
    {(R.raw.bruce_springsteen_hungry_heart), (R.string.hungry_heart), (R.string.bruce_springsteen),(R.drawable.hungry_heart)},
    {(R.raw.good_girls_5_seconds_of_summer), (R.string.good_girls), (R.string._5sos),(R.drawable.good_girls)},
    {(R.raw.calvin_harris_summer), (R.string.summer), (R.string.calvin_harris),(R.drawable.summer)}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        i = getIntent();
        b = i.getExtras();
        songN = findViewById(R.id.songName);
        songA = findViewById(R.id.songArtist);
        img = findViewById(R.id.thumbNail);
        play = findViewById(R.id.play);
        next = findViewById(R.id.next);
        pre = findViewById(R.id.previous);
        Log.d("***array length:",songs_details.length+"");
        Log.d("*****song",b.getString("song"));
    for(int i =0;i<songs_details.length;i++){
        Log.d("******resource",getResources().getString(songs_details[i][1]));

            Log.d("*****",i+"");
            if (b.getString("song").equals(getResources().getString(songs_details[i][1]))) {
                Log.d("*****if=",i+"");
                songNo = i;
                Log.d("*****songNo = ",songNo+"");
                song(songNo);
            }
        }

    }
    public void playSong(View v){
        if(play.getContentDescription().equals("play")){
            play.setContentDescription("pause");
            play.setImageResource(R.drawable.ic_pause_circle_filled_24dp);
            song(songNo);

        }else{
            play.setContentDescription("play");
            play.setImageResource(R.drawable.ic_play_circle_filled_24dp);
            mp.pause();
        }
    }
    public void song(int n){
        img.setImageResource(songs_details[n][3]);
        songN.setText(songs_details[n][1]);
        songA.setText(songs_details[n][2]);
        mp = MediaPlayer.create(this, songs_details[n][0]);
        mp.start();
        play.setContentDescription("pause");
        play.setImageResource(R.drawable.ic_pause_circle_filled_24dp);
    }
    public void nextSong(View v){
        mp.pause();
        if(songNo <8) {
            songNo= songNo+1;
            song(songNo);
        }else if(songNo==8){
            songNo= 0;
            song(songNo);
        }
    }
    public void previousSong(View v){
        mp.pause();
        if(songNo >0) {
            songNo= songNo-1;
            song(songNo);
        }else if(songNo==0){
            songNo= 8;
            song(songNo);
        }
    }
}
