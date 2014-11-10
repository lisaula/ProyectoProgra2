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
    protected String color, nombreFicha, nombreEspectro;
    Scanner lea = new Scanner(System.in);

    public Ficha(int vida, int escudo, int espada, String color) {
        this.vida = vida;
        this.escudo = escudo;
        this.espada = espada;
        this.color = color;
        nombreFicha = "Undefined";
        nombreEspectro = "Undefined";//cambio
        x = 0;
        y = 0;
    }

    public void moverPieza(int f, int c) {
        int fn, cn;
       while(true){
        System.out.print("Nueva posicion de Fila: ");
        fn = lea.nextInt();
        System.out.print("Nueva posicion de Columna: ");
        cn = lea.nextInt();
        if (((fn <= (f + 1) || fn <= (f - 1)) && (cn <= (c + 1) || cn <= (c - 1)) && ((f + 1) <= fn || (f - 1) <= fn) && ((c + 1) <= cn || (c - 1) <= cn))&& ((fn>=0 && fn<=5) &(cn>=0 && cn<=5))) {
           if (Battle.tablero[fn][cn] == null) {
                Battle.tablero[fn][cn] = Battle.tablero[f][c];
                Battle.tablero[f][c] = null;
                break;
            } else {
                System.out.println("Poscion ocupada");
                
            }
        } else {
            System.out.println("Posicion Inalcanzable");
           
        }
       }
    }

    @Override
    public String toString() {
        return "|" + nombreFicha + color + "|";
    }

    public String print(int x) {
        return "Se ataco pieza: "+nombreFicha + color + "Se le ha quitado " +x+
                "puntos.Quedan "+vida+" de vida. Escudo: " + escudo;
    }

    public String  atacar(int f, int c) {
        int fn, cn;
        while (true) {
            System.out.print("Fila de Ficha a atacar: ");
            fn = lea.nextInt();
            System.out.print("Columna de Ficha a atacar: ");
            cn = lea.nextInt();
            if (Battle.tablero[fn][cn] != null) {
                break;
            }
            System.out.println("posicion vacia,ingrese otras coordeandas");
        }
        Ficha atacado = Battle.tablero[fn][cn];
        Ficha atacante = Battle.tablero[f][c];
        if ((fn <= (f + 1) || fn <= (f - 1)) && (cn <= (c + 1) || cn <= (c - 1)) && ((f + 1) <= fn || (f - 1) <= fn) && ((c + 1) <= cn || (c - 1) <= cn)) {
            if (!(atacante.color.equals(atacado.color))) {
                if (atacado.escudo > 0) {
                    atacado.escudo -= espada;
                    if (atacado.escudo < 0) {
                        atacado.vida += atacado.escudo;
                        atacado.escudo = 0;
                    }
                } else {
                    atacado.vida -= espada;
                    if(atacado.vida<=0){
                      return "Se destruyo pieza "+atacado.nombreFicha+" del jugador ";
                    }else{
                        return atacado.print(atacante.espada);
                    }
                }
                
            } else {
                System.out.println("No puedes atacar a tu mismo equipo.");
            }
        } else {
            System.out.println("Posicion inalcanzable");
        }
        return null;
    }

    public abstract void subMenu(int f, int c,String n);
    
   // public abstr
    
//    public void removerFicha(int f, int c){
//        
//        if()
//    }

}
