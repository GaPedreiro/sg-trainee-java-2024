package com.example.Hospital.Ala;

import com.example.Hospital.Hospital.Hospital;
import com.example.Hospital.Quarto.Quarto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ala")
public class Ala {
    //private Hospital hospital;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "especialidade")
    private String especialidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ala_id")
    private List<Quarto> quartos;

    public Integer getId() {
        return id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

/*
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

 */


    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
}
