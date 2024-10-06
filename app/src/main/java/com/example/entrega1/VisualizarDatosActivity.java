package com.example.entrega1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VisualizarDatosActivity extends AppCompatActivity {

    private EditText etCodigo; // Para ingresar el código
    private Button btnVisualizar; // Botón para visualizar los datos
    private LinearLayout linearLayout; // Para mostrar los datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_datos);

        // Inicializar vistas
        etCodigo = findViewById(R.id.etCodigo);
        btnVisualizar = findViewById(R.id.btnVisualizar);
        linearLayout = findViewById(R.id.linearLayout);

        // Acción del botón Visualizar
        btnVisualizar.setOnClickListener(v -> {
            String codigo = etCodigo.getText().toString();
            if (!codigo.isEmpty()) {
                // Llamar al método para cargar y mostrar los datos
                mostrarDatos(codigo);
            } else {
                Toast.makeText(VisualizarDatosActivity.this, "Por favor ingresa un código", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para mostrar los datos del archivo
    private void mostrarDatos(String codigo) {
        try {
            String nombreArchivo = "datos_" + codigo + ".txt";
            BufferedReader archivo = new BufferedReader(new InputStreamReader(openFileInput(nombreArchivo)));
            String linea = archivo.readLine();
            archivo.close();

            if (linea != null) {
                // Limpiar cualquier dato anterior
                linearLayout.removeAllViews();

                // Separar los datos por comas
                String[] datos = linea.split(",");

                // Crear y mostrar TextViews para cada dato
                TextView tvNombre = new TextView(this);
                tvNombre.setText("Nombre: " + datos[0]);
                TextView tvApellido = new TextView(this);
                tvApellido.setText("Apellido: " + datos[1]);
                TextView tvDocumento = new TextView(this);
                tvDocumento.setText("Documento: " + datos[2]);
                TextView tvEdad = new TextView(this);
                tvEdad.setText("Edad: " + datos[3]);
                TextView tvEmail = new TextView(this);
                tvEmail.setText("Email: " + datos[4]);
                TextView tvTelefono = new TextView(this);
                tvTelefono.setText("Teléfono: " + datos[5]);
                TextView tvNacimiento = new TextView(this);
                tvNacimiento.setText("Fecha de Nacimiento: " + datos[6]);

                // Añadir TextViews al LinearLayout
                linearLayout.addView(tvNombre);
                linearLayout.addView(tvApellido);
                linearLayout.addView(tvDocumento);
                linearLayout.addView(tvEdad);
                linearLayout.addView(tvEmail);
                linearLayout.addView(tvTelefono);
                linearLayout.addView(tvNacimiento);
            } else {
                Toast.makeText(this, "No se encontraron datos para este código", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al cargar los datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
