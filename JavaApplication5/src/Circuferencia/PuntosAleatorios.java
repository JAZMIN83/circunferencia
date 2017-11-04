/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circuferencia;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jorge
 */
public class PuntosAleatorios {

    private final ArrayList<Punto> puntos;
    //final private Random rand = new Random();
    final private GeneradorLecuyer rand = new GeneradorLecuyer();

    public PuntosAleatorios() {

        this.puntos = new ArrayList<>();

        rand.inicial(2246, 4457, 1000000);
        rand.generar();
    }

    public void generar(double ladoCuadrado, int numeroAleatorios) {

        Punto punto;
        for (int i = 0; i < numeroAleatorios; i++) {
            do {
                punto = new Punto(
                        rand.nextDouble(ladoCuadrado) - (ladoCuadrado / 2),
                        rand.nextDouble(ladoCuadrado) - (ladoCuadrado / 2));
            } while (getPuntos().contains(punto));
            getPuntos().add(punto);
        }
    }

    /**
     * @return the puntos
     */
    public ArrayList<Punto> getPuntos() {
        return puntos;
    }
}
