package com.example.Mecanica.Cliente;

import com.example.Mecanica.Peca.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM cliente l WHERE l.id ILIKE :id")
    List<Cliente> findAllById(@Param("id") Integer id);
}
