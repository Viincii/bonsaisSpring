package fr.iut.csid.bonsais.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserDao  extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUsername(String s);

    @Query("select a.authorityId.authority from AuthorityEntity a where a.authorityId.uuid = :id")
    List<String> findAuthorityByUserId(@Param("id") UUID id);
}
