package modelo;

import vista.Ventana;

import java.util.*;

public class Modelo {

    private Ventana vista;
    private Casilla[][] tableroModelo = new Casilla[8][8];
    private Random rnd = new Random();

    public Modelo(Ventana vista){
        this.vista = vista;
    }

    //Este metodo inicializa las casillas del tablero de ajedrez (tableroModelo);

    public void initTablero(){
        int xInit = 50;
        int yInit = 50;
        for (int i = 0; i < tableroModelo.length; i++) {
            for (int j = 0; j < tableroModelo.length; j++) {
                tableroModelo[i][j] = new Casilla(xInit,yInit);
                xInit = xInit+30;
            }
            xInit = 50;
            yInit = yInit+30;
        }
        this.vista.getPanel().setTableroVista(this.tableroModelo);
        this.vista.repaint();
    }

    public void ubicarReina(int fila, int columna){
        tableroModelo[fila][columna].setHayReina(true);
        tableroModelo[fila][columna].setCasillaDisponible(false);
        int dif = fila - columna;
        int sum = fila + columna;

        for (int i = 0; i < tableroModelo.length; i++) {
            for (int j = 0; j < tableroModelo.length ; j++) {
                tableroModelo[fila][j].setCasillaDisponible(false);
                tableroModelo[i][columna].setCasillaDisponible(false);
                if(j == i-dif){
                    tableroModelo[i][j].setCasillaDisponible(false);
                }
                if(i+j == sum){
                    tableroModelo[i][j].setCasillaDisponible(false);
                }

            }
        }

        this.vista.getPanel().setTableroVista(this.tableroModelo);
        this.vista.repaint();
    }


    public void setReinas(int fila, int columna, ArrayList<IntPair> lista){
        if (numReinas()==8){
            System.out.println("Eureka");
        }
        else{
            initTablero();
            ubicarReina(fila,columna);
            for (int i = 0; i < tableroModelo.length; i++) {
                for (int j = 0; j < tableroModelo.length ; j++) {
                    if(tableroModelo[i][j].isCasillaDisponible()){
                        ubicarReina(i,j);
                    }
                }
            }
            System.out.println("Fila: " + fila + " Columna: " + columna);
            lista.remove(0);
            this.setReinas(lista.get(0).getFila(),lista.get(0).getColumna(),lista);
        }
    }

    //Utilidades

    //Este metodo crea un arraylist que contiene las ubicaciones de las casillas;

    public ArrayList<IntPair> crearArray(){
        ArrayList<IntPair> lista = new ArrayList<>();

        for (int i = 0; i < tableroModelo.length; i++) {
            for (int j = 0; j < tableroModelo.length; j++) {
                lista.add(new IntPair(i,j));
            }
        }
        return lista;
    }

    public void wait(int n){
        long t0, t1;
        t0 = System.currentTimeMillis();

        do {
            t1 = System.currentTimeMillis();
        } while ((t1 - t0) < n);
    }

    public int numReinas(){
        int num = 0;
        for (int i = 0; i < tableroModelo.length; i++) {
            for (int j = 0; j < tableroModelo.length; j++) {
                if(tableroModelo[i][j].isHayReina()){
                    num++;
                }
            }
        }
        return num;
    }



    //Para pruebas solamente

    public void printTablero(){
        for (int i = 0; i < tableroModelo.length; i++) {
            for (int j = 0; j < tableroModelo.length; j++) {
                if(tableroModelo[i][j].isHayReina()){
                    System.out.print("[Q]");
                }
                else if(!tableroModelo[i][j].isHayReina()&&!tableroModelo[i][j].isCasillaDisponible()){
                    System.out.print("[0]");
                }
                else if(!tableroModelo[i][j].isHayReina()&&tableroModelo[i][j].isCasillaDisponible()){
                    System.out.print("[1]");
                }

            }
            System.out.println();
        }
    }


}
