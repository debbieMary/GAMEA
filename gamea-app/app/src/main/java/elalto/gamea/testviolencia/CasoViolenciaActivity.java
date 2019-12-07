package elalto.gamea.testviolencia;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import elalto.gamea.R;

public class CasoViolenciaActivity extends AppCompatActivity {
    ImageView img_0,img_1,img_2,img_3,img_4,img_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso_violencia);
        init();
    }
    private void init() {
        img_0 = (ImageView)findViewById(R.id.img_0);
        img_1 = (ImageView)findViewById(R.id.img_1);
        img_2 = (ImageView)findViewById(R.id.img_2);
        img_3 = (ImageView)findViewById(R.id.img_3);
        img_4 = (ImageView)findViewById(R.id.img_4);
        img_5 = (ImageView)findViewById(R.id.img_5);
        img_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("¿Quíenes deben prevenir la violencia?","Estado central, gobernacion, municipio, funcionarios publicos, policia, unidades educativas, universidades, centros infantiles, centros de salud, vecinos y comunidad en general");
            }
        });
        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Si la niña, niño o adolecente presenta:","Violencia fisica, Psicologica y Sexula(Aislamiento, agresivilidad, bajo rendimiento escolar, baja autoestima, cambio de comportimiento y/o signos fisicos de violencia moretones heridas).");
            }
        });
        img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("¿Donde?","Defensorias de la niñes y adolecenci. SLIM(Servicio legales integrales). Modulo Policial. Fiscalia(Ministerio Publico). FELCV(Fuerzas Especiales de Lucha Contra la Violencia). SIJPLU(Servicio Integral de Justicia Plurinacional).");
            }
        });
        img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("La Defensoria de la niñes y adolecencia tiene la responsabilidad de:","Velar por la integridad fisica, emocional y Psicologica niña, niño y adolecente mediante. 1.Registro del caso 2.evaluacion psicologica 3.evaluacion social 4. Asesoramiento legal.");
            }
        });

        img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Denuncia","Se denuncia como delito a la FELCC o Ministerio Publico. Se aplican medidas de Proteccion ante un  Jusgado de la Niñes y Adolecencia.hasta llegar a una sentencia");
            }
        });
        img_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Cumpliendo","Cumplimiento de los derechos de las niñas, niños y adolecentes.");
            }
        });
    }

    public void ShowDialog(String titulo, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(titulo);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
