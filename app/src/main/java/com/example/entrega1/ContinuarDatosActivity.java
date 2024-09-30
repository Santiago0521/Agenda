package com.example.entrega1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ContinuarDatosActivity extends AppCompatActivity {

    private CheckBox cbMusica, cbDeporte, cbCine, cbVideojuegos, cbComida, cbViajes, cbLibros;
    private Spinner spnEquipoFavorito;
    private EditText etPeliculaFavorita, etColorFavorito, etComidaFavorita, etLibroFavorito, etCancionFavorita, etDescripcion;
    private Button btnGuardar;

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

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
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String documento = intent.getStringExtra("documento");
        String edad = intent.getStringExtra("edad");
        String email = intent.getStringExtra("email");
        String telefono = intent.getStringExtra("telefono");
        String nacimiento = intent.getStringExtra("nacimiento");
        String genero = intent.getStringExtra("genero");
        String estadoCivil = intent.getStringExtra("estado_civil");
        String codigo = intent.getStringExtra("codigo");

        // Botón guardar que almacena todos los datos en un ArrayList
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si los campos están vacíos o si no hay gustos seleccionados
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
                    // Recopilar los gustos seleccionados
                    ArrayList<String> gustos = new ArrayList<>();
                    if (cbMusica.isChecked()) gustos.add("Música");
                    if (cbDeporte.isChecked()) gustos.add("Deporte");
                    if (cbCine.isChecked()) gustos.add("Cine");
                    if (cbVideojuegos.isChecked()) gustos.add("Videojuegos");
                    if (cbComida.isChecked()) gustos.add("Comida");
                    if (cbViajes.isChecked()) gustos.add("Viajes");
                    if (cbLibros.isChecked()) gustos.add("Libros");

                    // Obtener datos adicionales
                    String equipoFavorito = spnEquipoFavorito.getSelectedItem().toString();
                    String peliculaFavorita = etPeliculaFavorita.getText().toString();
                    String colorFavorito = etColorFavorito.getText().toString();
                    String comidaFavorita = etComidaFavorita.getText().toString();
                    String libroFavorito = etLibroFavorito.getText().toString();
                    String cancionFavorita = etCancionFavorita.getText().toString();
                    String descripcion = etDescripcion.getText().toString();

                    // Crear el objeto usuario y añadirlo a la lista
                    Usuario usuario = new Usuario(codigo, nombre, apellido, documento, edad, email, telefono, nacimiento, genero, estadoCivil, gustos, equipoFavorito, peliculaFavorita, colorFavorito, comidaFavorita, libroFavorito, cancionFavorita, descripcion);
                    listaUsuarios.add(usuario);

                    // Mensaje de confirmación
                    Toast.makeText(ContinuarDatosActivity.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();

                    // Regresar a la pantalla principal
                    Intent intent = new Intent(ContinuarDatosActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Método para devolver la lista de usuarios
    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
