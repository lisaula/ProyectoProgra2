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
public class Vampiro extends Ficha{
    
    public Vampiro(String c, int co, int f){
        super(4,5,3,c);
        nombre ="V";
        x =co;
        y =f;
    }
    
    public boolean chuparSangre(int x, int y){
        Ficha c=Battle.tablero[x][y];
        vida += 1;
        if(c!=null){
            if(c.escudo !=0){
               c.escudo -= 1;
               if(c.escudo<0){
                   c.vida -=c.escudo;
               }
            }
            else{
                c.vida -= 1;
            }
            c.print();
            return true;
        }else{
            System.out.println("Posicion vacia");
            return false;
        }
    }
}
