/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VampireWargame;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ficha {

    protected int vida, escudo, espada, x, y;
    protected String color, nombre;
    Scanner lea = new Scanner(System.in);

    public Ficha(int vida, int escudo, int espada, String color) {
        this.vida = vida;
        this.escudo = escudo;
        this.espada = espada;
        this.color = color;
        nombre = "Undefined";
        x = 0;
        y = 0;
    }

    public boolean moverPieza(Ficha t[][]) {
        int p1, p2;
        System.out.print("Nueva posicion de Fila: ");
        p1 = lea.nextInt();
        System.out.print("Nueva posicion de Columna: ");
        p2 = lea.nextInt();

        if (p1 <= (x +1) && p2 <= (y +1)) {
            if (t[p1][p2] == null) {
                t[p1][p2] = t[x][y];
                t[x][y] = null;
                x = p1;
                y = p2;
                return true;
            }else{
                System.out.println("Poscion ocupada");
                return false;
            }
        } else {
            System.out.println("Posicion Inalcanzable");
            return false;
        }
    }

    public String toString() {
        return "|" + nombre + color + "|";
    }

    public void print() {
        System.out.println(nombre + color + " - Vida: " + vida + " - Escudo: " + escudo);
    }

    public void atacar() {
        int p1, p2;
        System.out.print("Fila de Ficha a atacar: ");
        p1 = lea.nextInt();
        System.out.print("Columna de Ficha a atacar: ");
        p2 = lea.nextInt();
        Ficha atacado = Battle.tablero[p1][p2];
        if (p1 <= (x + 1) && p2 <= (y + 1)) {
            if(Battle.tablero[p1][p2] != null){
                if (!color.equals(atacado.color)) {
                    if (atacado.escudo > 0) {
                        atacado.escudo -= espada;
                        if (atacado.escudo < 0) {
                            atacado.vida += atacado.escudo;
                            atacado.escudo = 0;
                        }
                    } else {
                        atacado.vida -= espada;
                    }
                    atacado.print();
                } else {
                    System.out.println("No puedes atacar a tu mismo equipo.");
                  }
            } else {
                System.out.println("Posicion Vacia");
            }
        }else
            System.out.println("Posicion inalcanzable");
    }

}
