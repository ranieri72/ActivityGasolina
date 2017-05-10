package com.ranieri.ex1glauber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {

    private double gas;
    private double alc;
    private TextView alcool;
    private TextView gasolina;
    private TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        gas = getIntent().getDoubleExtra("gas", 0);
        alc = getIntent().getDoubleExtra("alc", 0);

        alcool = (TextView) findViewById(R.id.txtAlcool);
        gasolina = (TextView) findViewById(R.id.txtGasolina);
        resposta = (TextView) findViewById(R.id.txtResultado);

        atualizarTexto();
    }

    private void atualizarTexto(){
        String textoResultado = getString(R.string.resultado);

        alcool.setText(String.valueOf(alc));
        gasolina.setText(String.valueOf(gas));

        if ((gas * 0.7) > alc){
            textoResultado += " " + getString(R.string.alcool);
        } else{
            textoResultado += " " + getString(R.string.gasolina);
        }

        resposta.setText(textoResultado);
    }
}
