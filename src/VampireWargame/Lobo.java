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
    public Lobo(){
        vida = 100;
        escudo = 40;
        espada = 100;
    }

    @Override
    public void atacar(Ficha h) {
    
    }

    @Override
    public void defender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
