package com.example.apidoublepartnerds.aspects;

import com.example.apidoublepartnerds.aplication.entities.BaseResponseDto;
import com.example.apidoublepartnerds.aplication.entities.ResponseCode;
import com.example.apidoublepartnerds.aplication.entities.h2.AuditDB;
import com.example.apidoublepartnerds.aplication.port.out.repository.h2database.AuditRepository;
import com.example.apidoublepartnerds.domain.Characters;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class GetAllCharactersAspect {

    AuditDB auditDB = new AuditDB();
    final AuditRepository auditRepository;

    public GetAllCharactersAspect(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Pointcut("execution(* com.example.apidoublepartnerds.adapter.in.RickAndMortyController.getAllCharacters(..))")
    private void getAllCharactersAspect() {

    }

    @Before("getAllCharactersAspect()  && args(page)")
    public void initGetAllCharacters(int page) {

        Date date = new Date();
        long time = date.getTime();

        this.auditDB = auditRepository.save(new AuditDB(new Timestamp(time), "GET", "param= " + page, null));
    }

    @AfterReturning(pointcut = "getAllCharactersAspect()", returning = "response")
    public void endGetAllCharacters(ResponseEntity<BaseResponseDto<Characters>> response) {
        log.info("Audit for GetAllCharacters end with code: {}", "response.getBody().getResponseCode()");
        var responseInternal = response.getBody();
        if (responseInternal != null) {
            if (responseInternal.getCode() != ResponseCode.OK) {
                this.auditDB.setError(responseInternal.getMessage() );
                auditRepository.save(this.auditDB);
            }
        }

    }

}
