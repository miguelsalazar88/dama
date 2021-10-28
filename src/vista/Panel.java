package vista;

import modelo.Casilla;
import javax.swing.*;
import java.awt.*;


public class Panel  extends JPanel{

    private Casilla[][] tableroVista = new Casilla[8][8];

    public Panel(){
        this.setVisible(true);
        this.setSize(400,400);
    }

    @Override
    public void paint(Graphics g){

        for (int i = 0; i < tableroVista.length; i++) {
            for (int j = 0; j < tableroVista[0].length; j++) {
                if(tableroVista[i][j].isHayReina()){
                    g.drawString("Q",tableroVista[i][j].getX()+10,tableroVista[i][j].getY()+20);
                    g.setColor(Color.BLACK);
                    g.drawRect(tableroVista[i][j].getX(),tableroVista[i][j].getY(),30,30);
                }
                else if(!tableroVista[i][j].isHayReina()&&!tableroVista[i][j].isCasillaDisponible()){
                    g.setColor(Color.red);
                    g.fillRect(tableroVista[i][j].getX(),tableroVista[i][j].getY(),30,30);
                    g.setColor(Color.BLACK);
                    g.drawRect(tableroVista[i][j].getX(),tableroVista[i][j].getY(),30,30);
                }
                else if(!tableroVista[i][j].isHayReina()&&tableroVista[i][j].isCasillaDisponible()){
                    g.setColor(Color.GREEN);
                    g.setColor(Color.BLACK);
                    g.drawRect(tableroVista[i][j].getX(),tableroVista[i][j].getY(),30,30);
                }
            }
        }
    }

    //Getters y Setters

    public void setTableroVista(Casilla[][] tableroVista) {
        this.tableroVista = tableroVista;
    }

}
