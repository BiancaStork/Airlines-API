package codoacodo.flights.models;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity  //me dice que esto sera almacenado en una bd

public class Dolar {
   

    private String moneda;
    private String casa;
    private String nombre;
    private Double compra;
    private Double venta;
    private LocalDateTime fechaActualizacion;


    public Dolar(String moneda, String casa, String nombre, Double compra, Double venta,
            LocalDateTime fechaActualizacion) {
        this.moneda = moneda;
        this.casa = casa;
        this.nombre = nombre;
        this.compra = compra;
        this.venta = venta;
        this.fechaActualizacion = fechaActualizacion;
    }
}
