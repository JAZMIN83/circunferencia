/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circuferencia;

import java.util.Scanner;

/**
 *
 * @author Veronica Cortes / Jazmin Patiño
 */
public class Inicio {

    public static void main(String[] args) {
        // TODO code application logic here
        double radio, area;
        System.out.println("HALLA EL AREA DE UN CIRCULO");
        //Scanner scanner = new Scanner(System.in);
        // radio = scanner.nextFloat();

        Circunferencia c = new Circunferencia(100);
        
        c.procesar(10000);
        
        System.out.println("Pi = " +  c.calcuarPi());

        System.out.println("Guia de simulacion");

    }

}
