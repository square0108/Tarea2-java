package org.example;

import java.util.ArrayList;

public class DepositoBebidas{
    private ArrayList<Bebida> deposito;
    public DepositoBebidas(){
        super();
        deposito = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida bebida){
        deposito.add(bebida);
    }
    public Bebida getBebida(){
        if (deposito.size() != 0){
            Bebida aux = deposito.get(0);
            deposito.remove(0);
            return aux;
        }else {
            return null;
        }
    }
}