package com.example.Hospital.Hospital;

import com.example.Hospital.Ala.Ala;
import com.example.Hospital.Ala.AlaRepository;
import com.example.Hospital.Ala.AlaService;
import com.example.Hospital.Leito.Leito;
import com.example.Hospital.Leito.LeitoRepository;
import com.example.Hospital.Quarto.Quarto;
import com.example.Hospital.Quarto.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public AlaRepository alaRepository;

    @Autowired
    public QuartoRepository quartoRepository;

    @Autowired
    public LeitoRepository leitoRepository;



    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public Ala criarAlaQuartoLeito(Hospital hospital, String especialidade, int quantidadeQuartos, int quantidadeDeLeitosPorQuarto) {
        Ala ala = new Ala();

        ala.setEspecialidade(especialidade);
        ala = alaRepository.save(ala);

        for (int i = 0; i < quantidadeQuartos; i++) {
            Quarto quarto = new Quarto();
            quarto.setCodigoQuarto("ODONTO" + (i + 1));
            quarto.setStatusQuarto(true);
            quarto = quartoRepository.save(quarto);

            for (int j = 0; j < quantidadeDeLeitosPorQuarto; j++) {
                Leito leito = new Leito();
                leito.setCodigoLeito("ODONTO" + (i + 1) + "-" + (j + 1));
                leito.setStatusLeito(true);
                leito = leitoRepository.save(leito);
            }
        }
        return ala;

    }

    @Transactional
    public Hospital cadastrar(Hospital hospital) {
        criarAlaQuartoLeito(hospital, "Odontologia", 5, 2);
        return this.hospitalRepository.save(hospital);
    }

    public Hospital pegarPorId(Integer id) {
        return this.hospitalRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.hospitalRepository.deleteById(id);
    }

    public List<Hospital> findByNome(String nome) {
        return this.hospitalRepository.findAllByNome("%" + nome + "%");
    }

    /*
    @Transactional(readOnly = true)
    public List<Hospital> findByNome {
        return this.hospitalRepository.findAllByNome("%" + nome + "%");
    }

     */




}
