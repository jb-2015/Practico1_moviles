package com.juanbecerra.traductor;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.juanbecerra.traductor.databinding.ActivityMainBinding;
import com.juanbecerra.traductor.databinding.ActivityTraduccionBinding;

public class ActivityTraduccion extends AppCompatActivity {
    private ActivityTraduccionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        binding = ActivityTraduccionBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.tvTraducido.setText(i.getStringExtra("traduccion"));
        binding.ivImagen.setImageResource(i.getIntExtra("imagenPath",0));





    }
}