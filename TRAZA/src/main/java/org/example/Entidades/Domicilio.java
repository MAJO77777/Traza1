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

public class Domicilio {
    private String calle;
    private Integer numero;
    private Integer cp;

    private Localidad localidad;

    @Override
    public String toString() {
        return "calle = {" + calle + "}, numero = {" + numero + "}, codigo postal = {" + cp + "}";
    }

}
