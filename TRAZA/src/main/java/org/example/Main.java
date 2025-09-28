package org.example;

import org.example.Entidades.*;
import org.example.RepositorioEmpresas.inMemory;

import javax.sound.midi.Soundbank;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Pais pais1 = new Pais("Argentina");


        Provincia p1 = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(pais1)
                .build();
        Provincia p2 = Provincia.builder()
                .nombre("Cordoba")
                .pais(pais1)
                .build();

        Localidad l1 = Localidad.builder()
                .nombre("Caba")
                .provincia(p1)
                .build();

        Localidad l2 = Localidad.builder()
                .nombre("La plata")
                .provincia(p1)
                .build();

        Localidad l3 = Localidad.builder()
                .nombre("Cordoba Capital")
                .provincia(p2)
                .build();

        Localidad l4 = Localidad.builder()
                .nombre("Villa Carlos Paz")
                .provincia(p2)
                .build();

        Domicilio d1 = Domicilio.builder()
                .calle("Florencio Varela")
                .numero(376)
                .cp(4410)
                .localidad(l1)
                .build();

        Domicilio d2 = Domicilio.builder()
                .localidad(l2)
                .calle("Calle 7")
                .numero(1100)
                .cp(1900)
                .build();

        Domicilio d3 = Domicilio.builder()
                .localidad(l3)
                .calle("25 de Mayo")
                .numero(123)
                .cp(5000)
                .build();

        Domicilio d4 = Domicilio.builder()
                .localidad(l4)
                .calle("Avenida San Martin")
                .numero(500)
                .cp(5152)
                .build();

        Sucursal s1 = Sucursal.builder()
                .nombre("Limpito")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(20, 0))
                .domicilio(d1)
                .build();

        Sucursal s2 = Sucursal.builder()
                .nombre("Limpito Emporio de la Limpieza")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(19, 0))
                .domicilio(d2)
                .build();

        Sucursal s3 = Sucursal.builder()
                .nombre("Limpito Productos de Limpieza")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(19, 0))
                .domicilio(d3)
                .build();

        Sucursal s4 = Sucursal.builder()
                .nombre("Limpito!")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(20, 0))
                .domicilio(d4)
                .build();

        Empresa e1 = Empresa.builder()
                .nombre("Limpito Emporio de la Limpieza Buenos Aires")
                .razonSocial("Limpito S.A")
                .cuit(592380071)
                .logo("Cuidamos tu hogar")
                .build();

        Empresa e2 = Empresa.builder()
                .nombre("Limpito Emporio de la Limpieza Cordoba")
                .razonSocial("Limpito S.A")
                .cuit(592380071)
                .logo("Animate a limpiar ahorrando")
                .build();

        e1.AgregarSucursales(s1);
        e1.AgregarSucursales(s2);

        e2.AgregarSucursales(s3);
        e2.AgregarSucursales(s4);



        //Ejecucion del punto 5

        //a) Mostrar todas las empresas: Me equivoque y mostre todas las sucursales por empresa jajaja

        inMemory repo = new inMemory();
        repo.agregarEmpresas(e1);
        repo.agregarEmpresas(e2);

        System.out.println("\nEmpresas en el repositorio: ");
        for (Empresa i : repo.getEmpresas()){
            System.out.println("- [" + i.getNombre() + "]");
        }

        System.out.println("\nEl 'ID' de la empresa " + e1.getNombre() + " es: " + e1.getId());
        System.out.println("El 'ID' de la empresa " + e2.getNombre() + " es: " + e2.getId() + "\n");

        //b) Buscar una empresa por su Id.

        repo.mostrarTodas();

        System.out.println("Buscando Empresa por ID...\n");
        System.out.println("Buscando ID=1 -> " + repo.buscarPorID(1));
        System.out.println("Buscando ID=2 -> " + repo.buscarPorID(2));

        //c) Buscar empresar por su nombre

        System.out.println("\nBuscando empresa por Nombre...\n");
        System.out.println("Buscando Empresa de nombre Limpito Emporio de la Limpieza Buenos Aires -> " + repo.buscarPorNombre("Limpito Emporio de la Limpieza Buenos Aires"));
        System.out.println("Buscando Empresa de nombre Limpito Emporio de la Limpieza Cordoba -> " + repo.buscarPorNombre("Limpito Emporio de la Limpieza Cordoba"));

        //d) Actualizar los datos de una empresa buscando por su ID. Por ejemplo modificar su cuil.

        System.out.println("\nActualizando datos de la Empresa " + e1.getNombre() + "...");
        repo.ActualizarCuit(1,2035264);
        System.out.println("- El cuit de la empresa se ha actualizado con exito a: " + e1.getCuit());

        //e) Eliminar una empresa buscando por su ID.

        System.out.println("\nEliminando Empresa " + e1.getNombre() + "...");
        repo.EliminarEmpresa(1);


    }
}