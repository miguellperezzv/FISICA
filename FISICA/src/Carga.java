/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gorym
 */
public class Carga {
    private double magnitud;
    private double exp;
    private double x,y;
    
    public Carga(double magnitud,double exp, double x, double y){
        setMagnitud(magnitud);
        setExp(exp);
        setX(x);
        setY(y);
    }

    public double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }
    
    public void setExp(double exp) {
        this.exp = exp;
    }
    
    public double getExp() {
        return exp;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
}
