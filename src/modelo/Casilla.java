package modelo;

public class Casilla {

    private int x;
    private int y;
    private boolean hayReina;
    private boolean casillaDisponible;

    public Casilla(int x, int y){
        this.x = x;
        this.y = y;
        this.hayReina = false;
        this.casillaDisponible = true;
    }

    //Getters y Setters


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isHayReina() {
        return hayReina;
    }

    public void setHayReina(boolean hayReina) {
        this.hayReina = hayReina;
    }

    public boolean isCasillaDisponible() {
        return casillaDisponible;
    }

    public void setCasillaDisponible(boolean casillaDisponible) {
        this.casillaDisponible = casillaDisponible;
    }
}
