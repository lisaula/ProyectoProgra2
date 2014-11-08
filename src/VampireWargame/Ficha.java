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

    protected int vida, escudo, espada, x,y;
    protected String color, nombre;
    Scanner lea = new Scanner(System.in);

    public Ficha(int vida, int escudo, int espada, String color) {
        this.vida = vida;
        this.escudo = escudo;
        this.espada = espada;
        this.color = color;
        nombre = "Undefined";
        x=0;
        y=0;
    }

    public boolean moverPieza(Ficha t[][]) {
        int p1,p2;
        Ficha f;
        System.out.print("Nueva posicion de Fila: ");
        p1 = lea.nextInt();
        System.out.print("Nueva posicion de Columna: ");
        p2 = lea.nextInt();

        if (t[p1][p2] != null) {
            System.out.println("Espacion Indisponible, escoja otra vez");
            return false;
        } else {
            t[p1][p2] = t[x][y];
            t[x][y]=null;
            x=p1;
            y=p2;
            return true;
        }
    }

    public String toString() {
        nombre.toUpperCase();
        color.toUpperCase();
        return "|" + nombre + color + "|";
    }
    
    public void print(){
        System.out.println(nombre+color +"-Vida: "+vida+"-Escudo: "+escudo);
    }

    public boolean atacar(int x, int y) {
        Ficha atacado = Battle.tablero[x][y];
        if (Battle.tablero[x][y] != null) {
            if (atacado.escudo != 0) {
                atacado.escudo -= espada;
                if (atacado.escudo < 0) {
                    atacado.vida -= atacado.escudo;
                    atacado.escudo = 0;
                }
            }else{
               atacado.vida -= espada;
            }
        atacado.print();
        return true;    
        }return false; 
    }

}
