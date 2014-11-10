/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VampireWargame;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Muerte extends Ficha {
    
    ArrayList<Zombie> z= new ArrayList<>();

    public Muerte(String c, int co, int f) {
        super(3, 1, 4, c);
        nombreFicha = "M";
        nombreEspectro = "MUERTE";
        x = co;
        y = f;
    }

    public void ataqueLanza(int f, int c) {
        int fn, cn;
        while (true) {
            System.out.print("Fila de ficha a lanzar: ");
            fn = lea.nextInt();
            System.out.print("Columna de ficha a lanzar: ");
            cn = lea.nextInt();
            if (Battle.tablero[fn][cn] != null) {
                break;
            }
            System.out.println("posicion vacia,ingrese otras coordeandas");
        }
        Ficha atacado = Battle.tablero[fn][cn];
        if ((fn <= (f + 2) || fn <= (f - 2)) && (cn <= (c + 2) || cn <= (c - 2)) && ((f + 2) <= fn || (f - 2) <= fn) && ((c + 2) <= cn || (c - 2) <= cn)) {
            if (!Battle.tablero[f][c].color.equals(atacado.color)) {
                atacado.vida -= 2;
                atacado.print(2);
            } else {
                System.out.println("No puedes atacar a tu mismo equipo");
            }

        } else {
            System.out.println("Posicion Inalcanzable");
        }
    }

//    public Zombie CrearZombie(){
//       int x,y;
//        System.out.print("Fila donde crear al Zombie: ");
//        x=lea.nextInt();
//        System.out.print("Columna donde crear al Zombie: ");
//        y=lea.nextInt();
//       Ficha a=Battle.tablero[x][y];
//        if(a!=null){
//        Zombie z= new Zombie(color,x,y); 
//        return z;
//        }else
//            return null;
//    }
    @Override
    public void subMenu(int f, int c,String n) {
        System.out.println("1.Moverse \n2.Atacar\n3.Ataque lanza \n4.Conjurar zombie\nQue opcion desea?");
        int op = lea.nextInt();
        switch (op) {
            case 1:
              moverPieza(f,c);
                break;
            case 2:
                System.out.print("a.Ataque normal\nb.Ataque con zombie\nEscoja uno:");
                char op2 = lea.next().charAt(0);
                if (op2 == 'a') {
                    System.out.println(atacar(f, c));
                } else if (op2 == 'b') {
                    
                }

                break;
            case 3:
                ataqueLanza(f, c);
                break;
            case 4:
                while (true) {
                    System.out.print("Numero de fila: ");
                    int nf = lea.nextInt();
                    System.out.print("Numero de columna: ");
                    int nc = lea.nextInt();
                    if (Battle.tablero[nf][nc] == null) {
                        Battle.tablero[nf][nc] = new Zombie(Battle.tablero[f][c].color, nf, nc);
                        Zombie zo=new Zombie(Battle.tablero[f][c].color, nf, nc);
                        z.add(zo);
                        break;
                    } else {
                        System.out.print("Posicion ocupada,escoja otra.");
                    }
                }
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

}
