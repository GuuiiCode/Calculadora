package br.com.guilherme.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    float numeroA = 0;
    float numeroB = 0;
    float result = 0;
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.txt_resultado);
    }

    public void cliclouBotao(View v) {
        switch (v.getId()) {
            case R.id.btn_soma:
                calculaNumeros("+");
                break;
            case R.id.btn_subtracao:
                calculaNumeros("-");
                break;
            case R.id.btn_divisao:
                calculaNumeros("/");
                break;
            case R.id.btn_multiplicacao:
                calculaNumeros("*");
                break;
            case R.id.btn_igual:
                mostraResultado();
                break;
            case R.id.btn_clear:
                reset();
                break;
            default:
                String numB = ((Button) v).getText().toString();
                numeroDigitado(numB);
                break;
        }
    }

    public void calculaNumeros(String tipoOperacao) {
       try{
           numeroA = Float.parseFloat(resultado.getText().toString());
           operacao = tipoOperacao;
           resultado.setText("");
       }catch (Exception e){
           e.getMessage();
       }
    }

    public void numeroDigitado(String numeroB) {
            String scrCurrent = resultado.getText().toString();
            scrCurrent += numeroB;
            resultado.setText(scrCurrent);
    }

    public void mostraResultado() {
        try {
            numeroB = Float.parseFloat(resultado.getText().toString());
            if (operacao.equals("+")) {
                result = numeroA + numeroB;
            } else if (operacao.equals("-")) {
                result = numeroA - numeroB;
            } else if (operacao.equals("*")) {
                result = numeroA * numeroB;
            } else {
                result = numeroA / numeroB;
            }
            resultado.setText(String.valueOf(result));
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void reset() {
        resultado.setText("");
        operacao = "";
        numeroA = 0;
        numeroB = 0;
    }
}
