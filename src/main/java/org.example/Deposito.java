package main.java.org.example;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> array;

    public Deposito() {
        this.array = new ArrayList<>();
    }
    public void add(T object) {
        this.array.add(object);
    }
    public T get() {
        return this.array.remove(0);
    }
}
