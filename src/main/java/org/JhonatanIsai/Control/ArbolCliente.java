package org.JhonatanIsai.Control;

import org.JhonatanIsai.Modelo.Cliente;

public class ArbolCliente {

    private NodoCliente raiz;

    public ArbolCliente() {
        raiz = null;
    }

    public NodoCliente getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoCliente raiz) {
        this.raiz = raiz;
    }

    //metodo para agregar un cliente al arbol
    public NodoCliente agregarCliente(NodoCliente nodoCliente, Cliente cliente) {
        if (nodoCliente == null) {
            NodoCliente nuevo = new NodoCliente(cliente);
            return nuevo;
        } else {
        }
        if (cliente.getNombreCompleto().compareTo(nodoCliente.getElemento().getNombreCompleto()) > 0) {
            nodoCliente.setDere(agregarCliente(nodoCliente.getDere(), cliente));
        } else {
            nodoCliente.setIzq(agregarCliente(nodoCliente.getIzq(), cliente));
        }
        return nodoCliente;
    }
}
