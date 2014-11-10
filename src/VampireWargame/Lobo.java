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

    @Override
    public void moverPieza(int f, int c) {
        int fn,cn;
        while(true){
        System.out.print("Nueva posicion de Fila: ");
        fn= lea.nextInt();
        System.out.print("Nueva posicion de Columna: ");
        cn = lea.nextInt();

        if((fn <= (f +2)||fn<=(f-2)) && (cn <= (c +2)||cn<=(c-2)) && ((f +2)<=fn ||(f-2)<=fn) && ((c +2)<=cn ||(c-2)<=cn)){
          if (Battle.tablero[fn][cn] == null) {
                Battle.tablero[fn][cn] = Battle.tablero[f][c];
                Battle.tablero[f][c] = null;
                break;
            }else{
                System.out.println("Poscion ocupada");
                
            }
        } else {
            System.out.println("Posicion Inalcanzable");
            
        }
        }
    }

    @Override
    public void subMenu(int f, int c,String n) {
        System.out.println("1.Moverse \n2.Atacar\nQue opcion desea?");
        int op=lea.nextInt();
        switch (op){
            case 1:
                moverPieza(f,c);
                break;
            case 2:
                System.out.println( atacar(f,c));
                break;
             default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    
    
}
