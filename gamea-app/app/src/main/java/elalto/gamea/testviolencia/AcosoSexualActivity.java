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

public class AcosoSexualActivity extends AppCompatActivity {
    TextView txv_consulta;
    Button btn_si, btn_no;
    Integer index = 0;
    Integer si, no;
    GifImageView semaforo;
    ArrayList<Preguntas> preguntasArrayList = new ArrayList<Preguntas>();
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acoso_sexual);
        init();
    }

    private void init() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("¿Sufres de acoso sexual?");
        txv_consulta = (TextView)findViewById(R.id.txv_consulta);
        preguntasArrayList.add(new Preguntas("¿En la calle, el colegio, la movilidad u otro lugar público has recibido piropos o comentarios sobre tu apariencia física que te han hecho sentir incómodo (a) y te han ofendido?",0));
        preguntasArrayList.add(new Preguntas("¿Alguna persona del sexo opuesto te ha mirado de forma morbosa o ha hecho gestos insinuantes que te causen molestia?",0));
        preguntasArrayList.add(new Preguntas("¿Alguna persona del sexo opuesto te ha mostrado imagenes de tipo sexual (en calendarios, carteles, pantallas de celular, computadoras u otras) que te resultaron incómodas?",0));
        preguntasArrayList.add(new Preguntas("¿Has recibido burlas, bromas, comentarios o preguntas sobre tu vida sexual o amorosa que te han hecho sentir incómodo (a)?",0));
        preguntasArrayList.add(new Preguntas("¿Has recibido llamadas telefónicas o mensajes sexuales no deseados?",0));
        preguntasArrayList.add(new Preguntas("¿Has recibido presión para aceptar invitaciones a encuentros o citas no deseadas fuera del colegio o de tu fuente laboral?",0));
        preguntasArrayList.add(new Preguntas("¿Has recibido amenazas por  no aceptar invitaciones o propuestas sexuales por parte de un (a) adulto (a), ya sea en el ámbito escolar o en tu fuente laboral?",0));
        preguntasArrayList.add(new Preguntas("¿Has recibido represalias o medidas disciplinarias por haber rechazado proposiciones sexuales?",0));
        preguntasArrayList.add(new Preguntas("¿Alguna persona te ha tocado o rozado partes íntimas de tu cuerpo sin tu consentimiento?",0));
        preguntasArrayList.add(new Preguntas("¿Has recibido acercamientos, abrazos o besos no deseados?",0));
        final ListIterator<Preguntas> listIterator = preguntasArrayList.listIterator();
        txv_consulta.setText(listIterator.next().getTexto());
        btn_si = (Button)findViewById(R.id.btn_si);
        btn_no = (Button) findViewById(R.id.btn_no);
        semaforo = (GifImageView)findViewById(R.id.semaforo);
        si = 0;
        no = 0;
        btn_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (index < preguntasArrayList.size()){
                    txv_consulta.setText(preguntasArrayList.get(index).getTexto());
                    si = si+1;
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

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (index < preguntasArrayList.size()){
                    txv_consulta.setText(preguntasArrayList.get(index).getTexto());
                    no = no+1;
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
        btn_si.setVisibility(View.INVISIBLE);
        btn_no.setVisibility(View.INVISIBLE);
    }

    private void check_respuestas(){
        Integer c = 0;
        if (si >= 3 && no >= 0){
            if (c == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("test", "acoso");
                bundle.putString("respuesta", "amarillo");
                startActivity(new Intent(AcosoSexualActivity.this, RespuestaActivity.class).putExtras(bundle));
                c = c + 1;
            }
        }

        if (si <= 1 || no > 0){
            if (c == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("test", "acoso");
                bundle.putString("respuesta", "verde");
                startActivity(new Intent(AcosoSexualActivity.this, RespuestaActivity.class).putExtras(bundle));
                c = c + 1;
            }
        }
    }
}
