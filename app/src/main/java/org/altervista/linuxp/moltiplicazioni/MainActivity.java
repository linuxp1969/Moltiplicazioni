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

    private Random randomLinux;
    private int risultato = 0, punteggio = 0, punteggiotot=0;

    private long mCurrentTime = 30000l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inizializzaFind();
        gestisciCronometro();
        cronometro.start();
        List<Integer> lista = generaNumero();
        impostaTestoBottoni(lista);
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
                mCurrentTime = mCurrentTime - 1000l;
                tvTimer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                tvRisultato.setText("Hai fatto " + punteggio + " punti su " + punteggiotot);
                chiudiGioco();

            }
        };
    }

    private void chiudiGioco() {
        bnRisposta1.setEnabled(false);
        bnRisposta2.setEnabled(false);
        bnRisposta3.setEnabled(false);
        bnRisposta4.setEnabled(false);
        tvTimer.setText("Hai finito il tempo");

    }

    private void onClick(View v) {
        punteggiotot++;
        Button bottone = (Button) v;

        List<Integer> lista = generaNumero();
        impostaTestoBottoni(lista);

        switch (v.getId()) {
            case R.id.bnRisposta1:
                bottone = bnRisposta1;
                rispostaCorretta(bottone);
            break;
            case (R.id.bnRisposta2):
                bottone = bnRisposta2;
                rispostaCorretta(bottone);
                break;
            case (R.id.bnRisposta3):
                bottone = bnRisposta3;
                rispostaCorretta(bottone);
                break;
            case (R.id.bnRisposta4):
                bottone = bnRisposta4;
                rispostaCorretta(bottone);
                break;
        }
    }

    private List<Integer> generaNumero() {
        List<Integer> lista = new ArrayList<>();

        for (int i=0; i<4; i++) {
            int numeroRandom1 = randomLinux.nextInt(10)+1;
            int numeroRandom2 = randomLinux.nextInt(10)+1;
            lista.add(numeroRandom1*numeroRandom2);
            if (i==0) {
                tvDomanda.setText("Quale è il risultato di "+numeroRandom1 + "*" + numeroRandom2 + "?");
                risultato = numeroRandom1*numeroRandom2;

            }

        }
        return lista;
    }

    private boolean rispostaCorretta (Button bottone) {
        if (bottone.getText().toString().equals(String.valueOf(risultato))) {
            punteggio++;
            return true;
        }
        return false;
    }

    private void impostaTestoBottoni (List<Integer> lista) {
        bnRisposta1.setText(String.valueOf(lista.get(0)));
        bnRisposta2.setText(String.valueOf(lista.get(1)));
        bnRisposta3.setText(String.valueOf(lista.get(2)));
        bnRisposta4.setText(String.valueOf(lista.get(3)));
    }
}
