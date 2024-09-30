package com.example.entrega1;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class VisualizarDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_datos);

        ScrollView scrollView = findViewById(R.id.scrollView);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        ArrayList<Usuario> listaUsuarios = ContinuarDatosActivity.getListaUsuarios();


        for (Usuario usuario : listaUsuarios) {
            TextView tvUsuario = new TextView(this);
            tvUsuario.setText(usuario.toString());

            // Crear un TextView para cada atributo del usuario
            TextView tvCodigo = new TextView(this);
            tvCodigo.setText("Código: " + usuario.getCodigo());
            TextView tvDocumento = new TextView(this);
            tvDocumento.setText("Documento: " + usuario.getDocumento());
            TextView tvNombre = new TextView(this);
            tvNombre.setText("Nombre: " + usuario.getNombre());

            TextView tvApellido = new TextView(this);
            tvApellido.setText("Apellido: " + usuario.getApellido());

            TextView tvEdad = new TextView(this);
            tvEdad.setText("Edad: " + usuario.getEdad());

            TextView tvEmail = new TextView(this);
            tvEmail.setText("Email: " + usuario.getEmail());

            TextView tvTelefono = new TextView(this);
            tvTelefono.setText("Teléfono: " + usuario.getTelefono());

            TextView tvNacimiento = new TextView(this);
            tvNacimiento.setText("Fecha de Nacimiento: " + usuario.getNacimiento());


            linearLayout.addView(tvNombre);
            linearLayout.addView(tvApellido);
            linearLayout.addView(tvEdad);
            linearLayout.addView(tvEmail);
            linearLayout.addView(tvTelefono);
            linearLayout.addView(tvNacimiento);
            linearLayout.addView(tvUsuario);
        }
    }
}
