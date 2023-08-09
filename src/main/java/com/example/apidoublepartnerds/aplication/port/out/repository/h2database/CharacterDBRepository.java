package com.example.apidoublepartnerds.aplication.port.out.repository.h2database;

import com.example.apidoublepartnerds.aplication.entities.h2.CharacterDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterDBRepository extends JpaRepository<CharacterDB,Long> {

    //Optional<Episodio> findByEpiNumber(Integer epiNumber);
}
