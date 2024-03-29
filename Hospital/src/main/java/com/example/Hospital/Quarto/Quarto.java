package com.example.Hospital.Quarto;

import com.example.Hospital.Ala.Ala;
import com.example.Hospital.Helpers.EntityId;
import com.example.Hospital.Leito.Leito;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "quarto")
public class Quarto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "codigo_quarto")
    private String codigoQuarto;

    @Column(name = "status_quarto")
    private boolean statusQuarto;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quarto_id")
    private List<Leito> leitos;

    public String getCodigoQuarto() {
        return codigoQuarto;
    }

    public void setCodigoQuarto(String codigoQuarto) {
        this.codigoQuarto = codigoQuarto;
    }

    public boolean isStatusQuarto() {
        return statusQuarto;
    }

    public void setStatusQuarto(boolean statusQuarto) {
        this.statusQuarto = statusQuarto;
    }

    // ACRESCENTEI ESSE OVERRIDE AQUI
    @Override
    public String toString() {
        return this.id + this.codigoQuarto + this.statusQuarto;
    }
}
