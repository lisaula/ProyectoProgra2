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
public class Lobo extends Ficha {

    public Lobo(String c, int co, int f) {
        super(5, 2, 5, c);
        nombre = "L";
        x = co;
        y = f;
    }

    public boolean moverPieza(Ficha t[][]) {
        int p1, p2;
        System.out.print("Nueva posicion de Fila: ");
        p1 = lea.nextInt();
        System.out.print("Nueva posicion de Columna: ");
        p2 = lea.nextInt();

        if(p1 <= (x +2) && p2 <= (y +2) ){
        if (t[p1][p2] == null) {
            if ((p1<=(x+2)&&p2!=(y+1))) {
                t[p1][p2] = t[x][y];
                t[x][y] = null;
                x = p1;
                y = p2;
                return true;
            }else{
                System.out.println("No puedes moverte en L.");
                return false;
            }
        } else {
            System.out.println("Poscion ocupada");
            return false;
        }
        }else
            System.out.println("Habilidad no disponible del Lobo");
        return false;
    }

    
    
}
