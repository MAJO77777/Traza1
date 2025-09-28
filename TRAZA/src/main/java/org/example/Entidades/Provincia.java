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

public class Provincia {
    private String nombre;
    private Pais pais;

    @Override

    public String toString(){
        return "nombre = {" + nombre + "}" + " del pais = {" + pais + "}";
    }


}
