package com.example.trabajopractico3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etDolares,etEuros;
    RadioButton rbEaD,rbDaE;
    AutoCompleteTextView atvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etDolares = (EditText)findViewById(R.id.etDolares);
        etEuros = (EditText)findViewById(R.id.etEuros);
        rbEaD = (RadioButton) findViewById(R.id.rbEurosADolares);
        rbDaE = (RadioButton) findViewById(R.id.rbDolaresAEuros);
        atvResultado = (AutoCompleteTextView) findViewById(R.id.atvResultado);

    }

    public void mostrar(View v){
        if(rbDaE.isChecked()) {
            atvResultado.setText("");
            etDolares.setEnabled(true);
            etEuros.setEnabled(false);
        }
        if(rbEaD.isChecked()) {
            atvResultado.setText("");
            etEuros.setEnabled(true);
            etDolares.setEnabled(false);
        }
    }

    public void calcular(View v){

        if(rbDaE.isChecked()){
            etDolares.setEnabled(true);
            Double resultado= (Double.parseDouble(etDolares.getText().toString())) * 0.85;
            DecimalFormat twoDForm = new DecimalFormat("#.##");
            resultado= Double.valueOf(twoDForm.format(resultado));
            atvResultado.setText(resultado.toString());
        }
        else if(rbEaD.isChecked()){
            etEuros.setEnabled(true);
            Double resultado= (Double.parseDouble(etEuros.getText().toString())) * 1.18;
            DecimalFormat twoDForm = new DecimalFormat("#.##");
            resultado= Double.valueOf(twoDForm.format(resultado));
            atvResultado.setText(resultado.toString());
        }
        else{
            Toast.makeText(getApplicationContext(),"Seleccione un tipo",Toast.LENGTH_LONG).show();
        }

    }
}