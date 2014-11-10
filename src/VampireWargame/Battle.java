package VampireWargame;

import java.util.*;

public class Battle {

    static ArrayList<Jugador> players = new ArrayList<>();
    static Ficha[][] tablero = new Ficha[6][6];

    public static void printTablero() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (tablero[x][y] == null) {
                    System.out.print("[  ]");
                } else {
                    System.out.print("" + tablero[x][y].toString() + "");
                }
            }
            System.out.println("");
        }
    }

    public static Jugador buscarPlayer(String n) {
        for (Jugador j : players) {
            if (j.getNombre().equalsIgnoreCase(n)) {
                return j;
            }
        }
        return null;
    }

    public static int controlFichas(boolean t) {
        int contB = 0, contN = 0;
        for (Ficha f[]: Battle.tablero) {
            for (Ficha c: f) {
                if (c != null && c.color.equals("N")) {
                    contN++;
                } else if(c != null && c.color.equals("B")){
                    contB++;
                }
            }
        }
        if (t==true) {
            return contB;
        } 
        return contN;
    }

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        Random rnd = new Random();
        String arr[] = {"VAMPIRO", "MUERTE", "LOBO", "VAMPIRO", "MUERTE", "LOBO"};
        int op;
        do {
            System.out.println("1-INICIAR PARTIDA\n"
                    + "2-RANKING HISTORICO DE JUGADORES\n"
                    + "3-LOG DE ULTIMAS 10 PARTIDAS\n"
                    + "4-SALIR");
            System.out.print("R: ");
            op = lea.nextInt();

            switch (op) {
                case 1:
                    Jugador player1=null;
                    Jugador player2=null;

                    System.out.print("Ingrese USERNAME de Player #1:");
                    String j1 = lea.next();
                    if (buscarPlayer(j1) != null) {
                        player1 = buscarPlayer(j1);
                    } else {
                        players.add(new Jugador(j1));
                        player1=buscarPlayer(j1);
                    }

                    System.out.print("Ingrese USERNAME de Player #2:");
                    String j2 = lea.next();
                    players.add(new Jugador(j2));
                    if (buscarPlayer(j2) != null) {
                        player2 = buscarPlayer(j2);
                    } else {
                        players.add(new Jugador(j2));
                        player2 = buscarPlayer(j2);
                    }

                    tablero[0][0] = new Lobo("B", 0, 0);;
                    tablero[0][5] = new Lobo("B", 0, 5);;
                    tablero[5][0] = new Lobo("N", 5, 0);;
                    tablero[5][5] = new Lobo("N", 5, 5);;
                    tablero[0][1] = new Vampiro("B", 0, 1);
                    tablero[0][4] = new Vampiro("B", 0, 4);
                    tablero[5][1] = new Vampiro("N", 5, 1);;
                    tablero[5][4] = new Vampiro("N", 5, 4);;
                    tablero[0][2] = new Muerte("B", 0, 2);;
                    tablero[0][3] = new Muerte("B", 0, 3);;
                    tablero[5][2] = new Muerte("N", 5, 2);;
                    tablero[5][3] = new Muerte("N", 5, 3);;
                    
                    int caso1=0,caso2=0;
                    String jugadorEnTurno;
                    int fichasRestantes=0;
                    boolean turn = true;

                    do {
                        System.out.println("");
                        printTablero();
                        System.out.println("");
                        jugadorEnTurno = (turn == true ? "Turno fichas blancas, mueve " + player1.getNombre() : "Turno Fichas negras, mueve " + player2.getNombre());
                        System.out.println(jugadorEnTurno);
                        
                        fichasRestantes=controlFichas(turn);
                        System.out.println("Restante de fichas: "+fichasRestantes);

                        String espectroAlAzar = arr[rnd.nextInt(arr.length)];//sselecciona al azar
                        System.out.println("Su opcion a mover es un(a) " + espectroAlAzar);
                        int fa, ca;

                        //printTablero();
                        while (true) {
                            System.out.print("Ingrese posicion fila actual: ");
                            fa = lea.nextInt();
                            System.out.print("Ingrese posicion columna actual: ");
                            ca = lea.nextInt();

                            if (tablero[fa][ca] != null && tablero[fa][ca].nombreEspectro.equals(espectroAlAzar)) {//compara que la posicion que ingreso sea del tipo que le salio
                                break;
                            } else if (fa == -1 && ca == -1) {
                                System.out.print("En realidad desea salir del juego? ");
                                String res = lea.next();
                                if (res.equalsIgnoreCase("si")) {
                                  break;
                                }
                                continue;
                            }
                            System.out.println("coordenadas incorrectas, ingreselas de nuevo");
                        }
                        tablero[fa][ca].subMenu(fa, ca);
                        //printTablero();
                        if(fichasRestantes==4 && caso1<=1){
                            caso1++;
                            continue;
                        }
                        
                        if (fichasRestantes==2 && caso2<=2){
                            caso2++;
                            continue;
                        }
                        
                        if (fichasRestantes==0 && turn==true){
                            System.out.println("Jugador "+player2.getNombre()+" ha vencido a jugador"+player1.getNombre()+
                                    ". Felicidades tienes 3 puntos");
                            player2.setPuntos();
                        }
                        if (fichasRestantes==0 && turn==false){
                            System.out.println("Jugador "+player1.getNombre()+" ha vencido a jugador"+player2.getNombre()+
                                    ". Felicidades tienes 3 puntos");
                            player1.setPuntos();
                        }
                        turn = !turn;
                        
                    } while (fichasRestantes>0);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Usted a escogido salir del sistema\nADIOS");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (op != 4);

//        printTablero();
//        tablero[2][0].moverPieza(tablero);
//        printTablero();
        //tablero[0][0].atacar(); 
//        if(tablero[0][0].moverPieza(tablero))
//            System.out.println("Movido");
//        else
//            tablero[0][0].moverPieza(tablero);
//        if(tablero[0][0] instanceof Lobo ){
//           tablero[0][0].moverPieza(tablero);
//        }else
//            System.out.println("No es lobo");
    }
}
