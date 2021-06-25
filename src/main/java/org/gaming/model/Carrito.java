package org.gaming.model;

public class Carrito extends Juegos {

	private double cantidad;

    public Carrito(String titulo, int idjuego, double precio, int stock, double cantidad) {
        super(titulo, idjuego, precio, stock);
        this.cantidad = cantidad;
    }

    public Carrito(String titulo, int idjuego, double precio, int stock) {
        super(titulo, idjuego, precio, stock);
    }

    public void aumentarCantidad() {
        this.cantidad++;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return this.getPrecio() * this.cantidad;
    }
}
