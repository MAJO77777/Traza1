package org.example.Entidades;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")//Con esto, aclaramos que el id de 2 empresas son iguales solo si tienen el mismo id.

public class Empresa {

    private static int contador = 1;
    private int id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;

    //Si no pongo esto, el builder de lombock me ignora la inicializacion que le dooy y a la hora de ejecutar me da error.
    //Con esto decimos “Si el builder no recibe un valor para este campo, usá la inicialización que está en línea.”
    private Set<Sucursal> sucursales = new HashSet<>(); //Es lo que nos inidica que la cardinalidad hacie sucursales es mucha

    @Builder
    public Empresa(int id, String nombre, String razonSocial, Integer cuit, String logo){
        this.id = contador ++; //El contador incrementa cada que creamos una instancia de Empresa.
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.logo = logo;
    }

    public String toString (){
        return "{Empresa} de nombre = (" + nombre + "), con Razon Social = (" + razonSocial + "), con cuit = (" + cuit + ") y logo = (" + logo + "), con las sucursales = [" + sucursales + "]";
    }


    //Metodo para agregar sucursales, podriamos hacerlo desde el main pero romperia con la encapsulacion.
    public void AgregarSucursales (Sucursal sucursal){
        sucursales.add(sucursal);
    }
}
