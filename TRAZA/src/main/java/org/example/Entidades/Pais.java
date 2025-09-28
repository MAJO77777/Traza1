package org.example.Entidades;
import lombok.*;
import lombok.Builder;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString

public class Pais {

    private String nombre;

    @Override
    public String toString() {
        return "nombre = {" + nombre + "}";
    }
}
