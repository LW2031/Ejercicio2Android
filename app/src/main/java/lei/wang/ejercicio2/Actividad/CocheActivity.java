package lei.wang.ejercicio2.Actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lei.wang.ejercicio2.Modelo.Coche;
import lei.wang.ejercicio2.R;

public class CocheActivity extends AppCompatActivity {

    private EditText txtMarca, txtModelo, txtColor;
    private Button btnCancelar, btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);

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
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty()){
                    Toast.makeText(CocheActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else {
                    Coche coche = new Coche(marca,modelo,color);

                    //Enviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Coches",coche);

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
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);

        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnCrear = findViewById(R.id.btnCrearCoche);
    }
}