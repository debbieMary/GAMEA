package elalto.gamea.testviolencia.clases;

import java.io.Serializable;

public class Prueba implements Serializable {
    String nombre, apellido;

    public Prueba(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
