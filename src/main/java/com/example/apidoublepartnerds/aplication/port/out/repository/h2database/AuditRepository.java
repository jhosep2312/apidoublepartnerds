package com.example.apidoublepartnerds.aplication.port.out.repository.h2database;

import com.example.apidoublepartnerds.aplication.entities.h2.AuditDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditDB,Long> {
}
