package com.juanbecerra.traductor;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.Map;

public class MainActivityViewModel extends AndroidViewModel {
    ///private MutableLiveData<String> mMensaje;

    private Map<String,String> palabras;
    private Map<String,Integer> imagenes;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        palabras.put("perro","dog");
        palabras.put("gato","cat");
        palabras.put("conejo","rabbit");

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
        getApplication().startActivity(intent);
    }

}
