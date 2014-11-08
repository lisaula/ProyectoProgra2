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
    
    public void ataqueLanza(int x, int y){
        Ficha a=Battle.tablero[x][y];
        
        a.vida -= 2;
        a.print();
    }
    
    public Zombie CrearZombie(int x,int y){
       Zombie z= new Zombie(color,x,y); 
       return z;
    }
    
    public void ataqueZombie(int x, int y){
        Ficha h=Battle.tablero[x][y];
        if(h.escudo>0)
            h.escudo -=1;
        else
            h.vida -=1;
    }
    
    
    
    
}
