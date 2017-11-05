/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circuferencia;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Veronica Cortes / Jazmin Patiño
 */
public class Circunferencia {

    final private PuntosAleatorios puntosAleatorios;
    final private int[] contadores = new int[2];
    final private double radio;

    public Circunferencia(double radio) {
        contadores[0] = 0;
        contadores[1] = 0;
        this.puntosAleatorios = new PuntosAleatorios();
        this.radio = radio;
    }

    public void procesar(int numerosaleatorios) {

        puntosAleatorios.generar(radio * 2, numerosaleatorios);

        ArrayList<Punto> pa = puntosAleatorios.getPuntos();

        for (int i = 0; i < pa.size(); i++) {
            Punto p = pa.get(i);
            boolean pdc = puntoDentroCircunferencia(p, radio);           
            contadores[pdc ? 1 : 0] += 1;
        }
    }
    
    public double calcuarPi()
    {
        return 4.0 * contadores[1] / (contadores[0] + contadores[1]);
    }

    private boolean puntoDentroCircunferencia(Punto punto, double radio) {

        return Math.pow(punto.getX(), 2) + Math.pow(punto.getY(), 2) <= Math.pow(radio, 2);
    }
}

/**
 *
 *
 * Ancho: 278 Alto: 143 Puntos totales 39754 Negro:18006 45.29% Blanco:21748
 * 54.70% Otro:0
 *
 * Area blanca 13.33333333333333 55.55% Area negra 10.66666666666666 44.44% Area
 * total 24
 *
 * 24 %100
 *
 * 39754 % 100
 *
 *
 * [253 254 255] [254 255 255] [255 255 255] [250 250 250] [171 171 171] [ 0 0
 * [254 255 255] [254 255 255] [252 252 252] [242 242 242] [ 52 52 52] [ 2 2
 * [254 254 254] [255 255 255] [255 255 255] [142 142 142] [ 0 0 0] [ 1 1 1]
 * [255 255 255] [255 255 255] [220 220 220] [ 45 45 45] [ 0 0 0] [ 0 0 0] [250
 * 250 250] [255 255 255] [144 144 144] [ 0 0 0] [ 2 2 2] [ 0 0 0] [255 255 253]
 * [239 239 239] [ 54 54 54] [ 0 0 0] [ 0 0 0] [ 0 0 0] [255 255 253] [169 168
 * 166] [ 3 2 0] [ 1 0 0] [ 1 0 0] [ 0 0 0] [253 252 248] [ 76 75 73] [ 1 0 0] [
 * 4 3 1] [ 0 0 0] [ 0 0 0] [126 122 119] [ 8 4 1] [ 1 0 0] [ 1 0 0] [ 0 0 0] [
 * 0 0 0] [ 23 22 20] [ 3 2 0] [ 1 0 0] [ 1 0 0] [ 0 0 0] [ 0 0 0] [ 62 62 62] [
 * 0 0 0] [ 0 0 0] [ 0 0 0] [ 0 0 0] [ 0 0 0] [ 23 24 26] [ 0 0 2] [ 6 7 9] [ 0
 * 0 0] [ 0 0 0] [ 0 0 0] [ 6 7 9] [ 0 0 2] [ 0 0 2] [ 0 0 0] [ 0 0 0] [ 0 0 0]
 * [ 1 2 4] [ 0 0 2] [ 0 0 1] [ 0 0 0] [ 0 0 0] [ 0 0 0] [ 0 1 3] [ 0 0 2] [ 0 0
 *
 *
 *
 *
 *
 *
 * 01234567890123456789012345678901 AAAAAAAA
 *
 *
 *
 *
 * 10000000 11111111 ________ 10000000
 *
 * 1 & 1 = 1
 * 1 & 0 = 0
 * 0 & 1 = 0
 * 0 & 0 = 0
 *
 * 1 | 1 = 1
 * 1 | 0 = 1
 * 0 | 1 = 1
 * 0 | 0 = 0
 *
 *
 *
 * https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
 * https://es.wikipedia.org/wiki/RGB
 * https://en.wikipedia.org/wiki/Linear_interpolation
 *
 */
