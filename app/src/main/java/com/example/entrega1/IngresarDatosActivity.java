package com.example.entrega1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class IngresarDatosActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etDocumento, etEdad, etEmail, etTelefono, etNacimiento;
    private RadioGroup rgGenero, rgEstadoCivil;
    private Button btnSiguiente;
    private String codigoDocumento;  // Usaremos este como código único

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_datos);

        // Inicialización de vistas
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etDocumento = findViewById(R.id.etDocumento);
        etEdad = findViewById(R.id.etEdad);
        etEmail = findViewById(R.id.etEmail);
        etTelefono = findViewById(R.id.etTelefono);
        etNacimiento = findViewById(R.id.etNacimiento);
        rgGenero = findViewById(R.id.rgGenero);
        rgEstadoCivil = findViewById(R.id.rgEstadoCivil);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        // Botón siguiente para continuar con más datos
        btnSiguiente.setOnClickListener(v -> {
            if (etNombre.getText().toString().isEmpty() ||
                    etApellido.getText().toString().isEmpty() ||
                    etDocumento.getText().toString().isEmpty() ||
                    etEdad.getText().toString().isEmpty() ||
                    etEmail.getText().toString().isEmpty() ||
                    etTelefono.getText().toString().isEmpty() ||
                    etNacimiento.getText().toString().isEmpty() ||
                    rgGenero.getCheckedRadioButtonId() == -1 ||
                    rgEstadoCivil.getCheckedRadioButtonId() == -1) {

                // Mostrar mensaje de error
                Toast.makeText(IngresarDatosActivity.this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Usar el número de documento como el código único
                codigoDocumento = etDocumento.getText().toString();

                // Guardar datos en un archivo
                guardarDatos();

                // Continuar si todos los campos están completos
                Intent intent = new Intent(IngresarDatosActivity.this, ContinuarDatosActivity.class);
                intent.putExtra("nombre", etNombre.getText().toString());
                intent.putExtra("apellido", etApellido.getText().toString());
                intent.putExtra("documento", etDocumento.getText().toString());
                intent.putExtra("edad", etEdad.getText().toString());
                intent.putExtra("email", etEmail.getText().toString());
                intent.putExtra("telefono", etTelefono.getText().toString());
                intent.putExtra("nacimiento", etNacimiento.getText().toString());
                intent.putExtra("codigo", codigoDocumento);  // Usamos el documento como código único

                int selectedGenero = rgGenero.getCheckedRadioButtonId();
                int selectedEstadoCivil = rgEstadoCivil.getCheckedRadioButtonId();
                RadioButton rbGenero = findViewById(selectedGenero);
                RadioButton rbEstadoCivil = findViewById(selectedEstadoCivil);

                intent.putExtra("genero", rbGenero.getText().toString());
                intent.putExtra("estado_civil", rbEstadoCivil.getText().toString());

                startActivity(intent);
            }
        });
    }

    // Método para guardar los datos en un archivo
    public void guardarDatos() {
        String nombreArchivo = "datos_" + codigoDocumento + ".txt";  // Archivo nombrado con el documento
        String contenido = etNombre.getText().toString() + "," +
                etApellido.getText().toString() + "," +
                etDocumento.getText().toString() + "," +
                etEdad.getText().toString() + "," +
                etEmail.getText().toString() + "," +
                etTelefono.getText().toString() + "," +
                etNacimiento.getText().toString();

        // Guardamos los datos en un bloque try-catch
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombreArchivo, Context.MODE_PRIVATE));
            archivo.write(contenido);
            archivo.flush();
            archivo.close();

            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {  // Capturamos IOException
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_LONG).show();
        }
    }
}
