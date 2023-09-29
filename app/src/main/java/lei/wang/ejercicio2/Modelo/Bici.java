package lei.wang.ejercicio2.Modelo;

import java.io.Serializable;

public class Bici implements Serializable {

    private String marca;
    private String pulgada;

    public Bici() {
    }

    public Bici(String marca, String pulgada) {
        this.marca = marca;
        this.pulgada = pulgada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPulgada() {
        return pulgada;
    }

    public void setPulgada(String pulgada) {
        this.pulgada = pulgada;
    }

    @Override
    public String toString() {
        return "Bici{" +
                "marca='" + marca + '\'' +
                ", pulgada='" + pulgada + '\'' +
                '}';
    }
}
