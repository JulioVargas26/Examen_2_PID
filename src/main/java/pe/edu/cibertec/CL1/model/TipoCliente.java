package pe.edu.cibertec.CL1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tipocliente")
public class TipoCliente implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "tipocliente_id")
    private int id;

    @Column(name = "tipocliente_nombre")
    private String nombre;
}
