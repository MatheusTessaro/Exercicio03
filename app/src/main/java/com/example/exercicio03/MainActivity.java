package com.example.exercicio03;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private TextView textField;
    private EditText edtText;
    private SeekBar skbTamanhoLetra;
    private ImageButton btnEnviar;
    private CheckBox ckbNegrito;
    private CheckBox ckbItalico;
    private CheckBox ckbMaiusculo;
    private RadioButton rdbRoxo;
    private RadioButton rdbLaranja;
    private RadioButton rdbCiano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = findViewById(R.id.textfield);
        edtText = findViewById(R.id.edtText);
        skbTamanhoLetra = findViewById(R.id.skbTamanhoLetra);
        btnEnviar = findViewById(R.id.btnEnviar);
        ckbNegrito = findViewById(R.id.ckbNegrito);
        ckbItalico = findViewById(R.id.ckbItalico);
        ckbMaiusculo = findViewById(R.id.ckbMaiusculo);
        rdbRoxo = findViewById(R.id.rdbRoxo);
        rdbLaranja = findViewById(R.id.rdbLaranja);
        rdbCiano = findViewById(R.id.rdbCiano);

        btnEnviar.setOnClickListener(this);
        skbTamanhoLetra.setOnSeekBarChangeListener(this);
        ckbNegrito.setOnCheckedChangeListener(this);
        ckbItalico.setOnCheckedChangeListener(this);
        ckbMaiusculo.setOnCheckedChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textField.setTextSize(progress+12);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnEnviar) {
                String aux = "";
                aux = aux.concat(textField.getText().toString() + " " + edtText.getText().toString());


                textField.setText(aux);
                edtText.getText().clear();

        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(ckbNegrito.isChecked()){
            textField.setTypeface(null, Typeface.BOLD);
        }
        if (ckbItalico.isChecked()){
            textField.setTypeface(null, Typeface.ITALIC);
        }
        if (ckbMaiusculo.isChecked()){
            textField.setText(textField.getText().toString().toUpperCase());
        }else {
            textField.setText(textField.getText().toString().toLowerCase());
        }

        if(ckbNegrito.isChecked() && ckbItalico.isChecked()){
            textField.setTypeface(null, Typeface.BOLD_ITALIC);
        }

        if(rdbRoxo.isChecked()){
            rdbLaranja.setChecked(false);
            rdbCiano.setChecked(false);
            textField.setTextColor(Color.parseColor("#808080"));
            textField.setTextColor(Color.parseColor("#6a0dad"));
        }
        if(rdbLaranja.isChecked()){
            rdbRoxo.setChecked(false);
            rdbCiano.setChecked(false);
            textField.setTextColor(Color.parseColor("#808080"));
            textField.setTextColor(Color.parseColor("#ff9900"));
        }
        if(rdbCiano.isChecked()){
            rdbRoxo.setChecked(false);
            rdbLaranja.setChecked(false);
            textField.setTextColor(Color.parseColor("#808080"));
            textField.setTextColor(Color.parseColor("#00FFFF"));
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}