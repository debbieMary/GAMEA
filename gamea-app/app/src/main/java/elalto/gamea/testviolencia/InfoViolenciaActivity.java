package elalto.gamea.testviolencia;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import elalto.gamea.R;

public class InfoViolenciaActivity extends AppCompatActivity {
    ImageView img_violencia, img_psicologica, img_sexual, img_digital, img_mujer, img_educativo;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_violencia);
        init();
    }
    private void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        img_violencia = (ImageView)findViewById(R.id.img_violencia);
        img_violencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Violencia Física","Cuando una persona realiza daño intencionado en el cuerpo de otra persona. Por ejemplo: \ngolpes, patadas, empujones, pellizcos, jalar el cabello, etc.");
            }
        });
        img_psicologica = (ImageView)findViewById(R.id.img_psicologica);
        img_psicologica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Violencia Psicológica","Son todos aquellos actos y expresiones que ofenden, humillan, asustan, amenazan o atentan contra la autoestima de la persona. Por ejemplo: insultos, apodos ofensivos, bromas y rumores malintencionados, chistes ofensivos, burlas, etc.");
            }
        });
        img_sexual = (ImageView)findViewById(R.id.img_sexual);
        img_sexual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Violencia Sexual","Es toda acción que involucre a una niña o niño en una actividad de naturaleza sexual o erotizada, que por su edad y desarrollo no puede comprender totalmente y que no está preparado/a para realizar o no puede consentir libremente. En el abuso sexual infantil, el adulto puede utilizar estrategias como la seducción, el chantaje, la amenaza, la manipulación psicológica y/o el uso de fuerza física para involucrar a un niño o una niña en actividades sexuales o erotizadas de cualquier índole. En todos estos actos podemos reconocer que existe asimetría de poder y opera la coerción.(UNICEF, 2006)");
            }
        });
        img_digital = (ImageView)findViewById(R.id.img_digital);
        img_digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Violencia Digital","Se produce cuando una persona provoca o realiza daño a otras utilizando las Tecnologías de Información y Comunicación TIC ́s (redes sociales, correos electrónicos, mensajes de texto, teléfonos móviles, etc.) Las formas más comunes son:\n- Ciberbulling: utilizar las TIC ́s para difamar y acosar a una persona.\n- Ciberpornografía: difusión de medios y materiales pornográficos a través de TICs.\n- Trata: es la captación por medio de las redes sociales de personas para formas de explotación sexual.\n- Sextorsión: Chantaje en el que se utilizan imágenes o fotografías de la intimidad sexual para obtener algo de la víctima, amenazándola con sus publicación.");
            }
        });
        img_mujer = (ImageView)findViewById(R.id.img_mujer);
        img_mujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Violencia Contra la Mujer","Constituye cualquier acción u omisión, abierta o encubierta, que cause la muerte, sufrimiento o daño físico, sexual o psicológico a una mujer u otra persona, le genere perjuicio en su patrimonio, en su economía, en su fuente laboral o en otro ámbito cualquiera, por el sólo hecho de ser mujer.(Ley 348)");
            }
        });
        img_educativo = (ImageView)findViewById(R.id.img_educativo);
        img_educativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog("Violencia en el ámbito educativo","Es cualquier tipo de agresión,  maltrato y/o ejercicio de poder que se presenta en centros o unidades educativas. Puede ser:\n- Violencia entre Pares: Las agresiones se producen entre estudiantes.\n- Violencia entre No Pares: las agresiones se producen por parte de maestras, maestros,  madres, padres, personal administrativo, de servicio y profesionales que prestan servicio dentro de una unidad educativa, contra las o los estudiantes (Código NNA 548).");
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
