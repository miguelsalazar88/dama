package controlador;

import modelo.Modelo;
import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Ventana vista;
    private Modelo modelo;

    public Controller(Ventana vista, Modelo modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(this.vista.getBotonIniciar())){
            this.modelo.setReinas(0,0,this.modelo.crearArray());
        }

    }
}
