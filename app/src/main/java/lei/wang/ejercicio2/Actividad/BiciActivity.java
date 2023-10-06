package lei.wang.ejercicio2.Actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lei.wang.ejercicio2.Modelo.Bici;
import lei.wang.ejercicio2.Modelo.Moto;
import lei.wang.ejercicio2.R;

public class BiciActivity extends AppCompatActivity {

    private EditText txtMarca,txtPulgada;
    private Button btnCrear, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bici);

        inicializarVista();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sacar la informacion del a vista para crear un coche
                String marca = txtMarca.getText().toString();
                String pulgado = txtPulgada.getText().toString();

                if (marca.isEmpty() || pulgado.isEmpty()){
                    Toast.makeText(BiciActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else {
                    Bici bici = new Bici(marca,pulgado);

                    //Enviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Bicis",bici);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);

                    //Devolver un resultado OK
                    setResult(RESULT_OK,intent);

                    //terminar
                    finish();
                }

            }
        });

    }

    private void inicializarVista() {
        txtMarca = findViewById(R.id.txtMarcaBici);
        txtPulgada = findViewById(R.id.txtPulgadodoBici);

        btnCancelar = findViewById(R.id.btnCancelarBici);
        btnCrear = findViewById(R.id.btnCrearBici);
    }
}