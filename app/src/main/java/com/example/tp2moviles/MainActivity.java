package com.example.tp2moviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.tp2moviles.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivityViewModel mv;
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        mv.getMutable().observe(this, new Observer<Moneda>() {
            @Override
            public void onChanged(Moneda moneda) {
                String text = String.format("%.2f",moneda.getImporter());
                binding.etBottom.setText(text);
            }
        });
        mv.Convertir("Euros",0);
        binding.rbDE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.rbED.setChecked(false);
                binding.tvTop.setText("Dolares");
                binding.tvBottom.setText("Euros");
            }
        });
        binding.rbED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.rbDE.setChecked(false);
                binding.tvTop.setText("Euros");
                binding.tvBottom.setText("Dolares");
            }
        });
        binding.btConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.tvTop.getText().toString();
                double importer = Double.parseDouble(binding.etTop.getText().toString());
                mv.Convertir(nombre,importer);

            }
        });
        binding.etTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etBottom.setText("");
            }
        });
    }
}
