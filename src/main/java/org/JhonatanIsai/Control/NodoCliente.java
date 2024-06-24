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

    public void setElemento(Cliente elemento) {
        this.elemento = elemento;
    }

    public void setIzq(NodoCliente izq) {
        this.izq = izq;
    }

    public void setDere(NodoCliente dere) {
        this.dere = dere;
    }

}
