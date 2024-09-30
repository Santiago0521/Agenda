package com.example.entrega1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar, btnVisualizar, btnModificar, btnCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de botones
        btnIngresar = findViewById(R.id.btnIngresar);
        btnVisualizar = findViewById(R.id.btnVisualizar);
        btnModificar = findViewById(R.id.btnModificar);
        btnCalculadora = findViewById(R.id.btnCalculadora);

        // Navegar a la pantalla de ingreso de datos
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IngresarDatosActivity.class);
                startActivity(intent);
            }
        });

        // Navegar a la pantalla de visualización de datos
        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VisualizarDatosActivity.class);
                startActivity(intent);
            }
        });

        // Navegar a la pantalla de modificación de datos
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ModificarDatosActivity.class);
                startActivity(intent);
            }
        });

        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostrarCalculadora.class);
                startActivity(intent);
            }
        });
    }
}
