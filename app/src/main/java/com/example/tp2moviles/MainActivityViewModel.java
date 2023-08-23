package com.example.tp2moviles;

import android.app.Application;

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


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        monedas.add(new Moneda("Euros",(float)1.09,0));
        monedas.add(new Moneda("Dolares",(float)0.92,0));
    }
    public void Convertir(String moneda,double importer){
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
