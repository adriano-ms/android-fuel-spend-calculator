package com.edu.fateczl.fuelspendcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Adriano M Sanchez
 */
public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtRa;

    private EditText etAverage;
    private EditText etTank;

    private TextView txtResult;

    private Button btCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtName = findViewById(R.id.txtName);
        txtRa = findViewById(R.id.txtRa);

        etAverage = findViewById(R.id.etAverage);
        etTank = findViewById(R.id.etTank);

        txtResult = findViewById(R.id.txtResult);

        btCalculate = findViewById(R.id.btCalculate);
        btCalculate.setOnClickListener(e -> calculate());
    }

    private void calculate(){
        double averageFuelSpend = Double.parseDouble(etAverage.getText().toString());
        double fuelInTheTank = Double.parseDouble(etTank.getText().toString());

        double result = fuelInTheTank * averageFuelSpend * 1000.0;

        txtResult.setText(String.format("%.2f %s", result, getString(R.string.txt_result)));
    }
}