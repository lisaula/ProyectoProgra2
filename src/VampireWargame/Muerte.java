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
public class Muerte extends Ficha {
    public Muerte(String c, int co, int f){
        super(3,1,4,c);
        nombreFicha = "M";
        nombreEspectro="MUERTE";
        x =co;
        y =f;
    }
    
    public void ataqueLanza(int f, int c){
        int p1,p2;
        System.out.print("Fila de ficha a lanzar: ");
        p1 = lea.nextInt();
        System.out.print("Columna de ficha a lanzar: ");
        p2 = lea.nextInt();
        Ficha a=Battle.tablero[p1][p2];
        if (p1 <= (f+ 2) && p2 <= (c + 2)) {
            if (a != null) {
                if (!Battle.tablero[f][c].color.equals(a.color)) {
                       a.vida -= 2;
                       a.print();
                }else
                    System.out.println("No puedes atacar a tu mismo equipo");
            }else
                System.out.println("Posicion Vacia");
        }else
            System.out.println("Posicion Inalcanzable");
    }
    
    public Zombie CrearZombie(){
       int x,y;
        System.out.print("Fila donde crear al Zombie: ");
        x=lea.nextInt();
        System.out.print("Columna donde crear al Zombie: ");
        y=lea.nextInt();
       Ficha a=Battle.tablero[x][y];
        if(a!=null){
        Zombie z= new Zombie(color,x,y); 
        return z;
        }else
            return null;
    }

    @Override
    public void subMenu(int f, int c) {
       System.out.println("1.Moverse \n2.Atacar\n3.Lanzar lanza \n4.Conjurar zombie\nQue opcion desea?");
        int op=lea.nextInt();
        switch (op){
            case 1:
                moverPieza(f,c);
                break;
            case 2:
                atacar(f,c);
                break;
            case 3:
                ataqueLanza(f,c);
                break;
            case 4:
                while(true){
                System.out.print("Numero de fila: ");
                int nf=lea.nextInt();
                System.out.print("Numero de columna: ");
                int nc=lea.nextInt();
                if(Battle.tablero[nf][nc]==null){
                Zombie z = new Zombie(Battle.tablero[f][c].color,nf,nc);
                break;
                }
                }
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        } 
    }
    
    
}
