/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circuferencia;

/**
 *
 * @author Veronica Cortes / Jazmin Patiño
 */
public class Punto {

    private int x;
    private int y;
    private boolean dentro;

    public Punto() {
        x = 0;
        y = 0;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object anotherObject) {

        if (this == anotherObject) {
            return true;
        }

        Punto that = (Punto) anotherObject;

        return this.x == that.getX() && this.y == that.getY();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    /**
     * @return the dentro
     */
    public boolean isDentro() {
        return dentro;
    }

    /**
     * @param dentro the dentro to set
     */
    public void setDentro(boolean dentro) {
        this.dentro = dentro;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
