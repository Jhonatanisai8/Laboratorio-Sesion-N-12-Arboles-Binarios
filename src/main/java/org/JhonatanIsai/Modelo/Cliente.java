package org.JhonatanIsai.Modelo;

public class Cliente {

    private String apellidos;
    private String nombres;
    private String telefono;

    public Cliente(Object[] registro) {
        this.apellidos = registro[0].toString();
        this.nombres = registro[1].toString();
        this.telefono = registro[2].toString();
    }

    public Object[] getRegistro() {
        Object[] registro = {apellidos, nombres, telefono};
        return registro;
    }

    public String getNombreCompleto() {
        return apellidos + " " + nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }

}
