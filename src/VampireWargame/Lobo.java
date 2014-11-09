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
        nombreFicha = "L";
        nombreEspectro="LOBO";
        x = co;
        y = f;
    }

    public boolean moverPieza(int f, int c) {
        int fn,cn;
        System.out.print("Nueva posicion de Fila: ");
        fn= lea.nextInt();
        System.out.print("Nueva posicion de Columna: ");
        cn = lea.nextInt();

        if(((fn <= (f +1)||fn<=(f-1))||(fn <= (f +2)||fn<=(f-2))) && ((cn <= (c +1)||cn<=(c-1))||(cn <= (c +2)||cn<=(c-2)))){
          if (Battle.tablero[fn][cn] == null) {
                Battle.tablero[fn][cn] = Battle.tablero[f][c];
                Battle.tablero[x][y] = null;
//                x = p1;
//                y = p2;
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

    @Override
    public void subMenu(int f, int c) {
        System.out.println("1.Moverse \n2.Atacar\nQue opcion desea?");
        int op=lea.nextInt();
        switch (op){
            case 1:
                moverPieza(f,c);
                break;
            case 2:
                atacar(f,c);
                break;
             default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    
    
}
