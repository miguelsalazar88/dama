package vista;

import controlador.Controller;

import javax.swing.*;

public class Ventana extends JFrame {

    private Panel panel = new Panel();
    private Controller controller;
    private JButton botonIniciar = new JButton("Iniciar");


    public Ventana(){
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(null);
        this.initComponents();
        this.setTitle("Ubica 8 reinas en el tablero");
    }

    public void initComponents() {
        this.add(panel);
        this.add(botonIniciar);
        this.botonIniciar.setBounds(250,400, 100, 30);
    }

    public void setController(Controller controller){
        this.controller = controller;
        this.botonIniciar.addActionListener(controller);
    }

    //Getters y Setters

    public Panel getPanel() {
        return panel;
    }

    public JButton getBotonIniciar() {
        return botonIniciar;
    }


}
