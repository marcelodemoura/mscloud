package com.br.marcelo.ms.cloudmensageria.repository;

import com.br.marcelo.ms.cloudmensageria.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {



}
