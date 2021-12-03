package fr.iut.csid.bonsais.bonsai.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepottingDao extends JpaRepository<RepottingEntity, UUID> {
    @Query("select p from repotting p WHERE p.bonsai.id=:bonsaiId order by p.date DESC")
    List<RepottingEntity> findAllByBonsaiId(@Param("bonsaiId") UUID bonsaiId);
}
