package com.example.exercicio03;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar skbVermelho;
    private SeekBar skbVerde;
    private SeekBar skbAzul;
    private TextView txtCor;
    private TextView cor;

    private String[] corHex={"00","00","00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skbVermelho = findViewById(R.id.skbVermelho);
        skbVerde = findViewById(R.id.skbVerde);
        skbAzul = findViewById(R.id.skbAzul);
        txtCor = findViewById(R.id.txtCor);
        cor = findViewById(R.id.barraCor);

        skbVermelho.setOnSeekBarChangeListener(this);
        skbVerde.setOnSeekBarChangeListener(this);
        skbAzul.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String c = Integer.toHexString(progress);
        if (seekBar.getId() == R.id.skbVermelho)
            corHex[0] = (c.length() == 2? "":"0") + c;
        if (seekBar.getId() == R.id.skbVerde)
            corHex[1] = (c.length() == 2? "":"0") + c;
        if (seekBar.getId() == R.id.skbAzul)
            corHex[2] = (c.length() == 2? "":"0") + c;

        txtCor.setText("#" + corHex[0] + corHex[1] + corHex[2]);
        cor.setBackgroundColor(Color.parseColor("#"+ corHex[0] + corHex[1] + corHex[2]));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}