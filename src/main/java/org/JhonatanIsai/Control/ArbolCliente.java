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
}
