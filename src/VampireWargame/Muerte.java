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
        nombre ="M";
        x =co;
        y =f;
    }
    
    public void ataqueLanza(){
        int p1,p2;
        System.out.print("Fila de ficha a lanzar: ");
        p1 = lea.nextInt();
        System.out.print("Columna de ficha a lanzar: ");
        p2 = lea.nextInt();
        Ficha a=Battle.tablero[p1][p2];
        if (p1 <= (x + 2) && p2 <= (y + 2)) {
            if (a != null) {
                if (!color.equals(a.color)) {
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
    
    
}
