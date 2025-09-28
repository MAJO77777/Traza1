package org.example.Entidades;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString

public class Localidad {
    private String nombre;

    private Provincia provincia;

    @Override
    public String toString() {
        return "nombre = {" + nombre + "}, pertenece a la provincia = {" + provincia + "}";
    }

}
