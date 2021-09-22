package vista;

import javax.swing.*;
import java.awt.*;

public class Panel  extends JPanel {

    private boolean[][] tablero = new boolean[8][8];

    public Panel(){
        this.setVisible(true);
        this.setSize(300,300);
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g){

    }

}
