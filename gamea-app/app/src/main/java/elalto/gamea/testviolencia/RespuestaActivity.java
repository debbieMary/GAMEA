package elalto.gamea.testviolencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import elalto.gamea.R;

public class RespuestaActivity extends AppCompatActivity {
    CarouselView carouselView;
    TextView txv_titulo, txv_contenido;
    int [] images = {R.drawable.uno,R.drawable.dos, R.drawable.tres,R.drawable.cuatro};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        carouselView = (CarouselView)findViewById(R.id.carousel);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(imageListener);
        txv_titulo = (TextView)findViewById(R.id.txv_titulo);
        txv_contenido = (TextView)findViewById(R.id.txv_contenido);
        final Bundle bundle = getIntent().getExtras();

        if (bundle.get("test").toString().equals("bullying")){
            switch (bundle.get("respuesta").toString()) {
                case "verde":
                    txv_titulo.setText("!!FELICIDADES!!\nNO SUFRES DE BULLYING");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.verde));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("La relacion con tus compañeros (as) del colegio es de respeto compañerismo y solidaridad.\nSin embargo, no bajes la guardia, debes estar atento (a) a cualquier situacion que te haga sentir incomodo (a) o atente contra tu integridad personal o la de algún compañero o compañera. \nRecuerda que la escuela debe ser un lugar seguro para todos y todas asi que si sabes de algun caso de bullying, se el primero o la primera en brindar ayuda a la victima y denunciar el hecho.\nPuedes ayudar a alguien que vive bullying compartiendo la aplicacion\n ¡¡Nada justifica la violencia!! ");
                    break;
                case "amarillo":
                    txv_titulo.setText("!!ALERTA!! PUEDES SER\nVICTIMA BULLYING");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.amarillo));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("Si no te sientes seguro ni a gusto en el colegio, es hora de hablar sobre ello. Busca a alguien de confianza y cuéntale lo que estás viviendo y como te sienntes, juntos busquen al Director (a) del colegio o algun docente de confianza para contarle la situación, ellos estan en la obligacion de ponerle solución al problema. Tambien puedes recurrir a tus padres hermanos o algun familiar de confianza para que se enteren de lo que estas viviendo.\nRecuerda que no estas  solo o sola, que siempre hay una salida, quue mereces tener una vida tranquila y feliz y por ello debes seguir luchando.\nNo te quedes callado (a), porque la situacion puede empeorar.\n Los conflictos se pueden resolver, sin hacer uso de la violencia. !Todas y todos tenemos derecho a vivir felices y sentirnos seguros en la escuela!");
                    break;
                case "rojo":
                    txv_titulo.setText("!!PELIGRO!!\nSUFRES DE BULLYING");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.rojo));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("No te asustes!!! No eres culpable de ser agredido (a) en el colegio. Tú no eres el problema. Tú puedes ser diferente, todos tenemos derecho a ser distintos, a tener una forma de ser propia, nadie puede imponerte una forma de ser.\n No eres inferior, ni cobarde, por no responder a las agreciones. Pero tienes que ser valiente para enfrentarte de una vez a la situacion. Es hora de actuar!!\nConversa sobre lo que te esta pasando con alguien de tu familia, con algun maestro o maestra o con cualquier persona a quien le tengas confianza. Si no quieres hablar a solas del tema pidele a un amigo(a) o hermano(a) que te acompañe. Si sientes que no puedes hablar escribe una carta o un mensaje y envialo a alguien de confianza.\n Recuerda que no estas solo o sola, que siempre hay una salida, que mereces tener una vida tranquila y feliz y por ello deves luchar!!!\n ¡NO DEJES QUE GANEN, PORQUE DE ESA FORMA, TODOS PERDEMOS!!!");
                    break;
                default:
                    break;
            }
        }

        if (bundle.get("test").toString().equals("relacion_violenta")){
            switch (bundle.get("respuesta").toString()) {
                case "verde":
                    txv_titulo.setText("!!FELICIDADES!! ESTAS EN\nUNA RELACIÓN SALUDABLE");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.verde));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("En la que existe respeto, igualdad, apoyo mutuo y confianza. Sin embargo, siempre dedebes estar atento/a ante cualquier señal que no te haga sentir a gusto con tu pareja y te cause angustia.");
                    break;
                case "amarillo":
                    txv_titulo.setText("!!ALERTA!! PUEDES SER\nVICTIMA DE VIOLENCIA");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.amarillo));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("Toma en cuenta que puedes estar viviendo el inicio de una situacion de violencia que NO VA A MEJORAR SI NO BUSCAN AYUDA!!! Conversen en pareja sobre los problemas que tienen (empujones, pellizcos, insultos y gritos) que pueden dañar la relacion.\nSi ves que pese a ello, vuelve a ocurrir, te sugerimos dejar esa relacion porque puedes quedar lastimada o lastimado");
                    break;
                case "rojo":
                    txv_titulo.setText("!!PELIGRO!! ESTAS VIVIENDO\nUNA SITUACION VIOLENTA");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.rojo));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("Muchas de las situaciones consultadas, aparentemente no son muy graves y nos parecen normales. Sin embargo, son formas de violencia que afectan nuestas vidas y no permiten que seamos felices en nuestra relación. Muchos casos de feminicidio se iniciaron con este tipo de situaciones. No te sustes, no te sientas mal, no estas sola o solo, pero debes actuar cuanto antes.\nBusca apoyo, habla con alguna persona de confianza que te escuche y respete, cuéntale lo que te esta pasando y juntos busquen ayuda para salir de esta situación.");
                    break;
                default:
                    break;
            }
        }

        if (bundle.get("test").toString().equals("acoso")){
            switch (bundle.get("respuesta").toString()) {
                case "verde":
                    txv_titulo.setText("!!FELICIDADES!!\nNO SUFRES DE ACOSO SEXUAL");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.verde));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("Sin embargo, debes estar siempre atento(a) ante cualquier situación de connotacion sexual que te incomode.\n CONFÍA SIEMPRE EN TU INTUICÍON!!\nsi algo te hace sentir incomodo(a) infórmate y pide apoyo.\n Si ves que alguien esta siendo acosado (a) ayuda, interviene, no dejes que el acosador quede impune, pues...\nTODOS Y TODAS TENEMOS DERECHO A UNA VIDA LIBRE DE VIOLENCIA SEXUAL.");
                    break;
                case "amarillo":
                    txv_titulo.setText("ESTAS VIVIENDO\n ACOSO SEXUAL LEVE");
                    txv_titulo.setBackgroundColor(getResources().getColor(R.color.amarillo));
                    txv_contenido.setTextColor(getResources().getColor(R.color.vpi__background_holo_dark));
                    txv_contenido.setText("Muchas veces pensamos que la violencia sexual se refiere únicamente a la violación y que una mirada morbosa, un gesto insinuante o un piropo son situaciones normales.\n Pero NO lo son... atentan con nuestra dignidad y no nos permiten disfrutar de nuestras actividades  con libertad plena\n POR ELLO DEBEMOS PONERLE UN ALTO!!!\n Algunos consejos utiles: \n* No te sientas culpable, camina con la cabeza en alto, habla fuerte y claro, demuestra seguridad.\n*Confronta visualmente al acosador, esto hará que baje la cabeza y no te moleste mas.\n*Pide ayuda de inmediato, grita si es posible.");
                    break;
                default:
                    break;
            }
        }
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };
}
