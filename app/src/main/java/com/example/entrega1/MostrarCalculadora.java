package com.example.entrega1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MostrarCalculadora extends AppCompatActivity {
    private EditText display;
    private String currentInput = "";
    private String operator = "";
    private double operand1 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_calculadora); // Asegúrate de que el nombre sea correcto

        display = findViewById(R.id.display);

        // Botones de números
        int[] numberIds = {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6,
                R.id.button_7, R.id.button_8, R.id.button_9};

        for (int id : numberIds) {
            findViewById(id).setOnClickListener(this::onNumberClick);
        }

        // Botones de operación
        int[] operatorIds = {R.id.button_add, R.id.button_subtract,
                R.id.button_multiply, R.id.button_divide};

        for (int id : operatorIds) {
            findViewById(id).setOnClickListener(this::onOperatorClick);
        }

        // Botón de igual
        findViewById(R.id.button_equals).setOnClickListener(this::onEqualsClick);

        // Botones de limpiar
        findViewById(R.id.button_clear).setOnClickListener(v -> clearAll());
        findViewById(R.id.button_backspace).setOnClickListener(v -> clearLastEntry());
    }

    private void onNumberClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        display.setText(currentInput);
    }

    private void onOperatorClick(View view) {
        Button button = (Button) view;
        if (!currentInput.isEmpty()) {
            operand1 = Double.parseDouble(currentInput);
            operator = button.getText().toString();
            currentInput = "";
        }
    }

    private void onEqualsClick(View view) {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double operand2 = Double.parseDouble(currentInput);
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
        }
    }

    private void clearAll() {
        currentInput = "";
        operator = "";
        display.setText("");
    }

    private void clearLastEntry() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            display.setText(currentInput);
        }
    }
}
