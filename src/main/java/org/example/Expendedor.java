package org.example;

public class Expendedor{
    public static final int COCA=1;
    public static final int SPRITE=2;
    private DepositoBebidas coca;
    private DepositoBebidas sprite;
    private DepositoMonedas monVu;
    private int precio;
    public Expendedor(int numBebidas, int precioBebidas){
        precio = precioBebidas;
        coca = new DepositoBebidas();
        sprite = new DepositoBebidas();
        monVu = new DepositoMonedas();

        Bebida b;
        for (int i=0; i<numBebidas; i++) {
            b = new CocaCola(100+i);
            coca.addBebida(b);
            b = new Sprite(200+i);
            sprite.addBebida(b);
        }
    }
    public Bebida comprarBebida(Moneda moneda, int bebida){
        Bebida b;
        if((bebida == COCA || bebida == SPRITE) && (moneda != null)){
            if (moneda.getValor() < precio){
                monVu.addMoneda(moneda);
                return null;
            }else{
                if(bebida == COCA){
                    b = coca.getBebida();
                }else{
                    b = sprite.getBebida();
                }
                if(b != null){
                    // sacamos el vuelto de la maquina
                    int vuelto = moneda.getValor() - precio;
                    while(vuelto > 0){
                        Moneda monedavuelto = new Moneda100();
                        monVu.addMoneda(monedavuelto);
                        vuelto = vuelto - monedavuelto.getValor();
                    }
                }else{
                    monVu.addMoneda(moneda);
                }
                return b;
            }
        }else{
            monVu.addMoneda(moneda);
            return null;
        }
    }
    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}