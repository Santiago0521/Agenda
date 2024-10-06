package com.example.entrega1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContinuarDatosActivity extends AppCompatActivity {

    private CheckBox cbMusica, cbDeporte, cbCine, cbVideojuegos, cbComida, cbViajes, cbLibros;
    private Spinner spnEquipoFavorito;
    private EditText etPeliculaFavorita, etColorFavorito, etComidaFavorita, etLibroFavorito, etCancionFavorita, etDescripcion;
    private Button btnGuardar;
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuar_datos);

        // Inicializar vistas
        cbMusica = findViewById(R.id.cbMusica);
        cbDeporte = findViewById(R.id.cbDeporte);
        cbCine = findViewById(R.id.cbCine);
        cbVideojuegos = findViewById(R.id.cbVideojuegos);
        cbComida = findViewById(R.id.cbComida);
        cbViajes = findViewById(R.id.cbViajes);
        cbLibros = findViewById(R.id.cbLibros);
        spnEquipoFavorito = findViewById(R.id.spnEquipoFavorito);
        etPeliculaFavorita = findViewById(R.id.etPeliculaFavorita);
        etColorFavorito = findViewById(R.id.etColorFavorito);
        etComidaFavorita = findViewById(R.id.etComidaFavorita);
        etLibroFavorito = findViewById(R.id.etLibroFavorito);
        etCancionFavorita = findViewById(R.id.etCancionFavorita);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Recuperar datos de la primera pantalla
        Intent intent = getIntent();
        codigo = intent.getStringExtra("codigo");
        cargarDatos();

        btnGuardar.setOnClickListener(v -> {
            if (etPeliculaFavorita.getText().toString().isEmpty() ||
                    etColorFavorito.getText().toString().isEmpty() ||
                    etComidaFavorita.getText().toString().isEmpty() ||
                    etLibroFavorito.getText().toString().isEmpty() ||
                    etCancionFavorita.getText().toString().isEmpty() ||
                    etDescripcion.getText().toString().isEmpty() ||
                    spnEquipoFavorito.getSelectedItem() == null ||
                    !(cbMusica.isChecked() || cbDeporte.isChecked() || cbCine.isChecked() ||
                            cbVideojuegos.isChecked() || cbComida.isChecked() || cbViajes.isChecked() || cbLibros.isChecked())) {

                // Mostrar mensaje de error
                Toast.makeText(ContinuarDatosActivity.this, "Por favor llena todos los campos y selecciona al menos un gusto", Toast.LENGTH_SHORT).show();
            } else {
                // Guardar en la lista
                ArrayList<String> gustos = new ArrayList<>();
                if (cbMusica.isChecked()) gustos.add("Música");
                if (cbDeporte.isChecked()) gustos.add("Deporte");
                if (cbCine.isChecked()) gustos.add("Cine");
                if (cbVideojuegos.isChecked()) gustos.add("Videojuegos");
                if (cbComida.isChecked()) gustos.add("Comida");
                if (cbViajes.isChecked()) gustos.add("Viajes");
                if (cbLibros.isChecked()) gustos.add("Libros");

                Usuario usuario = new Usuario(codigo, "", "", "", "", "", "", "", "", "", gustos, spnEquipoFavorito.getSelectedItem().toString(),
                        etPeliculaFavorita.getText().toString(), etColorFavorito.getText().toString(),
                        etComidaFavorita.getText().toString(), etLibroFavorito.getText().toString(),
                        etCancionFavorita.getText().toString(), etDescripcion.getText().toString());
                listaUsuarios.add(usuario);

                Toast.makeText(ContinuarDatosActivity.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();

                Intent intent1 = new Intent(ContinuarDatosActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    // Cargar datos desde el archivo
    private void cargarDatos() {
        try {
            String nombreArchivo = "datos_" + codigo + ".txt";
            BufferedReader archivo = new BufferedReader(new InputStreamReader(openFileInput(nombreArchivo)));
            String linea = archivo.readLine();
            archivo.close();

            if (linea != null) {
                String[] datos = linea.split(",");
                // Aquí puedes usar los datos según tu necesidad
                Toast.makeText(this, "Datos cargados: " + datos[0], Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
        }
    }

    // Método estático para obtener la lista de usuarios
    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    // Actualizar un usuario en la lista
    public static void actualizarUsuarioEnLista(Usuario usuarioActualizado) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if (usuario.getCodigo().equals(usuarioActualizado.getCodigo())) {
                listaUsuarios.set(i, usuarioActualizado);
                break;
            }
        }
    }
}
