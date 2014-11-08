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
public class Vampiro extends Ficha {

    public Vampiro(String c, int co, int f) {
        super(4, 5, 3, c);
        nombre = "V";
        x = co;
        y = f;
    }

    public boolean chuparSangre() {
        int p1, p2;
        System.out.print("Fila de Ficha a Chupar sangre: ");
        p1 = lea.nextInt();
        System.out.print("Columna de Ficha a Chupar sangre: ");
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
                    vida += 1;
                    return true;
                } else {
                    System.out.println("No puedes atacar a tu mismo equipo");
                    return false;
                }
            } else {
                System.out.println("Posicion Vacia");
                return false;
            }
        } else {
            System.out.println("Posicion inalcanzable");
            return false;
        }

    }
}
