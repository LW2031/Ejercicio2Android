package lei.wang.ejercicio2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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