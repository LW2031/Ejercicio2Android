package lei.wang.ejercicio2.Actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lei.wang.ejercicio2.Modelo.Moto;
import lei.wang.ejercicio2.R;

public class MotoActivity extends AppCompatActivity {

    private EditText txtMarca,txtModelo,txtCilindrado;
    private Button btnCrear, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);

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
                String cilindrado = txtCilindrado.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || cilindrado.isEmpty()){
                    Toast.makeText(MotoActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else {
                    Moto moto = new Moto(marca,modelo,cilindrado);

                    //Enviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Motos",moto);

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
        txtModelo = findViewById(R.id.txtModeloMoto);
        txtCilindrado = findViewById(R.id.txtCilindradoMoto);

        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrear = findViewById(R.id.btnCrearMoto);
    }
}