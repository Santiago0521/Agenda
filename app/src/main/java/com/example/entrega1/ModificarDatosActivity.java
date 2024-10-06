package com.example.entrega1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ModificarDatosActivity extends AppCompatActivity {

    private EditText etCodigoDocumento, etNombre, etApellido, etEdad, etEmail, etTelefono, etNacimiento;
    private RadioGroup rgGenero, rgEstadoCivil;
    private Button btnBuscar, btnActualizar;
    private Usuario usuarioEncontrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_datos);

        // Inicialización de vistas
        etCodigoDocumento = findViewById(R.id.etCodigoDocumento);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEdad = findViewById(R.id.etEdad);
        etEmail = findViewById(R.id.etEmail);
        etTelefono = findViewById(R.id.etTelefono);
        etNacimiento = findViewById(R.id.etNacimiento);
        rgGenero = findViewById(R.id.rgGenero);
        rgEstadoCivil = findViewById(R.id.rgEstadoCivil);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnActualizar = findViewById(R.id.btnActualizar);

        // Botón para buscar al usuario por código o documento
        btnBuscar.setOnClickListener(v -> {
            String codigoDocumento = etCodigoDocumento.getText().toString();
            if (!codigoDocumento.isEmpty()) {
                usuarioEncontrado = buscarUsuarioPorCodigoDocumento(codigoDocumento);

                if (usuarioEncontrado != null) {
                    // Mostrar los datos del usuario en los campos
                    etNombre.setText(usuarioEncontrado.getNombre());
                    etApellido.setText(usuarioEncontrado.getApellido());
                    etEdad.setText(usuarioEncontrado.getEdad());
                    etEmail.setText(usuarioEncontrado.getEmail());
                    etTelefono.setText(usuarioEncontrado.getTelefono());
                    etNacimiento.setText(usuarioEncontrado.getNacimiento());

                    if (usuarioEncontrado.getGenero().equals("Femenino")) {
                        rgGenero.check(R.id.rbFemenino);
                    } else {
                        rgGenero.check(R.id.rbMasculino);
                    }

                    if (usuarioEncontrado.getEstadoCivil().equals("Soltero")) {
                        rgEstadoCivil.check(R.id.rbSoltero);
                    } else {
                        rgEstadoCivil.check(R.id.rbCasado);
                    }

                    Toast.makeText(ModificarDatosActivity.this, "Usuario encontrado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ModificarDatosActivity.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(ModificarDatosActivity.this, "Por favor ingresa un código o documento", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón para actualizar los datos
        btnActualizar.setOnClickListener(v -> {
            if (usuarioEncontrado != null) {
                if (validarCampos()) {
                    // Actualizar los datos del usuario
                    usuarioEncontrado.setNombre(etNombre.getText().toString());
                    usuarioEncontrado.setApellido(etApellido.getText().toString());
                    usuarioEncontrado.setEdad(etEdad.getText().toString());
                    usuarioEncontrado.setEmail(etEmail.getText().toString());
                    usuarioEncontrado.setTelefono(etTelefono.getText().toString());
                    usuarioEncontrado.setNacimiento(etNacimiento.getText().toString());

                    int selectedGenero = rgGenero.getCheckedRadioButtonId();
                    RadioButton rbGenero = findViewById(selectedGenero);
                    usuarioEncontrado.setGenero(rbGenero.getText().toString());

                    int selectedEstadoCivil = rgEstadoCivil.getCheckedRadioButtonId();
                    RadioButton rbEstadoCivil = findViewById(selectedEstadoCivil);
                    usuarioEncontrado.setEstadoCivil(rbEstadoCivil.getText().toString());

                    // Guardar los datos actualizados en un archivo
                    guardarDatosActualizados(usuarioEncontrado);

                    Toast.makeText(ModificarDatosActivity.this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();

                    // Regresar a la pantalla principal
                    Intent intent = new Intent(ModificarDatosActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ModificarDatosActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(ModificarDatosActivity.this, "No se pudo actualizar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para buscar un usuario por código o documento
    private Usuario buscarUsuarioPorCodigoDocumento(String codigoDocumento) {
        ArrayList<Usuario> listaUsuarios = ContinuarDatosActivity.getListaUsuarios();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCodigo().equals(codigoDocumento) || usuario.getDocumento().equals(codigoDocumento)) {
                return usuario;
            }
        }
        return null;
    }

    // Validar que todos los campos estén llenos
    private boolean validarCampos() {
        return !etNombre.getText().toString().isEmpty() &&
                !etApellido.getText().toString().isEmpty() &&
                !etEdad.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty() &&
                !etTelefono.getText().toString().isEmpty() &&
                !etNacimiento.getText().toString().isEmpty();
    }

    // Método para guardar los datos actualizados en un archivo
    private void guardarDatosActualizados(Usuario usuario) {
        try {
            String nombreArchivo = "datos_" + usuario.getCodigo() + ".txt";
            BufferedWriter archivo = new BufferedWriter(new OutputStreamWriter(openFileOutput(nombreArchivo, MODE_PRIVATE)));

            // Guardar los datos en el archivo separados por comas
            archivo.write(usuario.getNombre() + "," + usuario.getApellido() + "," + usuario.getDocumento() + "," +
                    usuario.getEdad() + "," + usuario.getEmail() + "," + usuario.getTelefono() + "," +
                    usuario.getNacimiento() + "," + usuario.getGenero() + "," + usuario.getEstadoCivil());

            archivo.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error al guardar los datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
