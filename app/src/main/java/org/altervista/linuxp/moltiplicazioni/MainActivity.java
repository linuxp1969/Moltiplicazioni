package org.altervista.linuxp.moltiplicazioni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvDomanda, tvTimer, tvRisultato;
    private Button bnRisposta1, bnRisposta2, bnRisposta3, bnRisposta4;
    private CountDownTimer cronometro;

    private Random random;
    private int risultato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inizializzaFind();
        gestisciCronometro();
    }

    private void inizializzaFind() {
        tvDomanda = findViewById(R.id.tvDomanda);
        tvTimer = findViewById(R.id.tvTimer);
        tvRisultato = findViewById(R.id.tvRisultato);

        bnRisposta1 = findViewById(R.id.bnRisposta1);
        bnRisposta2 = findViewById(R.id.bnRisposta2);
        bnRisposta3 = findViewById(R.id.bnRisposta3);
        bnRisposta4 = findViewById(R.id.bnRisposta4);

    }

    private void gestisciCronometro() {
        cronometro = new CountDownTimer(30000l,1000l) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

            }
        };
    }

    private void onClick(View v) {
        Button bottone = (Button) v;

        switch (v.getId()) {
            case R.id.bnRisposta1:
            break;
            case (R.id.bnRisposta2):
                break;
            case (R.id.bnRisposta3):
                break;
            case (R.id.bnRisposta4):
                break;
        }
    }

    private List<Integer> generaNumero() {
        List<Integer> lista = new ArrayList<>();

        for (int i=0; i<4; i++) {
            int numeroRandom1 = random.nextInt(10)+1;
            int numeroRandom2 = random.nextInt(10)+1;
            lista.add(numeroRandom1*numeroRandom2);
            if (i==0) {
                tvDomanda.setText("Quale è il risultato di "+numeroRandom1 + "*" + numeroRandom2 + "?");
                risultato = numeroRandom1*numeroRandom2;

            }

        }
        return lista;
    }
}
