package com.geeksfarm.tasbihvirtual;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int angka = 0;
    private TextView textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitung(View v){
        angka++;
        Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        textCounter =  (TextView) findViewById(R.id.textCounter);
        textCounter.setText(Integer.toString(angka));
        vibe.vibrate(50);
        if(angka == 33){
            vibe.vibrate(2000);
        }
        if(angka == 34){
            reset(v);
        }
    }

    public void reset(View v){
        angka=0;
        textCounter = (TextView) findViewById(R.id.textCounter);
        textCounter.setText(Integer.toString(angka));

        String pesan = "Berhasil direset";
        Toast notif = Toast.makeText(this, pesan,Toast.LENGTH_LONG);
        notif.setGravity(Gravity.FILL_HORIZONTAL, 0, -500);
        notif.show();
    }
}
