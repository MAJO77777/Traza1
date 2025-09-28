package org.example.RepositorioEmpresas;

//Basado en la solucion del profe, pq en el texto de indicaciones no se mostraba
//Como tratar las empresas.


import org.example.Entidades.Empresa;

import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.ToString;

@Getter
@Setter
@ToString

public class inMemory {

    private Set<Empresa> empresas = new HashSet<>();

    public void agregarEmpresas (Empresa empresa) {
        empresas.add(empresa);
    }

    //Metodo para el busqueda de Empresas por ID

    public Empresa buscarPorID(int id) {
        for (Empresa e : empresas) {
            if ( e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public Empresa buscarPorNombre(String nombre){
        for (Empresa e: empresas){
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void mostrarTodas() {
        for (Empresa e : empresas) {
            System.out.println(e);
        }
    }

    public void ActualizarCuit(int id, int nuevoCuit) {
        for (Empresa e : empresas) {
            if (e.getId() == id) {
                e.setCuit(nuevoCuit);
            }
        }
    }

    public void EliminarEmpresa(int id) {
        for (Empresa e : empresas){
            if (e.getId() == id) {
                empresas.remove(e);
                System.out.println("Empresa"+ e.getNombre() + "eliminada con Exito");
            }
        }
    }
}
