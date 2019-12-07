package elalto.gamea.testviolencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.ListIterator;

import elalto.gamea.R;
import elalto.gamea.testviolencia.clases.Preguntas;
import pl.droidsonroids.gif.GifImageView;

public class RelacionViolentaActivity extends AppCompatActivity {
    TextView txv_consulta;
    Button btn_siempre, btn_aveces, btn_nunca;
    Integer index = 0;
    Integer siempre, aveces, nunca;
    GifImageView semaforo;
    ArrayList<Preguntas> preguntasArrayList = new ArrayList<Preguntas>();
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacion_violenta);
        init();
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("¿Tu relacion de pareja es violenta?");
        txv_consulta = (TextView)findViewById(R.id.txv_consulta);
        btn_siempre = (Button)findViewById(R.id.btn_siempre);
        btn_aveces = (Button) findViewById(R.id.btn_aveces);
        btn_nunca = (Button)findViewById(R.id.btn_nunca);
        semaforo = (GifImageView)findViewById(R.id.semaforo);
        siempre = 0;
        aveces = 0;
        nunca = 0;
        preguntasArrayList.add(new Preguntas("¿Tu pareja te hace sentir inferior o inútil?",0));
        preguntasArrayList.add(new Preguntas("¿Critica a tus amigos (as) o familia y te impide relacionarte con ellas y ellos?",0));
        preguntasArrayList.add(new Preguntas("¿Te controla las llamadas y mensajes de celular?",0));
        preguntasArrayList.add(new Preguntas("¿Te grita, insulta o amenaza cuando no haces lo que quiere?",0));
        preguntasArrayList.add(new Preguntas("¿Te hace sentir culpable de todo lo malo?",0));
        preguntasArrayList.add(new Preguntas("¿Te da miedo su mirada o sus gestos en alguna ocasión?",0));
        preguntasArrayList.add(new Preguntas("¿Te obliga a tener relaciones sexuales cuando tú no quieres?",0));
        preguntasArrayList.add(new Preguntas("¿Te grita o se enoja si no le dices a dónde vas?",0));
        preguntasArrayList.add(new Preguntas("¿Te asusta decirle que no estás de acuerdo con lo que dice?",0));
        preguntasArrayList.add(new Preguntas("¿Promete cambios que no complume y te lastima?",0));
        preguntasArrayList.add(new Preguntas("¿Amenaza con suicidarse si le dejas?",0));
        preguntasArrayList.add(new Preguntas("¿Se burla de ti con malicia avergonzándote delante de tus amigos y lo pasa como broma?",0));
        preguntasArrayList.add(new Preguntas("¿No confía en lo que le cuentas y lo comprueba?",0));
        preguntasArrayList.add(new Preguntas("¿Muestra celos constantemente?",0));
        preguntasArrayList.add(new Preguntas("¿Es infiel?",0));
        preguntasArrayList.add(new Preguntas("¿Te ha empujado, pellizcado o golpeado, aunque sea jugando?",0));
        preguntasArrayList.add(new Preguntas("¿Tus sentimientos y deseos son importantes para tu pareja?",0));
        preguntasArrayList.add(new Preguntas("¿Tu pareja te hace sentir inferior o inútil?",0));
        final ListIterator<Preguntas> listIterator = preguntasArrayList.listIterator();
        txv_consulta.setText(listIterator.next().getTexto());
        btn_siempre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (index < preguntasArrayList.size()){
                    txv_consulta.setText(preguntasArrayList.get(index).getTexto());
                    siempre = siempre+1;
                    index = index+1;
                }else{
                    hide_items();
                    semaforo.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            check_respuestas();
                            finish();
                        }
                    },1000);
                }
            }
        });

        btn_aveces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (index < preguntasArrayList.size()){
                    txv_consulta.setText(preguntasArrayList.get(index).getTexto());
                    aveces = aveces+1;
                    index = index+1;
                }else{
                    hide_items();
                    semaforo.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            check_respuestas();
                            finish();
                        }
                    },1000);
                }
            }
        });

        btn_nunca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (index < preguntasArrayList.size()){
                    txv_consulta.setText(preguntasArrayList.get(index).getTexto());
                    nunca = nunca+1;
                    index = index+1;
                }else{
                    hide_items();
                    semaforo.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            check_respuestas();
                            finish();
                        }
                    },1000);
                }
            }
        });
    }
    private void hide_items() {
        txv_consulta.setVisibility(View.INVISIBLE);
        btn_aveces.setVisibility(View.INVISIBLE);
        btn_nunca.setVisibility(View.INVISIBLE);
        btn_siempre.setVisibility(View.INVISIBLE);

    }
    private void check_respuestas(){
        Integer c = 0;
        if (aveces <= 1 && nunca >= 0){
            if (c == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("test", "relacion_violenta");
                bundle.putString("respuesta", "verde");
                startActivity(new Intent(RelacionViolentaActivity.this, RespuestaActivity.class).putExtras(bundle));
                c=c+1;
            }
        }

        if (aveces >= 2 && aveces <= 5){
            if (c == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("test", "relacion_violenta");
                bundle.putString("respuesta", "amarillo");
                startActivity(new Intent(RelacionViolentaActivity.this, RespuestaActivity.class).putExtras(bundle));
                c=c+1;
            }
        }

        if (aveces >= 6 || siempre > 0){
            if (c == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("test", "relacion_violenta");
                bundle.putString("respuesta", "rojo");
                startActivity(new Intent(RelacionViolentaActivity.this, RespuestaActivity.class).putExtras(bundle));
                c= c+1;
            }
        }
    }
}
