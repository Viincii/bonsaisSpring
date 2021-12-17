package fr.iut.csid.bonsais.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerDao extends JpaRepository<OwnerEntity, UUID> {
}
