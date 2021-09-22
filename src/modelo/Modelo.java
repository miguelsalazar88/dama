package modelo;

import vista.Ventana;

public class Modelo {

    private Ventana vista;
    private Casilla[][] tablero = new Casilla[8][8];

    public Modelo(Ventana vista){
        this.vista = vista;
    }


    public void initTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Casilla(i,j);
            }
        }
    }

    public void ubicarReina(int fila, int columna){
        tablero[fila][columna].setHayReina(true);
        int dif = fila - columna;
        int sum = fila + columna;
        tablero[fila][columna]. = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length ; j++) {
                tablero[fila][j].setCasillaDisponible(false);
                tablero[i][columna].setCasillaDisponible(false);
                if(j == i-dif){
                    tablero[i][j].setCasillaDisponible(false);
                }
                if(i+j == sum){
                    tablero[i][j].setCasillaDisponible(false);
                }

            }
        }
    }


    //Para pruebas solamente

    public void printTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println();
        }
    }


}
