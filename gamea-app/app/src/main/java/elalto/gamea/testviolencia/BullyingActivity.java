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

public class BullyingActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_bullying);
        init();
    }

    private void init() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("¿Sufres de bulling en la escuela?");
        txv_consulta = (TextView)findViewById(R.id.txv_consulta);
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio te obligan a hacer cosas que no quieres o que estan mal?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio rompen o esconden tus cosas a proposito?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio dicen a otros (as) que no te hablen o no sean tus amigos?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio te insultan?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio se burlan de ti por tu apariencia física?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio te golpean con frecuencia (patadas, empujones, puñetes, etc)?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio te ponen apodos que te hacen sentir mal?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio te quitan tu dinero u objetos de valor?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio te aíslan y no te dejan participar de actividades de grupo?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio publican fotos o comentarios ofensivos sobre ti en facebook, WhatsApp y otros?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio te hacen sentir incómoda (o) con insinuaciones de tipo sexual?",0));
        preguntasArrayList.add(new Preguntas("¿Tus compañeros (as) del colegio hacen chistes que te ridiculizan o hacen sentir mal?",0));
        final ListIterator<Preguntas> listIterator = preguntasArrayList.listIterator();
        txv_consulta.setText(listIterator.next().getTexto());
        btn_siempre = (Button)findViewById(R.id.btn_siempre);
        btn_aveces = (Button) findViewById(R.id.btn_aveces);
        btn_nunca = (Button)findViewById(R.id.btn_nunca);
        semaforo = (GifImageView)findViewById(R.id.semaforo);
        siempre = 0;
        aveces = 0;
        nunca = 0;
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
                bundle.putString("test", "bullying");
                bundle.putString("respuesta", "verde");
                startActivity(new Intent(BullyingActivity.this, RespuestaActivity.class).putExtras(bundle));
                c = c+1;
            }
        }

        if (aveces >= 2 && aveces <= 5){
            if (c == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("test", "bullying");
                bundle.putString("respuesta", "amarillo");
               startActivity(new Intent(BullyingActivity.this, RespuestaActivity.class).putExtras(bundle));
                c = c+1;
            }
        }

        if (aveces >= 6 || siempre > 0){
            if (c == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("test", "bullying");
                bundle.putString("respuesta", "rojo");
                startActivity(new Intent(BullyingActivity.this, RespuestaActivity.class).putExtras(bundle));
                c = c+1;
            }
        }
    }
}
