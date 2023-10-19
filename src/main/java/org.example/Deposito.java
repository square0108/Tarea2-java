package org.example;
import java.util.ArrayList;

public class Deposito<T> {
    private final ArrayList<T> array;
    public Deposito() {
        this.array = new ArrayList<>();
    }

    /**
     * Añade un objeto en la última posición del depósito.
     * @param object objeto a añadir al depósito.
     */
    public void add(T object) {
        this.array.add(object);
    }

    /**
     * Quita el primer objeto dentro del depósito.
     * @return referencia al objeto. Si esta vacio, devuelve null.
     */
    public T get() {
        if (!array.isEmpty()){
            return this.array.remove(0);
        } else {
            return null;
        }
    }
}
