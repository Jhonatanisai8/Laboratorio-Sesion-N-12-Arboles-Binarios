package org.JhonatanIsai.Control;

import org.JhonatanIsai.Modelo.Cliente;

public class NodoCliente {

    private Cliente elemento;
    private NodoCliente izq, dere;

    public NodoCliente(Cliente elemento) {
        this.elemento = elemento;
        izq = null;
        dere = null;
    }

    public Cliente getElemento() {
        return elemento;
    }

    public NodoCliente getIzq() {
        return izq;
    }

    public NodoCliente getDere() {
        return dere;
    }

}
