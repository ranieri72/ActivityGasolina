package com.ranieri.ex1glauber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String RESULTADO = "resultado";
    EditText mEdtGas;
    EditText mEdtAlcool;
    TextView mTxtResultado;

    public static final int NADA = 0;
    public static final int GAS = 1;
    public static final int ALC = 2;

    private int mResultado;

    View.OnClickListener tratadorDeEvento = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("MainActivity", "Evento de Clique");
            double gasolina = Double.parseDouble(mEdtGas.getText().toString());
            double alcool = Double.parseDouble(mEdtAlcool.getText().toString());

            switch (v.getId()) {
                case R.id.btnCalcular:
                    if ((gasolina * 0.7) > alcool){
                        mResultado = ALC;
                    } else{
                        mResultado = GAS;
                    }
                    atualizarTexto(mResultado);
                break;
                case R.id.btnNovaTela:
                    Intent it = new Intent(MainActivity.this, Tela2Activity.class);
                    it.putExtra("gas", gasolina);
                    it.putExtra("alc", alcool);
                    startActivity(it);
                break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtGas = (EditText) findViewById(R.id.editTextGas);
        mEdtAlcool = (EditText) findViewById(R.id.editTextAlc);
        mTxtResultado = (TextView) findViewById(R.id.textViewResultado);

        findViewById(R.id.btnCalcular).setOnClickListener(tratadorDeEvento);
        findViewById(R.id.btnNovaTela).setOnClickListener(tratadorDeEvento);

        if (savedInstanceState != null) {
            mResultado = savedInstanceState.getInt(RESULTADO);
            atualizarTexto(mResultado);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(RESULTADO, mResultado);
    }

    private void atualizarTexto(int resultado){
        if(resultado != NADA){
            String textoResultado = getString(R.string.resultado);

            if(resultado == ALC){
                textoResultado += getString(R.string.alcool);
            } else if (resultado == GAS){
                textoResultado += getString(R.string.gasolina);
            }
            mTxtResultado.setText(textoResultado);
        }
    }
}
