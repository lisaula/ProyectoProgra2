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
    public Muerte(String c){
        super(3,1,4,c);
        
    }
    
    public void ataqueLanza(Ficha a){
        a.vida -= 2;
    }
    
    public void CrearZombie(int x){
       
    }
    
    
    
    
}
