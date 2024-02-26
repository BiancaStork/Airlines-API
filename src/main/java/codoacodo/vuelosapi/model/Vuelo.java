package codoacodo.vuelosapi.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class Vuelo {
    private Long id;
    private String origen;
    private String destino;
    private LocalDateTime fechaHoraSalida;
    private LocalDateTime fechaHoraLlegada;
    private double precio; 
    private String frecuencia;
}
