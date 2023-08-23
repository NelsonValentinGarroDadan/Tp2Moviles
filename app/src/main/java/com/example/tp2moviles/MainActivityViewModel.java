package com.example.tp2moviles;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Moneda> monedaM;
    private ArrayList<Moneda> monedas = new ArrayList<Moneda>();
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
        monedas.add(new Moneda("Euros",(float)1.09,0));
        monedas.add(new Moneda("Dolares",(float)0.92,0));
    }
    public void Convertir(String moneda,double importer){
        if(moneda.equals("")){
            Toast.makeText(context, "Debe ingresar algun valor", Toast.LENGTH_LONG).show();
            return;
        }
        for(int i=0;i<monedas.size();i++){
            if(moneda.equals(monedas.get(i).getNombre())){
                double valor = importer * monedas.get(i).getValor();
                monedas.get(i).setImporter(valor);
                monedaM.setValue(monedas.get(i));
            }
        }
    }
    public LiveData<Moneda> getMutable(){
        if(monedaM == null){
            monedaM = new MutableLiveData<>();
        }
        return monedaM;
    }
}
