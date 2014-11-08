/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VampireWargame;

/**
 *
 * @author admin
 */
public final class Zombie extends Ficha {
    
    public Zombie(String c, int co, int f){
        super(1,1,0,c);
        nombre ="Z";
        x =co;
        y =f;
    }
    
    public void ataqueZombie(){
        int p1, p2;
        System.out.print("Fila de Ficha a atacar Zombie: ");
        p1 = lea.nextInt();
        System.out.print("Columna de Ficha a atacar Zombie: ");
        p2 = lea.nextInt();
        Ficha c = Battle.tablero[p1][p2];
        if (p1 <= (x + 1) && p2 <= (y + 1)) {
            if (Battle.tablero[p1][p2] != null) {
                if (!color.equals(c.color)) {
                    if (c.escudo > 0) {
                        c.escudo -= 1;
                        if (c.escudo < 0) {
                            c.vida += c.escudo;
                            c.escudo = 0;
                        }
                    } else {
                        c.vida -= 1;
                    }
                    c.print();
                 } else {
                    System.out.println("No puedes atacar a tu mismo equipo");
                 }
            } else {
                System.out.println("Posicion Vacia");
             }
        } else {
            System.out.println("Posicion inalcanzable");
        }
    }
    
}
