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
public final class Zombie extends Ficha {
    
    public Zombie(String c, int co, int f){
        super(1,1,0,c);
        nombreFicha = "Z";
        nombreEspectro="ZOMBIE";
        x =co;
        y =f;
    }
    
    public void ataqueZombie(int f,int c){
        int fn,cn;
        System.out.print("Fila de Ficha a atacar Zombie: ");
        fn = lea.nextInt();
        System.out.print("Columna de Ficha a atacar Zombie: ");
        cn = lea.nextInt();
        Ficha atacado = Battle.tablero[fn][cn];
        if ((fn <= (f +1)||fn<=(f-1)) && (cn <= (c +1)||cn<=(c-1)) && ((f +1)<=fn ||(f-1)<=fn) && ((c +1)<=cn ||(c-1)<=cn)) {
            if (Battle.tablero[fn][cn] != null) {
                if (!color.equals(atacado.color)) {
                    if (atacado.escudo > 0) {
                        atacado.escudo-=1;
                    } else {
                        atacado.vida -= 1;
                    }
                    atacado.print(1);
                 } else {
                    System.out.println("No puedes atacar a tu mismo equipo");
                 }
            } else {
                System.out.println("Posicion Vacia");
             }
        } else {
            System.out.println("Posicion inalcanzable");
        }
    }
    
    public void crearZombie(int f,int c){
        
    }

    @Override
    public void subMenu(int f, int c,String n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
