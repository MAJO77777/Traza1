package org.example.Entidades;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import java.time.LocalTime;

import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString


public class Sucursal {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean es_Casa_Matriz;

    private Domicilio domicilio;

    @Override
    public String toString() {
        return "nombre = {" + nombre + "}, Horario de Apertura = {" + horarioApertura + "}, Horario de cierre {" + horarioCierre + "}";
    }
}
