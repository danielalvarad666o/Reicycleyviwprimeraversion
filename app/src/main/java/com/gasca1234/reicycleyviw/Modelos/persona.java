package com.gasca1234.reicycleyviw.Modelos;

public class persona {
    private String Nombre;
    private String Telefono;


    //un modelo  representa un objeto
    //atra vez del modelo interpretas la infromacion
    // es mas facil trabajar con un objeto direccion
    public persona(String nombre, String telefono) {
        Nombre = nombre;
        Telefono = telefono;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
