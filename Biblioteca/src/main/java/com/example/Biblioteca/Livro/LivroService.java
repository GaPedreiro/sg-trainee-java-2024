package com.example.Biblioteca.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public Livro cadastrar(Livro livro) {
        return this.livroRepository.save(livro);
    }

    public Livro pegarPorId(Integer id) {
        return this.livroRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.livroRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Livro> findByNome(String nome) {
        return this.livroRepository.findAllByNome("%" + nome + "%");
    }

}