package com.juanbecerra.traductor;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivityViewModel extends AndroidViewModel {
    ///private MutableLiveData<String> mMensaje;

    private Map<String,String> palabras;
    private Map<String,Integer> imagenes;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        palabras =new HashMap<>();
        palabras.put("perro","dog");
        palabras.put("gato","cat");
        palabras.put("conejo","rabbit");

        imagenes = new HashMap<>();
        imagenes.put("perro",R.drawable.perro);
        imagenes.put("gato",R.drawable.gato);
        imagenes.put("conejo",R.drawable.conejo);
    }

    /*public MutableLiveData<String> getmMensaje() {
        if(mMensaje==null){
            mMensaje= new MutableLiveData<>();
        }
        return mMensaje;
    }*/

    public void traducir(String palabra){
            palabra=palabra.toLowerCase();
        Intent intent = new Intent(getApplication(), ActivityTraduccion.class);
            if(palabras.containsKey(palabra)){
                String trad=palabras.get(palabra);
                Integer path= imagenes.get(palabra);



                intent.putExtra("traduccion",trad);
                intent.putExtra("imagenPath", path);




            }else{
                intent.putExtra("traduccion","palabra no encontrada");
                intent.putExtra("imagenPath",R.drawable.no);

            }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getApplication().startActivity(intent);
    }

}
