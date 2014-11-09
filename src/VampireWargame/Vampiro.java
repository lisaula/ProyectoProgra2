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
        nombreFicha = "V";
        nombreEspectro="VAMPIRO";
        x = co;
        y = f;
    }
    

    public boolean chuparSangre(int fil,int col) {
        int p1, p2;
        System.out.print("Fila de Ficha a Chupar sangre: ");
        p1 = lea.nextInt();
        System.out.print("Columna de Ficha a Chupar sangre: ");
        p2 = lea.nextInt();
        Ficha c = Battle.tablero[p1][p2];
        Ficha c2= Battle.tablero[fil][col];
        if (p1 <= (fil + 1) && p2 <= (col + 1)) {
            if (Battle.tablero[p1][p2] != null) {
                if (!(c2.color.equals(c.color))) {
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

    @Override
    public void subMenu(int f, int c) {
        System.out.println("1.Moverse \n2.Atacar\n3.Chupar Sangre\nQue opcion desea?");
        int op=lea.nextInt();
        switch (op){
            case 1:
                moverPieza(f,c);
                break;
            case 2:
                atacar(f,c);
                break;
            case 3:
                chuparSangre(c,f);
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }
}
