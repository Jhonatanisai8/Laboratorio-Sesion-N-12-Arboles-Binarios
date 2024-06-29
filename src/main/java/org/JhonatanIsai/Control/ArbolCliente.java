package org.JhonatanIsai.Control;

import javax.swing.table.DefaultTableModel;
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

    //método para buscar un cliente
    public NodoCliente buscarCliente(String dato) {
        NodoCliente auxiliar = raiz;
        while (auxiliar != null) {
            if (auxiliar.getElemento().getNombreCompleto().startsWith(dato)) {
                return auxiliar;
            } else {
                if (dato.compareTo(auxiliar.getElemento().getNombreCompleto()) > 0) {
                    auxiliar = auxiliar.getDere();
                } else {
                    auxiliar = auxiliar.getIzq();
                }
            }
        }
        return null;
    }

    //método para listar en inOrden
    public void listarInOrden(NodoCliente nodoCliente, DefaultTableModel modelo) {
        if (nodoCliente != null) {
            listarInOrden(nodoCliente.getIzq(), modelo);
            modelo.addRow(nodoCliente.getElemento().getRegistro());
            listarInOrden(nodoCliente.getDere(), modelo);
        }
    }

    //método para buscar el mayor izquierda
    public NodoCliente buscarMayorIzquierda(NodoCliente auxiliar) {
        if (auxiliar != null) {
            while (auxiliar.getDere() != null) {
                auxiliar = auxiliar.getDere();
            }
        }
        return auxiliar;
    }

    //método para eliminar el mayor izquierda
    public NodoCliente eliminarMayorIzquierda(NodoCliente auxiliar) {
        if (auxiliar != null) {
            return null;
        } else if (auxiliar.getDere() != null) {
            auxiliar.setDere(eliminarMayorIzquierda(auxiliar.getDere()));
            return auxiliar;
        }
        return auxiliar.getIzq();
    }

    //método para eliminar un cliente
    public NodoCliente eliminar(NodoCliente auxiliar, String dato) {
        if (auxiliar == null) {
            return null;
        }
        if (dato.compareTo(auxiliar.getElemento().getNombreCompleto()) < 0) {
            auxiliar.setIzq(eliminar(auxiliar.getIzq(), dato));

        } else if (dato.compareTo(auxiliar.getElemento().getNombreCompleto()) > 0) {
            auxiliar.setDere(eliminar(auxiliar.getDere(), dato));
        } else if (auxiliar.getIzq() != null && auxiliar.getDere() != null) {
            auxiliar.setElemento(buscarMayorIzquierda(auxiliar.getIzq()).getElemento());
            auxiliar.setIzq(eliminarMayorIzquierda(auxiliar.getIzq()));
        } else {
            auxiliar = (auxiliar.getIzq() != null) ? auxiliar.getIzq() : auxiliar.getDere();
        }
        return auxiliar;
    }
}
