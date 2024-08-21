package com.juanbecerra.traductor;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.juanbecerra.traductor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p = binding.etPalabra.getText().toString();
                if(!p.isEmpty()){
                    mv.traducir(p);
                }

            }
        });




    }
}