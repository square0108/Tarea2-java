package org.example;

import java.util.ArrayList;

public class DepositoMonedas {
    private ArrayList<Moneda> deposito;

    public DepositoMonedas() {
        super();
        deposito = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda moneda) {
        deposito.add(moneda);
    }

    public Moneda getMoneda() {
        if (deposito.size() != 0) {
            Moneda aux = deposito.get(0);
            deposito.remove(0);
            return aux;
        } else {
            return null;
        }
    }
}
