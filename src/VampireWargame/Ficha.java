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
public abstract class Ficha {

    protected int vida, escudo, espada, x, y;
    protected String color, nombreFicha,nombreEspectro;
    Scanner lea = new Scanner(System.in);

    public Ficha(int vida, int escudo, int espada, String color) {
        this.vida = vida;
        this.escudo = escudo;
        this.espada = espada;
        this.color = color;
        nombreFicha = "Undefined"; 
        nombreEspectro="Undefined";//cambio
        x = 0;
        y = 0;
    }

    public boolean moverPieza(int f, int c) {
        int fn, cn;
        System.out.print("Nueva posicion de Fila: ");
        fn = lea.nextInt();
        System.out.print("Nueva posicion de Columna: ");
        cn = lea.nextInt();
        if ((fn <= (f +1)||fn<=(f-1)) && (cn <= (c +1)||cn<=(c-1))) {                                                                    
            if (Battle.tablero[fn][cn] == null) {
                Battle.tablero[fn][cn] = Battle.tablero[f][c];
                Battle.tablero[f][c] = null;
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
        return "|" + nombreFicha + color + "|";
    }

    public void print() {
        System.out.println(nombreFicha+ color + " - Vida: " + vida + " - Escudo: " + escudo);
    }

    public void atacar(int f, int c) {
        int fn, cn;
        System.out.print("Fila de Ficha a atacar: ");
        fn = lea.nextInt();
        System.out.print("Columna de Ficha a atacar: ");
        cn = lea.nextInt();
        Ficha atacado = Battle.tablero[fn][cn];
        Ficha atacante=Battle.tablero[f][c];
        if ((fn <= (f +1)||fn<=(f-1)) && (cn <= (c +1)||cn<=(c-1))) {
            if(Battle.tablero[fn][cn] != null){
                if (!(atacante.color.equals(atacado.color))) {
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
        }else{
            System.out.println("Posicion inalcanzable"); 
        }
           
    }
    
    public abstract void subMenu(int f,int c);

}
