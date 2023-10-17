package org.example;

public abstract class Bebida{
    private int numSerie;
    public Bebida(int a){
        numSerie = a;
    }
    public int getSerie(){
        return  numSerie;
    }
    public abstract String beber();
}
class CocaCola extends Bebida{
    public CocaCola(int a){
        super(a);
    }
    public String beber(){
        return "cocacola";
    }
}
class Sprite extends Bebida{
    public Sprite(int a){
        super(a);
    }
    public String beber(){
        return "sprite";
    }
}
