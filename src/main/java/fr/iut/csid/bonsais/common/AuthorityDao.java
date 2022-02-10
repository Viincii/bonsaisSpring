package fr.iut.csid.bonsais.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface AuthorityDao  extends JpaRepository<AuthorityEntity, UUID> {

    @Modifying
    @Transactional
    @Query(value = "delete from authorities where id=?1", nativeQuery = true)
    int deleteAuthByUserId(@Param("user_id") UUID userId);
}
