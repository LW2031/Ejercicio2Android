package lei.wang.ejercicio2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import lei.wang.ejercicio2.Actividad.BiciActivity;
import lei.wang.ejercicio2.Actividad.CocheActivity;
import lei.wang.ejercicio2.Actividad.MotoActivity;
import lei.wang.ejercicio2.Modelo.Bici;
import lei.wang.ejercicio2.Modelo.Coche;
import lei.wang.ejercicio2.Modelo.Moto;

public class MainActivity extends AppCompatActivity {
    private Button btnCrearCoche, btnCrearMoto, btnCrearBici;
    private TextView lbCantidadCoche, lbCantidadMoto, lbCantidadBici;

    //Atributos para los launchers (Obtener Informacion)
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;
    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBici;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariable();


        btnCrearBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherBicis.launch(new Intent(MainActivity.this, BiciActivity.class));
            }
        });
        btnCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherMotos.launch(new Intent(MainActivity.this, MotoActivity.class));
            }
        });

        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCoches.launch(new Intent(MainActivity.this,CocheActivity.class));
            }
        });


        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Coche coche =(Coche) result.getData().getExtras().getSerializable("Coches");
                                if (coche != null){
                                    listaCoches.add(coche);
                                    lbCantidadCoche.setText("Coches: "+listaCoches.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "No hay coche", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Actividad cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


        );

        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Moto moto =(Moto) result.getData().getExtras().getSerializable("Motos");
                                if (moto != null){
                                    listaMotos.add(moto);
                                    lbCantidadMoto.setText("Moto: "+listaBici.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "No hay motos", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Actividad cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        launcherBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Bici bici =(Bici) result.getData().getExtras().getSerializable("Bicis");
                                if (bici != null){
                                    listaBici.add(bici);
                                    lbCantidadBici.setText("Bicis: "+listaMotos.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "No hay bicis", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Actividad cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


    }





    private void inicializarVariable() {
        //Inicializar Vista
        lbCantidadCoche = findViewById(R.id.lbCocheMain);
        lbCantidadMoto = findViewById(R.id.lbMotoMain);
        lbCantidadBici = findViewById(R.id.lbBiciMain);

        btnCrearCoche = findViewById(R.id.btnCrearCocheMain);
        btnCrearMoto = findViewById(R.id.btnCrearMotoMain);
        btnCrearBici = findViewById(R.id.btnCrearBiciMain);

        //Inicializar Lógica
        listaBici = new ArrayList<>();
        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
    }
}