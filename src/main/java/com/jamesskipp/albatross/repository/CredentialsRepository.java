package com.jamesskipp.albatross.repository;

import com.jamesskipp.albatross.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
}
